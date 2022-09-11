package solver;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import game.CaseIndication;
import game.CaseList;
import game.CaseNormale;
import kakuroException.gameException;


public class Solver {
	protected CaseList list;
	protected List<Integer> array21 = new ArrayList<Integer>(Arrays.asList(1, 2));//3
	protected List<Integer> array23 = new ArrayList<Integer>(Arrays.asList(1,4));//5
	protected List<Integer> array24 = new ArrayList<Integer>(Arrays.asList(2,3));//5
	protected List<Integer>  array210 = new ArrayList<Integer>(Arrays.asList(1,7));//8
	protected List<Integer>  array211 = new ArrayList<Integer>(Arrays.asList(2,6));//8
	protected List<Integer>  array212 = new ArrayList<Integer>(Arrays.asList(3,5));//8
	protected List<Integer>  array221 = new ArrayList<Integer>(Arrays.asList(2,9));//11
	protected List<Integer>  array222 = new ArrayList<Integer>(Arrays.asList(3,8));//11
	protected List<Integer>  array223 = new ArrayList<Integer>(Arrays.asList(4,7));//11
	protected List<Integer>  array224 = new ArrayList<Integer>(Arrays.asList(5,6));//11
	protected List<Integer>  array225 = new ArrayList<Integer>(Arrays.asList(6,9));//15
	protected List<Integer>  array226 = new ArrayList<Integer>(Arrays.asList(7,8));//15
	
	protected List<Integer>  array31 = new ArrayList<Integer>(Arrays.asList(1, 2, 5));//8
	protected List<Integer>  array32 = new ArrayList<Integer>(Arrays.asList(1, 3, 4));//8
	protected List<Integer>  array33 = new ArrayList<Integer>(Arrays.asList(1, 2, 8));//11
	protected List<Integer>  array34 = new ArrayList<Integer>(Arrays.asList(1, 3, 7));//11
	protected List<Integer>  array35 = new ArrayList<Integer>(Arrays.asList(1, 4, 6));//11
	protected List<Integer>  array36 = new ArrayList<Integer>(Arrays.asList(2, 3, 6));//11
	protected List<Integer>  array37 = new ArrayList<Integer>(Arrays.asList(2, 4, 5));//11
	protected List<Integer>  array38 = new ArrayList<Integer>(Arrays.asList(1, 5, 9));//15
	protected List<Integer>  array39 = new ArrayList<Integer>(Arrays.asList(1, 6, 8));//15
	protected List<Integer>  array310 = new ArrayList<Integer>(Arrays.asList(2, 4, 9));//15
	protected List<Integer>  array311 = new ArrayList<Integer>(Arrays.asList(2,5,8));//15
	protected List<Integer>  array312 = new ArrayList<Integer>(Arrays.asList(2,6,7));//15
	protected List<Integer>  array313 = new ArrayList<Integer>(Arrays.asList(3,4,8));//15
	protected List<Integer>  array314 = new ArrayList<Integer>(Arrays.asList(3,5,7));//15
	protected List<Integer>  array315 = new ArrayList<Integer>(Arrays.asList(4,5,6));//15
	
	protected List<Integer>  array41 = new ArrayList<Integer>(Arrays.asList(1,2,3,5));//11
	protected List<Integer>  array42 = new ArrayList<Integer>(Arrays.asList(1,2,3,9));//15
	protected List<Integer>  array43 = new ArrayList<Integer>(Arrays.asList(1,2,4,8));//15
	protected List<Integer>  array44 = new ArrayList<Integer>(Arrays.asList(1,2,5,7));//15
	protected List<Integer>  array45 = new ArrayList<Integer>(Arrays.asList(1,3,4,7));//15
	protected List<Integer>  array46 = new ArrayList<Integer>(Arrays.asList(1,3,5,6));//15
	protected List<Integer>  array47 = new ArrayList<Integer>(Arrays.asList(2,3,4,6));//15
	protected List<Integer>  array48 = new ArrayList<Integer>(Arrays.asList(1,7,8,9));//25
	protected List<Integer>  array49 = new ArrayList<Integer>(Arrays.asList(2,6,8,9));//25
	protected List<Integer>  array410 = new ArrayList<Integer>(Arrays.asList(3,5,8,9));//25
	protected List<Integer>  array411 = new ArrayList<Integer>(Arrays.asList(3,6,7,9));//25
	protected List<Integer>  array412 = new ArrayList<Integer>(Arrays.asList(4,5,7,9));//25
	protected List<Integer>  array413 = new ArrayList<Integer>(Arrays.asList(4,6,7,8));//25
	
