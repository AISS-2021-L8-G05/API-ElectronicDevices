package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Device;

public class ComparatorNameDevice implements Comparator<Device>{

	@Override
	public int compare(Device d1, Device d2) {
		return d1.getName().compareTo(d2.getName());
	}

}
