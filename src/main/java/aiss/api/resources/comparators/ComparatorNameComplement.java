package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Complement;

public class ComparatorNameComplement implements Comparator<Complement>{

	@Override
	public int compare(Complement c1, Complement c2) {
		return c1.getName().compareTo(c2.getName());
	}

}