	HashMap<Integer, List<Integer>>  mapTwo= new HashMap<>();
	HashMap<Integer, List<Integer>> mapThree = new HashMap<>();
	HashMap<Integer, List<Integer>> mapFour = new HashMap<>();
	public void initialize_Partitions(){
		mapTwo.put(3, array21);
		List<Integer> twoFive = new ArrayList<Integer>();
		twoFive.addAll(array23); twoFive.addAll(array24);
		mapTwo.put(5, twoFive);
		List<Integer> twoEight = new ArrayList<Integer>();
		twoEight.addAll(array210);twoEight.addAll(array211);twoEight.addAll(array212);
		mapTwo.put(8, twoEight);
		List<Integer> twoEleven = new ArrayList<Integer>();
		twoEleven.addAll(array221);twoEleven.addAll(array222);twoEleven.addAll(array223);twoEleven.addAll(array224);
		mapTwo.put(11, twoEleven); 
		List<Integer> twoFifteen = new ArrayList<Integer>();
		twoFifteen .addAll(array225);twoFifteen .addAll(array226);
		mapTwo.put(15, twoFifteen);
		
		
		List<Integer> threeEight = new ArrayList<Integer>();
		threeEight.addAll(array31); threeEight.addAll(array32);
		mapThree.put(8, threeEight);
		List<Integer> threeEleven = new ArrayList<Integer>();
		threeEleven.addAll(array33);threeEleven.addAll(array34);threeEleven.addAll(array35);threeEleven.addAll(array36);
		threeEleven.addAll(array37);
		mapThree.put(11, threeEleven);
		
		List<Integer> threeFifteen = new ArrayList<Integer>();
		threeFifteen.addAll(array38);threeFifteen.addAll(array39);threeFifteen.addAll(array310);threeFifteen.addAll(array311);
		threeFifteen.addAll(array312);threeFifteen.addAll(array313);threeFifteen.addAll(array314);threeFifteen.addAll(array315);
	
		mapThree.put(15, threeFifteen);
		
		List<Integer> fourEleven = new ArrayList<Integer>();
		fourEleven.addAll(array41);
		
		 mapFour.put(11, fourEleven);
		 List<Integer> fourFifteen = new ArrayList<Integer>();
			fourFifteen.addAll(array42);fourFifteen.addAll(array43);fourFifteen.addAll(array44);fourFifteen.addAll(array45);
			fourFifteen.addAll(array46);fourFifteen.addAll(array47);
		
		 mapFour.put(15, fourFifteen);
		 List<Integer> fourTwentyFive = new ArrayList<Integer>();
			fourTwentyFive.addAll(array48);fourTwentyFive.addAll(array49);fourTwentyFive.addAll(array410);fourTwentyFive.addAll(array411);
			fourTwentyFive.addAll(array412);fourTwentyFive.addAll(array413);
		
		 mapFour.put(25, fourTwentyFive);

		 
	}
	
	public Solver(CaseList l) {
		list = l;
	}
	
	public void setPossibleValuesColumn(CaseIndication ci, int line, int column) {
			int nombreGauche = Integer.parseInt(ci.getNombreGauche());
			int numberSummandsGauche = ci.getNumberSummandsGauche();
			if(numberSummandsGauche==1) {
				list.SetValeur(line+1, column, nombreGauche);
				CaseNormale terme = (CaseNormale) list.getGrid()[line+1][column];
				terme.setPossibleColumnValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
				terme.setPossibleLineValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
			}else {
			
				for(int k=line+1; k<=line+numberSummandsGauche; k++) {
					HashMap<Integer, List<Integer>> map = null;
					
					if(numberSummandsGauche == 2) {
						map = mapTwo;
					}
					else if(numberSummandsGauche == 3) {
						
						map = mapThree;
					}else if(numberSummandsGauche == 4) {
						
						map = mapFour;
						
					}
					//System.out.println(numberSummandsGauche+" summands for "+line+" "+column);
					//System.out.println("MAP " + map.toString());
					CaseNormale terme = (CaseNormale) list.getGrid()[k][column];
					if(!terme.isPreRemplie()) {
						//System.out.println("!isPreRemplie ");
						List<Integer> allValues = new ArrayList<Integer>();
						for(Entry<Integer, List<Integer>> entry: map.entrySet()) {
						      if(entry.getKey() == nombreGauche) {
						    	 // System.out.println(nombreGauche);
						    	allValues.addAll(entry.getValue());
						      }
						}
						terme.setPossibleColumnValues(allValues);
					    //System.out.println("column values for "+k+" "+column+" "+terme.getPossibleColumnValues());
					}else {
						terme.setPossibleColumnValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
						//System.out.println("column values for "+k+" "+column+" "+terme.getPossibleColumnValues());
						terme.setPossibleLineValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
						//System.out.println("line values for "+k+" "+column+" "+terme.getPossibleLineValues());
					}
				}
			}
	}
	
