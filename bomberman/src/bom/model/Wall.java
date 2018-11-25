package bom.model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Wall {
	
	private int x;
	private int y;
	private Image img;
	private int type;
	
	public Wall(int x, int y, Image img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void drawUnit(Graphics2D g) {
		g.drawImage(img, x, y, 30, 30, null);
	}
}
