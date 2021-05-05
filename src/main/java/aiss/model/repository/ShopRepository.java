package aiss.model.repository;

import java.util.Collection;

import aiss.model.Device;
import aiss.model.Shop;

public interface ShopRepository {

	// Device
	public void addDevice(Device d);
	public Collection<Device> getAllDevices();
	public Device getDevice(Integer deviceId);
	public void updateDevice(Device d);
	public void deleteDevice(Integer deviceId);
	
	// Shop
	public void addShop(Shop s);
	public Collection<Shop> getAllShops();
	public Shop getShop(Integer shopId);
	public void updateShop(Shop s);
	public void deleteShop(Integer shopId);
	public Collection<Device> getAll(Integer shopId);
	public void addDevice(Integer shopId, Integer deviceId);
	public void removeDevice(Integer shopId, Integer deviceId);
	
}
