package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Accessory;

public class ComparatorPriceAccessory implements Comparator<Accessory>{

	@Override
	public int compare(Accessory a1, Accessory a2) {
		return a1.getPrice().compareTo(a2.getPrice());
	}

}