	public void setPossibleValuesLine(CaseIndication ci, int line, int column) {
		int nombreDroit = Integer.parseInt(ci.getNombreDroit());
		int numberSummandsDroit = ci.getNumberSummandsDroit();
		if(numberSummandsDroit == 1) {
			list.SetValeur(line, column+1, nombreDroit);
			CaseNormale terme = (CaseNormale) list.getGrid()[line][column+1];
			terme.setPossibleColumnValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
			terme.setPossibleLineValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
		}
		else {
			for(int k=column+1; k<=column+numberSummandsDroit; k++) {
				HashMap<Integer, List<Integer>> map = null;
				
				if(numberSummandsDroit == 2) {
					map = mapTwo;
				}
				else if(numberSummandsDroit == 3) {
					
					map = mapThree;
				}else if(numberSummandsDroit == 4) {
					
					map = mapFour;
					
				}
				CaseNormale terme = (CaseNormale) list.getGrid()[line][k];
				if(!terme.isPreRemplie()) {
					List<Integer> allValues = new ArrayList<Integer>();
					for(Entry<Integer, List<Integer>> entry: map.entrySet()) {
					
					      if(entry.getKey() == nombreDroit) {
					    	  allValues.addAll(entry.getValue());
					    	
					      }
					      
					}
					terme.setPossibleLineValues(allValues);
				      //System.out.println("line values for "+line+" "+k+" "+terme.getPossibleLineValues());
					
				}
				else {
					terme.setPossibleColumnValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
					//System.out.println("column values for "+line+" "+k+" "+terme.getPossibleColumnValues());
					terme.setPossibleLineValues(new ArrayList<Integer>(Arrays.asList(terme.getValeur())));
					//System.out.println("line values for "+line+" "+k+" "+terme.getPossibleLineValues());
				}
			}
		
		}
	}
	
	public void solve() throws gameException {
		initialize_Partitions();
		for(int i = 0; i<list.getNbr_ligne();i++) {
			for(int j = 0; j<list.getNbr_colonne();j++) {
				if(list.getGrid()[i][j] instanceof CaseIndication) {
					CaseIndication ci = (CaseIndication) list.getGrid()[i][j];
					if(ci.getNombreGauche()!="-1") {
						setPossibleValuesColumn(ci, i,j);
					}
					if(ci.getNombreDroit()!="-1") {
						setPossibleValuesLine(ci, i, j);
						
					}
					if(ci.getNombreGauche()!="-1") {
						int numberSummandsGauche = ci.getNumberSummandsGauche();
						for(int k=i+1; k<=i+numberSummandsGauche; k++) {
							CaseNormale terme = (CaseNormale) list.getGrid()[k][j];
							terme.getIntersection();
							
							System.out.print("for " + k +" " + j + " line: ");
							if(terme.getPossibleLineValues()!=null) {
								System.out.print(terme.getPossibleLineValues().toString());
							}
							
							System.out.print(" column: ");
							if(terme.getPossibleColumnValues()!=null) {
								System.out.print(terme.getPossibleColumnValues().toString());
							}
							System.out.println();
							System.out.print("intersecter Gauche: ");
							if(terme.getPossibleValues() == null) {
								System.out.println("null pour " + k + " " + j);
							}else {
								System.out.println(terme.getPossibleValues().toString());
							}
						
						}
					}
					if(ci.getNombreDroit()!="-1") {
						
					
						int numberSummandsDroit = ci.getNumberSummandsDroit();
						for(int k=j+1; k<=j+numberSummandsDroit; k++) {
							
							CaseNormale terme = (CaseNormale) list.getGrid()[i][k];
							terme.getIntersection();
							
							
							System.out.print("for "+ i +" "+ k +" line: ");
							if(terme.getPossibleLineValues()!=null) {
								System.out.print(terme.getPossibleLineValues().toString());
							}
							
							System.out.print(" column: ");
							if(terme.getPossibleColumnValues()!=null) {
								System.out.print(terme.getPossibleColumnValues().toString());
							}
							System.out.println();
							System.out.print("intersecter Droit: ");
							if(terme.getPossibleValues() == null) {
								System.out.println("null pour " + i + " " + k);
							}else {
								System.out.println(terme.getPossibleValues().toString());
							}
							
							
						}
					}
				}
			}
		}
	}
	
 	
}

