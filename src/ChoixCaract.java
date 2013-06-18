import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class ChoixCaract extends JPanel {
	
	protected JComboBox metal1, metal2, solution1, solution2, concentration1, concentration2;
	protected String[] metaux = {"aluminium", "fer", "zinc", "cuivre", "argent", "or", "plomb"};
	protected String[] solutions = {"sulfate de cuivre (II)", "Sulfate de zinc", "sulfate d’aluminium", "eau salée", "solution acidifiée"};
	protected String concentrations[] ={"0.01 mol/L","0.02 mol/L","0.03 mol/L"};
	protected String metal1Choisis, metal2Choisis, solution1Choisis, solution2Choisis, concentration1Choisis, concentration2Choisis;
	protected Label concentrations1,concentrations2;
	
	public ChoixCaract(){
		super();
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		titlePan.setLayout(new BoxLayout(titlePan, BoxLayout.LINE_AXIS));
		titlePan.add(Box.createRigidArea(new Dimension(350,50)));
		titlePan.add(new Label("Choix des caracteristiques"));
		
		this.add(titlePan,BorderLayout.NORTH);
		
		JPanel gridChoice = new JPanel();
		gridChoice.setLayout(new GridLayout(2,4,30,30));
		
		
		metal1 = new JComboBox(metaux);
		metal1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				metal1Choisis = (String)metal1.getSelectedItem();
				ChoixSolution(metal1Choisis, "solution1");
				System.out.println(metal1Choisis);
				concentrations1.setText("Concentration en "+solution1Choisis+" : ");
				AccueilScreen.GetInstance().contentPane.revalidate();
			}
		});
		metal2 = new JComboBox(metaux);
		metal2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				metal2Choisis = (String)metal2.getSelectedItem();
				ChoixSolution(metal2Choisis, "solution2");
				System.out.println(metal2Choisis);
				concentrations2.setText("Concentration en "+solution2Choisis+" : ");
				AccueilScreen.GetInstance().contentPane.revalidate();
			}
		});
		
		concentration1 = new JComboBox(concentrations);
		concentration1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration1Choisis = (String)concentration1.getSelectedItem();
				System.out.println(concentration1Choisis);
			}
		});
		concentration2 = new JComboBox(concentrations);
		concentration2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration2Choisis = (String)concentration2.getSelectedItem();
				System.out.println(concentration2Choisis);
			}
		});
		
		gridChoice.add(new Label("Lame 1 : "));
		gridChoice.add(metal1);
		gridChoice.add(new Label("Lame 2 : "));
		gridChoice.add(metal2);
		
		solution1Choisis = "sulfate d'alumunium ";
		solution2Choisis = "sulfate d'alumunium ";
		concentrations1 = new Label("Concentration en "+solution1Choisis+" : ");  
		concentrations2 = new Label("Concentration en "+solution2Choisis+" : ");
		gridChoice.add(concentrations1);
		gridChoice.add(concentration1);
		gridChoice.add(concentrations2);
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
				AccueilScreen.GetInstance().contentPane.removeAll();
				
				AccueilScreen.GetInstance().contentPane.add(new SchemaMontage());
				
				AccueilScreen.GetInstance().contentPane.revalidate();
				
			}
		});
		otherButtons.add(InfoHelp, BorderLayout.WEST);
		otherButtons.add(Okay, BorderLayout.EAST);
		
		this.add(otherButtons, BorderLayout.SOUTH);
	}
	
	public void ChoixSolution(String metal, String solutions){
		switch (metal){
			case "aluminium" : 
				if(solutions == "solution1"){
					solution1Choisis = "sulfate d'aluminium";
				}
				else{solution2Choisis = "sulfate d'aluminium";}
				break;
			case "fer" :
				if(solutions == "solution1"){
					solution1Choisis = "sulfate de fer";
				}
				else{solution2Choisis = "sulfate de fer";}
				break;
			case "zinc":
				if(solutions == "solution1"){
					solution1Choisis = "sulfate de zinc";
				}
				else{solution2Choisis = "sulfate de zinc";}
				break;
			case "cuivre" :
				if(solutions == "solution1"){
					solution1Choisis = "sulfate de cuivre";
				}
				else{solution2Choisis = "sulfate de cuivre";}
				break;
			case "argent" :
				if(solutions == "solution1"){
					solution1Choisis = "sulfate d'argent";
				}
				else{solution2Choisis = "sulfate d'argent";}
				break;
			case "or" :
				if(solutions == "solution1"){
					solution1Choisis = "solution d'or";
				}
				else{solution2Choisis = "solution d'or";}
				break;
			case "plomb" :
				if(solutions == "solution1"){
					solution1Choisis = "sulfate de plomb";
				}
				else{solution2Choisis = "sulfate de plomb";}
				break;
			default :
				if(solutions == "solution1"){
					solution1Choisis = "error";
				}
				else{solution2Choisis = "error";}
				break;
		}
				
	}
}
