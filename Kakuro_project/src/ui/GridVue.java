package ui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import controler.GridController;
import game.ChangementValeurEvent;
import game.ChangementValeurListener;

public class GridVue extends JFrame implements ChangementValeurListener{
	private static final long serialVersionUID = 1L;
	protected controler.GridController control = null;
	public GridVue(GridController gc) {
		control = gc;
		try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final GridController GetControleur() { 
		 return control;
	}

	@Override
	public void ValeurChangee(ChangementValeurEvent event) {

		
	}
	

}
