package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SchemaFerme extends JPanel {
	
	BufferedImage img;
	JLabel metal1, metal2, solution1, solution2, concentration1, concentration2, Tension, plus, moins, fHaut, fBas, fGauche, fDroit, bfBas, bfHaut, electron, anode, cathode, courant;
	
	boolean alreadyOn = false;
	
	float potentiel1, potentiel2;
	
	public SchemaFerme(){
		
		this.setLayout(null);
		img = null;
		try {
		    img = ImageIO.read(getClass().getResource("/Imgs/schmaferme.png"));
		} catch (IOException e) {
			System.out.println("toto");
		}

		
		//Les labels pour les composants du schéma
		metal1 = new JLabel(MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]);
		metal1.setBounds(220, 350, 200, 20);
		metal2 = new JLabel(MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]);
		metal2.setBounds(660,350,200,20);
		solution1 = new JLabel(MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal1]);
		solution1.setBounds(250,530,200,20);
		solution2 = new JLabel(MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal2]);
		solution2.setBounds(620,530,200,20);
		concentration1 = new JLabel(MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire1]);
		concentration1.setBounds(250,550,200,20);
		concentration2 = new JLabel(MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire2]);
		concentration2.setBounds(620,550,200,20);
		anode = new JLabel("Anode");
		anode.setVisible(false);
		cathode = new JLabel("Cathode");
		cathode.setVisible(false);
		this.add(metal1);
		this.add(metal2);
		this.add(solution1);
		this.add(solution2);
		this.add(concentration1);
		this.add(concentration2);
		this.add(anode);
		this.add(cathode);
		
		//Boutons
		JButton retour = new JButton("Retour");
		retour.setBounds(2, 2, 200, 40);
		retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().contentPane.removeAll();
				AccueilScreen.GetInstance().contentPane.add(AccueilScreen.GetInstance().circuitferme);
				AccueilScreen.GetInstance().contentPane.repaint();
				AccueilScreen.GetInstance().contentPane.revalidate();
				
			}
		});
		this.add(retour);
		
		JButton sensCourant = new JButton("Sens conventionnel du courant");
		sensCourant.setBounds(743, 2, 250, 40);
		sensCourant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				affichSensCourant();
				
			}
		});
		this.add(sensCourant);
		
		Tension = new JLabel();
		Tension.setBounds(480, 220, 90, 20);
		Tension.setForeground(Color.blue);
		Tension.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(Tension);
		
		courant = new JLabel();
		courant.setBounds(570,100,90,20);
		courant.setForeground(Color.blue);
		courant.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(courant);
		
		plus = new JLabel(new ImageIcon(getClass().getResource("/Imgs/plus.png")));
		plus.setBounds(290, 280, 50, 50);
		this.add(plus);
		
		moins = new JLabel(new ImageIcon(getClass().getResource("/Imgs/moins.png")));
		moins.setBounds(630, 280, 50, 50);
		this.add(moins);
		
		
		fGauche = new JLabel(new ImageIcon(getClass().getResource("/Imgs/flechegauche.png")));
		fGauche.setBounds(290, 280, 50, 50);
		this.add(fGauche);
		
		fDroit = new JLabel(new ImageIcon(getClass().getResource("/Imgs/flechedroite.png")));
		fDroit.setBounds(370, 252, 50, 50);
		this.add(fDroit);
		
		fBas = new JLabel(new ImageIcon(getClass().getResource("/Imgs/flechebas.png")));
		fBas.setBounds(579, 280, 50, 50);
		this.add(fBas);
		
		fHaut = new JLabel(new ImageIcon(getClass().getResource("/Imgs/flechehaut.png")));
		fHaut.setBounds(333, 280, 50, 50);
		this.add(fHaut);
				
		
		bfBas = new JLabel(new ImageIcon(getClass().getResource("/Imgs/blackflechebas.png")));
		bfBas.setBounds(579, 20, 50, 50);
		this.add(bfBas);
		
		bfHaut = new JLabel(new ImageIcon(getClass().getResource("/Imgs/blackflechehaut.png")));
		bfHaut.setBounds(579, 200, 50, 50);
		this.add(bfHaut);
		
		electron = new JLabel("e-");
		electron.setBounds(620, 200, 50, 20);
		this.add(electron);
		
	}
	
	public void upDateAffich(){
		metal1.setText(MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]);
		metal2.setText(MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]);
		solution1.setText(MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal1]);
		solution2.setText(MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal2]);
		concentration1.setText(""+Calculs.calculConcentrationMassique(MetauxCaract.massesMolaires[AccueilScreen.GetInstance().circuitferme.metal1], MetauxCaract.concentrationsMolaires[AccueilScreen.GetInstance().circuitferme.concentrationMolaire1])+ " g/L");
		concentration2.setText(""+Calculs.calculConcentrationMassique(MetauxCaract.massesMolaires[AccueilScreen.GetInstance().circuitferme.metal2], MetauxCaract.concentrationsMolaires[AccueilScreen.GetInstance().circuitferme.concentrationMolaire2])+ " g/L");
		potentiel1 = Calculs.calculPotentiel(AccueilScreen.GetInstance().circuitferme.metal1, AccueilScreen.GetInstance().circuitferme.concentrationMolaire1);
		potentiel2 = Calculs.calculPotentiel(AccueilScreen.GetInstance().circuitferme.metal2, AccueilScreen.GetInstance().circuitferme.concentrationMolaire2);
		plus.setVisible(false);
		moins.setVisible(false);
		fDroit.setVisible(false);
		fBas.setVisible(false);
		fHaut.setVisible(false);
		fGauche.setVisible(false);
		bfBas.setVisible(false);
		bfHaut.setVisible(false);
		electron.setVisible(false);
		anode.setVisible(false);
		cathode.setVisible(false);
		alreadyOn = false;
		
		Tension.setText("  " + Calculs.calculDDP(potentiel1, potentiel2)+ " V");
		courant.setText("  "+ Calculs.calculCourant(Calculs.calculDDP(potentiel1, potentiel2), AccueilScreen.GetInstance().circuitferme.R)+" A");
	}
	
	
	public void affichSensCourant(){
		if(alreadyOn==false){
			if(Calculs.calculDDP(potentiel1, potentiel2)<0){	
				plus.setBounds(290, 280, 50, 50);
				moins.setBounds(630, 280, 50, 50);
				fDroit.setBounds(370, 132, 50, 50);
				fBas.setBounds(579, 280, 50, 50);
				fHaut.setBounds(333, 280, 50, 50);
				anode.setBounds(630,270,200,20);
				cathode.setBounds(290,260,200,20);
				plus.setVisible(true);
				moins.setVisible(true);
				fDroit.setVisible(true);
				fBas.setVisible(true);
				fHaut.setVisible(true);
				bfHaut.setVisible(true);
				electron.setVisible(true);
				anode.setVisible(true);
				cathode.setVisible(true);
				alreadyOn = true;
	
			}else if(Calculs.calculDDP(potentiel1, potentiel2)>0){
				plus.setBounds(630, 280, 50, 50);
				moins.setBounds(290, 280, 50, 50);
				fGauche.setBounds(370, 132, 50, 50);
				fBas.setBounds(333, 280, 50, 50);
				fHaut.setBounds(579, 280, 50, 50);
				cathode.setBounds(630,260,200,20);
				anode.setBounds(290,270,200,20);
				plus.setVisible(true);
				moins.setVisible(true);
				fGauche.setVisible(true);
				fBas.setVisible(true);
				fHaut.setVisible(true);
				bfBas.setVisible(true);
				electron.setVisible(true);
				anode.setVisible(true);
				cathode.setVisible(true);
				
				alreadyOn = true;
				
			}else{}
		}else{
			plus.setVisible(false);
			moins.setVisible(false);
			fDroit.setVisible(false);
			fBas.setVisible(false);
			fHaut.setVisible(false);
			fGauche.setVisible(false);
			bfBas.setVisible(false);
			bfHaut.setVisible(false);
			electron.setVisible(false);
			anode.setVisible(false);
			cathode.setVisible(false);
			alreadyOn = false;
		}
		

		
	}
	
	
	@Override
    public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		//super.paintComponent(g);		
	}
}
