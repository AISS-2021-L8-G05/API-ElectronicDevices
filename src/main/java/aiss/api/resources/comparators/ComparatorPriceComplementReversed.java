package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Complement;

public class ComparatorPriceComplementReversed implements Comparator<Complement>{

	@Override
	public int compare(Complement c1, Complement c2) {
		return c2.getPrice().compareTo(c1.getPrice());
	}

}
