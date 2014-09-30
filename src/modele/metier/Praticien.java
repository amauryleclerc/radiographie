package modele.metier;

public class Praticien extends Personne {
	
	public Praticien() {
		super();
	}
	public Praticien(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Praticien [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	
	
}