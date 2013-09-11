package Application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits extends JPanel{
	
	
	public Credits(){
		super();
		
		this.setLayout(new BorderLayout());
		
		JPanel titlePan = new JPanel();
		JLabel title = new JLabel("Credits");
		title.setFont(new Font("Arial", Font.BOLD, 35 ));
		titlePan.add(title);
		
		JPanel grid = new JPanel();
		grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
		grid.setAlignmentY(CENTER_ALIGNMENT);

		JLabel vamdc = new JLabel("VAMDC Consortium, Observatoire de Paris");
		vamdc.setAlignmentX(CENTER_ALIGNMENT);
		vamdc.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel dev = new JLabel("Developers: J. Tuckey, N. Moreau");
		dev.setAlignmentX(CENTER_ALIGNMENT);
		dev.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel pR = new JLabel("Pedagogical Resources: F. Maas, College des Combelles, Fougerolles");
		pR.setAlignmentX(CENTER_ALIGNMENT);
		pR.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel date = new JLabel("Date: July 2013, VAMDC");
		date.setAlignmentX(CENTER_ALIGNMENT);
		date.setFont(new Font("Arial", Font.PLAIN, 20));
		
		grid.add(Box.createRigidArea(new Dimension(0,200)));
		grid.add(vamdc);
		grid.add(Box.createRigidArea(new Dimension(0,40)));
		grid.add(dev);
		grid.add(pR);
		grid.add(Box.createRigidArea(new Dimension(0,20)));
		grid.add(date);
		
		
		
		
		JPanel logo = new JPanel();
		logo.setLayout(new FlowLayout());
		JLabel vamdcImg = new JLabel(new ImageIcon(getClass().getResource("/Imgs/vamdc.png")));
		JLabel vamdcsupImg = new JLabel(new ImageIcon(getClass().getResource("/Imgs/vamdcsup.png")));
		JLabel obsparis = new JLabel(new ImageIcon(getClass().getResource("/Imgs/obsparis.png")));
		JLabel voparis = new JLabel(new ImageIcon(getClass().getResource("/Imgs/voparisdatacentre.png")));
		
		
		logo.add(vamdcImg);
		logo.add(vamdcsupImg);
		logo.add(obsparis);
		logo.add(voparis);
		
		
		
		
		
		
		this.add(titlePan, BorderLayout.NORTH);
		this.add(grid, BorderLayout.CENTER);
		this.add(logo, BorderLayout.SOUTH);
		
		
	}
	
	
	
	
	
	
	
}
