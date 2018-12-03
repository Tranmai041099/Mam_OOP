package bom.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;


public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlayPanel play;
	StartPanel start = new StartPanel(this);
	
	public GUI() {	
		init();
		setResizable(false); 
		//setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		add(start);
		pack();
	}
	
	private void init() {
		
	}
	
	public void startGame() {
		start.setVisible(false);
		play = new PlayPanel();
		add(play);
		pack();
		play.startGame();		
		play.setVisible(true);
		play.requestFocusInWindow();
		
	}
}
