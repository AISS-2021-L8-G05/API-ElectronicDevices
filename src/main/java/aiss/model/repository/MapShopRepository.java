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
		
			// macBookPro16
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
		
			// Galaxy S20 FE
		Device galaxyS20FE = new Device();
		galaxyS20FE.setName("Galaxy S20 FE");
		galaxyS20FE.setBrand("Samsung");
		galaxyS20FE.setPrice(649.);
		galaxyS20FE.setScreenSize(6.5);
		galaxyS20FE.setWeight(0.19);
		galaxyS20FE.setDeviceType(DeviceType.MOBILE);
		galaxyS20FE.setStorage(128);
		galaxyS20FE.setProcessor("Samsung Exynos 990");
		galaxyS20FE.setMemory(6);
		galaxyS20FE.setOS("Android");
		galaxyS20FE.setCamera("Principal 12Mp");
		Set<String> galaxyS20FEColors = new HashSet<String>();
		galaxyS20FEColors.add("Cloud Navy"); galaxyS20FEColors.add("Cloud Red"); 
		galaxyS20FEColors.add("Cloud Orange"); galaxyS20FEColors.add("Cloud white");
		galaxyS20FE.setSetColors(galaxyS20FEColors);
		addDevice(galaxyS20FE);
		
			// Xiaomi Mi Tv 4s
		Device miTv4s = new Device();
		miTv4s.setName("Mi TV 4s");
		miTv4s.setBrand("Xiaomi");
		miTv4s.setPrice(449.);
		miTv4s.setScreenSize(55.);
		miTv4s.setWeight(12.45);
		miTv4s.setDeviceType(DeviceType.SMART_TV);
		miTv4s.setStorage(8);
		miTv4s.setProcessor("MediaTek MSD6886");
		miTv4s.setMemory(2);
		miTv4s.setOS("Android TV");
		miTv4s.setCamera("-");
		Set<String> miTV4sColors = new HashSet<String>();
		miTV4sColors.add("Black");
		miTv4s.setSetColors(miTV4sColors);
		addDevice(miTv4s);
		
			// Huawei P20 Lite
		Device p20Lite = new Device();
		p20Lite.setName("P20 Lite");
		p20Lite.setBrand("Huawei");
		p20Lite.setPrice(450.0);
		p20Lite.setScreenSize(5.8);
		p20Lite.setWeight(0.145);
		p20Lite.setDeviceType(DeviceType.MOBILE);
		p20Lite.setStorage(64);
		p20Lite.setProcessor("Kirin 659");
		p20Lite.setMemory(4);
		p20Lite.setOS("Android");
		p20Lite.setCamera("Principal 16 Mp");
		Set<String> p20LiteColors = new HashSet<String>();
		p20LiteColors.add("Blue"); p20LiteColors.add("White");
		p20LiteColors.add("Black");
		p20Lite.setSetColors(p20LiteColors);
		addDevice(p20Lite);
		
			// Xiaomi Mi Band 6
		Device miBand6 = new Device();
		miBand6.setName("Mi Band 6");
		miBand6.setBrand("Xiaomi");
		miBand6.setPrice(45.5);
		miBand6.setScreenSize(1.56);
		miBand6.setWeight(0.128);
		miBand6.setDeviceType(DeviceType.SMARTBAND);
		miBand6.setStorage(1);
		miBand6.setProcessor("-");
		miBand6.setMemory(1);
		miBand6.setOS("-");
		miBand6.setCamera("-");
		Set<String> miBand6Colors = new HashSet<>();
		miBand6Colors.add("Black");
		miBand6.setSetColors(miBand6Colors);
		addDevice(miBand6);
		
			// iMac M1
		Device iMacM1 = new Device();
		iMacM1.setName("iMac");
		iMacM1.setBrand("Apple");
		iMacM1.setPrice(1449.);
		iMacM1.setScreenSize(24.);
		iMacM1.setWeight(4.46);
		iMacM1.setDeviceType(DeviceType.COMPUTER);
		iMacM1.setStorage(256);
		iMacM1.setProcessor("Apple M1");
		iMacM1.setMemory(8);
		iMacM1.setOS("macOS");
		iMacM1.setCamera("Front-facing: Facetime HD (1080p)");
		Set<String> iMacM1Colors = new HashSet<String>();
		iMacM1Colors.add("Blue"); iMacM1Colors.add("Green"); 
		iMacM1Colors.add("Pink"); iMacM1Colors.add("Silver");
		iMacM1.setSetColors(iMacM1Colors);
		addDevice(iMacM1);
		
			// Asus Rog Strix G15
		Device asusRog = new Device();
		asusRog.setName("Rog Strix G15");
		asusRog.setBrand("Asus");
		asusRog.setPrice(1490.);
		asusRog.setScreenSize(15.6);
		asusRog.setWeight(2.5);
		asusRog.setDeviceType(DeviceType.COMPUTER);
		asusRog.setStorage(1000);
		asusRog.setProcessor("Intel i7-10750H");
		asusRog.setMemory(16);
		asusRog.setOS("Windows");
		asusRog.setCamera("-");
		Set<String> asusRogColors = new HashSet<String>();
		asusRogColors.add("Black"); asusRogColors.add("Grey");
		asusRog.setSetColors(asusRogColors);
		addDevice(asusRog);		
		
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
