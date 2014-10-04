package modele.metier;
/*
 * Classe Praticien hériant de la classe Personne
 */
public class Praticien extends Personne {
	
	//Constructeur sans paramètre
	public Praticien() {
		super();
	}
	
	//Constructeur avec paramètre
	public Praticien(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
		// TODO Auto-generated constructor stub
	}

	//la méthode toString,renvoie une chaîne de caractères servant à décrire l'objet concerné
	@Override
	public String toString() {
		return "Praticien [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}//Fin de la méthode toString

	
	
}//Fin de la classe