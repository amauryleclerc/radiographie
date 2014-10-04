package modele.metier;
/*
 * Classe Praticien h�riant de la classe Personne
 */
public class Praticien extends Personne {
	
	//Constructeur sans param�tre
	public Praticien() {
		super();
	}
	
	//Constructeur avec param�tre
	public Praticien(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
		// TODO Auto-generated constructor stub
	}

	//la m�thode toString,renvoie une cha�ne de caract�res servant � d�crire l'objet concern�
	@Override
	public String toString() {
		return "Praticien [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}//Fin de la m�thode toString

	
	
}//Fin de la classe