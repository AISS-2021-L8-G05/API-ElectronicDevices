package aiss.model.repository;

import java.util.Collection;

import aiss.model.Accessory;
import aiss.model.Complement;
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
	public void addComplementShop (Integer shopId, Integer complementId);
	public void removeComplementShop (Integer shopId, Integer complementId);
	public void addAccessoryShop (Integer shopId, Integer accessoryId);
	public void removeAccessoryShop(Integer shopId, Integer accessoryId);
	
	// Accessory
	public void addAccessory(Accessory a);
	public Collection<Accessory> getAllAccessory();
	public Accessory getAccessory(Integer accessoryId);
	public void updateAccessory(Accessory a);
	public void deleteAccessory(Integer accessoryId);
	public void addDeviceAccessory(Integer accessoryId, Integer deviceId);
	public void removeDeviceAccessory(Integer accessoryId, Integer deviceId);
	
	// Complement
	public void addComplement(Complement c);
	public Collection<Complement> getAllComplement();
	public Complement getComplement(Integer completentId);
	public void updateComplement(Complement c);
	public void deleteComplement(Integer complementId);
	public void addDeviceComplement(Integer complementId, Integer deviceId);
	public void removeDeviceComplement(Integer complementId, Integer deviceId);
	
}
