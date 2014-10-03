package modele.metier;

public class CompteRendu {

	private String chemin;
	private String mdp;
	public CompteRendu(String chemin, String mdp) {
		super();
		this.chemin = chemin;
		this.mdp = mdp;
	}
	
	public CompteRendu() {
		super();
	}

	public String getChemin() {
		return chemin;
	}
	public String getMdp() {
		return mdp;
	}

}