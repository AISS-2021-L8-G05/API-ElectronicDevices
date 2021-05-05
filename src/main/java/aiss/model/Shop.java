package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private List<Device> devicesList;
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

}
