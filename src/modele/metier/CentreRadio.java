package modele.metier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import modele.comparator.RadioDateComparator;
import modele.comparator.RadioNumComparator;
import modele.comparator.RadioPatientComparator;
import tools.XMLTools;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
//Classe CentreRadio
public class CentreRadio {
	
	/**Attributs</br>
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
	/**Méthodes </br>
	 * permettant de vérifier quel type de personne est connecté</br>
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
	 * Méthodes </br>
	 * qui servent a créer un type de personne selon 
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
	 * Méthodes creerRadiographie</br>
	 *  qui permettent de créer une radiographie seulement si c'est un prtaticien connecté
	 * @param patient
	 * @param datePrise
	 * @param compteRendu
	 * @param etat
	 * @param typeRadio
	 * @param nbRadio
	 */
	public void creerRadiographie(Patient patient, Date datePrise, String compteRendu, Etat etat,
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
	
	public void creerRadiographie(int numPatient, Date datePrise, String compteRendu, Etat etat,
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
	/**
	 * Méthode afficheRadiographies</br> 
	 * qui permet d'afficher les radiographies
	 */
	public void afficheRadiographies() {
		
		for (Radiographie uneRadiographie : lesRadiographies) {
			
			System.out.print(" ");
			uneRadiographie.afficher();
		}
	}
	/**
	 * Méthode supprimerRadiographie</br>
	 * permet de supprimer une radiographie
	 * @param num
	 */
	public void supprimerRadiographie(int num) {
		System.out.println("Suppression de :");
		this.lesRadiographies.get(num).getPatient().getMesRadiographie().remove(this.lesRadiographies.get(num));
		this.lesRadiographies.remove(num).afficher();;
		
	}
	/**
	 * Méthode affichePatients</br>
	 * qui affiche la liste des patients enregistrés
	 */
	public void affichePatients() {
		int i = 0;
		for (Patient unPatient : lesPatients) {
			i++;
			System.out.print(i + " ");
			unPatient.afficher();
		}
	}
	/**
	 * Méthode afficheUnPatient</br>
	 * qui permet d'afficher un seul patient
	 * @param num
	 */
	public void afficheUnPatient(int num) {
		this.lesPatients.get(num).afficher();
		
	}
	/**
	 * Méthode afficheToutUnPatient</br>
	 * qui permet d'afficher un patient et ces informations grâce a la méthode afficheTout de patient
	 * @param num
	 */
	public void afficheToutUnPatient(int num) {
		this.lesPatients.get(num).afficheTout();
		
	}
	/**
	 * Méthode regenererIdUnPatient</br>
	 * qui sert a regénérer les identifiant d'un patient
	 * @param num
	 */
	public void regenererIdUnPatient(int num) {
		this.lesPatients.get(num).newidentifiant();
	}
	/**
	 * Méthode afficheRadiographie </br>
	 * qui sert a afficher une radiographie
	 */
	public void afficheRadiographie() {
		int i = 0;
		for (Radiographie unRadiographie : lesRadiographies) {
			i++;
			System.out.print(i + "-");
			unRadiographie.afficher();
		}
	}
	public void afficheUneRadiographie(int numRadio) {
		this.lesPatients.get(numRadio).afficher();
	}
	/**
	 * Méthode supprimerPatient</br>
	 *  qui permet de supprimer un patient
	 * @param num
	 */
	public void supprimerPatient(int num) {
		System.out.println("Suppression de :");
		this.lesPatients.remove(num).afficher();
		
	}
	
	/**
	 * Méthode connexion</br>
	 *  pour la connexion selon le type de personne reconnu grâce au mdp et au login
	 * @param login
	 * @param mdp
	 */
	//
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
	/**
	 * Méthode deconnexion</br>
	 * qui permet de se déconnecter
	 */
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
	/**
	 * Méthode enregistrer</br>
	 * Outil xml, permettant d'enregistrer des fichiers xml
	 * @param fileLocation
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void enregistrer(String fileLocation) throws FileNotFoundException, IOException {
		
		XMLTools.encodeToFile(this.lesPraticiens, fileLocation + "\\lespraticiens.xml");
		XMLTools.encodeToFile(this.lesPatients, fileLocation + "\\lespatients.xml");
		XMLTools.encodeToFile(this.lesRadiographies, fileLocation + "\\lesradiographies.xml");
		XMLTools.encodeToFile(this.lesSecretaires, fileLocation + "\\lessecretaires.xml");
	}
	/**
	 * Méthode charger</br>
	 * permet de charger les fichiers xml auparavant enregitrés
	 * @param fileLocation
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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
	/**
	 * Méthode trierRadioParNum </br>
	 * permet de trier les radiographies par leur numéro
	 */
	public void trierRadioParNum(){
		RadioNumComparator radioNumComparator = new RadioNumComparator();
		Collections.sort(lesRadiographies, radioNumComparator);
	}
	/**
	 * Méthode trierRadioParPatient </br>
	 * permet de trier les radiographies par le nom du patient
	 */
	public void trierRadioParPatient(){
		RadioPatientComparator radioPatientComparator = new RadioPatientComparator();
		Collections.sort(lesRadiographies, radioPatientComparator);
	}
	/**
	 * Méthode trierRadioParDate </br>
	 * permet de trier les radiographies par Date de Prise
	 * 
	 */
	public void trierRadioParDate(){
		RadioDateComparator radioDateComparator = new RadioDateComparator();
		Collections.sort(lesRadiographies, radioDateComparator);
	}
	/**
	 * Méthode changerEtatRadio</br>
	 * permet de chanter l'état de la radio en planifiée ou en effectué
	 * @param numRadio
	 */
	public void changerEtatRadio(int numRadio){
		 if(this.lesRadiographies.get(numRadio).getEtat() == Etat.effectuée){
			 this.lesRadiographies.get(numRadio).setEtat(Etat.planifiée);
		}else{
			this.lesRadiographies.get(numRadio).setEtat(Etat.effectuée);
		}
		 System.out.println("Etat changé");
	}
	/**
	 * Méthode ajouterCompteRendRadio</br>
	 * permet de lier un compte rendu rédiger par le praticien à une radio
	 * @param numRadio
	 * @param text
	 */
	public void ajouterCompteRenduRadio(int numRadio, String text){
		text = this.lesRadiographies.get(numRadio).getCompteRendu()+" /n "+text;
		this.lesRadiographies.get(numRadio).setCompteRendu(text);
		System.out.println("compte rendu ajouté");
	}
	/**
	 * Méthode ajouterClicheRadio</br>
	 * permet d'ajouter un cliché à une radio
	 * @param numRadio
	 * @param nbCliches
	 */
	public void ajouterClicheRadio(int numRadio, int nbCliches){
		this.lesRadiographies.get(numRadio).ajouterCliches(nbCliches);
		System.out.println("clichés ajouté");
	}

	public static void main(String args[]) throws ParseException {
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cr.creerRadiographie(cr.lesPatients.get(0), sdf.parse("26/09/2014"), "compterendu.txt",
				Etat.effectuée, TypeRadio.echographieUltraSons, 2);
		cr.creerRadiographie(cr.lesPatients.get(0),sdf.parse("27/09/2014"), "compterendu.txt",
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