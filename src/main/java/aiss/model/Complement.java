package aiss.model;

import java.util.HashSet;
import java.util.Set;

public class Complement {
	
	private Integer complementId;
	private String name;
	private String material;				// Ej: crystal, plastic, fur ... 
	private Double price; 					// Euros
	private Set<Device> compatibleDevices;	// Set of compatible devices with this complement
	
	public Complement(String name, String material, Double price, Set<Device> compatibleDevices) {
		super();
		this.name = name;
		this.material = material;
		this.price = price;
		this.compatibleDevices = new HashSet<Device>(compatibleDevices);
	}

	public Complement(Integer complementId, String name, String material, Double price,
			Set<Device> compatibleDevices) {
		super();
		this.complementId = complementId;
		this.name = name;
		this.material = material;
		this.price = price;
		this.compatibleDevices = new HashSet<Device>(compatibleDevices);
	}

	public Complement() {
		super();
	}

	public Set<Device> getCompatibleDevices() {
		return compatibleDevices;
	}

	public void setCompatibleDevices(Set<Device> compatibleDevices) {
		this.compatibleDevices = new HashSet<Device>(compatibleDevices);
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
	
	public void addCompatibleDevies(Set<Device> s) {
		this.compatibleDevices = s;
	}
		
}
