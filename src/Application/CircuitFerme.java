package Application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CircuitFerme extends JPanel{

	int metal1 =0, metal2 =1, concentrationMolaire1=0, concentrationMolaire2=1;
	float volume1 =1, volume2 =1,  masse1 =1,  masse2 = 1,  R =1, avancementFinal, concentrationfinale1, concentrationfinale2, masseFinale1, masseFinale2, avancementTempsT, tempsT=0,concentration1TempsT, concentration2TempsT, masse1TempsT, masse2TempsT, ddp, tempsTotal=0, massevol1finale,massevol2finale, massevol1TempsT, massevol2TempsT;
	JLabel tempsTotalLabel, tempsTLabel, tempsTotalLabelconv, tempsTLabelconv, pileImg;
	JPanel chartPanel, ouest;
	JFreeChart chartMasse, chartConcentration;
	ChartPanel cPanelMasse, cPanelConcentration ;
	CategoryDataset datasetMasse, datasetconcentration;
	boolean initial = true;
	protected String[] fonctionTempsPourcent = {"0%","10%" , "20%", "30%" , "40%", "50%", "60%", "70%", "80%","90%", "100%"};
	JComboBox fonctionTemps;
	JButton EtatfinalInit, animation;
	JLabel[] piles;
	
	
	
	
	public CircuitFerme(){
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		JLabel title = new JLabel("Circuit Fermé");
		title.setFont(new Font("Arial", Font.BOLD, 20 ));
		titlePan.add(title);

		
		JButton Option = new JButton("Options");
		Option.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().opt.setVisible(true);
			}
		});
		
		JButton valeurs = new JButton("Valeurs");
		valeurs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AccueilScreen.GetInstance().val.setVisible(true);
			}
		});
		
		
		JPanel south = new JPanel();
		south.add(Option);
		south.add(valeurs);
		
		datasetMasse = createDatasetMasse(initial);
		datasetconcentration = createDatasetConcentration(initial);
		chartMasse = createChartMasse(datasetMasse);
		chartConcentration = createChartConcentration(datasetconcentration);
		cPanelConcentration = new ChartPanel(chartConcentration);
		cPanelMasse = new ChartPanel(chartMasse);
		chartPanel = new JPanel();
		chartPanel.setLayout(new GridLayout(0,2));
		chartPanel.add(cPanelMasse);
		chartPanel.add(cPanelConcentration);
		this.add(chartPanel, BorderLayout.CENTER);
		
		
		EtatfinalInit = new JButton("Etat initial");
		EtatfinalInit.setAlignmentX(CENTER_ALIGNMENT);
		EtatfinalInit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(initial==true){
					initial = false;
					EtatfinalInit.setText("Etat final");
					fonctionTemps.setSelectedIndex(10);
					
				}else{
					initial=true;
					EtatfinalInit.setText("Etat initial");
					fonctionTemps.setSelectedIndex(0);
				}
				refreshChart();
				AccueilScreen.GetInstance().contentPane.repaint();
				
			}
		});
		
		tempsTotalLabel = new JLabel("Temps total de réaction : "+tempsTotal+" s");
		tempsTotalLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		tempsTotalLabelconv = new JLabel(conversionSecHeure(tempsTotal));
		tempsTotalLabelconv.setAlignmentX(CENTER_ALIGNMENT);
		
		
		fonctionTemps = new JComboBox(fonctionTempsPourcent);
		fonctionTemps.setPreferredSize(new Dimension(100, 20));
		fonctionTemps.setMaximumSize(fonctionTemps.getPreferredSize());
		fonctionTemps.setAlignmentX(CENTER_ALIGNMENT);
		fonctionTemps.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tempsT = fonctionTemps.getSelectedIndex();
				tempsT = tempsT*0.1f*tempsTotal;
				avancementTempsT = Calculs.calculReactTempsT(tempsT, ddp);
				Calculs.calculConcentrationsEtMasse(avancementTempsT);
				refreshChartTempsT();
				tempsTLabel.setText("Temps t : "+ tempsT + " s");
				tempsTLabelconv.setText(conversionSecHeure(tempsT));
				repaint();
				//System.out.println(tempsT);
				//System.out.println(avancementTempsT);
			}
		});
		
		tempsTLabel = new JLabel("Temps t : "+ tempsT + " s");
		tempsTLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		tempsTLabelconv = new JLabel(conversionSecHeure(tempsT));
		tempsTLabelconv.setAlignmentX(CENTER_ALIGNMENT);		
		
		
		animation = new JButton("Animation");
		animation.setAlignmentX(CENTER_ALIGNMENT);
		animation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				timer();
			}
		});
		
		
		ouest = new JPanel();
		ouest.setLayout(new BoxLayout(ouest, BoxLayout.Y_AXIS));
		ouest.add(EtatfinalInit);
		ouest.add(tempsTotalLabel);
		ouest.add(tempsTotalLabelconv);
		ouest.add(fonctionTemps);
		ouest.add(tempsTLabel);
		ouest.add(tempsTLabelconv);
		
		
		piles = new JLabel[11];
		for(int i=0; i<11;i++){
			createAffpile(i);
		}
		
		
		ouest.add(animation);
		
		
		

		this.add(titlePan, BorderLayout.NORTH);
		
		this.add(south, BorderLayout.SOUTH);
		
		this.add(ouest, BorderLayout.WEST);
		
	}
	
	
	public void conversionAffich(){
		massevol1finale = concentrationfinale1 * MetauxCaract.massesMolaires[metal1];
		massevol2finale = concentrationfinale2 * MetauxCaract.massesMolaires[metal2];
		massevol1TempsT = concentration1TempsT * MetauxCaract.massesMolaires[metal1];
		massevol2TempsT = concentration2TempsT * MetauxCaract.massesMolaires[metal2];
	}
	
	
	
	public void timer(){
		Timer tim = new Timer();
		tim.scheduleAtFixedRate(new TimerTask(){
			int i=0;			
			@Override
			public void run() {
				try {
					SwingUtilities.invokeAndWait(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							fonctionTemps.setSelectedIndex(i);
							i++;				
						}});
				} catch (InvocationTargetException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i>10){
					this.cancel();
				}	

			}
		}, 0, 1*1000);
		
		
	}
	
	
	
	
	public String conversionSecHeure(float tempsSec){
		String tempsHeure;
		int heure,min,sec;
		heure = (int) (tempsSec/3600);
		min = (int) ((tempsSec%3600)/60);
		sec = (int)(((tempsSec%3600)%60));		
		
		tempsHeure = "Ce qui équivaut à :"+heure+" h, "+min+" min, "+sec+" s.";
		
		return tempsHeure;
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
	
	
	private CategoryDataset createDatasetMasseTempsT(){
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.addValue(masse1TempsT, MetauxCaract.metaux[metal1], "g");
			dataset.addValue(masse2TempsT, MetauxCaract.metaux[metal2], "g");
		
		return dataset;
	}
	
	private CategoryDataset createDatasetConcentration(boolean initial){
		conversionAffich();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(initial){
			dataset.addValue(MetauxCaract.concentrationsMolaires[concentrationMolaire1]* MetauxCaract.massesMolaires[metal1], MetauxCaract.solutions[metal1], "g/L");
			dataset.addValue(MetauxCaract.concentrationsMolaires[concentrationMolaire2]* MetauxCaract.massesMolaires[metal2], MetauxCaract.solutions[metal2], "g/L");
		}else{
			dataset.addValue(massevol1finale, MetauxCaract.solutions[metal1], "mol/L");
			dataset.addValue(massevol2finale, MetauxCaract.solutions[metal2], "mol/L");

		}
		
		return dataset;
	}

	private CategoryDataset createDatasetConcentrationTempsT(){
		
		conversionAffich();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.addValue(massevol1TempsT, MetauxCaract.solutions[metal1],"g");
			dataset.addValue(massevol2TempsT, MetauxCaract.solutions[metal2],"g");

		
		return dataset;
	}
	
	private JFreeChart createChartMasse(CategoryDataset dataset){
		
		JFreeChart chart = ChartFactory.createBarChart( "Métaux", "", "Masses (g)", dataset, PlotOrientation.VERTICAL, true, true, false);
		return chart;
		
	}
	
	private JFreeChart createChartConcentration(CategoryDataset dataset){
		
		JFreeChart chart = ChartFactory.createBarChart( "Solutions", "", "Concentration Massique (g/L)", dataset, PlotOrientation.VERTICAL, true, true, false);
		return chart;
		
	}
	
	
	
	public void refreshChart(){
		chartPanel.removeAll();
		datasetMasse = createDatasetMasse(initial);
		datasetconcentration = createDatasetConcentration(initial);
		chartMasse = createChartMasse(datasetMasse);
		chartConcentration = createChartConcentration(datasetconcentration);
		cPanelConcentration.setChart(chartConcentration);
		cPanelMasse.setChart(chartMasse);
		chartPanel.add(cPanelMasse);
		chartPanel.add(cPanelConcentration);	
		tempsTotalLabel.setText("Temps total de réaction : "+tempsTotal+" s");
		tempsTotalLabelconv.setText(conversionSecHeure(tempsTotal));
		
	}
	
	public void refreshChartTempsT(){
		chartPanel.removeAll();
		datasetMasse = createDatasetMasseTempsT();
		datasetconcentration = createDatasetConcentrationTempsT();
		chartMasse = createChartMasse(datasetMasse);
		chartConcentration = createChartConcentration(datasetconcentration);
		cPanelConcentration.setChart(chartConcentration);
		cPanelMasse.setChart(chartMasse);
		chartPanel.add(cPanelMasse);
		chartPanel.add(cPanelConcentration);	
		int temps = fonctionTemps.getSelectedIndex();
		for(int i=0; i<piles.length;i++){
			piles[i].setVisible(false);
		}
		piles[temps].setVisible(true);
	}
	
	public void createAffpile(int i){
		int j=10-i;
		pileImg =new JLabel(new ImageIcon(getClass().getResource("/Imgs/pile"+Integer.toString(j)+"0.png")));
		pileImg.setAlignmentX(CENTER_ALIGNMENT);
		pileImg.setDoubleBuffered(true);
		if(i==0){
			pileImg.setVisible(true);
		}else{
			pileImg.setVisible(false);
		}
		piles[i] = pileImg;
		ouest.add(pileImg);
	}

}
