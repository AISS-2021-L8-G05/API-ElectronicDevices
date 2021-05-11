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
	private String processor;
	private Integer memory;
	private String OS;		
	private Set<String> setColors;
	private String camera; 		// Mpx
	
	public Device () {
		
	}

	public Device(String name, String brand, Double price, Double screenSize, Double weight, DeviceType deviceType,
			Integer storage, String processor, Integer memory, String OS, Set<String> setColors, String camera) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.screenSize = screenSize;
		this.weight = weight;
		this.deviceType = deviceType;
		this.storage = storage;
		this.processor = processor;
		this.memory = memory;
		this.OS = OS;
		this.setColors = setColors;
		this.camera = camera;
	}

	public Device(Integer id, String name, String brand, Double price, Double screenSize, Double weight,
			DeviceType deviceType, Integer storage, String processor, Integer memory, String OS, Set<String> setColors,
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
		this.processor = processor;
		this.memory = memory;
		this.OS = OS;
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

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
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
