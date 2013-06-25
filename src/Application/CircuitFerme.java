package Application;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CircuitFerme extends JPanel{

	int metal1 =0, metal2 =1, concentrationMolaire1=0, concentrationMolaire2=1;
	float volume1 =1, volume2 =1,  masse1 =1,  masse2 = 1,  R =1, avancementFinal, concentrationfinale1, concentrationfinale2, masseFinale1, masseFinale2, avancementTempsT, tempsT,concentration1TempsT, concentration2TempsT, masse1TempsT, masse2TempsT;
	JLabel metal1Label, metal2Label, solution1Label, solution2Label, concentration1Label, concentration2Label, volume1Label, volume2Label, masse1Label, masse2Label, RLabel, avancementFinalLabel, concentrationfinale1Label, concentrationfinale2Label, masseFinale1Label, masseFinale2Label;
	JPanel chartPanel;
	JFreeChart chartMasse, chartConcentration;
	ChartPanel cPanelMasse, cPanelConcentration ;
	CategoryDataset datasetMasse, datasetconcentration;
	boolean initial = true;
	
	public CircuitFerme(){
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		JLabel title = new JLabel("Circuit Fermé");
		title.setFont(new Font("Arial", Font.PLAIN, 16 ));
		titlePan.add(title);
		
		
		JPanel TestVals = new JPanel();
		TestVals.setLayout(new GridLayout(0,2));
		
		metal1Label = new JLabel("Metal 1 :"+MetauxCaract.metaux[metal1]);
		masse1Label = new JLabel("Masse metal 1"+masse1+" g.");
		concentration1Label = new JLabel("Concentration solution 1"+MetauxCaract.concentrationsMolairesAff[concentrationMolaire1]);
		volume1Label = new JLabel("Volume solution 1 :"+volume1+" mL");
		
		metal2Label = new JLabel("Métal 2 :"+MetauxCaract.metaux[metal2]);
		masse2Label = new JLabel("Masse métal 2 :"+masse2+" g");
		concentration2Label = new JLabel("Concentration solution 2 : "+MetauxCaract.concentrationsMolairesAff[concentrationMolaire2]);
		volume2Label = new JLabel("Volume solution 2 : "+volume2+" mL");
		
		RLabel = new JLabel("Resistance : "+R+ " Ohm");
		avancementFinalLabel = new JLabel("Avancement final : "+avancementFinal);
		concentrationfinale1Label = new JLabel("concentration 1 finale : "+concentrationfinale1);
		concentrationfinale2Label = new JLabel("concentration 2 finale : "+concentrationfinale2);
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
		
		
		JButton Option = new JButton("Options");
		Option.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CircuitFermeOption opt = new CircuitFermeOption("Options",450,350);
			}
		});
		
		this.add(titlePan, BorderLayout.NORTH);
		//this.add(TestVals, BorderLayout.CENTER);
		this.add(Option, BorderLayout.SOUTH);
		
		datasetMasse = createDatasetMasse(initial);
		datasetconcentration = createDatasetConcentration(initial);
		chartMasse = createChart(datasetMasse);
		chartConcentration = createChart(datasetconcentration);
		cPanelConcentration = new ChartPanel(chartConcentration);
		cPanelMasse = new ChartPanel(chartMasse);
		chartPanel = new JPanel();
		chartPanel.setLayout(new GridLayout(0,2));
		chartPanel.add(cPanelMasse);
		chartPanel.add(cPanelConcentration);
		this.add(chartPanel, BorderLayout.CENTER);
		
		
		final JButton EtatfinalInit = new JButton("Etat initial");
		EtatfinalInit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(initial==true){
					initial = false;
					EtatfinalInit.setText("Etat final");
				}else{
					initial=true;
					EtatfinalInit.setText("Etat initial");
				}
				refreshChart();
				AccueilScreen.GetInstance().contentPane.repaint();
				
			}
		});
		
		JPanel ouest = new JPanel();
		ouest.setLayout(new FlowLayout());
		ouest.add(EtatfinalInit);
		
		this.add(ouest, BorderLayout.WEST);
		
		
	}
	
	public void repaintAffich(){
		metal1Label.setText("Metal 1 : "+MetauxCaract.metaux[metal1]);
		masse1Label.setText("Masse métal 1 : "+masse1+" g.");
		concentration1Label.setText("Concentration solution 1 :"+MetauxCaract.concentrationsMolairesAff[concentrationMolaire1]);
		volume1Label.setText("Volume solution 1 :"+volume1+" mL");
		metal2Label.setText("Metal 2 : "+MetauxCaract.metaux[metal2]);
		masse2Label.setText("Masse métal 2 : "+masse2+" g.");
		concentration2Label.setText("Concentration solution 2 :"+MetauxCaract.concentrationsMolairesAff[concentrationMolaire2]);
		volume2Label.setText("Volume solution 2 :"+volume2+" mL");
		RLabel.setText("Résistance : "+R+ " Ohm");
		avancementFinalLabel.setText("Avancement final : "+avancementFinal);
		concentrationfinale1Label.setText("concentration 1 finale : "+concentrationfinale1);
		concentrationfinale2Label.setText("concentration 2 finale : "+concentrationfinale2);
		masseFinale1Label.setText("masse 1 finale : "+masseFinale1);
		masseFinale2Label.setText("masse 2 finale : "+masseFinale2);
		AccueilScreen.GetInstance().contentPane.repaint();
	}
	
	private CategoryDataset createDatasetMasse(boolean initial){
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(initial){
			dataset.addValue(masse1, MetauxCaract.metaux[metal1], "g");
			dataset.addValue(masse2, MetauxCaract.metaux[metal2], "g");
		}else{
			dataset.addValue(masseFinale1, MetauxCaract.metaux[metal1], "g");
			dataset.addValue(masseFinale2, MetauxCaract.metaux[metal2], "g");
		}
		
		return dataset;
	}
	
	private CategoryDataset createDatasetConcentration(boolean initial){
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(initial){
			dataset.addValue(MetauxCaract.concentrationsMolaires[concentrationMolaire1], MetauxCaract.solutions[metal1], "mol/L");
			dataset.addValue(MetauxCaract.concentrationsMolaires[concentrationMolaire2], MetauxCaract.solutions[metal2], "mol/L");
		}else{
			dataset.addValue(concentrationfinale1, MetauxCaract.solutions[metal1], "mol/L");
			dataset.addValue(concentrationfinale2, MetauxCaract.solutions[metal2], "mol/L");

		}
		
		return dataset;
	}
	
	
	private JFreeChart createChart(CategoryDataset dataset){
		
		JFreeChart chart = ChartFactory.createBarChart( "EtatInit", "Réactifs et produits", "Valeures", dataset, PlotOrientation.VERTICAL, true, true, false);

		
		return chart;
		
	}
	
	
	
	public void refreshChart(){
		chartPanel.removeAll();
		datasetMasse = createDatasetMasse(initial);
		datasetconcentration = createDatasetConcentration(initial);
		chartMasse = createChart(datasetMasse);
		chartConcentration = createChart(datasetconcentration);
		cPanelConcentration.setChart(chartConcentration);
		cPanelMasse.setChart(chartMasse);
		chartPanel.add(cPanelMasse);
		chartPanel.add(cPanelConcentration);		
	}

}
