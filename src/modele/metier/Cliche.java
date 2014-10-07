package modele.metier;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
//Classe Cliche
public class Cliche {

	//Attribut
	private int numPrise;

	//COnstructeurs sans paramètre
	public Cliche() {
		super();
	}

	//Constructeurs avec paramètre
	public Cliche(int numPrise) {
		super();
		this.numPrise = numPrise;
	}

	//la méthode toString,renvoie une chaîne de caractères servant à décrire l'objet concerné
	@Override
	public String toString() {
		return "Cliche [numPrise=" + numPrise + "]";
	}
	//Accesseurs
	public int getNumPrise() {
		return numPrise;
	}

	public void setNumPrise(int numPrise) {
		this.numPrise = numPrise;
	}

}//Fin de la classe Cliche