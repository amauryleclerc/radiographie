package modele.metier;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
/**
 * Classe Secretaire </br>
 * Elle h�rite de la classe Personne
 */
public class Secretaire extends Personne {

	//Constructeur avec param�tres
	public Secretaire(String nom, String prenom, String login, String mdp) {
		super(nom, prenom, login, mdp);
	}
	
	//Constructeur sans param�tre 
	public Secretaire() {
		super();
		
	}
	
	//la m�thode toString,renvoie une cha�ne de caract�res servant � d�crire l'objet concern�
	@Override
	public String toString() {
		return "Secretaire [toString()=" + super.toString() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}//Fin de la m�thode toString
	
}//Fin de classe Secretaire