package game;
import java.util.EventObject;

public class ChangementValeurEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	private int nouvelleValeur;
	private int line;
	private int column;
	
	public ChangementValeurEvent(Object source, int nouvelle, int ligne, int colonne) {
		super(source);
		nouvelleValeur = nouvelle; 
		line = ligne;
		column = colonne;		 
	}
	public int getNouvelleValeur() {
		return nouvelleValeur;
	}
	public int getLine() {
		return line;
	}
	public int getColumn() {
		return column;
	}
	
}
