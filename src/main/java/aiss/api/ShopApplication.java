package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.AccessoryResource;
import aiss.api.resources.ComplementResource;
import aiss.api.resources.DeviceResource;
import aiss.api.resources.ShopResource;

public class ShopApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public ShopApplication() {

		singletons.add(ShopResource.getInstance());
		singletons.add(DeviceResource.getInstance());
		singletons.add(ComplementResource.getInstance());
		singletons.add(AccessoryResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
