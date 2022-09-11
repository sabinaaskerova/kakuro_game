package game;

import java.util.ArrayList;

import javax.swing.event.EventListenerList;


public class CaseList {
	protected int nbr_colonne = 0;
	protected int nbr_ligne = 0;
	protected Case grid[][];
	private EventListenerList ecouteurs;
	protected ArrayList<Case> cases = new ArrayList<Case>();
	Case c11 = new CaseIndication(1, 1, "-1", "-1", 0, 0); 
	Case c12 = new CaseIndication(1, 2, "-1", "-1", 0, 0); 
	Case c13 = new CaseIndication(1, 3, "25", "-1", 4, 0); 
	Case c14 = new CaseIndication(1, 4, "2", "-1", 1, 0);
	Case c21 = new CaseIndication(2, 1, "-1", "-1", 0,0); 
	Case c22 = new CaseIndication(2, 2, "5", "8", 2, 2);
	Case c23 = new CaseNormale(2, 3);
	Case c24 = new CaseNormale(2, 4);
	Case c31 = new CaseIndication(3, 1, "-1", "11", 0, 2);
	Case c32 = new CaseNormale(3, 2);
	Case c33 = new CaseNormale(3, 3, 8, true);
	Case c34 = new CaseIndication(3, 4, "5", "-1", 2, 0);
	Case c41 = new CaseIndication(4, 1, "-1", "15", 0, 3);
	Case c42 = new CaseNormale(4, 2, 2, true);
	Case c43 = new CaseNormale(4, 3);
	Case c44 = new CaseNormale(4, 4);
	Case c51 = new CaseIndication(5, 1, "-1", "-1", 0, 0);
	Case c52 = new CaseIndication(5, 2, "-1", "3", 0, 2);
	Case c53 = new CaseNormale(5, 3);
	Case c54 = new CaseNormale(5, 4);
	
	public CaseList() { 
		ecouteurs= new EventListenerList();		
		cases.add(c11); cases.add(c12); cases.add(c13); cases.add(c14);
		cases.add(c21); cases.add(c22); cases.add(c23); cases.add(c24);
		cases.add(c31); cases.add(c32); cases.add(c33); cases.add(c34);
		cases.add(c41); cases.add(c42); cases.add(c43); cases.add(c44);
		cases.add(c51); cases.add(c52); cases.add(c53); cases.add(c54);
		 
		nbr_ligne = 5;
		nbr_colonne = 4;
		
		grid = new Case[nbr_ligne][nbr_colonne];
		int compteur = 0;
		for(int i = 0; i<nbr_ligne;i++) {
			for(int j=0; j<nbr_colonne; j++) {
				grid[i][j] = cases.get(compteur);
				compteur++;
			}
		}
	}
	public void SetValeur(int ligne, int colonne, int val) {
		CaseNormale casen = (CaseNormale) grid[ligne][colonne];
		casen.setValeur(val);
		ValeurChangee(val, ligne, colonne);
		
	}

	 public boolean checkValeurDroite(int line, int column){
		 CaseIndication ciCheck = (CaseIndication) grid[line][column];
		 int sumTermesLigne = 0;
		 if(ciCheck.nombreDroit != "-1") {
			 int valeurDroiteCi = Integer.parseInt(ciCheck.nombreDroit);
			 int k = column+1;
			 while(k<nbr_colonne && !(grid[line][k] instanceof CaseIndication)) {
				 System.out.println("checkValeurDroite: ligne " + line + " colonne " + k);
				 CaseNormale terme = (CaseNormale) grid[line][k];
				 if(terme.valeur == 0) {
					 //String message = "vous n'avez pas entre la valeur sur la ligne "+line+" et colonne "+k;
					 //throw(new gameException(message));

					 System.out.println("Vous n'avez pas entre la valeur sur la ligne " + line + " et colonne " + k);
					 return false;
			
				 }
				 sumTermesLigne += terme.valeur;
				 k++;
			 }

			 if(sumTermesLigne!=valeurDroiteCi) {
				// System.out.println("checkValeurDroite:somme sur la ligne "+line +" colonne "
				//		 			+k+" egale a "+sumTermesLigne+" somme attendue etant "+valeurDroiteCi);
				 return false;
				 
			 }
			 else {
				 return true;
			 }
		 }
		return true;
	 }
	 
	 public boolean checkValeurGauche(int line, int column) {
		 CaseIndication ciCheck = (CaseIndication) grid[line][column];
		 int sumTermesColonne = 0;
		 if(ciCheck.nombreGauche != "-1") {
			 int valeurGaucheCi = Integer.parseInt(ciCheck.nombreGauche);
			 int j = line+1;
			 while(j<nbr_ligne && !(grid[j][column] instanceof CaseIndication)) {
				 System.out.println("checkValeurGauche:ligne "+j+" colonne "+column);
				 CaseNormale terme = (CaseNormale) grid[j][column];
				 if(terme.valeur == 0) {
					 //String message = "vous n'avez pas entre la valeur sur la ligne "+j+" et colonne "+column;
					 //throw(new gameException(message));
					 System.out.println("Vous n'avez pas entre la valeur sur la ligne " + j + " et colonne " + column);
					 return false;
					 
				 }
				 sumTermesColonne += terme.valeur;
				 j++;
			 }
			 
			 if(sumTermesColonne!=valeurGaucheCi) {
				 //System.out.println("checkValeurGauche:somme sur la ligne "+j +" colonne "
					//	 			+column+" egale a "+sumTermesColonne+" somme attendue etant "+valeurGaucheCi);
				 
				 return false;
			 }
			 else {
				 return true;
			 }
		 }
		return true;
	 }
	 
