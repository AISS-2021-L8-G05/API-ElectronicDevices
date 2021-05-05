package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Shop;

public class ComparatorNameShopReversed implements Comparator<Shop>{

	@Override
	public int compare(Shop s1, Shop s2) {
		return s2.getName().compareTo(s1.getName());
	}

}
