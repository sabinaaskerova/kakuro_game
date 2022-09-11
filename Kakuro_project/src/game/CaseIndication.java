package game;

public class CaseIndication extends Case{
	protected String nombreGauche;
	protected String nombreDroit;
	protected int sommeGaucheBas;
	protected int sommeDroitHaut;
	protected int numberSummandsGauche;
	protected int numberSummandsDroit;
	
	public CaseIndication(int x, int y, String ng, String nd, int nsg, int nsd) {
		super(x, y);
		nombreGauche = ng;
		nombreDroit = nd;
		numberSummandsGauche = nsg;
		numberSummandsDroit = nsd;
	}

	public String getNombreGauche() {
		return nombreGauche;
	}

	public void setNombreGauche(String nombreGauche) {
		this.nombreGauche = nombreGauche;
	}

	public String getNombreDroit() {
		return nombreDroit;
	}

	public void setNombreDroit(String nombreDroit) {
		this.nombreDroit = nombreDroit;
	}

	public int getSommeGaucheBas() {
		return sommeGaucheBas;
	}

	public void setSommeGaucheBas(int sommeGaucheBas) {
		this.sommeGaucheBas = sommeGaucheBas;
	}

	public int getSommeDroitHaut() {
		return sommeDroitHaut;
	}

	public void setSommeDroitHaut(int sommeDroitHaut) {
		this.sommeDroitHaut = sommeDroitHaut;
	}

	public int getNumberSummandsGauche() {
		return numberSummandsGauche;
	}

	public void setNumberSummandsGauche(int numberSummandsGauche) {
		this.numberSummandsGauche = numberSummandsGauche;
	}

	public int getNumberSummandsDroit() {
		return numberSummandsDroit;
	}

	public void setNumberSummandsDroit(int numberSummandsDroit) {
		this.numberSummandsDroit = numberSummandsDroit;
	}
	
	
}