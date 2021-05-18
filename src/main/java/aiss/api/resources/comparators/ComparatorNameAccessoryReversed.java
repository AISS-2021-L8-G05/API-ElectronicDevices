package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Accessory;

public class ComparatorNameAccessoryReversed implements Comparator<Accessory>{

	@Override
	public int compare(Accessory a1, Accessory a2) {
		return a2.getName().compareTo(a1.getName());
	}

}
