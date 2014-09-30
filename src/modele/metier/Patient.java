package modele.metier;

import java.util.ArrayList;

public class Patient extends Personne {

	private String numSECU;
	private ArrayList<Radiographie> mesRadiographie;

	public Patient(String nom, String prenom, String login, String mdp,
			String numSECU) {
		super(nom, prenom, login, mdp);
		this.numSECU = numSECU;
		this.mesRadiographie = new ArrayList<Radiographie>();
	}
	

	

	public Patient() {
		super();
	}




	public Patient(String nom, String prenom, String numSECU) {
		// TODO Auto-generated constructor stub
		super(nom, prenom, null, null);
		this.numSECU = numSECU;
		mesRadiographie = new  ArrayList<Radiographie>();
	}




	@Override
	public String toString() {
		return "Patient [numSECU=" + numSECU + ", mesRadiographie="
				+ mesRadiographie + ", toString()=" + super.toString() + "]";
	}



	public String getNumSECU() {
		return numSECU;
	}

	public void setNumSECU(String numSECU) {
		this.numSECU = numSECU;
	}

	public ArrayList<Radiographie> getMesRadiographie() {
		return mesRadiographie;
	}

	public void setMesRadiographie(ArrayList<Radiographie> mesRadiographie) {
		this.mesRadiographie = mesRadiographie;
	}
	public void afficher(){
		System.out.println(this.getNom()+" "+this.getPrenom()+" "+this.getNumSECU());
	}
	public void afficheTout(){
		System.out.println(" "+this.getNom()+" "+this.getPrenom()+" "+this.getNumSECU());
		for(Radiographie radio : this.mesRadiographie){
			String clicheCh = " cliche : ";
			for(Cliche cliche : radio.getMesCliches()){
				clicheCh += " "+cliche.getNumPrise()+";";  
			}
			System.out.println("  "+radio.getNumExam()+" "+radio.getTypeRadio()+" "+radio.getDatePrise()+" "+radio.getEtat()+" "+clicheCh);
		}
	}

}