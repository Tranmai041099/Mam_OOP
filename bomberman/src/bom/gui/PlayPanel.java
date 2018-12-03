package bom.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

import javax.swing.JPanel;

import bom.audio.SoundManager;
import bom.control.Action;
import bom.map.Setmap;
import bom.map.Value;
import bom.model.Wall;

public class PlayPanel extends JPanel implements KeyListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Setmap map = new Setmap(1);
	private Wall wall;
	private Action action = new Action();
	private long time = 0;
	private static int x;
	private BitSet bitset;
	private boolean over = false;
	private SoundManager soundMgr=new SoundManager();
	
	private Thread thread;
	
	public PlayPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(700, 450)); 
		init();
		setFocusable(true);
	}
	
	public void init() {
		
		bitset = new BitSet(256);
		bitset.clear();
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
		soundMgr.startGame();
		soundMgr.getSoundClickStart();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			time++;
			
			try {
				runBitset();
				Thread.sleep(1);
				action.moveBomber(time);
				action.moveCreep(time);
				action.timeBomb(time);
				action.bustBoob(time);
				if (action.checkDie()) {
					break;
				}
				if (action.checkWin()) {
					break;
				}
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		soundMgr.startGameOver();
		soundMgr.stopGame();
		try {
			Thread.sleep(4000);
			setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		soundMgr.startBG();
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		bitset.set(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		bitset.clear(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public void runBitset() {
		if (bitset.get(KeyEvent.VK_LEFT)) {
			if(!action.getBomber().isRun()) {
				action.getBomber().setRun(true);
				action.getBomber().setMove(Value.LEFT, action.getMove(Value.LEFT));
			}
			
		}
		
		if (bitset.get(KeyEvent.VK_RIGHT)) {
			if(!action.getBomber().isRun()) {
				action.getBomber().setRun(true);
				action.getBomber().setMove(Value.RIGHT, action.getMove(Value.RIGHT));
			}
		}
		
		if (bitset.get(KeyEvent.VK_UP)) {
			if(!action.getBomber().isRun()) {
				action.getBomber().setRun(true);
				action.getBomber().setMove(Value.UP, action.getMove(Value.UP));
			}
		} 
		
		else if (bitset.get(KeyEvent.VK_DOWN)) {
			if(!action.getBomber().isRun()) {
				action.getBomber().setRun(true);
				action.getBomber().setMove(Value.DOWN, action.getMove(Value.DOWN));
			}
		}
		if (bitset.get(KeyEvent.VK_SPACE)) {
			if (time % 50 == 0) {
				action.addBomb(time);
			}
		}
	}
}
