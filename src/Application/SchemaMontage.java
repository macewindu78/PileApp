package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SchemaMontage extends JPanel {
	
	BufferedImage img;
	JLabel metal1, metal2, solution1, solution2, concentration1, concentration2, Tension, plus, moins, fHaut, fBas, fGauche, fDroit, bfDroit, bfGauche, electron;
	
	boolean alreadyOn = false;
	
	float potentiel1, potentiel2;
	
	public SchemaMontage(){
		
		this.setLayout(null);
		img = null;
		try {
		    img = ImageIO.read(getClass().getResource("/ressources/Imgs/schma.png"));
		} catch (IOException e) {
			System.out.println("toto");
		}

		
		//Les labels pour les composants du schéma
		metal1 = new JLabel(MetauxCaract.metaux[AccueilScreen.GetInstance().pageChoix.metal1Choisis]);
		metal1.setBounds(220, 350, 200, 20);
		metal2 = new JLabel(MetauxCaract.metaux[AccueilScreen.GetInstance().pageChoix.metal2Choisis]);
		metal2.setBounds(660,350,200,20);
		solution1 = new JLabel(MetauxCaract.solutions[AccueilScreen.GetInstance().pageChoix.solution1Choisis]);
		solution1.setBounds(250,530,200,20);
		solution2 = new JLabel(MetauxCaract.solutions[AccueilScreen.GetInstance().pageChoix.solution2Choisis]);
		solution2.setBounds(620,530,200,20);
		concentration1 = new JLabel(MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().pageChoix.concentration1Choisis]);
		concentration1.setBounds(250,550,200,20);
		concentration2 = new JLabel(MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().pageChoix.concentration2Choisis]);
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
		
		
		plus = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/plus.png")));
		plus.setBounds(290, 280, 50, 50);
		this.add(plus);
		
		moins = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/moins.png")));
		moins.setBounds(630, 280, 50, 50);
		this.add(moins);
		
		
		fGauche = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/flechegauche.png")));
		fGauche.setBounds(290, 280, 50, 50);
		this.add(fGauche);
		
		fDroit = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/flechedroite.png")));
		fDroit.setBounds(370, 252, 50, 50);
		this.add(fDroit);
		
		fBas = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/flechebas.png")));
		fBas.setBounds(579, 280, 50, 50);
		this.add(fBas);
		
		fHaut = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/flechehaut.png")));
		fHaut.setBounds(333, 280, 50, 50);
		this.add(fHaut);
		
		bfGauche = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/blackflechegauche.png")));
		bfGauche.setBounds(530, 254, 50, 50);
		this.add(bfGauche);
		
		bfDroit = new JLabel(new ImageIcon(getClass().getResource("/ressources/Imgs/blackflechedroite.png")));
		bfDroit.setBounds(530, 254, 50, 50);
		this.add(bfDroit);
		
		electron = new JLabel("e-");
		electron.setBounds(540, 290, 50, 20);
		this.add(electron);
		
	}
	
	public void upDateAffich(){
		metal1.setText(MetauxCaract.metaux[AccueilScreen.GetInstance().pageChoix.metal1Choisis]);
		metal2.setText(MetauxCaract.metaux[AccueilScreen.GetInstance().pageChoix.metal2Choisis]);
		solution1.setText(MetauxCaract.solutions[AccueilScreen.GetInstance().pageChoix.metal1Choisis]);
		solution2.setText(MetauxCaract.solutions[AccueilScreen.GetInstance().pageChoix.metal1Choisis]);
		concentration1.setText(""+Calculs.calculConcentrationMassique(MetauxCaract.massesMolaires[AccueilScreen.GetInstance().pageChoix.metal1Choisis], MetauxCaract.concentrationsMolaires[AccueilScreen.GetInstance().pageChoix.concentration1Choisis])+ " g/L");
		concentration2.setText(""+Calculs.calculConcentrationMassique(MetauxCaract.massesMolaires[AccueilScreen.GetInstance().pageChoix.metal2Choisis], MetauxCaract.concentrationsMolaires[AccueilScreen.GetInstance().pageChoix.concentration2Choisis])+ " g/L");
		potentiel1 = Calculs.calculPotentiel(AccueilScreen.GetInstance().pageChoix.metal1Choisis, AccueilScreen.GetInstance().pageChoix.concentration1Choisis);
		potentiel2 = Calculs.calculPotentiel(AccueilScreen.GetInstance().pageChoix.metal2Choisis, AccueilScreen.GetInstance().pageChoix.concentration2Choisis);
		plus.setVisible(false);
		moins.setVisible(false);
		fDroit.setVisible(false);
		fBas.setVisible(false);
		fHaut.setVisible(false);
		fGauche.setVisible(false);
		bfGauche.setVisible(false);
		bfDroit.setVisible(false);
		electron.setVisible(false);
		alreadyOn = false;
		
		Tension.setText("  " + Calculs.calculDDP(potentiel1, potentiel2)+ " V");
	}
	
	
	public void affichSensCourant(){
		if(alreadyOn==false){
			if(Calculs.calculDDP(potentiel1, potentiel2)<0){	
				plus.setBounds(290, 280, 50, 50);
				moins.setBounds(630, 280, 50, 50);
				fDroit.setBounds(370, 252, 50, 50);
				fBas.setBounds(579, 280, 50, 50);
				fHaut.setBounds(333, 280, 50, 50);
				plus.setVisible(true);
				moins.setVisible(true);
				fDroit.setVisible(true);
				fBas.setVisible(true);
				fHaut.setVisible(true);
				bfGauche.setVisible(true);
				electron.setVisible(true);
				alreadyOn = true;
	
			}else if(Calculs.calculDDP(potentiel1, potentiel2)>0){
				plus.setBounds(630, 280, 50, 50);
				moins.setBounds(290, 280, 50, 50);
				fGauche.setBounds(370, 252, 50, 50);
				fBas.setBounds(333, 280, 50, 50);
				fHaut.setBounds(579, 280, 50, 50);
				
				plus.setVisible(true);
				moins.setVisible(true);
				fGauche.setVisible(true);
				fBas.setVisible(true);
				fHaut.setVisible(true);
				bfDroit.setVisible(true);
				electron.setVisible(true);
				
				alreadyOn = true;
				
			}else{}
		}else{
			plus.setVisible(false);
			moins.setVisible(false);
			fDroit.setVisible(false);
			fBas.setVisible(false);
			fHaut.setVisible(false);
			fGauche.setVisible(false);
			bfGauche.setVisible(false);
			bfDroit.setVisible(false);
			electron.setVisible(false);
			alreadyOn = false;
		}
		

		
	}
	
	
	@Override
    public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		//super.paintComponent(g);		
	}
}
