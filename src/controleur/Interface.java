package controleur;

import java.io.Console;
import java.io.IOException;

import clavier.Lire;
import modele.metier.CentreRadio;
import modele.metier.Patient;

public class Interface {
	CentreRadio cr;
	String ch ;
	public Interface() {
		super();
		this.cr = new CentreRadio();
		this.ch  =  System.getProperty("user.dir");
		try {
			cr.charger(ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Interface in = new Interface();
		in.connexion();
	}
	
	private void connexion(){
		System.out.println("Bienvenue");
		System.out.println("Login :");
		String login = Lire.S();
		System.out.println("Mot de passe :");
		String mdp = Lire.S();
		while(!cr.connexion(login, mdp)){
			System.out.println("Login :");
			 login = Lire.S();
			System.out.println("Mot de passe :");
			 mdp = Lire.S();
		}
		this.menuPrincipal();
		
	}
	private void menuPrincipal(){
		
		if(cr.isPraticienConnecte()){
			System.out.println("Taper");
			System.out.println("1 - pour créer une radiographie");
			System.out.println("2 - pour consulter une radiographie");
			System.out.println("3 - pour mofifier une radiographie");
			System.out.println("4 - pour supprimer une radiographie");
			System.out.println(" ");
			System.out.println("5 - pour créer un patient");
			System.out.println("6 - pour afficher les patients");
			System.out.println("7 - pour mofifier un patient");
			System.out.println("8 - pour supprimer un patient");
			System.out.println(" ");
			System.out.println("0 - déconnexion");
			System.out.println("Choix :");
			String choix = Lire.S();
			
			switch (choix) {
			case "5":
				this.creerPatient();
				break;
			case "6":
				this.affichePatients();
				break;
			case "7":
				this.modifierPatient();
				break;
			case "8":
				this.supprimerPatient();;
				break;
			case "0":
				cr.deconnexion();
				this.connexion();
				break;
			default:
				break;
			}
			Lire.S();
			this.menuPrincipal();
		}else if(cr.isSecretaireConnecte()){
	
		}else if(cr.isPatientConnecte()){
			System.out.println("Taper");
			System.out.println("1 - pour afficher vos information");
			System.out.println("0 - déconnexion");
			System.out.println("choix :");
			String choix = Lire.S();
			switch (choix) {
			case "1":
				System.out.println("Vos informations :");
				((Patient) cr.getPersonneConnecte()).afficheTout();
				break;
			case "0":
				cr.deconnexion();
				this.connexion();
				break;
		
			default:
				break;
			}
	
		}else{
			this.connexion();
		}
	}
	
	private void creerPatient(){
		System.out.println("Création d'un patient :");
		System.out.println("nom :");
		String nom = Lire.S();
		System.out.println("prenom :");
		String prenom = Lire.S();
		System.out.println("SECU :");
		String secu = Lire.S();
		cr.creerPatient(nom, prenom, secu);
		try {
			cr.enregistrer(ch);
		} catch (IOException e) {
			System.out.println("Erreur : enregistrement impossible");
		}
	}
	private void modifierPatient(){
		System.out.println("Modifier un patient");
		this.affichePatients();
		System.out.println("numero du patient à modifier:");
		int numPatient = Lire.i()-1;
		cr.afficheToutUnPatient(numPatient);
		System.out.println("Taper");
		System.out.println("1 - pour regénérer des identifiants");
		System.out.println("choix :");
		String choix = Lire.S();
		switch (choix) {
		case "1":
			cr.regenererIdUnPatient(numPatient);
			break;
	
		default:
			break;
		}
		try {
			cr.enregistrer(ch);
		} catch (IOException e) {
			System.out.println("Erreur : enregistrement impossible");
		}
	}
	private void affichePatients(){
		System.out.println("Les patients :");
		cr.affichePatients();
	}
	private void supprimerPatient(){
		System.out.println("Supprimer un patient");
		this.affichePatients();
		System.out.println("numero du patient a supprimer:");
		int numPatient = Lire.i()-1;
		System.out.print("Confirmation de suppression de :");
		cr.afficheUnPatient(numPatient);
		System.out.println("(o/n)");
		char choix = Lire.c();
		if(choix == 'o'){
			cr.supprimerPatient(numPatient);
			try {
				cr.enregistrer(ch);
			} catch (IOException e) {
				System.out.println("Erreur : enregistrement impossible");
			}
		}else{
			System.out.println("Annulation");
		}
		
	}

}
