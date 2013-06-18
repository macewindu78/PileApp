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
		JLabel metal1 = new JLabel(AccueilScreen.instance.pageChoix.metal1Choisis);
		JLabel metal2 = new JLabel(AccueilScreen.instance.pageChoix.metal2Choisis);
		JLabel solution1 = new JLabel(AccueilScreen.instance.pageChoix.solution1Choisis);
		JLabel solution2 = new JLabel(AccueilScreen.instance.pageChoix.solution2Choisis);
		JLabel concentration1 = new JLabel(AccueilScreen.instance.pageChoix.concentration1Choisis);
		JLabel concentration2 = new JLabel(AccueilScreen.instance.pageChoix.concentration2Choisis);
		this.add(schma, BorderLayout.CENTER);
	}


}
