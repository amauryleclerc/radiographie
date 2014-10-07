package modele.metier;

import java.text.SimpleDateFormat;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
import java.util.*;
//Classe Radiographie
public class Radiographie {

	//Attributs
	private ArrayList<Cliche> mesCliches;
	private static int lastNumExam = 0;
	private int numExam;
	private Date datePrise;
	private String compteRendu;
	private Etat etat;
	private TypeRadio typeRadio;
	private Patient patient;
	private Praticien praticien;

	//Constructeur sans param�tre
	public Radiographie() {
		super();
	}
	//Constructeurs avec param�tre
	public Radiographie(ArrayList<Cliche> mesCliches, Date datePrise,
			Etat etat, TypeRadio typeRadio) {
		super();
		lastNumExam++;
		this.mesCliches = mesCliches;
		this.datePrise = datePrise;
		this.numExam = lastNumExam;
		this.etat = etat;
		this.typeRadio = typeRadio;
	}

	public Radiographie(Date datePrise, Etat etat, TypeRadio typeRadio, Praticien praticien, Patient patient) {
		super();
		lastNumExam++;
		this.mesCliches = new ArrayList<Cliche>();
		this.datePrise = datePrise;
		this.numExam = lastNumExam;
		this.etat = etat;
		this.typeRadio = typeRadio;
		this.patient = patient;
		this.praticien = praticien;
	}

	/**
	 * M�thode ajouterCliches</br>
	 * Elle permet d'ajouter un clich� � une radiographie
	 * @param nbCliches
	 */
	public void ajouterCliches(int nbCliches) {
		int numCliches = this.mesCliches.size() + 1;
		for (int i = 0; i < nbCliches; i++) {
			this.mesCliches.add(new Cliche(numCliches));
			numCliches++;
		}
	}

	//la m�thode toString,renvoie une cha�ne de caract�res servant � d�crire l'objet concern�
	@Override
	public String toString() {
		return "Radiographies [mesCliches=" + mesCliches + ", datePrise="
				+ datePrise + "]";
	}
	//Accesseurs
	public static void setLastNumExam(int lastNumExam) {
		Radiographie.lastNumExam = lastNumExam;
	}

	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void setTypeRadio(TypeRadio typeRadio) {
		this.typeRadio = typeRadio;
	}

	public ArrayList<Cliche> getMesCliches() {
		return mesCliches;
	}

	public void setMesCliches(ArrayList<Cliche> mesCliches) {
		this.mesCliches = mesCliches;
	}

	public int getNumExam() {
		return numExam;
	}

	public void setNumExam(int numExam) {
		this.numExam = numExam;
	}

	public Date getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(Date datePrise) {
		this.datePrise = datePrise;
	}

	public static int getLastNumExam() {
		return lastNumExam;
	}

	public String getCompteRendu() {
		return compteRendu;
	}

	public Etat getEtat() {
		return etat;
	}

	public TypeRadio getTypeRadio() {
		return typeRadio;
	}
	/**
	 * M�thode changeEtat</br>
	 * Elle permet de changer l'�tat d'une radiographie, en �tat Planifi�e ou en �tat Effectu�e
	 */
	public void changeEtat() {
		if (this.etat.equals(Etat.effectu�e)) {
			this.etat = Etat.planifi�e;
		} else {
			this.etat = Etat.effectu�e;
		}
	}
	/**
	 * M�thode afficher</br>
	 * affichage des informations concernant les radiographies
	 */
	public void afficher() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(this.numExam+" "+this.typeRadio+" "+sdf.format(this.datePrise)+" "+this.getEtat()+" "+this.patient.getPrenom()+" "+this.patient.getNom());
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}//Fin de classe Radiographie