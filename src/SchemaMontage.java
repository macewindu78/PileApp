import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SchemaMontage extends JPanel {
	
	public SchemaMontage(){
		
		
		this.setLayout(new BorderLayout());
		
		JPanel pan = new JPanel();
		JLabel schma = new JLabel(new ImageIcon("Imgs/schma.png"));
		
		this.add(schma, BorderLayout.CENTER);
	}


}
