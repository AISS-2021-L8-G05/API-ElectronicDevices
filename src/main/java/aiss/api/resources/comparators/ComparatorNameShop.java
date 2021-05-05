package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Shop;

public class ComparatorNameShop implements Comparator<Shop>{

	@Override
	public int compare(Shop s1, Shop s2) {
		return s1.getName().compareTo(s2.getName());
	}

}
