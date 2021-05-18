package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Accessory;

public class ComparatorPriceAccessoryReversed implements Comparator<Accessory>{

	@Override
	public int compare(Accessory a1, Accessory a2) {
		return a2.getPrice().compareTo(a1.getPrice());
	}

}
