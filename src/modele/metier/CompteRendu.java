package modele.metier;
/*
 * Classe CompteRendu
 */
public class CompteRendu {

	//Attributs
	private String chemin;//Chemin permettant de retourver ou se situe le compteRendu
	private String mdp;//Mot de passe qui prot�ge le compteRendu
	
	//Constructeurs avec param�tres
	public CompteRendu(String chemin, String mdp) {
		super();
		this.chemin = chemin;
		this.mdp = mdp;
	}
	//Constructeurs sans param�tres
	public CompteRendu() {
		super();
	}
	//Accesseurs
	public String getChemin() {
		return chemin;
	}
	public String getMdp() {
		return mdp;
	}

}//Fin de la classe CompteREndu