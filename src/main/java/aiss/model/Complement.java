package aiss.model;

import java.util.List;

public class Complement {
	
	private Integer complementId;
	private String name;
	private String material;				// Ej: crystal, plastic, fur ... 
	private Double price; 					// Euros
	private List<Device> compatibleDevices;	// List of compatible devices with this complement
	
	public Complement(String name, String material, Double price, List<Device> compatibleDevices) {
		super();
		this.name = name;
		this.material = material;
		this.price = price;
		this.compatibleDevices = compatibleDevices;
	}

	public Complement(Integer complementId, String name, String material, Double price,
			List<Device> compatibleDevices) {
		super();
		this.complementId = complementId;
		this.name = name;
		this.material = material;
		this.price = price;
		this.compatibleDevices = compatibleDevices;
	}

	public List<Device> getCompatibleDevices() {
		return compatibleDevices;
	}

	public void setCompatibleDevices(List<Device> compatibleDevices) {
		this.compatibleDevices = compatibleDevices;
	}

	public Integer getComplementId() {
		return complementId;
	}

	public void setComplementId(Integer complementId) {
		this.complementId = complementId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
		
}
