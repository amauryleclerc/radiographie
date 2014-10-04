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
	//Constructeur avec paramètre
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
	//Constructeurs sans paramètre
	public Personne() {
		super();
	}
	//la méthode toString,renvoie une chaîne de caractères servant à décrire l'objet concerné
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + "]";
	}//Fin de la méthode toString
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
//Méthode compareMdp sert à vérifier si le mdp entré au clavier est égal au mdp enregistrer
	public boolean compareMdp(String mdp){
		return this.mdp.equals(mdp);
	}//Fin de la méthode compareMdp
/*Méthode newidentiant
 * Elle permet de générer aléatoirement un mot de passe en utilisant les lettres maj et min et les chiffres de 0 à 9.
 * Elle permet de génerer un login en utilisant le nomp et prénom entré au clavier
 * le login est composé de la première lettre du prénom suivi du nom complet
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
}//Fin de la méthode newidentifiant

//Méthode affiche qui permet l'affichage du nom et du prénom
public void afficher(){
	System.out.println(this.getNom()+" "+this.getPrenom());
}

}//Fin de la classe Personne