package modele.metier;

import java.util.Random;

public abstract class Personne {

	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	public Personne(String nom, String prenom, String login, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		if(login==null){
			this.newidentifiant();
		}
	}
	
	public Personne() {
		super();
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean compareMdp(String mdp){
		return this.mdp.equals(mdp);
	}
public void newidentifiant(){
	String mdp = "" ;
	  String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      Random rand = new Random();
      for (int i=0; i<6; i++)
      {
    	  mdp += alphabet.charAt(rand.nextInt(alphabet.length()));
      }
    String login = this.prenom.substring(0,1).toLowerCase();
    login += this.nom.toLowerCase();
    this.login = login;
      this.mdp = mdp;
      System.out.println("login : "+this.login+" mdp :"+this.mdp);
}
public void afficher(){
	System.out.println(this.getNom()+" "+this.getPrenom());
}

	

}