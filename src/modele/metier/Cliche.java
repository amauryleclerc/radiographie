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

	//COnstructeurs sans param�tre
	public Cliche() {
		super();
	}

	//Constructeurs avec param�tre
	public Cliche(int numPrise) {
		super();
		this.numPrise = numPrise;
	}

	//la m�thode toString,renvoie une cha�ne de caract�res servant � d�crire l'objet concern�
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