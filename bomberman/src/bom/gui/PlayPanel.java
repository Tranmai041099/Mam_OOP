package bom.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import bom.control.Action;
import bom.map.Setmap;
import bom.model.Wall;

public class PlayPanel extends JPanel implements KeyListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Setmap map = new Setmap(1);
	private Wall wall;
	private Action action = new Action();
	private int x, time = 0;
	
	private Thread thread;
	
	public PlayPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(930, 390)); 
		init();
		setFocusable(true);
	}
	
	public void init() {
		addKeyListener(this);

	}
	
	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		action.drawBottomUnit(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			time++;
			if (time % 1000 == 0)
				if (time == 60000) {
					break;
				}
			
			try {
				action.getBomber().setMove(x);
				action.getBomber().movePlayer(x, time);
				repaint();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		x = e.getKeyCode();
		System.out.println(x);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		x = 0;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
