package modele.metier;

import java.util.Random;
/*
 * Classe abstraite Personne
 */
public abstract class Personne {

	//Attributs
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	//Constructeur avec param�tre
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
	//Constructeurs sans param�tre
	public Personne() {
		super();
	}
	//la m�thode toString,renvoie une cha�ne de caract�res servant � d�crire l'objet concern�
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + "]";
	}//Fin de la m�thode toString
	//Accesseurs
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
//M�thode compareMdp sert � v�rifier si le mdp entr� au clavier est �gal au mdp enregistrer
	public boolean compareMdp(String mdp){
		return this.mdp.equals(mdp);
	}//Fin de la m�thode compareMdp
/*M�thode newidentiant
 * Elle permet de g�n�rer al�atoirement un mot de passe en utilisant les lettres maj et min et les chiffres de 0 � 9.
 * Elle permet de g�nerer un login en utilisant le nomp et pr�nom entr� au clavier
 * le login est compos� de la premi�re lettre du pr�nom suivi du nom complet
 */
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
}//Fin de la m�thode newidentifiant

//M�thode affiche qui permet l'affichage du nom et du pr�nom
public void afficher(){
	System.out.println(this.getNom()+" "+this.getPrenom());
}

}//Fin de la classe Personne