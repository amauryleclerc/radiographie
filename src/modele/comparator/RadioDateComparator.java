package modele.comparator;

import java.util.Comparator;

import modele.metier.Radiographie;

public class RadioDateComparator implements Comparator<Radiographie> {

	@Override
	public int compare(Radiographie r1, Radiographie r2) {
		if( r1.getDatePrise().compareTo( r2.getDatePrise())==0){
			return Integer.compare(r1.getNumExam(), r2.getNumExam());
		}
		return r1.getDatePrise().compareTo( r2.getDatePrise());
}
}