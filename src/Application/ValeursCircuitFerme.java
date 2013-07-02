package Application;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValeursCircuitFerme extends JFrame{
	
	
	JLabel metal1Label, metal2Label, solution1Label, solution2Label, concentration1Label, concentration2Label, volume1Label, volume2Label, masse1Label, masse2Label, RLabel, avancementFinalLabel, concentrationfinale1Label, concentrationfinale2Label, masseFinale1Label, masseFinale2Label, avancementTempsTLabel, concentration1TempsTLabel, concentration2TempsTLabel, masse1TempsTLabel,	masse2TempsTLabel, empty;
	public ValeursCircuitFerme(String titre, int width, int height){
		super(titre);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(width,height);
		
		JPanel TestVals = new JPanel();
		TestVals.setLayout(new GridLayout(0,2));
		
		metal1Label = new JLabel("Metal 1 :"+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]);
		masse1Label = new JLabel("Masse metal 1"+AccueilScreen.GetInstance().circuitferme.masse1+" g.");
		concentration1Label = new JLabel("Concentration solution 1"+MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire1]);
		volume1Label = new JLabel("Volume solution 1 :"+AccueilScreen.GetInstance().circuitferme.volume1+" mL");
		
		metal2Label = new JLabel("Métal 2 :"+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]);
		masse2Label = new JLabel("Masse métal 2 :"+AccueilScreen.GetInstance().circuitferme.masse2+" g");
		concentration2Label = new JLabel("Concentration solution 2 : "+MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire2]);
		volume2Label = new JLabel("Volume solution 2 : "+AccueilScreen.GetInstance().circuitferme.volume2+" mL");
		
		RLabel = new JLabel("Resistance : "+AccueilScreen.GetInstance().circuitferme.R+ " Ohm");
		
		empty = new JLabel("");
		
		avancementTempsTLabel = new JLabel("Avancement temps T : "+AccueilScreen.GetInstance().circuitferme.avancementTempsT);
		concentration1TempsTLabel = new JLabel("concentration 1 temps T : "+AccueilScreen.GetInstance().circuitferme.concentration1TempsT);
		concentration2TempsTLabel = new JLabel("concentration 2 temps T : "+AccueilScreen.GetInstance().circuitferme.concentration2TempsT);
		masse1TempsTLabel = new JLabel("masse 1 temps T : "+AccueilScreen.GetInstance().circuitferme.masse1TempsT);
		masse2TempsTLabel = new JLabel("masse 2 temps T : "+AccueilScreen.GetInstance().circuitferme.masse2TempsT);
		
		
		
		avancementFinalLabel = new JLabel("Avancement final : "+AccueilScreen.GetInstance().circuitferme.avancementFinal);
		concentrationfinale1Label = new JLabel("concentration 1 finale : "+AccueilScreen.GetInstance().circuitferme.concentrationfinale1);
		concentrationfinale2Label = new JLabel("concentration 2 finale : "+AccueilScreen.GetInstance().circuitferme.concentrationfinale2);
		masseFinale1Label = new JLabel("masse 1 finale : "+AccueilScreen.GetInstance().circuitferme.masseFinale1);
		masseFinale2Label = new JLabel("masse 2 finale : "+AccueilScreen.GetInstance().circuitferme.masseFinale2);
		
		TestVals.add(metal1Label);
		TestVals.add(metal2Label);
		
		TestVals.add(masse1Label);
		TestVals.add(masse2Label);
		
		TestVals.add(concentration1Label);
		TestVals.add(concentration2Label);
		
		TestVals.add(volume1Label);
		TestVals.add(volume2Label);
			
		TestVals.add(RLabel);
		TestVals.add(empty);
		
		TestVals.add(avancementTempsTLabel);
		TestVals.add(avancementFinalLabel);
		
		TestVals.add(concentration1TempsTLabel);
		TestVals.add(concentration2TempsTLabel);
		TestVals.add(masse1TempsTLabel);
		TestVals.add(masse2TempsTLabel);
		
		
		TestVals.add(concentrationfinale1Label);
		TestVals.add(concentrationfinale2Label);
		TestVals.add(masseFinale1Label);
		TestVals.add(masseFinale2Label);
		
		JPanel valscreen = new JPanel();
		valscreen.setLayout(new BorderLayout());
		valscreen.add(TestVals, BorderLayout.CENTER);
		
		this.add(valscreen);
		
		this.setResizable(true);
		this.setVisible(false);
	}
	
	public void repaintAffich(){
		metal1Label.setText("Metal : "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]);
		masse1Label.setText("Masse "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]+" : "+AccueilScreen.GetInstance().circuitferme.masse1+" g.");
		concentration1Label.setText("Concentration en "+MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal1]+ " :" +MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire1]);
		volume1Label.setText("Volume en "+MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal1]+" :"+AccueilScreen.GetInstance().circuitferme.volume1+" mL");
		metal2Label.setText("Metal : "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]);
		masse2Label.setText("Masse "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]+" : "+AccueilScreen.GetInstance().circuitferme.masse2+" g.");
		concentration2Label.setText("Concentration "+MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal2]+ " :"+MetauxCaract.concentrationsMolairesAff[AccueilScreen.GetInstance().circuitferme.concentrationMolaire2]);
		volume2Label.setText("Volume "+MetauxCaract.solutions[AccueilScreen.GetInstance().circuitferme.metal2]+ " :"+AccueilScreen.GetInstance().circuitferme.volume2+" mL");
		RLabel.setText("Résistance : "+AccueilScreen.GetInstance().circuitferme.R+ " Ohm");
		avancementTempsTLabel.setText("Avancement temps T : "+AccueilScreen.GetInstance().circuitferme.avancementTempsT);
		concentration1TempsTLabel.setText("concentration temps T : "+AccueilScreen.GetInstance().circuitferme.concentration1TempsT+" g/L");
		concentration2TempsTLabel.setText("concentration temps T : "+AccueilScreen.GetInstance().circuitferme.concentration2TempsT+" g/L");
		masse1TempsTLabel.setText("masse temps T "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]+" : "+AccueilScreen.GetInstance().circuitferme.masse1TempsT+" g");
		masse2TempsTLabel.setText("masse temps T "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal2]+" : "+AccueilScreen.GetInstance().circuitferme.masse2TempsT+" g");
		avancementFinalLabel.setText("Avancement final : "+AccueilScreen.GetInstance().circuitferme.avancementFinal);
		concentrationfinale1Label.setText("concentration finale : "+AccueilScreen.GetInstance().circuitferme.massevol1finale+" g/L");
		concentrationfinale2Label.setText("concentration finale : "+AccueilScreen.GetInstance().circuitferme.massevol2finale+" g/L");
		masseFinale1Label.setText("masse finale "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]+" : "+AccueilScreen.GetInstance().circuitferme.masseFinale1+" g");
		masseFinale2Label.setText("masse finale "+MetauxCaract.metaux[AccueilScreen.GetInstance().circuitferme.metal1]+" : "+AccueilScreen.GetInstance().circuitferme.masseFinale2+" g");
		AccueilScreen.GetInstance().contentPane.repaint();
	}
}
