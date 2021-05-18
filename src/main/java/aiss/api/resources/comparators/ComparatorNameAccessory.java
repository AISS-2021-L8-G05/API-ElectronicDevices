package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Accessory;

public class ComparatorNameAccessory implements Comparator<Accessory>{

	@Override
	public int compare(Accessory a1, Accessory a2) {
		return a1.getName().compareTo(a2.getName());
	}

}
