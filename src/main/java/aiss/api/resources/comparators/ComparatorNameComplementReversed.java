package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Complement;

public class ComparatorNameComplementReversed implements Comparator<Complement>{

	@Override
	public int compare(Complement c1, Complement c2) {
		return c2.getName().compareTo(c1.getName());
	}

}
