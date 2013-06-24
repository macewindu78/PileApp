package Application;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CircuitFerme extends JPanel{

	static int metal1 =0, metal2 =1, concentrationMolaire1=0, concentrationMolaire2=1;
	static float volume1 =1, volume2 =1,  masse1 =1,  masse2 = 1,  R =1, avancementFinal, concentrationfinale1, concentrationfinale2, masseFinale1, masseFinale2;
	JLabel metal1Label, metal2Label, solution1Label, solution2Label, concentration1Label, concentration2Label, volume1Label, volume2Label, masse1Label, masse2Label, RLabel, avancementFinalLabel, concentrationfinale1Label, concentrationfinale2Label, masseFinale1Label, masseFinale2Label;
	
	public CircuitFerme(){
		
		JPanel TestVals = new JPanel();
		TestVals.setLayout(new GridLayout(0,2));
		
		metal1Label = new JLabel(MetauxCaract.metaux[metal1]);
		masse1Label = new JLabel(masse1+" g.");
		concentration1Label = new JLabel(MetauxCaract.concentrationsMolairesAff[concentrationMolaire1]);
		volume1Label = new JLabel(volume1+" mL");
		
		metal2Label = new JLabel(MetauxCaract.metaux[metal2]);
		masse2Label = new JLabel(masse2+" g.");
		concentration2Label = new JLabel(MetauxCaract.concentrationsMolairesAff[concentrationMolaire2]);
		volume2Label = new JLabel(volume2+" mL");
		
		RLabel = new JLabel(R+ "Ohm");
		avancementFinalLabel = new JLabel("Avancement final : "+avancementFinal);
		concentrationfinale1Label = new JLabel("concentration 1 finale : "+concentrationfinale1);
		concentrationfinale2Label = new JLabel("ceoncentration 2 finale : "+concentrationfinale2);
		masseFinale1Label = new JLabel("masse 1 finale : "+masseFinale1);
		masseFinale2Label = new JLabel("masse 2 finale : "+masseFinale2);
		
		TestVals.add(metal1Label);
		TestVals.add(masse1Label);
		TestVals.add(concentration1Label);
		TestVals.add(volume1Label);

		TestVals.add(metal2Label);
		TestVals.add(masse2Label);
		TestVals.add(concentration2Label);
		TestVals.add(volume2Label);
		
		TestVals.add(RLabel);
		TestVals.add(avancementFinalLabel);
		TestVals.add(concentrationfinale1Label);
		TestVals.add(concentrationfinale2Label);
		TestVals.add(masseFinale1Label);
		TestVals.add(masseFinale2Label);
		
		
		
		
	}

	




}
