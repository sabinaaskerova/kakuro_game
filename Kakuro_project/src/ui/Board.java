package ui;
import javax.swing.*;


import controler.GridController;
import game.*;
import kakuroException.gameException;
import solver.Solver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends GridVue implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	JPanel panneau_;
	JPanel buttonPanel;
	protected CaseList list;
	protected JButton solveButton = null;
	protected JButton checkSolutionButton = null;
	//protected JButton retryButton = null;
	protected static boolean winner = false;
	protected static boolean gameOver = false;
	protected JCheckBox hardMode_checkbox = null; 
	protected static int lost_count = 0;
	protected static final int largeurCase = 100;
	protected JLabel gameOverMessage = new JLabel();
	protected Solver solveur;

	public Board(GridController gc, CaseList cl) {
		super(gc);
		list = cl;
		solveur = new Solver(list);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        panneau_ = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override
            public void paint(Graphics g){
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 1000, 1000);
                if(list!=null) {
                	 int index =  0;
                     for (int y = 0; y < list.getNbr_ligne(); y++){
                     	for (int x = 0; x < list.getNbr_colonne(); x++) {
                     		if(list.getCases().get(index) instanceof CaseIndication) { 
                     			CaseIndication casei = (CaseIndication) cl.getCases().get(index);
                     			g.setColor(Color.BLACK); 
                     			if(casei.getNombreDroit() == "-1") {
                     				int[] xPoints = new int[]{x*largeurCase, x*largeurCase+largeurCase, x*largeurCase+largeurCase};
                                    int[] yPoints = new int[] {y*largeurCase, y*largeurCase, y*largeurCase+largeurCase};
                         			g.fillPolygon(xPoints, yPoints, 3);
                     			}
                     			else {
                     				String data = casei.getNombreDroit();
                     				g.drawString(data, x*largeurCase+50,y*largeurCase+25);
                     			}
     							  if(casei.getNombreGauche() == "-1") { 
     								  int[] xPoints = new int[]{x*largeurCase, x*largeurCase, x*largeurCase+largeurCase}; 
     								  int[] yPoints = new int[] {y*largeurCase, y*largeurCase+largeurCase, y*largeurCase+largeurCase};
     								  g.fillPolygon(xPoints, yPoints, 3); 
     							  } else { 
     								  String data =casei.getNombreGauche(); g.drawString(data, x*largeurCase+20,y*largeurCase+50);
     							  }
                     			g.drawLine(x*largeurCase, y*largeurCase, x*largeurCase+largeurCase,y*largeurCase+largeurCase);
                     		}
                     		else if(list.getCases().get(index) instanceof CaseNormale) {
                     			CaseNormale casen = (CaseNormale) list.getCases().get(index);
     							
     							if(casen.getValeur() != 0){ 
     								  String data =Integer.toString(casen.getValeur()); 
     								  if(casen.isLigneDoublon() == true || casen.isColonneDoublon() == true) {
     									 g.setColor(Color.RED);
     								  }
     								  g.drawString(data, x*largeurCase+50,y*largeurCase+50); }
     	    					}
                     		index++;
                     		g.setColor(Color.BLACK);
                     		g.drawLine((x+1)*largeurCase, 0, (x+1)*largeurCase, largeurCase*list.getNbr_ligne());
        		             
                     	}
                     	g.drawLine(0,(y+1)*largeurCase, largeurCase*(list.getNbr_ligne()-1), (y+1)*largeurCase);
                     }
            	}
               
            }
         };
         buttonPanel = new JPanel();
         solveButton = new JButton("Solve");
         checkSolutionButton = new JButton("Check solution");
		 hardMode_checkbox = new JCheckBox("Hard mode, 3 attempts only", false);
		 hardMode_checkbox.setFocusable(false);
		 //retryButton = new JButton("Try again");

         ActionListener checkListener = new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 
				if(list.checkSolution()) {
					gameOver = true;
					winner = true;
					gameOverMessage.setText("WINNER!");
					System.out.println("YOU WON!");					
				}else {
					gameOver = true;
					gameOverMessage.setText("LOSER!");
					System.out.println("YOU'RE A LOSER");

					if (hardMode_checkbox.isSelected())
						lost_count += 1;
					
					if (lost_count == 3)
					{
						gameOverMessage.setText("GAME OVER!");
						winner = true;
					}
					

				}
				
 			}
         	 
         };

         ActionListener solveListener = new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {
   
   				try {
					solveur.solve();
				} catch (gameException e1) {
					System.out.println("An error occured during solving");
					e1.printStackTrace();
				}					
  				
  				
   			}
           	 
         };

		 /*ActionListener retryListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	
				try {
					list = new CaseList();
					solveur = new Solver(list);
					gameOver = false;
					gameOverMessage.setText("DO BETTER THIS TIME!");
					winner = false;
					panneau_.revalidate();
					panneau_.repaint();
				} catch (gameException e2) {
					System.out.println(e2.getMessage());
					e2.printStackTrace();
				}
				   
			}
				 
		 };*/


         solveButton.addActionListener( solveListener);
         checkSolutionButton.addActionListener(checkListener);
		 //retryButton.addActionListener(retryListener);
         buttonPanel.add(solveButton);
         buttonPanel.add(checkSolutionButton);
		 buttonPanel.add(hardMode_checkbox);
		 //buttonPanel.add(retryButton);
         this.getContentPane().add(panneau_);
         this.getContentPane().add(buttonPanel);
         panneau_.addMouseListener(this);
         pack();
         setSize(largeurCase*(list.getNbr_colonne())*2, largeurCase*(list.getNbr_ligne()+1));
		 
		 gameOverMessage.setVerticalAlignment(SwingConstants.CENTER);
		 buttonPanel.add(gameOverMessage);

	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (winner == true)
            return;
	
		int x = (e.getX())/largeurCase;
        int y = (e.getY())/largeurCase;
        if(y<list.getNbr_ligne() && x <list.getNbr_colonne()) {
        	if(list.getGrid()[y][x] instanceof CaseNormale ) {
        		CaseNormale casen = (CaseNormale) list.getGrid()[y][x];
        		if(casen.isPreRemplie()==false) {
                	control.AfficherVueInput(y, x);
        		}
            	
        	}
        }
	}
	 public void ValeurChangee(game.ChangementValeurEvent event){
		 int col = event.getColumn();
		 int lin = event.getLine();
		 boolean hasDoublonColonne = list.isDoublonColonne(lin, col);
		 boolean hasDoublonLigne = list.isDoublonLigne(lin, col);
		
		if(hasDoublonColonne && hasDoublonLigne) {
			list.resetDoublonColonne(lin, col, hasDoublonColonne);
			list.resetDoublonLigne(lin, col, hasDoublonLigne);
		} 
		if(hasDoublonColonne && !hasDoublonLigne) {
			list.resetDoublonColonne(lin, col, hasDoublonColonne);
		} 
		if(hasDoublonLigne && !hasDoublonColonne) {
			list.resetDoublonLigne(lin, col, hasDoublonLigne);
		} 
		if(!hasDoublonLigne&& !hasDoublonColonne ) {
			list.resetDoublonColonne(lin, col, hasDoublonColonne);
			list.resetDoublonLigne(lin, col, hasDoublonLigne);
		}
		
		
       panneau_.revalidate();
       panneau_.repaint();
	 }
	
	 
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
