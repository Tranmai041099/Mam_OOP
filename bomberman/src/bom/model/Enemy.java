package bom.model;

import java.awt.Image;

import bom.Image.Img;
import bom.map.Setmap;

public abstract class Enemy {
	private int x, y, speed, orient, jump = 8;
	private Image img;	
	
	public Enemy(int x, int y, int speed, int orient) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.orient = orient;
		img = Img.arrCreepImg.get(orient);
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	
	public int getOrient() {
		return orient;
	}
	public void setOrient(int orient) {
		//img = Img.arrCreepImg.get(orient);
		this.orient = orient;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	public Image getImg() {
		return img;
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
	
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
	
	public boolean checkMoveLeft(int x, int y, Setmap map, int size) {
		boolean check = false;
		for(Wall wall : map.getListWall_0()) {
			if(y/size == wall.getY() && wall.getX() == x/size) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public boolean checkMoveRight(int x, int y, Setmap map, int size) {
		boolean check = false;
		for(Wall wall : map.getListWall_0()) {
			if(y/size == wall.getY() && wall.getX() == x/size + 1) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public boolean checkMoveUp(int x, int y, Setmap map, int size) {
		boolean check = false;
		for(Wall wall : map.getListWall_0()) {
			if(x/size == wall.getX() && wall.getY() == y/size) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public boolean checkMoveDown(int x, int y, Setmap map, int size) {
		boolean check = false;
		for(Wall wall : map.getListWall_0()) {
			if(x/size == wall.getX() && wall.getY() == y/size +1) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public double space(int x, int y, int x1, int y1) {
		double space = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
		return space;
	}
	
	public abstract void moveEnemy(Setmap map, Bomber bomber, long time);
	public abstract void searchPath(Setmap map, Bomber bomber);
	public abstract void checkBomb(MrBomb bombMr);
	
}
