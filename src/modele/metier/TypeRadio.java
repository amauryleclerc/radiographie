package modele.metier;
/*
 * Classe d'énumération TypeRadio
 * Elle permet de définir le type de radiographie ajouté.
 */
public enum TypeRadio {
	rayonsX ("Rayons X"),
	echographieUltraSons ("Echographie à Ultra Sons"),
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