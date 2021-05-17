package aiss.model;

import java.util.List;

public class Accessory {
	
	private Integer accessoryId;
	private String name;
	private Boolean wireless;		
	private Double price;						// Euros
	private List<Device> compatibleDevices;		// List of compatible devices with this complement
	
	public Accessory(String name, Boolean wireless, Double price, List<Device> compatibleDevices) {
		super();
		this.name = name;
		this.wireless = wireless;
		this.price = price;
		this.compatibleDevices = compatibleDevices;
	}

	public Accessory(Integer accessoryId, String name, Boolean wireless, Double price, List<Device> compatibleDevices) {
		super();
		this.accessoryId = accessoryId;
		this.name = name;
		this.wireless = wireless;
		this.price = price;
		this.compatibleDevices = compatibleDevices;
	}

	public List<Device> getCompatibleDevices() {
		return compatibleDevices;
	}

	public void setCompatibleDevices(List<Device> compatibleDevices) {
		this.compatibleDevices = compatibleDevices;
	}

	public Integer getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(Integer accessoryId) {
		this.accessoryId = accessoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getWireless() {
		return wireless;
	}

	public void setWireless(Boolean wireless) {
		this.wireless = wireless;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	

}
