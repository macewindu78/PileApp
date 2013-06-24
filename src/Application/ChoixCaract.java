package Application;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChoixCaract extends JPanel {
	
	protected JComboBox metal1, metal2, solution1, solution2, concentration1, concentration2;
	protected int metal1Choisis =0, metal2Choisis=0, solution1Choisis =0, solution2Choisis =0, concentration1Choisis =0, concentration2Choisis=0;
	protected Label concentrations1,concentrations2;
	
	public ChoixCaract(){
		super();
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		JLabel title = new JLabel("Choix des caracteristiques");
		title.setFont(new Font("Arial", Font.PLAIN, 20 ));
		titlePan.add(title);
		
		this.add(titlePan,BorderLayout.NORTH);
		
		JPanel gridChoice = new JPanel();
		gridChoice.setLayout(new GridLayout(0,2));
		
		
		metal1 = new JComboBox(MetauxCaract.metaux);
		metal1.setPreferredSize(new Dimension(100,20));
		metal1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				metal1Choisis = metal1.getSelectedIndex();
				//System.out.println(metal1Choisis);
				concentrations1.setText("Concentration en "+MetauxCaract.solutions[metal1Choisis]+" : ");
				AccueilScreen.GetInstance().contentPane.revalidate();
			}
		});
		metal2 = new JComboBox(MetauxCaract.metaux);
		metal2.setPreferredSize(new Dimension(100,20));
		metal2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				metal2Choisis = metal2.getSelectedIndex();
				//System.out.println(metal2Choisis);
				concentrations2.setText("Concentration en " +MetauxCaract.solutions[metal2Choisis]+" : ");
				AccueilScreen.GetInstance().contentPane.revalidate();
			}
		});
		
		concentration1 = new JComboBox(MetauxCaract.concentrationsMolairesAff);
		concentration1.setPreferredSize(new Dimension(100,20));
		concentration1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration1Choisis = concentration1.getSelectedIndex();
				//System.out.println(concentration1Choisis);
			}
		});
		concentration2 = new JComboBox(MetauxCaract.concentrationsMolairesAff);
		concentration2.setPreferredSize(new Dimension(100,20));
		concentration2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				concentration2Choisis = concentration2.getSelectedIndex();
				//System.out.println(concentration2Choisis);
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
		
		concentrations1 = new Label("Concentration en "+MetauxCaract.solutions[metal1Choisis]+" : ");
		gridChoice.add(concentrations1);
		gridChoice.add(concentration1);
		
		
		gridChoice.add(new Label("Lame 2 : "));
		gridChoice.add(metal2);

		concentrations2 = new Label("Concentration en "+MetauxCaract.solutions[metal2Choisis]+" : ");
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
				
				try {
					String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
					System.out.println(path);
					System.out.println(path.lastIndexOf("/"));
					if(!Test.eclipse){
						path = path.substring(0, path.lastIndexOf("."));
					}
					System.out.println(path);
					File jc2 = new File(path+"html/Index.html");
					System.out.println(jc2);
					Desktop.getDesktop().browse(jc2.toURI());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton okay = new JButton("Valider");
		okay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().contentPane.removeAll();
				AccueilScreen.GetInstance().schmMont.upDateAffich();
				AccueilScreen.GetInstance().contentPane.add(AccueilScreen.GetInstance().schmMont);
				AccueilScreen.GetInstance().contentPane.repaint();
				AccueilScreen.GetInstance().contentPane.revalidate();
				
				
			}
		});
		otherButtons.add(InfoHelp, BorderLayout.WEST);
		otherButtons.add(okay, BorderLayout.EAST);
		
		this.add(otherButtons, BorderLayout.SOUTH);
	}
	
}
