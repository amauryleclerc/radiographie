package modele.metier;

public class Cliche {

	private int numPrise;

	public Cliche() {
		super();
	}

	public Cliche(int numPrise) {
		super();
		this.numPrise = numPrise;
	}

	@Override
	public String toString() {
		return "Cliche [numPrise=" + numPrise + "]";
	}

	public int getNumPrise() {
		return numPrise;
	}

	public void setNumPrise(int numPrise) {
		this.numPrise = numPrise;
	}

}