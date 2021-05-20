package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private List<Device> devicesList;
	private List<Complement> complementsList;
	private List<Accessory> accessoriesList;
	private String name;
	private Integer id;
	private String url;

	public Shop() {
	}

	public Shop(String name) {
		this.name = name;
	}

	protected void setDevice(List<Device> d) {
		devicesList = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Device> getDevices(){
		return devicesList;
	}

	public Device getDevice(Integer id) {
		if (devicesList == null)
			return null;
		
		Device result = null;
		for (Device d : devicesList) {
			if (d.getId().equals(id)) {
				result = d;
				break;
			}
		}
		return result;
	}
	
	public void addDevice(Device d) {
		if(devicesList == null)
			devicesList = new ArrayList<Device>();
		devicesList.add(d);
	}
	
	public void deleteDevice(Device d) {
		devicesList.remove(d);
	}
	
	public void deleteDevice(Integer id) {
		Device d = getDevice(id);
		if(d!=null)
			devicesList.remove(d);
	}
	
	public List<Complement> getComplements(){
		return complementsList;
	}

	public Complement getComplement(Integer id) {
		if (complementsList == null)
			return null;
		
		Complement result = null;
		for (Complement c : complementsList) {
			if (c.getComplementId().equals(id)) {
				result = c;
				break;
			}
		}
		return result;
	}
	
	public void addComplement(Complement c) {
		if(complementsList == null) this.complementsList = new ArrayList<Complement>();
		this.complementsList.add(c);
	}
	
	public void deleteComplement(Complement c) {
		complementsList.remove(c);
	}
	
	public void deleteComplement(Integer id) {
		Complement c = getComplement(id);
		if(c!=null)
			complementsList.remove(c);
	}
	
	public List<Accessory> getAccesories(){
		return accessoriesList;
	}

	public Accessory getAccessory(Integer id) {
		if (accessoriesList == null)
			return null;
		
		Accessory result = null;
		for (Accessory a : accessoriesList) {
			if (a.getAccessoryId().equals(id)) {
				result = a;
				break;
			}
		}
		return result;
	}
	
	public void addAccessory(Accessory a) {
		if(accessoriesList == null) accessoriesList = new ArrayList<Accessory>();
		accessoriesList.add(a);
 	}
	
	public void deleteAccessory(Accessory a) {
		accessoriesList.remove(a);
	}
	
	public void deleteAccessory(Integer id) {
		Accessory a = getAccessory(id);
		if(a!=null)
			accessoriesList.remove(a);
	}

}
