import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;


public class ChoixCaract extends JPanel {
	
	
	public ChoixCaract(){
		super();
		
		this.setLayout(new BorderLayout());
		this.add(new Label("Choix des cacteristiques"),BorderLayout.NORTH);
		
		JPanel gridChoice = new JPanel();
		gridChoice.setLayout(new GridLayout(3,4,30,30));
		
		
		
		
		
		
		
		
		
		gridChoice.add(new Label("Lame 1 : "));
		gridChoice.add(new Label("Solution 1 : "));
		gridChoice.add(new Label("Concentration : "));
		
		
		
		
		gridChoice.add(new Label("Lame 2 : "));
		gridChoice.add(new Label("Solution 2 : "));
		gridChoice.add(new Label("Concentration : "));
		
		
		
		
		
	}
}
