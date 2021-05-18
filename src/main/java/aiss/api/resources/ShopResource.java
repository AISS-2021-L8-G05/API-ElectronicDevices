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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorNameShop;
import aiss.api.resources.comparators.ComparatorNameShopReversed;
import aiss.model.Device;
import aiss.model.Shop;
import aiss.model.repository.MapShopRepository;
import aiss.model.repository.ShopRepository;

@Path("/shops")
public class ShopResource {
	
	/* Singleton */
	private static ShopResource _instance=null;
	ShopRepository repository;
	
	private ShopResource() {
		repository=MapShopRepository.getInstance();

	}
	
	public static ShopResource getInstance()
	{
		if(_instance==null)
				_instance=new ShopResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Shop> getAll(@QueryParam("order") String order, @QueryParam("isEmpty") Boolean isEmpty, @QueryParam("name") String name)
	{
		List<Shop> result = new ArrayList<Shop>();
		
		for(Shop shop : repository.getAllShops()) {
			if(name == null || shop.getName().equals(name)) {	// Name filter
				if(isEmpty == null	// Si el filtro no se usa, incluir todas las listas
						|| (isEmpty && (shop.getDevices() == null || shop.getDevices().size() == 0))	// Si el filtro se pone a true, incluir las listas que no tengan canciones
						|| (!isEmpty && (shop.getDevices() != null && shop.getDevices().size() > 0))) {	// Si el filtro se pone a false, incluir las listas que tengan canciones
					result.add(shop);
				}
			}
		}
		
		if(order != null) {
			if(order.equals("name")) {
				Collections.sort(result, new ComparatorNameShop());
			}else if(order.equals("-name")) {
				Collections.sort(result, new ComparatorNameShopReversed());
			}else {
				throw new BadRequestException("The order parameter must be 'name' or '-name'.");
			}
		}
		
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Shop get(@PathParam("id") String id)
	{
		Shop list = repository.getShop(Integer.valueOf(id));
		
		if (list == null) {
			throw new NotFoundException("The shop with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addShop(@Context UriInfo uriInfo, Shop shop) {
		if (shop.getName() == null || "".equals(shop.getName()))
			throw new BadRequestException("The name of the shop must not be null");
		
		if (shop.getDevices()!=null)
			throw new BadRequestException("The devices property is not editable.");

		repository.addShop(shop);

		// Builds the response. Returns the shop the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(shop.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(shop);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Shop shop) {
		Shop oldshop = repository.getShop(shop.getId());
		if (oldshop == null) {
			throw new NotFoundException("The shop with id="+ shop.getId() +" was not found");			
		}
		
		if (shop.getDevices()!=null)
			throw new BadRequestException("The devices property is not editable.");
		
		// Update name
		if (shop.getName()!=null)
			oldshop.setName(shop.getName());
		
		// Update url
		if (shop.getUrl()!=null)
			oldshop.setUrl(shop.getUrl());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeShop(@PathParam("id") String id) {
		Shop toberemoved=repository.getShop(Integer.valueOf(id));
		if (toberemoved == null)
			throw new NotFoundException("The shop with id="+ id +" was not found");
		else
			repository.deleteShop(Integer.valueOf(id));
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{shopId}/{deviceId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addDevice(@Context UriInfo uriInfo,@PathParam("shopId") String shopId, @PathParam("deviceId") String deviceId)
	{				
		
		Shop shop = repository.getShop(Integer.valueOf(shopId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (shop==null)
			throw new NotFoundException("The shop with id=" + shopId + " was not found");
		
		if (device==null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		if (shop.getDevice(Integer.valueOf(deviceId))!=null)
			throw new BadRequestException("The device is already included in the shop.");
			
		repository.addDevice(Integer.valueOf(shopId), Integer.valueOf(deviceId));		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(shopId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(shop);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{shopId}/{deviceId}")
	public Response removeDevice(@PathParam("shopId") String shopId, @PathParam("deviceId") String deviceId) {
		Shop shop = repository.getShop(Integer.valueOf(shopId));
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (shop==null)
			throw new NotFoundException("The shop with id=" + shopId + " was not found");
		
		if (device == null)
			throw new NotFoundException("The device with id=" + deviceId + " was not found");
		
		
		repository.removeDevice(Integer.valueOf(shopId), Integer.valueOf(deviceId));		
		
		return Response.noContent().build();
	}
}