package me.lpmg.sakura;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	public void init() {
		JFrame frame = new JFrame("SAKURA さくら | LPMG Games | Early Alpha/Concept Version");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());
		frame.add(new GamePanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);		
		frame.setVisible(true);
	}
}
