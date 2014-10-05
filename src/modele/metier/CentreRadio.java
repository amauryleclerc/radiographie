package modele.metier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import tools.XMLTools;

//Classe CentreRadio
public class CentreRadio {
	
	/*Attributs
	 * ArrayList Pour chaque type de personne et pour les différentes radiographies
	 */
	private ArrayList<Radiographie> lesRadiographies;
	private ArrayList<Patient> lesPatients;
	private ArrayList<Praticien> lesPraticiens;
	private ArrayList<Secretaire> lesSecretaires;
	private Personne personneConnecte = null;
	
	//Constructeurs avec paramètre
	public CentreRadio(ArrayList<Radiographie> lesRadiographies, ArrayList<Patient> lesPatients,
			ArrayList<Praticien> lesPraticiens, ArrayList<Secretaire> lesSecretaires) {
		super();
		this.lesRadiographies = lesRadiographies;
		this.lesPatients = lesPatients;
		this.lesPraticiens = lesPraticiens;
		this.lesSecretaires = lesSecretaires;
	}
	
	public CentreRadio() {
		this.lesRadiographies = new ArrayList<Radiographie>();
		this.lesPatients = new ArrayList<Patient>();
		this.lesPraticiens = new ArrayList<Praticien>();
		this.lesSecretaires = new ArrayList<Secretaire>();
	}
	
