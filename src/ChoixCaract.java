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
	protected String[] solutions = {"sulfate de cuivre (II)", "Sulfate de zinc", "sulfate d’aluminium", "nitrate d'argent", "nitrate d'or","nitrate de plomb"};
	protected String concentrations[] ={"0.01 mol/L","0.02 mol/L","0.03 mol/L"};
	protected String metal1Choisis ="aluminium", metal2Choisis="aluminium", solution1Choisis = "sulfate d'aluminium", solution2Choisis = "sulfate d'aluminium", concentration1Choisis ="0.01 mol/L", concentration2Choisis="0.01 mol/L";
	protected Label concentrations1,concentrations2;
	
	public ChoixCaract(){
		super();
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		titlePan.setLayout(new BoxLayout(titlePan, BoxLayout.LINE_AXIS));
		titlePan.add(Box.createRigidArea(new Dimension(400,50)));
		titlePan.add(new Label("Choix des caracteristiques"));
		
		this.add(titlePan,BorderLayout.NORTH);
		
		JPanel gridChoice = new JPanel();
		gridChoice.setLayout(new GridLayout(0,4));
		
		
		metal1 = new JComboBox(metaux);
		metal1.setPreferredSize(new Dimension(100,20));
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
		metal2.setPreferredSize(new Dimension(100,20));
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
		concentration1.setPreferredSize(new Dimension(100,20));
		concentration1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration1Choisis = (String)concentration1.getSelectedItem();
				System.out.println(concentration1Choisis);
			}
		});
		concentration2 = new JComboBox(concentrations);
		concentration2.setPreferredSize(new Dimension(100,20));
		concentration2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration2Choisis = (String)concentration2.getSelectedItem();
				System.out.println(concentration2Choisis);
			}
		});
		
		JPanel blank = new JPanel();
		blank.setLayout(new BoxLayout(blank,BoxLayout.LINE_AXIS));
		blank.add(Box.createRigidArea(new Dimension(10,300)));
		
		JPanel blank2 = new JPanel();
		blank2.setLayout(new BoxLayout(blank2,BoxLayout.LINE_AXIS));
		blank2.add(Box.createRigidArea(new Dimension(10,200)));
		JPanel blank3 = new JPanel();
		blank3.setLayout(new BoxLayout(blank3,BoxLayout.LINE_AXIS));
		blank3.add(Box.createRigidArea(new Dimension(10,200)));
		JPanel blank4 = new JPanel();
		blank4.setLayout(new BoxLayout(blank4,BoxLayout.LINE_AXIS));
		blank4.add(Box.createRigidArea(new Dimension(10,200)));
		JPanel blank5 = new JPanel();
		blank5.setLayout(new BoxLayout(blank5,BoxLayout.LINE_AXIS));
		blank5.add(Box.createRigidArea(new Dimension(10,200)));
		
		
		gridChoice.add(blank2);
		gridChoice.add(blank3);
		gridChoice.add(blank4);
		gridChoice.add(blank5);
		
		
		gridChoice.add(new Label("Lame 1 : "));
		gridChoice.add(metal1);
		gridChoice.add(new Label("Lame 2 : "));
		gridChoice.add(metal2);
	
		
		concentrations1 = new Label("Concentration en "+solution1Choisis+" : ");  
		concentrations2 = new Label("Concentration en "+solution2Choisis+" : ");
		gridChoice.add(concentrations1);
		gridChoice.add(concentration1);
		gridChoice.add(concentrations2);
		gridChoice.add(concentration2);
		
		
		//Mise en page
		gridChoice.add(blank);
		
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
				AccueilScreen.GetInstance().schmMont = new SchemaMontage();
				AccueilScreen.GetInstance().contentPane.add(AccueilScreen.GetInstance().schmMont);
				AccueilScreen.GetInstance().contentPane.repaint();
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
					solution1Choisis = "nitrate d'argent";
				}
				else{solution2Choisis = "nitrate d'argent";}
				break;
			case "or" :
				if(solutions == "solution1"){
					solution1Choisis = "nitrate d'or";
				}
				else{solution2Choisis = "nitrate d'or";}
				break;
			case "plomb" :
				if(solutions == "solution1"){
					solution1Choisis = "nitrate de plomb";
				}
				else{solution2Choisis = "nitrate de plomb";}
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
