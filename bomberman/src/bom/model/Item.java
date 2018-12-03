package bom.model;

import java.awt.Graphics2D;

import bom.Image.Img;

public class Item {
private int x,y, type;
	
	public Item(int x, int y, int type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getXtam() {
		return x + 25;
	}
	
	public int getYtam() {
		return y + 25;
	}
	
	public void drawItem(Graphics2D g2d) {
		g2d.drawImage(Img.arrItemImg.get(type), x, y, null);
	}
}
