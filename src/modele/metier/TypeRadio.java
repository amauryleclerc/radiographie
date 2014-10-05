package modele.metier;
/*
 * Classe d'�num�ration TypeRadio
 * Elle permet de d�finir le type de radiographie ajout�.
 */
public enum TypeRadio {
	rayonsX ("Rayons X"),
	echographieUltraSons ("Echographie � Ultra Sons"),
	IRM ("IRM")
	;

	  private String name = "";
	   
	  //Constructeur
	  TypeRadio(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}//Fin de la classe TypeRadio