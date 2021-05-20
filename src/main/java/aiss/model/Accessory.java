package aiss.model;

import java.util.HashSet;
import java.util.Set;

public class Accessory {
	
	private Integer accessoryId;
	private String name;
	private Boolean wireless;		
	private Double price;						// Euros
	private Set<Device> compatibleDevices;		// Set of compatible devices with this complement
	
	public Accessory(String name, Boolean wireless, Double price, Set<Device> compatibleDevices) {
		super();
		this.name = name;
		this.wireless = wireless;
		this.price = price;
		
		if(compatibleDevices == null) {
			this.compatibleDevices = new HashSet<Device>();
		}else {
			this.compatibleDevices = new HashSet<>(compatibleDevices);
		}
		
	}

	public Accessory(Integer accessoryId, String name, Boolean wireless, Double price, Set<Device> compatibleDevices) {
		super();
		this.accessoryId = accessoryId;
		this.name = name;
		this.wireless = wireless;
		this.price = price;

		if(compatibleDevices == null) {
			this.compatibleDevices = new HashSet<Device>();
		}else {
			this.compatibleDevices = new HashSet<>(compatibleDevices);
		}
		
	}				

	public Accessory() {
		super();
	}

	public Set<Device> getCompatibleDevices() {
		return compatibleDevices;
	}

	public void setCompatibleDevices(Set<Device> compatibleDevices) {
		this.compatibleDevices = new HashSet<Device>(compatibleDevices);
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
	
	public void addCompatibleDevices(Device d) {
		if(this.compatibleDevices == null) this.compatibleDevices = new HashSet<Device>();
		this.compatibleDevices.add(d);
	}

}
