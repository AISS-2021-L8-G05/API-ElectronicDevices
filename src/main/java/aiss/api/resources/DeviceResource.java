package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorMemoryDevice;
import aiss.api.resources.comparators.ComparatorMemoryDeviceReversed;
import aiss.api.resources.comparators.ComparatorNameDevice;
import aiss.api.resources.comparators.ComparatorNameDeviceReversed;
import aiss.api.resources.comparators.ComparatorPriceDevice;
import aiss.api.resources.comparators.ComparatorPriceDeviceReversed;
import aiss.api.resources.comparators.ComparatorScreenSizeDevice;
import aiss.api.resources.comparators.ComparatorScreenSizeDeviceReversed;
import aiss.api.resources.comparators.ComparatorStorageDevice;
import aiss.api.resources.comparators.ComparatorStorageDeviceReversed;
import aiss.api.resources.comparators.ComparatorWeightDevice;
import aiss.api.resources.comparators.ComparatorWeightDeviceReversed;
import aiss.model.Device;
import aiss.model.repository.MapShopRepository;
import aiss.model.repository.ShopRepository;

@Path("/devices")
public class DeviceResource {
	
	public static DeviceResource _instance=null;
	ShopRepository repository;
	
	private DeviceResource() {
		repository=MapShopRepository.getInstance();
	}
	
	public static DeviceResource getInstance() {
		if(_instance==null)
			_instance=new DeviceResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Device> getAll(@QueryParam("order") String order, @QueryParam("brand") String brand,
			@QueryParam("deviceType") String deviceType, @QueryParam("OS") String OS, @QueryParam("Color") String Color,
			@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit){
		
		Set<Device> aux = new HashSet<Device>(repository.getAllDevices());
		
		List<Device> res = aux.stream().collect(Collectors.toList());
		
		for(int i = 0; i<res.size(); i++) {
			Device d = res.get(i);
			
			if (brand != null && res.contains(d) && !(d.getBrand().toLowerCase().equals(brand.toLowerCase()))) {
				res.remove(d);
				i--;
			}

			if (deviceType != null && res.contains(d) && !(d.getDeviceType().toString().toLowerCase().equals(deviceType.toLowerCase()))) {
				res.remove(d);
				i--;
			}

			if (OS != null && res.contains(d) && !(d.getOS().equals(OS))) {
				res.remove(d);
				i--;
			}

			if (Color != null && res.contains(d) && !(d.getSetColors().contains(Color))) {
				res.remove(d);
				i--;
			}

		}
		
		
		if(order != null) {
			if(order.equals("name")) {
				Collections.sort(res, new ComparatorNameDevice());
			} else if (order.equals("-name")) {
				Collections.sort(res, new ComparatorNameDeviceReversed());	
			} else if (order.equals("price")) {
				Collections.sort(res, new ComparatorPriceDevice());
			} else if (order.equals("-price")) {
				Collections.sort(res, new ComparatorPriceDeviceReversed());
			} else if (order.equals("screenSize")) {
				Collections.sort(res, new ComparatorScreenSizeDevice());
			} else if (order.equals("-screenSize")) {
				Collections.sort(res, new ComparatorScreenSizeDeviceReversed());
			} else if (order.equals("weight")) {
				Collections.sort(res, new ComparatorWeightDevice());
			} else if (order.equals("-weight")) {
				Collections.sort(res, new ComparatorWeightDeviceReversed());
			} else if (order.equals("memory")) {
				Collections.sort(res, new ComparatorMemoryDevice());
			} else if (order.equals("-memory")) {
				Collections.sort(res, new ComparatorMemoryDeviceReversed());
			} else if (order.equals("storage")) {
				Collections.sort(res, new ComparatorStorageDevice());
			} else if (order.equals("-storage")) {
				Collections.sort(res, new ComparatorStorageDeviceReversed());
			} else {
				throw new BadRequestException("The parameter order isn't correct");
			}
		}
		if (offset != null && offset<0) throw new BadRequestException("Offset must be >=0 but was "+offset+"!");
	    if (limit != null && limit<-1) throw new BadRequestException("Limit must be >=-1 but was "+limit+"!");

	    if (offset != null && offset>0) {
	        if (offset >= res.size()) {
	            res = res.subList(0, 0); //return empty.
	        }
	        if (limit != null && limit >-1) {
	            //apply offset and limit
	            res = res.subList(offset, Math.min(offset+limit, res.size()));
	        } else {
	            //apply just offset
	            res = res.subList(offset, res.size());
	        }
	    } else if (limit != null && limit >-1) {
	        //apply just limit
	        res = res.subList(0, Math.min(limit, res.size()));
	    } else {
	      res = res.subList(0, res.size());
	    }
		
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Device get(@PathParam("id") String deviceId) {
		Device device = repository.getDevice(Integer.valueOf(deviceId));
		
		if (device == null) {
			throw new BadRequestException("The device with id="+deviceId+" was not found");
		}
		
		return device;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addDevice(@Context UriInfo uriInfo, Device device) {
		
		if(device.getName()==null || "".equals(device.getName())) {
			throw new BadRequestException("The name of the device must not be null");
		}
		
		if(device.getPrice()==null || "".equals(device.getPrice().toString())) {
			throw new BadRequestException("The price of the device must not be null");
		}
		
		if(device.getDeviceType()==null || "".equals(device.getDeviceType().toString())) {
			throw new BadRequestException("The type of the device must not be null");
		}
		
		repository.addDevice(device);
		
		// BUilds the response. Returns the song the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(device.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(device);
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateDevice(Device device) {
		
		Device oldDevice = repository.getDevice(device.getId());
		
		if(oldDevice == null) {
			throw new NotFoundException("The device with id="+device.getId()+" was not found");
		}
		
		// Update name
		if(device.getName() != null) {
			oldDevice.setName(device.getName());
		}
		
		// Update brand
		if(device.getBrand() != null) {
			oldDevice.setBrand(device.getBrand());
		}
		
		// Update price
		if(device.getPrice() != null) {
			oldDevice.setPrice(device.getPrice());
		}
		
		// Update screenSize
		if(device.getScreenSize() != null) {
			oldDevice.setScreenSize(device.getScreenSize());
		}
		
		// Update weight
		if(device.getWeight() != null) {
			oldDevice.setWeight(device.getWeight());
		}
		
		// Update deviceType
		if(device.getDeviceType() != null) {
			oldDevice.setDeviceType(device.getDeviceType());
		}
		
		// Update storage
		if(device.getStorage() != null) {
			oldDevice.setStorage(device.getStorage());
		}
		
		// Update processor
		if(device.getProcessor() != null) {
			oldDevice.setProcessor(device.getProcessor());
		}
		
		// Update memory
		if(device.getMemory() != null) {
			oldDevice.setMemory(device.getMemory());
		}
		
		// Update OS
		if(device.getOS() != null) {
			oldDevice.setOS(device.getOS());
		}
		
		// Update setColors
		if(device.getSetColors() != null) {
			oldDevice.setSetColors(device.getSetColors());
		}
		
		// Update camera
		if(device.getCamera() != null) {
			oldDevice.setCamera(device.getCamera());
		}
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeDevice(@PathParam("id") String deviceId) {
		Device toberemoved = repository.getDevice(Integer.valueOf(deviceId));
		
		if(toberemoved == null) {
			throw new NotFoundException("The device with id="+deviceId+" was not found");
		}else {
			repository.deleteDevice(Integer.valueOf(deviceId));
		}
		return Response.noContent().build();
	}

}
