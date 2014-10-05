package modele.comparator;

import java.util.Comparator;

import modele.metier.Radiographie;

public class RadioNumComparator implements Comparator<Radiographie> {

	@Override
	public int compare(Radiographie r1, Radiographie r2) {
		
		return Integer.compare(r1.getNumExam(), r2.getNumExam());
}
}