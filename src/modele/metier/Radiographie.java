package modele.metier;

import java.util.*;

public class Radiographie {

	private ArrayList<Cliche> mesCliches;
	private static int lastNumExam = 0;
	private int numExam;
	private String datePrise;
	private CompteRendu compteRendu;
	private Etat etat;
	private TypeRadio typeRadio;

	public Radiographie() {
		super();
	}

	public Radiographie(ArrayList<Cliche> mesCliches, String datePrise,
			Etat etat, TypeRadio typeRadio) {
		super();
		lastNumExam++;
		this.mesCliches = mesCliches;
		this.datePrise = datePrise;
		this.numExam = lastNumExam;
		this.etat = etat;
		this.typeRadio = typeRadio;
	}

	public Radiographie(String datePrise, Etat etat, TypeRadio typeRadio) {
		super();
		lastNumExam++;
		this.mesCliches = new ArrayList<Cliche>();
		this.datePrise = datePrise;
		this.numExam = lastNumExam;
		this.etat = etat;
		this.typeRadio = typeRadio;
	}

	public void ajouterCliches(int nbCliches) {
		int numCliches = this.mesCliches.size() + 1;
		for (int i = 0; i < nbCliches; i++) {
			this.mesCliches.add(new Cliche(numCliches));
			numCliches++;
		}
	}

	@Override
	public String toString() {
		return "Radiographies [mesCliches=" + mesCliches + ", datePrise="
				+ datePrise + "]";
	}

	public static void setLastNumExam(int lastNumExam) {
		Radiographie.lastNumExam = lastNumExam;
	}

	public void setCompteRendu(CompteRendu compteRendu) {
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

	public String getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(String datePrise) {
		this.datePrise = datePrise;
	}

	public static int getLastNumExam() {
		return lastNumExam;
	}

	public CompteRendu getCompteRendu() {
		return compteRendu;
	}

	public Etat getEtat() {
		return etat;
	}

	public TypeRadio getTypeRadio() {
		return typeRadio;
	}

	public void changeEtat() {
		if (this.etat.equals(Etat.effectuée)) {
			this.etat = Etat.planifiée;
		} else {
			this.etat = Etat.effectuée;
		}
	}

}