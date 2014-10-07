package modele.comparator;

import java.util.Comparator;

import modele.metier.Radiographie;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
public class RadioPatientComparator implements Comparator<Radiographie> {

	@Override
	public int compare(Radiographie r1, Radiographie r2) {
		
		if( r1.getPatient().getNom().compareTo( r2.getPatient().getNom())==0){
			return r1.getPatient().getPrenom().compareTo( r2.getPatient().getPrenom());
		}
		return r1.getPatient().getNom().compareTo( r2.getPatient().getNom());
}
}