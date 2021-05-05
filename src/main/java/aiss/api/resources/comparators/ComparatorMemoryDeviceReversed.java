package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Device;

public class ComparatorMemoryDeviceReversed implements Comparator<Device>{

	@Override
	public int compare(Device d1, Device d2) {
		return d2.getMemory().compareTo(d1.getMemory());
	}

}
