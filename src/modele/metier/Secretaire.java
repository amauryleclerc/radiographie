package modele.metier;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
/**
 * Classe Secretaire </br>
 * Elle hérite de la classe Personne
 */
public class Secretaire extends Personne {

	//Constructeur avec paramètres
	public Secretaire(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
	}
	
	//Constructeur sans paramètre 
	public Secretaire() {
		super();
		
	}
	
	//la méthode toString,renvoie une chaîne de caractères servant à décrire l'objet concerné
	@Override
	public String toString() {
		return "Secretaire [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}//Fin de la méthode toString
	
}//Fin de classe Secretaire