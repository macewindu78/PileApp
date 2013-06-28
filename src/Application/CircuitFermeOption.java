package Application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CircuitFermeOption extends JFrame {
	
	protected Container contentPane;
	protected JComboBox metal1, metal2, solution1, solution2, concentration1, concentration2;
	protected JFormattedTextField masse1, masse2, volume1, volume2, resistance;
	protected Label concentrations1,concentrations2;
	
	public CircuitFermeOption(String titre, int width, int height){
		super(titre);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(width,height);
		
		
		JPanel titlePan = new JPanel();
		JLabel title = new JLabel("Options Circuit Fermé");
		title.setFont(new Font("Arial", Font.PLAIN, 20 ));
		titlePan.add(title);
			
		
		
		
		contentPane = getContentPane();

		metal1 = new JComboBox(MetauxCaract.metaux);
		metal1.setPreferredSize(new Dimension(100,20));
		metal1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().circuitferme.metal1 = metal1.getSelectedIndex();
				
			}
		});
		
		metal2 = new JComboBox(MetauxCaract.metaux);
		metal2.setPreferredSize(new Dimension(100,20));
		metal2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().circuitferme.metal2 = metal2.getSelectedIndex();
			
			}
		});
		
		concentration1 = new JComboBox(MetauxCaract.concentrationsMolairesAff);
		concentration1.setPreferredSize(new Dimension(100,20));
		concentration1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().circuitferme.concentrationMolaire1 = concentration1.getSelectedIndex();
			
			}
		});
		concentration2 = new JComboBox(MetauxCaract.concentrationsMolairesAff);
		concentration2.setPreferredSize(new Dimension(100,20));
		concentration2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().circuitferme.concentrationMolaire2 = concentration2.getSelectedIndex();
			}
		});
		
		masse1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		masse1.setPreferredSize(new Dimension(100,20));
		
		masse2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		masse2.setPreferredSize(new Dimension(100,20));
		
		volume1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		volume1.setPreferredSize(new Dimension(100,20));
		
		volume2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		volume2.setPreferredSize(new Dimension(100,20));
		
		resistance = new JFormattedTextField(NumberFormat.getIntegerInstance());
		resistance.setPreferredSize(new Dimension(100,20));
		
		
		
		JPanel midPan = new JPanel();
		midPan.setLayout(new GridLayout(0,2));
		
		midPan.add(new Label("Lame 1 : "));
		midPan.add(metal1);
		
		midPan.add(new Label("Masse 1 (g) : "));
		midPan.add(masse1);

		midPan.add(new Label("Concentration 1 : "));
		midPan.add(concentration1);
		
		midPan.add(new Label("Volume 1 (mL) : "));
		midPan.add(volume1);

		midPan.add(new Label("Lame 2 : "));
		midPan.add(metal2);

		midPan.add(new Label("Masse 2 (g) : "));
		midPan.add(masse2);

		midPan.add(new Label("Concentration 2 : "));
		midPan.add(concentration2);

		midPan.add(new Label("Volume 2 (mL) : "));
		midPan.add(volume2);
		
		midPan.add(new Label("Resistance (ohm) :"));
		midPan.add(resistance);
		
		
		JButton okay = new JButton("Valider");
		okay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().circuitferme.masse1 = Integer.parseInt(masse1.getText());
				AccueilScreen.GetInstance().circuitferme.masse2 = Integer.parseInt(masse2.getText());
				AccueilScreen.GetInstance().circuitferme.volume1 = Integer.parseInt(volume1.getText());
				AccueilScreen.GetInstance().circuitferme.volume2 = Integer.parseInt(volume2.getText());
				AccueilScreen.GetInstance().circuitferme.R = Integer.parseInt(resistance.getText());
				Calculs.calculReactLimitantetAvancement();
				AccueilScreen.GetInstance().circuitferme.refreshChart();
				AccueilScreen.GetInstance().val.repaintAffich();
			}
		});
		
		
		
		JPanel window = new JPanel();
		window.setLayout(new BorderLayout());
		window.add(titlePan,BorderLayout.NORTH);
		window.add(midPan, BorderLayout.CENTER);
		window.add(okay, BorderLayout.SOUTH);
		
		contentPane.add(window);
		
		this.setResizable(false);
		
		this.setVisible(false);
		
		
	}
	
}
