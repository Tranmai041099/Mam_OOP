package bom.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import bom.Image.Img;


public class Bomber {
	
	private int x, y, speed, oirent, jump = 10, typeRun, vt = 0;
	private boolean isRun = false, isDie = false;
	private int start = 0, stept = 0;
	
	private Image img;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public int getOirent() {
		return oirent;
	}
	
	public Bomber(int x, int y, int speed, int oirent) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.oirent = oirent;
		img = Img.arrPlayerImg.get(oirent);
	}
	
	public void drawPlayer(Graphics2D g2d) {
		g2d.drawImage(img, x, y, 50, 50, null);
	}
	
	public void setMove(int keyCode) {
		if(!isDie) {
			switch(keyCode) {
			case KeyEvent.VK_UP:
				start = 0;
				break;
			case KeyEvent.VK_DOWN:
				start = 1;
				break;
			case KeyEvent.VK_RIGHT:
				start = 2;
				break;
			case KeyEvent.VK_LEFT:
				start = 3;
				break;
			}
		}
	}
	public void movePlayer(int keyCode, long time) {
		
		if(time % speed != 0){
			return;
		}
		
		switch(keyCode) {
		case KeyEvent.VK_UP: {
			y -= jump;
			stept++;
			stept = stept%5;
			stept += start*5;
			System.out.println(start);
			img = Img.arrPlayerImg.get(stept);
			break;

		}
		case KeyEvent.VK_DOWN: {
			y += jump;
			stept++;
			stept = stept%5;
			stept += start*5;
			System.out.println(start);
			img = Img.arrPlayerImg.get(stept);
			break;

		}
		case KeyEvent.VK_RIGHT: {
			x += jump;
			stept++;
			stept = stept%5;
			stept += start*5;
			System.out.println(start);
			img = Img.arrPlayerImg.get(stept);
			break;
		}
		case KeyEvent.VK_LEFT: {
			x -= jump;
			stept++;
			stept = stept%5;
			stept += start*5;
			System.out.println(start);
			img = Img.arrPlayerImg.get(stept);
			break;

		}
		}
	}
}
