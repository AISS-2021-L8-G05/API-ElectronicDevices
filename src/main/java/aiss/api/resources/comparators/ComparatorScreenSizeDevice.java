package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Device;

public class ComparatorScreenSizeDevice implements Comparator<Device>{

	@Override
	public int compare(Device d1, Device d2) {
		return d1.getScreenSize().compareTo(d2.getScreenSize());
	}

}
