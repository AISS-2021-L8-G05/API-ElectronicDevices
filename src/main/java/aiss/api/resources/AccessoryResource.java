package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.MapShopRepository;
import aiss.model.repository.ShopRepository;
import aiss.api.resources.comparators.ComparatorNameAccessory;
import aiss.api.resources.comparators.ComparatorNameAccessoryReversed;
import aiss.api.resources.comparators.ComparatorPriceAccessory;
import aiss.api.resources.comparators.ComparatorPriceAccessoryReversed;
import aiss.model.Accessory;
import aiss.model.Device;

@Path("/accessories")
public class AccessoryResource {
	
	public static AccessoryResource _instance=null;
	ShopRepository repository;
	
	private AccessoryResource() {
		repository = MapShopRepository.getInstance();
	}
	
	public static AccessoryResource getInstance() {
		if(_instance==null) {
			_instance = new AccessoryResource();
		}
		
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Accessory> getAll(@QueryParam("order") String order, @QueryParam("isEmpty") Boolean isEmpty, 
			@QueryParam("name") String name, @QueryParam("wireless") String wireless) {
		
		List<Accessory> res = new ArrayList<>(repository.getAllAccessory());
		
		
		for(int i = 0; i<res.size(); i++) {
			Accessory a = res.get(i);
			
			if(!(isEmpty == null	// Si el filtro no se usa, incluir todas las listas
					|| (isEmpty && (a.getCompatibleDevices() == null || a.getCompatibleDevices().size() == 0))	// Si el filtro se pone a true, incluir las listas que no tengan dispositivos compatibles
					|| (!isEmpty && (a.getCompatibleDevices()) != null && a.getCompatibleDevices().size() > 0))) {	// Si el filtro se pone a false, incluir las listas que tengan dispositivos compatibles
				res.remove(a);
				i--;
			}
			
			if (name != null && res.contains(a) && !(a.getName().toLowerCase().contains(name.toLowerCase()))) {
				res.remove(a);
				i--;
			}
			
			if(wireless != null && res.contains(a) && !(a.getWireless().toString().toLowerCase()==wireless.toLowerCase())) {
				res.remove(a);
				i--;
			}
		
		}
		
		if(order != null) {
			if(order.equals("name")) {
				Collections.sort(res, new ComparatorNameAccessory());
			}else if(order.equals("-name")) {
				Collections.sort(res, new ComparatorNameAccessoryReversed());
			}else if (order.equals("price")){
				Collections.sort(res, new ComparatorPriceAccessory());
			}else if(order.equals("-price")) {
				Collections.sort(res, new ComparatorPriceAccessoryReversed());
			}else {
				throw new BadRequestException("The order parameter must be 'name' or '-name'.");
			}
		}
				
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Accessory get(@PathParam("id") String id)
	{
		Accessory list = repository.getAccessory(Integer.valueOf(id));
		
		if (list == null) {
			throw new NotFoundException("The accesory with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccessory(@Context UriInfo uriInfo, Accessory accessory) {
		if (accessory.getName() == null || "".equals(accessory.getName())) {
			throw new BadRequestException("The name of the accessory must not be null");
		}
		
		if(accessory.getCompatibleDevices()!=null) {
			throw new BadRequestException("The compatibleDevices property is not editable.");
		}
		
		repository.addAccessory(accessory);
		
		// Builds the response. Returns the shop the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(accessory.getAccessoryId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(accessory);			
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateAccessory(Accessory accessory) {
		Accessory oldaccessory = repository.getAccessory(accessory.getAccessoryId());
		if (oldaccessory == null) {
			throw new NotFoundException("The accessory with id="+ accessory.getAccessoryId() +" was not found");			
		}
		
		if (accessory.getCompatibleDevices()!=null)
			throw new BadRequestException("The compatibleDevices property is not editable.");
		
		// Update name
		if (accessory.getName()!=null)
			oldaccessory.setName(accessory.getName());
		
		// Update price
		if (accessory.getPrice()!=null)
			oldaccessory.setPrice(accessory.getPrice());
		
		// Update wireless
		if (accessory.getWireless()!=null)
			oldaccessory.setWireless(accessory.getWireless());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeAccessory(@PathParam("id") String id) {
		Accessory toberemoved=repository.getAccessory(Integer.valueOf(id));
		if (toberemoved == null)
			throw new NotFoundException("The accessory with id="+ id +" was not found");
		else
			repository.deleteAccessory(Integer.valueOf(id));
		
		return Response.noContent().build();
	}
	
	@POST	
	@Path("/{accessoryId}/{deviceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDevice(@Context UriInfo uriInfo,@PathParam("accessoryId") String accessoryId, @PathParam("deviceId") String deviceId)
	{				
		
		Accessory accessory = repository.getAccessory(Integer.valueOf(accessoryId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (accessory==null)
			throw new NotFoundException("The accessory with id=" + accessoryId + " was not found");
		
		if (device==null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		if (accessory.getCompatibleDevices().contains(device)==true)
			throw new BadRequestException("The device is already included in the compatibleDevices list of accessories");
			
		repository.addDeviceAccessory(Integer.valueOf(accessoryId), Integer.valueOf(deviceId));		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(accessoryId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(accessory);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{accessoryId}/{deviceId}")
	public Response removeDevice(@PathParam("accessoryId") String accessoryId, @PathParam("deviceId") String deviceId) {
		Accessory accessory = repository.getAccessory(Integer.valueOf(accessoryId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (accessory==null)
			throw new NotFoundException("The accessory with id=" + accessoryId + " was not found");
		
		if (device == null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		
		repository.removeDeviceAccessory(Integer.valueOf(accessoryId), Integer.valueOf(deviceId));		
		
		return Response.noContent().build();
	}
}
