

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	
	public AccueilScreen(String titre, int width, int height){
		super(titre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		

		contentPane = getContentPane();
		
		
		//init page choix caract
		pageChoix = new ChoixCaract();
		
		
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
				contentPane.revalidate();
			}
		});
		
		JMenuItem Help = new JMenuItem("Aide");
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
		JButton college = new JButton("College");
		college.setBackground(Color.green);
		college.setSize(width/2, height/4);
		college.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("College");
				contentPane.removeAll();
				contentPane.add(pageChoix);
				
				contentPane.revalidate();
			}
		});
		
		JButton lycee = new JButton("Lycée");
		lycee.setBackground(Color.blue);
		college.setSize(width/2, height/4);
		
		accueilPan.add(college);
		accueilPan.add(lycee);
		
		gPan.add(accueilPan,BorderLayout.CENTER);
				
		contentPane.add(gPan);
		

		
		this.setVisible(true);
	}
	
}
