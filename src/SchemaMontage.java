import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SchemaMontage extends JPanel {
	
	BufferedImage img;
	public SchemaMontage(){
		
		
		
		JPanel pan = new JPanel();
		
		this.setLayout(null);
		img = null;
		try {
		    img = ImageIO.read(new File("Imgs/schma.png"));
		} catch (IOException e) {
			System.out.println("toto");
		}

		
		//Les labels pour les composants du schéma
		JLabel metal1 = new JLabel(AccueilScreen.GetInstance().pageChoix.metal1Choisis);
		metal1.setBounds(220, 350, 200, 20);
		JLabel metal2 = new JLabel(AccueilScreen.GetInstance().pageChoix.metal2Choisis);
		metal2.setBounds(660,350,200,20);
		JLabel solution1 = new JLabel(AccueilScreen.GetInstance().pageChoix.solution1Choisis);
		solution1.setBounds(250,530,200,20);
		JLabel solution2 = new JLabel(AccueilScreen.GetInstance().pageChoix.solution2Choisis);
		solution2.setBounds(620,530,200,20);
		JLabel concentration1 = new JLabel(AccueilScreen.GetInstance().pageChoix.concentration1Choisis);
		concentration1.setBounds(250,550,200,20);
		JLabel concentration2 = new JLabel(AccueilScreen.GetInstance().pageChoix.concentration2Choisis);
		concentration2.setBounds(620,550,200,20);
		this.add(metal1);
		this.add(metal2);
		this.add(solution1);
		this.add(solution2);
		this.add(concentration1);
		this.add(concentration2);
		
		
		//Boutons
		JButton retour = new JButton("Retour");
		retour.setBounds(2, 2, 200, 40);
		retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().contentPane.removeAll();
				AccueilScreen.GetInstance().contentPane.add(AccueilScreen.GetInstance().pageChoix);
				AccueilScreen.GetInstance().contentPane.repaint();
				AccueilScreen.GetInstance().contentPane.revalidate();
				
			}
		});
		this.add(retour);
		
		JButton sensCourant = new JButton("Sens du courant");
		sensCourant.setBounds(793, 2, 200, 40);
		sensCourant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO ACTION
				
			}
		});
		this.add(sensCourant);
		
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		//super.paintComponent(g);		
	}
}
