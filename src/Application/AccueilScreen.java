package Application;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Page d'accueil
 * @author Jonathan
 * Simple Screen with only two choices.
 */
public class AccueilScreen extends JFrame {
	
	protected JPanel gPan,accueilPan;
	protected Container contentPane;
	protected ChoixCaract pageChoix;
	protected JMenuBar mBar;
	protected static AccueilScreen instance;
	protected SchemaMontage schmMont;
	protected CircuitFerme circuitferme;
	protected CircuitFermeOption opt;
	protected ValeursCircuitFerme val;
	
	
	public AccueilScreen(String titre, int width, int height){
		super(titre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		
		instance = this;
		contentPane = getContentPane();
		
		
		//init page choix caract
		pageChoix = new ChoixCaract();
		circuitferme = new CircuitFerme();
		
		
		gPan = new JPanel();
		gPan.setLayout(new BorderLayout(10,10));
		
		//Menu bar
		mBar = new JMenuBar();
		
		JMenu File = new JMenu("File");
		JMenuItem Accueil = new JMenuItem("Accueil");
		Accueil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contentPane.removeAll();
				contentPane.add(gPan);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		JMenuItem Help = new JMenuItem("Credits");
		JMenuItem Quit = new JMenuItem("Quit");
		Quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		File.add(Accueil);
		File.add(Help);
		File.add(Quit);
		mBar.add(File);
		setJMenuBar(mBar);
		
		accueilPan = new JPanel();
		
		accueilPan.setLayout(new GridLayout(2,1,100,height/4));
		
		/**
		 * Buttons on the front page
		 */
		JButton college = new JButton("Circuit Ouvert");
		college.setSize(width/2, height/4);
		college.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contentPane.removeAll();
				contentPane.add(pageChoix);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		JButton lycee = new JButton("Circuit Ferm�");
		lycee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contentPane.removeAll();
				contentPane.add(circuitferme);
				opt = new CircuitFermeOption("Options",450,350);
				val = new ValeursCircuitFerme("Valeurs",600,350);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		lycee.setSize(width/2, height/4);
		
		accueilPan.add(college);
		accueilPan.add(lycee);
		
		gPan.add(accueilPan,BorderLayout.CENTER);
				
		contentPane.add(gPan);
		
		this.setResizable(false);
		
		this.setVisible(true);
		
		schmMont = new SchemaMontage();

	}
	
	public static AccueilScreen GetInstance(){
		return instance;
	}
	
}