	//Accesseurs
	public Personne getPersonneConnecte() {
		return personneConnecte;
	}
	/*Méthodes permettant de vérifier quel type de personne est connecté
	 * Praticien ou Secretaire ou Patient
	 */
	public boolean isPraticienConnecte() {
		if (getPersonneConnecte() instanceof Praticien) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isSecretaireConnecte() {
		if (getPersonneConnecte() instanceof Secretaire) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPatientConnecte() {
		if (getPersonneConnecte() instanceof Patient) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param numSECU
	 * @param mdp
	 * @param login
	 */
	/*
	 * Méthodes qui servent a créer un type de personne selon 
	 * leur paramètre propre à chacun
	 */
	public void creerPatient(String nom, String prenom, String numSECU) {
		
		lesPatients.add(new Patient(nom, prenom, numSECU));
	}
	
	public void creerPraticien(String nom, String prenom, String login, String mdp) {
		
		lesPraticiens.add(new Praticien(nom, prenom, login, mdp));
	}
	
	public void creerSecretaire(String nom, String prenom, String login, String mdp) {
		
		lesSecretaires.add(new Secretaire(nom, prenom, login, mdp));
	}
	
	/**
	 * 
	 * @param patient
	 * @param datePrise
	 * @param compteRendu
	 */
	//Méthodes qui permetent de créer une radiographie seulement si c'est un prtaticien connecté
	public void creerRadiographie(Patient patient, String datePrise, String compteRendu, Etat etat,
			TypeRadio typeRadio, int nbRadio) {
		if (!isPraticienConnecte()) {
			System.out.println("ERREUR DROIT: vous n etes pas autorisé à créer une radiographie");
		} else {
			Radiographie radiographie = new Radiographie(datePrise, etat, typeRadio,
					(Praticien) this.getPersonneConnecte(), patient);
			radiographie.ajouterCliches(nbRadio);
			patient.getMesRadiographie().add(radiographie);
			this.lesRadiographies.add(radiographie);
			System.out.println("radiographie ajouté");
		}
		
	}
	
	public void creerRadiographie(int numPatient, String datePrise, String compteRendu, Etat etat,
			TypeRadio typeRadio, int nbRadio) {
		Patient patient = this.lesPatients.get(numPatient);
		if (!isPraticienConnecte()) {
			System.out.println("ERREUR DROIT: vous n etes pas autorisé à créer une radiographie");
		} else {
			Radiographie radiographie = new Radiographie(datePrise, etat, typeRadio,
					(Praticien) this.getPersonneConnecte(), patient);
			radiographie.ajouterCliches(nbRadio);
			patient.getMesRadiographie().add(radiographie);
			this.lesRadiographies.add(radiographie);
			System.out.println("radiographie ajouté");
		}
		
	}
	//Méthode qui permet d'afficher les radiographies
	public void afficheRadiographies() {
		
		for (Radiographie uneRadiographie : lesRadiographies) {
			
			System.out.print(" ");
			uneRadiographie.afficher();
		}
	}
	//Méthode qui affiche la liste des patients enregistrés
	public void affichePatients() {
		int i = 0;
		for (Patient unPatient : lesPatients) {
			i++;
			System.out.print(i + " ");
			unPatient.afficher();
		}
	}
	//Méthode qui permet d'afficher un seul patient
	public void afficheUnPatient(int num) {
		this.lesPatients.get(num).afficher();
		
	}
	//Méthode qui permet d'afficher un patient et ces informations grâce a la méthode afficheTout de patient
	public void afficheToutUnPatient(int num) {
		this.lesPatients.get(num).afficheTout();
		
	}
	//Méthode qui sert a regénérer les identifiant d'un patient
	public void regenererIdUnPatient(int num) {
		this.lesPatients.get(num).newidentifiant();
	}
	//Méthode qui sert a afficher une radiographie
	public void afficheRadiographie() {
		for (Radiographie unRadiographie : lesRadiographies) {
			System.out.println(unRadiographie.toString());
		}
	}
	//Méthode qui permet de supprimer un patient
	public void supprimerPatient(int num) {
		System.out.println("Suppression de :");
		this.lesPatients.remove(num).afficher();
		
	}
	
	/**
	 * 
	 * @param login
	 * @param mdp
	 */
	//méthode pour la connexion selon le type de personne reconnu grâce au mdp et au login
	public boolean connexion(String login, String mdp) {
		this.deconnexion();
		for (Patient unPatient : lesPatients) {
			if (unPatient.getLogin().equals(login) && unPatient.compareMdp(mdp)) {
				System.out.println("Connexion de " + unPatient.getPrenom() + " "
						+ unPatient.getNom());
				this.personneConnecte = unPatient;
				return true;
			}
		}
		for (Praticien unPraticien : lesPraticiens) {
			if (unPraticien.getLogin().equals(login) && unPraticien.compareMdp(mdp)) {
				System.out.println("Connexion de " + unPraticien.getPrenom() + " "
						+ unPraticien.getNom());
				this.personneConnecte = unPraticien;
				return true;
			}
		}
		for (Secretaire unSecretaire : lesSecretaires) {
			if (unSecretaire.getLogin().equals(login) && unSecretaire.compareMdp(mdp)) {
				System.out.println("Connexion de " + unSecretaire.getPrenom() + " "
						+ unSecretaire.getNom());
				this.personneConnecte = unSecretaire;
				return true;
			}
		}
		System.out.println("login ou mot de passe incorrect");
		return false;
	}
	//Méthode qui permet de se déconnecter
	public void deconnexion() {
		if (this.personneConnecte != null) {
			System.out.println("Déconnection de " + this.personneConnecte.getPrenom() + " "
					+ this.personneConnecte.getNom());
			
		}
		this.personneConnecte = null;
		
	}
	
	public boolean isPersConnecte() {
		return (this.personneConnecte != null);
	}
	
	public void enregistrer(String fileLocation) throws FileNotFoundException, IOException {
		
		XMLTools.encodeToFile(this.lesPraticiens, fileLocation + "\\lespraticiens.xml");
		XMLTools.encodeToFile(this.lesPatients, fileLocation + "\\lespatients.xml");
		XMLTools.encodeToFile(this.lesRadiographies, fileLocation + "\\lesradiographies.xml");
		XMLTools.encodeToFile(this.lesSecretaires, fileLocation + "\\lessecretaires.xml");
	}
	
	@SuppressWarnings("unchecked")
	public void charger(String fileLocation) throws FileNotFoundException, IOException {
		
		this.lesPraticiens = (ArrayList<Praticien>) XMLTools.decodeFromFile(fileLocation
				+ "\\lespraticiens.xml");
		this.lesPatients = (ArrayList<Patient>) XMLTools.decodeFromFile(fileLocation
				+ "\\lespatients.xml");
		this.lesRadiographies = (ArrayList<Radiographie>) XMLTools.decodeFromFile(fileLocation
				+ "\\lesradiographies.xml");
		this.lesSecretaires = (ArrayList<Secretaire>) XMLTools.decodeFromFile(fileLocation
				+ "\\lessecretaires.xml");
	}
	
	public static void main(String args[]) {
		String ch = System.getProperty("user.dir");
		System.out.println(ch);
		CentreRadio cr = new CentreRadio();
		cr.creerPatient("MARTINEAU", "Thomas", "230230230121");
		cr.creerPraticien("LECLERC", "Amaury", "aleclerc", "test");
		cr.creerPraticien("qsdfqsf", "qfsdsqdf", "qsdfqsdf", "test");
		cr.affichePatients();
		System.out.println("personeConnecte " + cr.isPersConnecte());
		cr.connexion("aleclerc", "test");
		// cr.connexion("tmartineau", "test");
		
		System.out.println("personeConnecte " + cr.isPersConnecte());
		
		cr.creerRadiographie(cr.lesPatients.get(0), "26/09/2014", "compterendu.txt",
				Etat.effectuée, TypeRadio.echographieUltraSons, 2);
		cr.creerRadiographie(cr.lesPatients.get(0), "27/09/2014", "compterendu.txt",
				Etat.planifiée, TypeRadio.IRM, 0);
		cr.affichePatients();
		cr.afficheRadiographie();
		
		try {
			cr.enregistrer(ch);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			cr.charger(ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cr.affichePatients();
		
	}
	
}//Fin de la classe 