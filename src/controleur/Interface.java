package controleur;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import clavier.Lire;
import modele.metier.CentreRadio;
import modele.metier.Etat;
import modele.metier.Patient;
import modele.metier.TypeRadio;

//Classe interface
public class Interface {
	// Attributs
	CentreRadio cr;
	String ch;
	
	// Constructeurs avec paramètre
	public Interface() {
		super();
		this.cr = new CentreRadio();
		this.ch = System.getProperty("user.dir");
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
	
	/**
	 * Méthode connexion</br>
	 * pour gérer la connexion via la console
	 */
	private void connexion() {
		System.out.println("Bienvenue");
		System.out.println("Login :");
		String login = Lire.S();
		System.out.println("Mot de passe :");
		String mdp = Lire.S();
		while (!cr.connexion(login, mdp)) {
			System.out.println("Login :");
			login = Lire.S();
			System.out.println("Mot de passe :");
			mdp = Lire.S();
		}
		this.menuPrincipal();
		
	}
	
	/**
	 * Méthode menuPrincipal</br>
	 * qui affiche le menu principal avec les différentes possibilités d'actions selon le type de personne
*/
	private void menuPrincipal() {
		
		if (cr.isPraticienConnecte()) {
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
			case "1":
				this.creerRadiographie();
				break;
			case "2":
				this.afficheRadiographie();
				break;
			case "3":
				this.modifierRadiographie();
				break;
			case "4":
				this.supprimerRadiographie();
				break;
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
				this.supprimerPatient();
				;
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
		} else if (cr.isSecretaireConnecte()) {
			System.out.println("Taper");
			System.out.println("1 - pour consulter une radiographie");
			System.out.println("2 - pour afficher les patients");
			System.out.println(" ");
			System.out.println("0 - déconnexion");
			System.out.println("Choix :");
			String choix = Lire.S();
			switch (choix) {
			case "1":
				this.afficheRadiographie();
				break;
			case "2":
				this.affichePatients();
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
			
		} else if (cr.isPatientConnecte()) {
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
			
		} else {
			this.connexion();
		}
	}
	
	/**
	 * Méthode qui permet de créer la radiographie d'un patient </br> ATTENTION
	 * il n y a aucun systeme de controle des données
	 */
	private void creerRadiographie() {
		
		System.out.println("Création d'une radiographie :");
		System.out.println("patient :");
		cr.affichePatients();
		System.out.println("numero de patient :");
		int numPatient = Lire.i() - 1;
		
		System.out.println("date (jj/mm/yyyy) :");
		String datePrise = Lire.S();
		System.out.println("compteRendu :");
		String compteRendu = Lire.S();
		System.out.println("numero de l'etat :");
		int i = 0;
		for (Etat etat : Etat.values()) {
			i++;
			System.out.println(i + " " + etat.name());
		}
		Etat etat = Etat.values()[Lire.i() - 1];
		
		System.out.println("Numero du type de radiographie :");
		i = 0;
		for (TypeRadio typeRadio : TypeRadio.values()) {
			i++;
			System.out.println(i + " " + typeRadio.name());
		}
		TypeRadio typeRadio = TypeRadio.values()[Lire.i() - 1];
		System.out.println("Nombre de radiographie :");
		int nbRadio = Lire.i();
		cr.creerRadiographie(numPatient, new Date(datePrise), compteRendu, etat, typeRadio, nbRadio);
		try {
			cr.enregistrer(ch);
		} catch (IOException e) {
			System.out.println("Erreur : enregistrement impossible");
		}
		
	}
	
	/**
	 * Méthodes pour afficher,modifier,supprimer les radiographies
	 */
	
	private void afficheRadiographie() {
		System.out.println("Afficher les radiographie :");
		this.trierRadiographie();
		cr.afficheRadiographie();
		System.out.println();
	}
	
	private void modifierRadiographie() {
		System.out.println("Modifier un patient");
		this.afficheRadiographie();
		System.out.println("numero de la radiographie à modifier:");
		int numRadio = Lire.i() - 1;
		// cr.afficheToutUnPatient(numPatient);
		System.out.println("Taper");
		System.out.println("1 - pour changer l'etat");
		System.out.println("2 - pour modifier le compte rendu");
		System.out.println("3 - pour ajouter des clichés");
		System.out.println("choix :");
		String choix = Lire.S();
		switch (choix) {
		case "1":
			cr.changerEtatRadio(numRadio);
			break;
		case "2":
			System.out.println("Compte rendu :");
			String text = Lire.S();
			cr.ajouterCompteRenduRadio(numRadio, text);
			break;
		case "3":
			System.out.println("Nombres de clichés :");
			int nbCliches = Lire.i();
			cr.ajouterClicheRadio(numRadio, nbCliches);
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
	
	private void supprimerRadiographie() {
		System.out.println("Supprimmer une radiographie :");
		this.afficheRadiographie();
		System.out.println("numero de la radiographie a supprimer:");
		int numRadio = Lire.i() - 1;
		System.out.print("Confirmation de suppression de :");
		cr.afficheUneRadiographie(numRadio);
		System.out.println("(o/n)");
		char choix = Lire.c();
		if (choix == 'o') {
			cr.supprimerRadiographie(numRadio);
			try {
				cr.enregistrer(ch);
			} catch (IOException e) {
				System.out.println("Erreur : enregistrement impossible");
			}
		} else {
			System.out.println("Annulation");
		}
		
	}
	
	private void trierRadiographie() {
		System.out.println("trier Radiographie : 1 num - 2 patient - 3 date");
		switch (Lire.S()) {
		case "1":
			cr.trierRadioParNum();
			break;
		case "2":
			cr.trierRadioParPatient();
			break;
		case "3":
			cr.trierRadioParDate();
			break;
		default:
			break;
		}
		
	}
	
	/**
	 *  Méthode qui sert a créer un patient
	 */
	private void creerPatient() {
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
	
	/**
	 *  Méthode qui permet de modifier un patient
	 */
	private void modifierPatient() {
		System.out.println("Modifier un patient");
		this.affichePatients();
		System.out.println("numero du patient à modifier:");
		int numPatient = Lire.i() - 1;
		// cr.afficheToutUnPatient(numPatient);
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
	
	/**
	 *  Méthode pour afficher un patient
	 */
	private void affichePatients() {
		System.out.println("Les patients :");
		cr.affichePatients();
	}
	
	/**
	 *  Méthode pour supprimer un patient
	 */
	private void supprimerPatient() {
		System.out.println("Supprimer un patient");
		this.affichePatients();
		System.out.println("numero du patient a supprimer:");
		int numPatient = Lire.i() - 1;
		System.out.print("Confirmation de suppression de :");
		cr.afficheUnPatient(numPatient);
		System.out.println("(o/n)");
		char choix = Lire.c();
		if (choix == 'o') {
			cr.supprimerPatient(numPatient);
			try {
				cr.enregistrer(ch);
			} catch (IOException e) {
				System.out.println("Erreur : enregistrement impossible");
			}
		} else {
			System.out.println("Annulation");
		}
		
	}
	
}// Fin de la classe interface