	 public boolean checkSolution() {
		 for(int i = 0; i<nbr_ligne; i++) {
			 for(int j = 0; j<nbr_colonne; j++) {
				 if(grid[i][j] instanceof CaseIndication) {
						if(!(checkValeurGauche(i,j))||!(checkValeurDroite(i,j))) {
							 return false;
						 }
				
				 }
			 }
		 }
		 return true;
	 }
	 
	public boolean isDoublonColonne(int line, int column) {
		boolean result = false;
		for(int i = line; i>=0 && !(grid[i][column] instanceof CaseIndication); i--) {
			CaseNormale terme1 = (CaseNormale) grid[i][column];
			for(int j = line; j>=0 && !(grid[j][column] instanceof CaseIndication); j--) {
				CaseNormale terme2 = (CaseNormale) grid[j][column];
				if(i!= j && terme1.valeur != 0 && terme1.valeur == terme2.valeur) {
					result =  true;
					break;
				}
			}
		}
		for(int i = line; i < nbr_ligne&& !(grid[i][column] instanceof CaseIndication); i++) {
			CaseNormale terme1 = (CaseNormale) grid[i][column];
			for(int j = line; j < nbr_ligne&& !(grid[j][column] instanceof CaseIndication); j++) {
				CaseNormale terme2 = (CaseNormale) grid[j][column];
				if(i!= j && terme1.valeur != 0 && terme1.valeur == terme2.valeur) {
					result =  true;
					break;
				}
			}
		}
		
		return result;
	}

	
	public boolean isDoublonLigne(int line, int column) {
		boolean result = false;
		for(int i = column; i>=0 && !(grid[line][i] instanceof CaseIndication); i--) {
			CaseNormale terme1 = (CaseNormale) grid[line][i];
			for(int j = column; i>=0 && !(grid[line][j] instanceof CaseIndication); j--) {
				CaseNormale terme2 = (CaseNormale) grid[line][j];
				if(i!=j && terme1.valeur != 0 && terme1.valeur == terme2.valeur) {
					result = true;
					break;
				}
			}
		}
		for(int i = column; i<nbr_colonne && !(grid[line][i] instanceof CaseIndication) ; i++) {
			CaseNormale terme1 = (CaseNormale) grid[line][i];
			for(int j = column; j<nbr_colonne && !(grid[line][j] instanceof CaseIndication); j++) {
				
				CaseNormale terme2 = (CaseNormale) grid[line][j];
				if(i!=j&& terme1.valeur != 0 && terme1.valeur == terme2.valeur) {
					result = true;
					break;
				}
			}
				
			}
		
		return result;
		
	}
	
	public void resetDoublonLigne(int lin, int col, boolean doublon)
	{
		
			for(int i = col; i>=0 && !(grid[lin][i] instanceof CaseIndication); i--) {
				 CaseNormale terme = (CaseNormale) grid[lin][i];
				 terme.setLigneDoublon(doublon);
			 }
			 for(int j = col+1; j<getNbr_colonne() && !(grid[lin][j] instanceof CaseIndication) ; j++) {
				 	CaseNormale terme = (CaseNormale) grid[lin][j];
					terme.setLigneDoublon(doublon);
			 }
		
		
	}
	public void resetDoublonColonne(int lin, int col, boolean doublon) {
		
		for(int i = lin; i>=0 && !(grid[i][col] instanceof CaseIndication); i--) {
			 CaseNormale terme = (CaseNormale) grid[i][col];
			
			 terme.setColonneDoublon(doublon);
		 }
		 for(int j = lin+1; j < getNbr_ligne()&& !(grid[j][col] instanceof CaseIndication); j++) {
			 CaseNormale terme = (CaseNormale) grid[j][col];
			
			 terme.setColonneDoublon(doublon);
		 }
	}
	
	public Case[][] getGrid() {
		return grid;
	}
	
	public ArrayList<Case> getCases() {
		return cases;
	}
	public void AjouterEcouteurValeur(ChangementValeurListener ecouteur){
        ecouteurs.add(ChangementValeurListener.class, ecouteur);
    }
    public void EnleverEcouteurValeur(ChangementValeurListener ecouteur) {
    	ecouteurs.remove(ChangementValeurListener.class, ecouteur);
    }
	public int getNbr_colonne() {
		return nbr_colonne;
	}
	public int getNbr_ligne() {
		return nbr_ligne;
	}
	public void setGrid(Case[][] grid) {
		this.grid = grid;
	}
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
	private void ValeurChangee(int val, int ligne, int colonne) {
		ChangementValeurListener[] ecouteurs_list = 
	                (ChangementValeurListener[])
	                ecouteurs.getListeners(ChangementValeurListener.class);
	        for (ChangementValeurListener ecouteur : ecouteurs_list){
	            ecouteur.ValeurChangee(new ChangementValeurEvent(this, val, ligne, colonne));
	        }
	 }
	
	
}

