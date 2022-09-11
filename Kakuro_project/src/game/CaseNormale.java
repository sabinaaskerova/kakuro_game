package game;

import java.util.List;
import java.util.stream.Collectors;

import kakuroException.gameException;

public class CaseNormale extends Case{
	protected boolean preRemplie = false;
	protected boolean ligneDoublon = false;
	protected boolean colonneDoublon = false;
	protected List<Integer> possibleLineValues;
	protected List<Integer> possibleColumnValues ;
	protected List<Integer> possibleValues ;
	protected int valeur=0;
	public CaseNormale(int x, int y) {
		super(x, y);
	}
	public CaseNormale(int x, int y, int val, boolean dejaRemplie) {
		super(x, y);
		valeur = val;
		preRemplie = true;
	}
	
	public void setValeur(int x) {
		valeur = x;
	}

	public int getValeur() {
		return valeur;
	}
	public boolean isPreRemplie() {
		return preRemplie;
	}
	public void setPreRemplie(boolean preRemplie) {
		this.preRemplie = preRemplie;
	}
	public boolean isLigneDoublon() {
		return ligneDoublon;
	}
	public void setLigneDoublon(boolean ligneDoublon) {
		this.ligneDoublon = ligneDoublon;
	}
	public boolean isColonneDoublon() {
		return colonneDoublon;
	}
	public void setColonneDoublon(boolean colonneDoublon) {
		this.colonneDoublon = colonneDoublon;
	}
	public List<Integer> getPossibleLineValues() {
		return possibleLineValues;
	}
	public void setPossibleLineValues(List<Integer> possibleLineValues) {
		this.possibleLineValues = possibleLineValues;
	}
	public List<Integer> getPossibleColumnValues() {
		return possibleColumnValues;
	}
	public void setPossibleColumnValues(List<Integer> possibleColumnValues) {
		this.possibleColumnValues = possibleColumnValues;
	}
	public List<Integer> getPossibleValues() {
		return possibleValues;
	}
	
	public void intersecterPossibleValues() {
		if(possibleLineValues!=null && possibleColumnValues!=null) {
			possibleValues = possibleLineValues;
			possibleLineValues.retainAll(possibleColumnValues);
			
		}
		
	}
	public void getIntersection() throws gameException {
		if(possibleLineValues==null && possibleColumnValues==null) {
			throw new gameException("Lists are null");
		}else {
			possibleValues =  possibleLineValues.stream().filter(possibleColumnValues::contains).collect(Collectors.toList());
		}
	    
	}
	

	
	
	
}