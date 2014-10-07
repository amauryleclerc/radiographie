package modele.metier;
/**
 * 
 * @author Amaury Leclerc et Thomas Martineau
 *
 */
import java.util.ArrayList;
/**
 * Classe Patient</br>
 * elle hérite de la classe Personne
 */
public class Patient extends Personne {

	//Attributs
	private String numSECU;
	private ArrayList<Radiographie> mesRadiographie;
	//Constructeurs avec paramètres
	public Patient(String nom, String prenom, String login, String mdp,
			String numSECU) {
		super(nom, prenom, login, mdp);
		this.numSECU = numSECU;
		this.mesRadiographie = new ArrayList<Radiographie>();
	}
	//Constructeurs sans paramètre
	public Patient() {
		super();
	}

	public Patient(String nom, String prenom, String numSECU) {
		// TODO Auto-generated constructor stub
		super(nom, prenom, null, null);
		this.numSECU = numSECU;
		mesRadiographie = new  ArrayList<Radiographie>();
	}
	/*la méthode toString,
	 * renvoie une chaîne de caractères servant à décrire l'objet concerné
	 */
	@Override
	public String toString() {
		return "Patient [numSECU=" + numSECU + ", mesRadiographie="
				+ mesRadiographie + ", toString()=" + super.toString() + "]";
	}

	//Accesseurs
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
	/**
	 * Méthode afficher</br>
	 * permettant d'afficher le nom, prénom et numéro de sécu d'un patient
	 */
	public void afficher(){
		System.out.println(this.getNom()+" "+this.getPrenom()+" "+this.getNumSECU());
	}
	/**
	 * Méthode afficheTout</br>
	 * permet d'afficher les radiographies du patient ainsi que c'est informations de base.
	 */
	public void afficheTout(){
		System.out.println(" "+this.getNom()+" "+this.getPrenom()+" "+this.getNumSECU());
		for(Radiographie radio : this.mesRadiographie){
			String clicheCh = " cliche : ";
			for(Cliche cliche : radio.getMesCliches()){
				clicheCh += " "+cliche.getNumPrise()+";";  
			}
			System.out.println("  "+radio.getNumExam()+" "+radio.getTypeRadio()+" "+radio.getDatePrise()+" "+radio.getEtat()+" "+clicheCh);
		}//fin du for
	}//Fin de la méthode afficheTout

}//Fin de la classe Patient