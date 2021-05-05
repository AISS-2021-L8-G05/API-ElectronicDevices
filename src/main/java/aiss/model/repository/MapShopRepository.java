package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aiss.model.Device;
import aiss.model.DeviceType;
import aiss.model.Shop;

public class MapShopRepository implements ShopRepository{
	
	Map<Integer, Shop> shopMap;
	Map<Integer, Device> deviceMap;
	private static MapShopRepository instance=null;
	private int index=0;	// Index to create shops and devices identifiers.
	
	public static MapShopRepository getInstance() {
		if (instance==null) {
			instance = new MapShopRepository();
			instance.init();
		}
		return instance;
	}
	
	public void init() {
		shopMap = new HashMap<Integer, Shop>();
		deviceMap = new HashMap<Integer, Device>();
		
		// Create devices
		Device macBookPro16 = new Device();
		macBookPro16.setName("MacBook Pro");
		macBookPro16.setBrand("Apple");
		macBookPro16.setPrice(3100.0);
		macBookPro16.setScreenSize(16.0);
		macBookPro16.setWeight(2.0);
		macBookPro16.setDeviceType(DeviceType.COMPUTER);
		macBookPro16.setStorage(1000);
		macBookPro16.setProcessor("Intel i9-8core (9th gen)");
		macBookPro16.setMemory(16);
		macBookPro16.setOS("macOS");
		macBookPro16.setCamera("Front-facing: Facetime HD (720p)");
		Set<String> macBookPro16Colors = new HashSet<String>();
		macBookPro16Colors.add("Space grey"); macBookPro16Colors.add("Silver");
		macBookPro16.setSetColors(macBookPro16Colors);
		addDevice(macBookPro16);
		
		// Create shops
		Shop worten = new Shop();
		worten.setName("Worten");
		worten.setUrl("https://www.worten.es");
		addShop(worten);
		
		// Add devices to shops
		addDevice(worten.getId(), macBookPro16.getId());
	}
	
	
	// Song related opetations
	@Override
	public void addDevice(Device d) {
		Integer id = index++;
		d.setId(id);
		deviceMap.put(id, d);		
	}

	@Override
	public Collection<Device> getAllDevices() {
		return deviceMap.values();
	}

	@Override
	public Device getDevice(Integer deviceId) {
		return deviceMap.get(deviceId);
	}

	@Override
	public void updateDevice(Device d) {
		Device device = deviceMap.get(d.getId());
		device.setName(d.getName());
		device.setBrand(d.getBrand());
		device.setPrice(d.getPrice());
		device.setScreenSize(d.getScreenSize());
		device.setWeight(d.getWeight());
		device.setDeviceType(d.getDeviceType());
		device.setStorage(d.getStorage());
		device.setProcessor(d.getProcessor());
		device.setMemory(d.getMemory());
		device.setOS(d.getOS());
		device.getSetColors().addAll(d.getSetColors());
		device.setCamera(d.getCamera());
		
	}

	@Override
	public void deleteDevice(Integer deviceId) {
		deviceMap.remove(deviceId);
	}

	// Shop related operations
	@Override
	public void addShop(Shop s) {
		Integer id = index++;
		s.setId(id);
		shopMap.put(id, s);		
	}

	@Override
	public Collection<Shop> getAllShops() {
		return shopMap.values();
	}

	@Override
	public Shop getShop(Integer shopId) {
		return shopMap.get(shopId);
	}

	@Override
	public void updateShop(Shop s) {
		shopMap.put(s.getId(), s);
	}

	@Override
	public void deleteShop(Integer shopId) {
		shopMap.remove(shopId);
	}

	@Override
	public Collection<Device> getAll(Integer shopId) {
		return getShop(shopId).getDevices();
	}

	@Override
	public void addDevice(Integer shopId, Integer deviceId) {
		Shop shop = getShop(shopId);
		shop.addDevice(deviceMap.get(deviceId));
	}

	@Override
	public void removeDevice(Integer shopId, Integer deviceId) {
		getShop(shopId).deleteDevice(deviceId);
	}

}
