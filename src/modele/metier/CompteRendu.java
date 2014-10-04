package modele.metier;
/*
 * Classe CompteRendu
 */
public class CompteRendu {

	//Attributs
	private String chemin;//Chemin permettant de retourver ou se situe le compteRendu
	private String mdp;//Mot de passe qui protège le compteRendu
	
	//Constructeurs avec paramètres
	public CompteRendu(String chemin, String mdp) {
		super();
		this.chemin = chemin;
		this.mdp = mdp;
	}
	//Constructeurs sans paramètres
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