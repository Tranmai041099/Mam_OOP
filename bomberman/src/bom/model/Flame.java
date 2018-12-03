package bom.model;

import java.awt.Graphics2D;
import java.awt.Image;

import bom.Image.Img;


public class Flame {
	private int x,y, vt=0, type, x1, y1;
	private long time;
	private Image img;
	
	public Flame(int x, int y, int x1, int y1, long time, Image img, int type) {
		super();
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.time = time;
		this.img = img;
		this.type = type;
	}
	
	public int getX_tam_bom() {
		return x1+25;
	}
	public int getY_tam_bom() {
		return y1+25;
	}

	public int getXtam() {
		return x + 25;
	}
	
	public int getYtam() {
		return y + 25;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public long getTime() {
		return time;
	}
	
	public int getType() {
		return type;
	}
	
	public void drawFlame(Graphics2D g2d) {
		g2d.drawImage(img, x, y, null);
	}
}
