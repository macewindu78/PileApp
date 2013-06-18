import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class ChoixCaract extends JPanel {
	
	protected JComboBox metal1, metal2, solution1, solution2, concentration1, concentration2;
	protected String[] metaux = {"Aluminium", "fer", "zinc", "cuivre", "argent", "or", "plomb"};
	protected String[] solutions = {"sulfate de cuivre (II)", "Sulfate de zinc", "sulfate d’aluminium", "eau salée", "solution acidifiée"};
	protected String concentrations[] ={"0.01 mol/L","0.02 mol/L","0.03 mol/L"};
	
	public ChoixCaract(){
		super();
		
		this.setLayout(new BorderLayout());
		this.add(new Label("Choix des cacteristiques"),BorderLayout.NORTH);
		
		JPanel gridChoice = new JPanel();
		gridChoice.setLayout(new GridLayout(3,4,30,30));
		
		
		metal1 = new JComboBox(metaux);
		metal2 = new JComboBox(metaux);
		
		solution1 = new JComboBox(solutions);
		solution2 = new JComboBox(solutions);
		
		concentration1 = new JComboBox(concentrations);
		concentration2 = new JComboBox(concentrations);
		
		gridChoice.add(new Label("Lame 1 : "));
		gridChoice.add(metal1);
		gridChoice.add(new Label("Lame 2 : "));
		gridChoice.add(metal2);
		
		gridChoice.add(new Label("Solution 1 : "));
		gridChoice.add(solution1);
		gridChoice.add(new Label("Solution 2 : "));
		gridChoice.add(solution2);
		
		
		gridChoice.add(new Label("Concentration : "));
		gridChoice.add(concentration1);
		gridChoice.add(new Label("Concentration : "));
		gridChoice.add(concentration2);
		
		this.add(gridChoice, BorderLayout.CENTER);
		
		JPanel otherButtons = new JPanel();
		otherButtons.setLayout(new BorderLayout());
		JButton InfoHelp = new JButton("Aide");
		InfoHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO new JFRAME for HELP
				
			}
		});
		JButton Okay = new JButton("Valider");
		Okay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO new JPanel for the rest of the app
				AccueilScreen.GetInstance().contentPane.removeAll();
				
				AccueilScreen.GetInstance().contentPane.add(new SchemaMontage());
				
				AccueilScreen.GetInstance().contentPane.revalidate();
				
			}
		});
		otherButtons.add(InfoHelp, BorderLayout.WEST);
		otherButtons.add(Okay, BorderLayout.EAST);
		
		this.add(otherButtons, BorderLayout.SOUTH);
		
		
	}
}
