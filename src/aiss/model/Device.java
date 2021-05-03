package aiss.model;

import java.util.Set;

public class Device {
	private Integer id;
	private String name;
	private String brand;
	private Double price;		// Euros
	private Double screenSize;	// Inches
	private Double weight;		// g
	private DeviceType deviceType;
	private Integer storage;
	private String proccesor;
	private Integer memory;
	private String SO;		
	private Set<String> setColors;
	private String camera; 		//Mpx
	
	public Device () {
		
	}

	public Device(String name, String brand, Double price, Double screenSize, Double weight, DeviceType deviceType,
			Integer storage, String proccesor, Integer memory, String sO, Set<String> setColors, String camera) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.screenSize = screenSize;
		this.weight = weight;
		this.deviceType = deviceType;
		this.storage = storage;
		this.proccesor = proccesor;
		this.memory = memory;
		SO = sO;
		this.setColors = setColors;
		this.camera = camera;
	}

	public Device(Integer id, String name, String brand, Double price, Double screenSize, Double weight,
			DeviceType deviceType, Integer storage, String proccesor, Integer memory, String sO, Set<String> setColors,
			String camera) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.screenSize = screenSize;
		this.weight = weight;
		this.deviceType = deviceType;
		this.storage = storage;
		this.proccesor = proccesor;
		this.memory = memory;
		SO = sO;
		this.setColors = setColors;
		this.camera = camera;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Double screenSize) {
		this.screenSize = screenSize;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public String getProccesor() {
		return proccesor;
	}

	public void setProccesor(String proccesor) {
		this.proccesor = proccesor;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public String getSO() {
		return SO;
	}

	public void setSO(String sO) {
		SO = sO;
	}

	public Set<String> getSetColors() {
		return setColors;
	}

	public void setSetColors(Set<String> setColors) {
		this.setColors = setColors;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}
	
	
	
}
