package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aiss.model.Accessory;
import aiss.model.Complement;
import aiss.model.Device;
import aiss.model.Shop;

public class MapShopRepository implements ShopRepository {

	Map<Integer, Shop> shopMap;
	Map<Integer, Device> deviceMap;
	Map<Integer, Accessory> accessoryMap;
	Map<Integer, Complement> complementMap;
 	private static MapShopRepository instance = null;
	private int index = 0; // Index to create shops and devices identifiers.

	public static MapShopRepository getInstance() {
		if (instance == null) {
			instance = new MapShopRepository();
			instance.init();
		}
		return instance;
	}

	public void init() {
		shopMap = new HashMap<Integer, Shop>();
		deviceMap = new HashMap<Integer, Device>();
		accessoryMap = new HashMap<Integer, Accessory>();
		complementMap = new HashMap<Integer, Complement>();

		// Create devices

		// macBookPro16
		Device macBookPro16 = new Device();
		macBookPro16.setName("MacBook Pro");
		macBookPro16.setBrand("Apple");
		macBookPro16.setPrice(3100.0);
		macBookPro16.setScreenSize(16.0);
		macBookPro16.setWeight(2.0);
		macBookPro16.setDeviceType("computer");
		macBookPro16.setStorage(1000);
		macBookPro16.setProcessor("Intel i9-8core (9th gen)");
		macBookPro16.setMemory(16);
		macBookPro16.setOS("macOS");
		macBookPro16.setCamera("Front-facing: Facetime HD (720p)");
		Set<String> macBookPro16Colors = new HashSet<String>();
		macBookPro16Colors.add("Space grey");
		macBookPro16Colors.add("Silver");
		macBookPro16.setSetColors(macBookPro16Colors);
		addDevice(macBookPro16);

		// Galaxy S20 FE
		Device galaxyS20FE = new Device();
		galaxyS20FE.setName("Galaxy S20 FE");
		galaxyS20FE.setBrand("Samsung");
		galaxyS20FE.setPrice(649.);
		galaxyS20FE.setScreenSize(6.5);
		galaxyS20FE.setWeight(0.19);
		galaxyS20FE.setDeviceType("mobile");
		galaxyS20FE.setStorage(128);
		galaxyS20FE.setProcessor("Samsung Exynos 990");
		galaxyS20FE.setMemory(6);
		galaxyS20FE.setOS("Android");
		galaxyS20FE.setCamera("Main 12Mp");
		Set<String> galaxyS20FEColors = new HashSet<String>();
		galaxyS20FEColors.add("Cloud Navy");
		galaxyS20FEColors.add("Cloud Red");
		galaxyS20FEColors.add("Cloud Orange");
		galaxyS20FEColors.add("Cloud white");
		galaxyS20FE.setSetColors(galaxyS20FEColors);
		addDevice(galaxyS20FE);

		// Xiaomi Mi Tv 4s
		Device miTv4s = new Device();
		miTv4s.setName("Mi TV 4s");
		miTv4s.setBrand("Xiaomi");
		miTv4s.setPrice(449.);
		miTv4s.setScreenSize(55.);
		miTv4s.setWeight(12.45);
		miTv4s.setDeviceType("SMART_TV");
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
		p20Lite.setDeviceType("MOBILE");
		p20Lite.setStorage(64);
		p20Lite.setProcessor("Kirin 659");
		p20Lite.setMemory(4);
		p20Lite.setOS("Android");
		p20Lite.setCamera("Main 16 Mp");
		Set<String> p20LiteColors = new HashSet<String>();
		p20LiteColors.add("Blue");
		p20LiteColors.add("White");
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
		miBand6.setDeviceType("SMARTBAND");
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
		iMacM1.setDeviceType("COMPUTER");
		iMacM1.setStorage(256);
		iMacM1.setProcessor("Apple M1");
		iMacM1.setMemory(8);
		iMacM1.setOS("macOS");
		iMacM1.setCamera("Front-facing: Facetime HD (1080p)");
		Set<String> iMacM1Colors = new HashSet<String>();
		iMacM1Colors.add("Blue");
		iMacM1Colors.add("Green");
		iMacM1Colors.add("Pink");
		iMacM1Colors.add("Silver");
		iMacM1.setSetColors(iMacM1Colors);
		addDevice(iMacM1);

		// Asus Rog Strix G15
		Device asusRog = new Device();
		asusRog.setName("Rog Strix G15");
		asusRog.setBrand("Asus");
		asusRog.setPrice(1490.);
		asusRog.setScreenSize(15.6);
		asusRog.setWeight(2.5);
		asusRog.setDeviceType("COMPUTER");
		asusRog.setStorage(1000);
		asusRog.setProcessor("Intel i7-10750H");
		asusRog.setMemory(16);
		asusRog.setOS("Windows 10");
		asusRog.setCamera("-");
		Set<String> asusRogColors = new HashSet<String>();
		asusRogColors.add("Black");
		asusRogColors.add("Grey");
		asusRog.setSetColors(asusRogColors);
		addDevice(asusRog);

		// iPadProM1
		Device iPadProM1 = new Device();
		iPadProM1.setName("iPad Pro M1");
		iPadProM1.setBrand("Apple");
		iPadProM1.setPrice(879.);
		iPadProM1.setScreenSize(11.);
		iPadProM1.setWeight(0.468);
		iPadProM1.setDeviceType("tablet");
		iPadProM1.setStorage(128);
		iPadProM1.setProcessor("Apple M1");
		iPadProM1.setMemory(8);
		iPadProM1.setOS("iPadOS");
		iPadProM1.setCamera("Main: 12 Mpx");
		Set<String> iPadProM1Colors = new HashSet<String>();
		iPadProM1Colors.add("Space grey");
		iPadProM1Colors.add("Silver");
		iPadProM1.setSetColors(iPadProM1Colors);
		addDevice(iPadProM1);

		// iPadAir
		Device iPadAir = new Device();
		iPadAir.setName("iPad Air");
		iPadAir.setBrand("Apple");
		iPadAir.setPrice(649.);
		iPadAir.setScreenSize(10.9);
		iPadAir.setWeight(0.458);
		iPadAir.setDeviceType("tablet");
		iPadAir.setStorage(64);
		iPadAir.setProcessor("Apple A14 Bionic");
		iPadAir.setMemory(4);
		iPadAir.setOS("iPadOS");
		iPadAir.setCamera("Main: 7 Mpx");
		Set<String> iPadAirColors = new HashSet<String>();
		iPadAirColors.add("Silver");
		iPadAirColors.add("Space grey");
		iPadAirColors.add("Rose Gold");
		iPadAirColors.add("Green");
		iPadAirColors.add("Sky Blue");
		iPadAir.setSetColors(iPadAirColors);
		addDevice(iPadAir);

		// xiaomi11i
		Device xiaomi11i = new Device();
		xiaomi11i.setName("Mi 11i 5G");
		xiaomi11i.setBrand("Xiaomi");
		xiaomi11i.setPrice(699.0);
		xiaomi11i.setScreenSize(6.67);
		xiaomi11i.setWeight(0.2);
		xiaomi11i.setDeviceType("mobile");
		xiaomi11i.setStorage(256);
		xiaomi11i.setProcessor("Qualcomm Snapdragon 888");
		xiaomi11i.setMemory(8);
		xiaomi11i.setOS("Android");
		xiaomi11i.setCamera("Main: 108MP");
		Set<String> xiaomi11iColors = new HashSet<String>();
		xiaomi11iColors.add("Silver");
		xiaomi11i.setSetColors(xiaomi11iColors);
		addDevice(xiaomi11i);

		// samsungGalaxyA20s
		Device samsungGalaxyA20s = new Device();
		samsungGalaxyA20s.setName("Galaxy A20s");
		samsungGalaxyA20s.setBrand("Samsung");
		samsungGalaxyA20s.setPrice(129.0);
		samsungGalaxyA20s.setScreenSize(6.5);
		samsungGalaxyA20s.setWeight(0.22);
		samsungGalaxyA20s.setDeviceType("mobile");
		samsungGalaxyA20s.setStorage(32);
		samsungGalaxyA20s.setProcessor("Qualcomm Snapdragon 450");
		samsungGalaxyA20s.setMemory(3);
		samsungGalaxyA20s.setOS("Android");
		samsungGalaxyA20s.setCamera("Single Cam");
		Set<String> samsungGalaxyA20sColors = new HashSet<String>();
		samsungGalaxyA20sColors.add("Black");
		samsungGalaxyA20s.setSetColors(samsungGalaxyA20sColors);
		addDevice(samsungGalaxyA20s);

		// iphone12ProMax
		Device iphone12ProMax = new Device();
		iphone12ProMax.setName("iPhone 12 Pro Max");
		iphone12ProMax.setBrand("Apple");
		iphone12ProMax.setPrice(1238.0);
		iphone12ProMax.setScreenSize(6.7);
		iphone12ProMax.setWeight(0.19);
		iphone12ProMax.setDeviceType("mobile");
		iphone12ProMax.setStorage(128);
		iphone12ProMax.setProcessor("Apple A14 Bionic");
		iphone12ProMax.setMemory(6);
		iphone12ProMax.setOS("iOS");
		iphone12ProMax.setCamera("Main: 12MP");
		Set<String> iphone12ProMaxColors = new HashSet<String>();
		iphone12ProMaxColors.add("Graphite");
		iphone12ProMax.setSetColors(iphone12ProMaxColors);
		addDevice(iphone12ProMax);

		// Huawei MatePad
		Device huaweiMatePad = new Device();
		huaweiMatePad.setName("MatePad");
		huaweiMatePad.setBrand("Huawei");
		huaweiMatePad.setPrice(279.);
		huaweiMatePad.setScreenSize(10.4);
		huaweiMatePad.setWeight(0.45);
		huaweiMatePad.setDeviceType("tablet");
		huaweiMatePad.setStorage(32);
		huaweiMatePad.setProcessor("Huawei Kirin 810");
		huaweiMatePad.setMemory(3);
		huaweiMatePad.setOS("Android");
		huaweiMatePad.setCamera("Main: 8MP");
		Set<String> huaweiMatePadColors = new HashSet<String>();
		huaweiMatePadColors.add("Greys");
		huaweiMatePad.setSetColors(huaweiMatePadColors);
		addDevice(huaweiMatePad);

		// huaweiMate40Pro
		Device huaweiMate40Pro = new Device();
		huaweiMate40Pro.setName("Huawei Mate 40 Pro Plus 5G");
		huaweiMate40Pro.setBrand("Huawei");
		huaweiMate40Pro.setPrice(1400.0);
		huaweiMate40Pro.setScreenSize(6.7);
		huaweiMate40Pro.setWeight(0.16);
		huaweiMate40Pro.setDeviceType("mobile");
		huaweiMate40Pro.setStorage(256);
		huaweiMate40Pro.setProcessor("Main: 50MP");
		huaweiMate40Pro.setMemory(12);
		huaweiMate40Pro.setOS("Android");
		huaweiMate40Pro.setCamera("Cámara triple de 12 Mpx con gran angular");
		Set<String> huaweiMate40ProColors = new HashSet<String>();
		huaweiMate40ProColors.add("Balck");
		huaweiMate40ProColors.add("White");
		huaweiMate40Pro.setSetColors(huaweiMate40ProColors);
		addDevice(huaweiMate40Pro);

		// macBookAir
		Device macBookAir = new Device();
		macBookAir.setName("MacBook Air");
		macBookAir.setBrand("Apple");
		macBookAir.setPrice(1129.0);
		macBookAir.setScreenSize(13.3);
		macBookAir.setWeight(1.29);
		macBookAir.setDeviceType("computer");
		macBookAir.setStorage(256);
		macBookAir.setProcessor("Apple M1");
		macBookAir.setMemory(8);
		macBookAir.setOS("macOS");
		macBookAir.setCamera("Front-facing: Facetime HD (720p)");
		Set<String> macBookAirColors = new HashSet<String>();
		macBookAirColors.add("Space grey");
		macBookAirColors.add("Silver");
		macBookAirColors.add("Gold");
		macBookAir.setSetColors(macBookAirColors);
		addDevice(macBookAir);

		// surfaceBook3
		Device surfaceBook3 = new Device();
		surfaceBook3.setName("Surface Book 3");
		surfaceBook3.setBrand("Microsoft");
		surfaceBook3.setPrice(2599.0);
		surfaceBook3.setScreenSize(15.0);
		surfaceBook3.setWeight(1.905);
		surfaceBook3.setDeviceType("computer");
		surfaceBook3.setStorage(256);
		surfaceBook3.setProcessor("Intel i7-4core (10th gen)");
		surfaceBook3.setMemory(16);
		surfaceBook3.setOS("Windows 10");
		surfaceBook3.setCamera("Front-facing: 5MP (1080p)");
		Set<String> surfaceBook3Colors = new HashSet<String>();
		surfaceBook3Colors.add("Silver");
		surfaceBook3.setSetColors(surfaceBook3Colors);
		addDevice(surfaceBook3);

		// mateBookXPro
		Device mateBookXPro = new Device();
		mateBookXPro.setName("MateBook X Pro");
		mateBookXPro.setBrand("Huawei");
		mateBookXPro.setPrice(1899.0);
		mateBookXPro.setScreenSize(13.9);
		mateBookXPro.setWeight(1.33);
		mateBookXPro.setDeviceType("computer");
		mateBookXPro.setStorage(1000);
		mateBookXPro.setProcessor("Intel i7-4core (11th gen)");
		mateBookXPro.setMemory(16);
		mateBookXPro.setOS("Windows 10");
		mateBookXPro.setCamera("Front-facing: 1MP (720p)");
		Set<String> mateBookXProColors = new HashSet<String>();
		mateBookXProColors.add("Space grey");
		mateBookXProColors.add("Emerald grey");
		mateBookXPro.setSetColors(mateBookXProColors);
		addDevice(mateBookXPro);

		// samsungCrystalUHD85"
		Device crystalUHD85 = new Device();
		crystalUHD85.setName("Crystal UHD 85`");
		crystalUHD85.setBrand("Samsung");
		crystalUHD85.setPrice(1999.);
		crystalUHD85.setScreenSize(85.);
		crystalUHD85.setWeight(41.5);
		crystalUHD85.setDeviceType("SMART_TV");
		crystalUHD85.setStorage(8);
		crystalUHD85.setProcessor("Samsung Crystal UHD");
		crystalUHD85.setMemory(4);
		crystalUHD85.setOS("Tizen");
		crystalUHD85.setCamera("Fron-facing: (1080)");
		Set<String> crystalUHD85Color = new HashSet<String>();
		crystalUHD85Color.add("Black");
		crystalUHD85.setSetColors(mateBookXProColors);
		addDevice(crystalUHD85);

		// thinkPadX1Carbon
		Device thinkPadX1Carbon = new Device();
		thinkPadX1Carbon.setName("ThinkPad X1 Carbon");
		thinkPadX1Carbon.setBrand("Lenovo");
		thinkPadX1Carbon.setPrice(1829.0);
		thinkPadX1Carbon.setScreenSize(14.0);
		thinkPadX1Carbon.setWeight(1.13);
		thinkPadX1Carbon.setDeviceType("computer");
		thinkPadX1Carbon.setStorage(256);
		thinkPadX1Carbon.setProcessor("Intel i5-4core (11th gen)");
		thinkPadX1Carbon.setMemory(8);
		thinkPadX1Carbon.setOS("Windows 10");
		thinkPadX1Carbon.setCamera("Front-facing: IR HD (720p)");
		Set<String> thinkPadX1CarbonColors = new HashSet<String>();
		thinkPadX1CarbonColors.add("Carbon");
		thinkPadX1Carbon.setSetColors(thinkPadX1CarbonColors);
		addDevice(thinkPadX1Carbon);

		// appleWatchSeries6
		Device appleWatchSeries6 = new Device();
		appleWatchSeries6.setName("Apple Watch Series 6");
		appleWatchSeries6.setBrand("Apple");
		appleWatchSeries6.setPrice(429.0);
		appleWatchSeries6.setScreenSize(1.5);
		appleWatchSeries6.setWeight(0.0471);
		appleWatchSeries6.setDeviceType("smartwatch");
		appleWatchSeries6.setStorage(32);
		appleWatchSeries6.setProcessor("Apple S6");
		appleWatchSeries6.setMemory(1);
		appleWatchSeries6.setOS("watchOS");
		appleWatchSeries6.setCamera("-");
		Set<String> appleWatchSeries6Colors = new HashSet<String>();
		appleWatchSeries6Colors.add("Silver");
		appleWatchSeries6Colors.add("Space grey");
		appleWatchSeries6Colors.add("Gold");
		appleWatchSeries6Colors.add("Blue");
		appleWatchSeries6Colors.add("Red");
		appleWatchSeries6.setSetColors(appleWatchSeries6Colors);
		addDevice(appleWatchSeries6);

		// appleWatchSE
		Device appleWatchSE = new Device();
		appleWatchSE.setName("Apple Watch SE");
		appleWatchSE.setBrand("Apple");
		appleWatchSE.setPrice(299.0);
		appleWatchSE.setScreenSize(1.5);
		appleWatchSE.setWeight(0.0471);
		appleWatchSE.setDeviceType("SMARTWATCH");
		appleWatchSE.setStorage(32);
		appleWatchSE.setProcessor("Apple S5");
		appleWatchSE.setMemory(1);
		appleWatchSE.setOS("watchOS");
		appleWatchSE.setCamera("-");
		Set<String> appleWatchSEColors = new HashSet<String>();
		appleWatchSEColors.add("Silver");
		appleWatchSEColors.add("Space grey");
		appleWatchSEColors.add("Gold");
		appleWatchSE.setSetColors(appleWatchSEColors);
		addDevice(appleWatchSE);

		// galaxyWatch3
		Device galaxyWatch3 = new Device();
		galaxyWatch3.setName("Galaxy Watch3");
		galaxyWatch3.setBrand("Samsung");
		galaxyWatch3.setPrice(349.0);
		galaxyWatch3.setScreenSize(1.4);
		galaxyWatch3.setWeight(0.0538);
		galaxyWatch3.setDeviceType("SMARTWATCH");
		galaxyWatch3.setStorage(8);
		galaxyWatch3.setProcessor("Samsung Exynos");
		galaxyWatch3.setMemory(1);
		galaxyWatch3.setOS("Tizen");
		galaxyWatch3.setCamera("-");
		Set<String> galaxyWatch3Colors = new HashSet<String>();
		galaxyWatch3Colors.add("Silver");
		galaxyWatch3Colors.add("Black");
		galaxyWatch3Colors.add("Gold");
		galaxyWatch3.setSetColors(galaxyWatch3Colors);
		addDevice(galaxyWatch3);

		// galaxyWatchActive2
		Device galaxyWatchActive2 = new Device();
		galaxyWatchActive2.setName("Galaxy Watch Active2");
		galaxyWatchActive2.setBrand("Samsung");
		galaxyWatchActive2.setPrice(209.0);
		galaxyWatchActive2.setScreenSize(1.2);
		galaxyWatchActive2.setWeight(0.026);
		galaxyWatchActive2.setDeviceType("SMARTWATCH");
		galaxyWatchActive2.setStorage(4);
		galaxyWatchActive2.setProcessor("Samsung Exynos");
		galaxyWatchActive2.setMemory(1);
		galaxyWatchActive2.setOS("Tizen");
		galaxyWatchActive2.setCamera("-");
		Set<String> galaxyWatchActive2Colors = new HashSet<String>();
		galaxyWatchActive2Colors.add("Silver");
		galaxyWatchActive2Colors.add("Black");
		galaxyWatchActive2Colors.add("Gold");
		galaxyWatchActive2.setSetColors(galaxyWatchActive2Colors);
		addDevice(galaxyWatchActive2);

		// Xiaomi Mi Band 5
		Device miBand5 = new Device();
		miBand5.setName("Mi Band 5");
		miBand5.setBrand("Xiaomi");
		miBand5.setPrice(35.);
		miBand5.setScreenSize(1.1);
		miBand5.setWeight(0.119);
		miBand5.setDeviceType("smartband");
		miBand5.setStorage(1);
		miBand5.setProcessor("-");
		miBand5.setMemory(1);
		miBand5.setOS("-");
		miBand5.setCamera("-");
		Set<String> miBand5Colors = new HashSet<>();
		miBand5Colors.add("Black");
		miBand5.setSetColors(miBand5Colors);
		addDevice(miBand5);

		// Samsung Galaxy Fit
		Device galaxyFit2 = new Device();
		galaxyFit2.setName("Galaxy Fit 2");
		galaxyFit2.setBrand("Samsung");
		galaxyFit2.setPrice(34.90);
		galaxyFit2.setScreenSize(1.1);
		galaxyFit2.setWeight(0.021);
		galaxyFit2.setDeviceType("smartband");
		galaxyFit2.setStorage(1);
		galaxyFit2.setProcessor("-");
		galaxyFit2.setMemory(1);
		galaxyFit2.setOS("-");
		galaxyFit2.setCamera("-");
		Set<String> galaxyFit2Colors = new HashSet<>();
		galaxyFit2Colors.add("Black");
		galaxyFit2.setSetColors(galaxyFit2Colors);
		addDevice(galaxyFit2);
		
		// Create complement
		Complement siliconCase = new Complement();
		siliconCase.setName("Silicon Case Iphone 12 Pro Max");
		siliconCase.setPrice(50.);
		siliconCase.setMaterial("silicon");
		Set<Device> siliconCaseCompatibleDevice = new HashSet<>();
		siliconCaseCompatibleDevice.add(iphone12ProMax);
		siliconCase.addCompatibleDevies(siliconCaseCompatibleDevice);
		addComplement(siliconCase);
		
		
		// Create shops

		// Worten
		Shop worten = new Shop();
		worten.setName("Worten");
		worten.setUrl("https://www.worten.es");
		addShop(worten);

		// MediaMarkt
		Shop mediaMarkt = new Shop();
		mediaMarkt.setName("MediaMarkt");
		mediaMarkt.setUrl("https://www.mediamarkt.es");
		addShop(mediaMarkt);

		// PcComponentes
		Shop pcComponentes = new Shop();
		pcComponentes.setName("PcComponentes");
		pcComponentes.setUrl("https://www.pccomponentes.com/");
		addShop(pcComponentes);

		// ElCorteIngles
		Shop elCorteIngles = new Shop();
		elCorteIngles.setName("El Corte Ingles");
		elCorteIngles.setUrl("https://www.elcorteingles.es/");
		addShop(elCorteIngles);

		// Add devices to shops

		// Add Worten
		addDevice(worten.getId(), macBookPro16.getId());
		addDevice(worten.getId(), galaxyS20FE.getId());
		addDevice(worten.getId(), p20Lite.getId());
		addDevice(worten.getId(), miBand6.getId());
		addDevice(worten.getId(), asusRog.getId());
		addDevice(worten.getId(), iPadProM1.getId());
		addDevice(worten.getId(), xiaomi11i.getId());
		addDevice(worten.getId(), samsungGalaxyA20s.getId());
		addDevice(worten.getId(), huaweiMatePad.getId());
		addDevice(worten.getId(), huaweiMate40Pro.getId());
		addDevice(worten.getId(), surfaceBook3.getId());
		addDevice(worten.getId(), mateBookXPro.getId());

		// Add MediaMarkt
		addDevice(mediaMarkt.getId(), macBookPro16.getId());
		addDevice(mediaMarkt.getId(), miTv4s.getId());
		addDevice(mediaMarkt.getId(), p20Lite.getId());
		addDevice(mediaMarkt.getId(), iMacM1.getId());
		addDevice(mediaMarkt.getId(), asusRog.getId());
		addDevice(mediaMarkt.getId(), iPadProM1.getId());
		addDevice(mediaMarkt.getId(), iPadAir.getId());
		addDevice(mediaMarkt.getId(), xiaomi11i.getId());
		addDevice(mediaMarkt.getId(), huaweiMate40Pro.getId());
		addDevice(mediaMarkt.getId(), macBookAir.getId());

		// Add PcComponentes
		addDevice(pcComponentes.getId(), galaxyS20FE.getId());
		addDevice(pcComponentes.getId(), miTv4s.getId());
		addDevice(pcComponentes.getId(), p20Lite.getId());
		addDevice(pcComponentes.getId(), miBand6.getId());
		addDevice(pcComponentes.getId(), iPadAir.getId());
		addDevice(pcComponentes.getId(), samsungGalaxyA20s.getId());
		addDevice(pcComponentes.getId(), iphone12ProMax.getId());
		addDevice(pcComponentes.getId(), mateBookXPro.getId());

		// Add El Corte Ingles
		addDevice(elCorteIngles.getId(), miBand6.getId());
		addDevice(elCorteIngles.getId(), iPadAir.getId());
		addDevice(elCorteIngles.getId(), iphone12ProMax.getId());
		addDevice(elCorteIngles.getId(), surfaceBook3.getId());
		addDevice(elCorteIngles.getId(), mateBookXPro.getId());

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
		device.setDeviceType(d.getDeviceType().toString());
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
	
	// Accessory

	@Override
	public void addAccessory(Accessory a) {
		Integer id = index++;
		a.setAccessoryId(id);
		accessoryMap.put(id, a);		
	}

	@Override
	public Collection<Accessory> getAllAccessory() {
		return accessoryMap.values();
	}

	@Override
	public Accessory getAccessory(Integer accessoryId) {
		return accessoryMap.get(accessoryId);
	}

	@Override
	public void updateAccessory(Accessory a) {
		accessoryMap.put(a.getAccessoryId(), a);
	}

	@Override
	public void deleteAccessory(Integer accessoryId) {
		accessoryMap.remove(accessoryId);
		
	}

	@Override
	public void addDeviceAccessory(Integer accessoryId, Integer deviceId) {
		accessoryMap.get(accessoryId).getCompatibleDevices().add(deviceMap.get(deviceId));
		
	}

	@Override
	public void removeDeviceAccessory(Integer accessoryId, Integer deviceId) {
		accessoryMap.get(accessoryId).getCompatibleDevices().remove(deviceMap.get(deviceId));
		
	}

	// Complement
	
	@Override
	public void addComplement(Complement c) {
		Integer id = index++;
		c.setComplementId(id);
		complementMap.put(id, c);
	}

	@Override
	public Collection<Complement> getAllComplement() {
		return complementMap.values();
	}

	@Override
	public Complement getComplement(Integer completentId) {
		return complementMap.get(completentId);
	}

	@Override
	public void updateComplement(Complement c) {
		complementMap.put(c.getComplementId(), c);
	}

	@Override
	public void deleteComplement(Integer complementId) {
		complementMap.remove(complementId);
	}

	@Override
	public void addDeviceComplement(Integer complementId, Integer deviceId) {
		complementMap.get(complementId).getCompatibleDevices().add(deviceMap.get(deviceId));
	}

	@Override
	public void removeDeviceComplement(Integer complementId, Integer deviceId) {
		complementMap.get(complementId).getCompatibleDevices().remove(deviceMap.get(deviceId));
	}

}
