package modele.metier;

public class Secretaire extends Personne {

	public Secretaire(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);

	}
	public Secretaire() {
		super();
		
	}
	@Override
	public String toString() {
		return "Secretaire [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
}