package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;       
import java.awt.event.WindowAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controler.GridController;
import game.ChangementValeurEvent;


public class VueInput extends GridVue implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private JButton submitButton;
	private JPanel radioPanel = new JPanel(new GridLayout(1,1));
	private JPanel content = new JPanel();

	private int ligne; //changer ca pour notifierchangementvaleur
	private int colonne; //ca aussi
	private int valueInput = 0;

	private boolean vueInputShown = false;

	public VueInput(GridController gc) {
		super(gc);
		submitButton = new JButton("Submit");
		content = new JPanel();
		setLayout();
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Action performed on submit");
					GetControleur().NotifierChangementValeur(ligne, colonne, valueInput);
					gc.setNewValueControl(valueInput);
					
				} catch(Exception exception) {
					System.out.println(exception.getMessage());
				}
				
			}
		});
		submitButton.addActionListener(event->{
			setVueInputShown(false);
        	this.dispose(); //close the input window on submit
        });

		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
				setVueInputShown(false);
                dispose();   
            }    
        });    

		content.add(radioPanel);
		content.add(submitButton);
		setContentPane(content);
		pack();
		setSize(500, 200);	
		
	}

	@Override
	public void ValeurChangee(ChangementValeurEvent event) {
		
	}
	

    @Override
    public void stateChanged(ChangeEvent e)
    {
    	GetControleur().NotifierChangementValeur(ligne, colonne, valueInput);
    }

	public void updateCoords(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public void setVueInputShown(boolean bool) {
		vueInputShown = bool;
	}

	public boolean getVueInputShown() {
		return vueInputShown;
	}

	public void setLayout() {
		content.setLayout(new GridLayout(2,1));

	     ButtonGroup group = new ButtonGroup();
	     for(int i=1 ; i < 10 ; i++) {
	     	JRadioButton radioButton = new JRadioButton(""+i);
	     	radioButton.setActionCommand(Integer.toString(i));
	     	radioButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						valueInput = Integer.parseInt(radioButton.getText());
					}catch(Exception exception) {
						System.out.println(exception.getMessage());
					}
				}
	     		
	     	});
	     	group.add(radioButton);
	     	radioPanel.add(radioButton);
	     }
	}

}