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

import aiss.api.resources.comparators.ComparatorNameComplement;
import aiss.api.resources.comparators.ComparatorNameComplementReversed;
import aiss.api.resources.comparators.ComparatorPriceComplement;
import aiss.api.resources.comparators.ComparatorPriceComplementReversed;
import aiss.model.Complement;
import aiss.model.Device;
import aiss.model.repository.MapShopRepository;
import aiss.model.repository.ShopRepository;

@Path("/complements")
public class ComplementResource {
	public static ComplementResource _instance=null;
	ShopRepository repository;
	
	private ComplementResource() {
		repository = MapShopRepository.getInstance();
	}
	
	public static ComplementResource getInstance() {
		if(_instance==null) {
			_instance = new ComplementResource();
		}
		
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Complement> getALll(@QueryParam("order") String order, @QueryParam("isEmpty") Boolean isEmpty, 
			@QueryParam("name") String name, @QueryParam("material") String material) {
		
		List<Complement> res = new ArrayList<>(repository.getAllComplement());
		
		
		for(int i = 0; i<res.size(); i++) {
			Complement a = res.get(i);
			
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
			
			if(material != null && res.contains(a) && !(a.getMaterial().toLowerCase()==material.toLowerCase())) {
				res.remove(a);
				i--;
			}
		
		}
		
		if(order != null) {
			if(order.equals("name")) {
				Collections.sort(res, new ComparatorNameComplement());
			}else if(order.equals("-name")) {
				Collections.sort(res, new ComparatorNameComplementReversed());
			}else if (order.equals("price")){
				Collections.sort(res, new ComparatorPriceComplement());
			}else if(order.equals("-price")) {
				Collections.sort(res, new ComparatorPriceComplementReversed());
			}else {
				throw new BadRequestException("The order parameter must be 'name' or '-name'.");
			}
		}
				
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Complement get(@PathParam("id") String id)
	{
		Complement list = repository.getComplement(Integer.valueOf(id));
		
		if (list == null) {
			throw new NotFoundException("The accesory with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComplement(@Context UriInfo uriInfo, Complement complement) {
		if (complement.getName() == null || "".equals(complement.getName())) {
			throw new BadRequestException("The name of the complement must not be null");
		}
		
		if(complement.getCompatibleDevices()!=null) {
			throw new BadRequestException("The compatibleDevices property is not editable.");
		}
		
		repository.addComplement(complement);
		
		// Builds the response. Returns the shop the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(complement.getComplementId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(complement);			
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateComplement(Complement complement) {
		Complement oldcomplement = repository.getComplement(complement.getComplementId());
		if (oldcomplement == null) {
			throw new NotFoundException("The complement with id="+ complement.getComplementId() +" was not found");			
		}
		
		if (complement.getCompatibleDevices()!=null)
			throw new BadRequestException("The compatibleDevices property is not editable.");
		
		// Update name
		if (complement.getName()!=null)
			oldcomplement.setName(complement.getName());
		
		// Update price
		if (complement.getPrice()!=null)
			oldcomplement.setPrice(complement.getPrice());
		
		// Update material
		if (complement.getMaterial()!=null)
			oldcomplement.setMaterial(complement.getMaterial());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeComplement(@PathParam("id") String id) {
		Complement toberemoved=repository.getComplement(Integer.valueOf(id));
		if (toberemoved == null)
			throw new NotFoundException("The complement with id="+ id +" was not found");
		else
			repository.deleteComplement(Integer.valueOf(id));
		
		return Response.noContent().build();
	}
	
	@POST	
	@Path("/{complementId}/{deviceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDevice(@Context UriInfo uriInfo,@PathParam("complementId") String complementId, @PathParam("deviceId") String deviceId)
	{				
		
		Complement complement = repository.getComplement(Integer.valueOf(complementId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (complement==null)
			throw new NotFoundException("The complement with id=" + complementId + " was not found");
		
		if (device==null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		if (complement.getCompatibleDevices().contains(device)==true)
			throw new BadRequestException("The device is already included in the compatibleDevices list of accessories");
			
		repository.addDeviceComplement(Integer.valueOf(complementId), Integer.valueOf(deviceId));		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(complementId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(complement);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{complementId}/{deviceId}")
	public Response removeDevice(@PathParam("complementId") String complementId, @PathParam("deviceId") String deviceId) {
		Complement complement = repository.getComplement(Integer.valueOf(complementId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (complement==null)
			throw new NotFoundException("The complement with id=" + complementId + " was not found");
		
		if (device == null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		
		repository.removeDeviceComplement(Integer.valueOf(complementId), Integer.valueOf(deviceId));		
		
		return Response.noContent().build();
	}
}
