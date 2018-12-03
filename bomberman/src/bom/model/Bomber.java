package bom.model;

import java.awt.Graphics2D;
import java.awt.Image;

import bom.Image.Img;
import bom.map.Value;


public class Bomber {
	
	private int x, y, jump = 10,  countBomb = 3, lengBomb = 2, vt = 0;
	private int speed, orient, typeRun;
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
	public int getOrient() {
		return orient;
	}
	
	public int getJump() {
		return jump;
	}
	
	public boolean isRun() {
		return isRun;
	}
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	public void setCountBomb(int countBomb) {
		if(countBomb>5){
			this.countBomb = 5;
		} else {
			this.countBomb = countBomb;
		}
	}
	public void setLengBomb(int lengBomb) {
		if(lengBomb==5){
			this.lengBomb = 5;
		} else {
			this.lengBomb = lengBomb;
		}
	}
	public int getCountBomb() {
		return countBomb;
	}
	public int getLengBomb() {
		return lengBomb;
	}
	
	public int getStart() {
		return start;
	}
	
	public Bomber(int x, int y, int speed, int orient) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.orient = orient;
		img = Img.arrBomberImg.get(orient);

	}
	
	public void drawBomber(Graphics2D g2d) {
		g2d.drawImage(img, x, y, null);
	}
	
	public void setMove(int keyCode, int typeRun) {
		if(typeRun == 0) {
			jump = 0;
		}
		else
			jump = 10;
		if(!isDie) {
			switch(keyCode) {
			case Value.UP:
				start = 0;
				break;
			case Value.DOWN:
				start = 1;
				break;
			case Value.RIGHT:
				start = 2;
				break;
			case Value.LEFT:
				start = 3;
				break;
			}
		}
		this.orient = keyCode;
	}
	
	public void checkBomb(MrBomb bombMr) {
		int x1 = x+50;
		int y1 = y+85;
		for(Bomb bomb : bombMr.getArrBomb()) {
			if(Math.abs(x1 - bomb.getX()) <= 65 && Math.abs(y1 - bomb.getY()) <= 25){
				this.typeRun = 0;
			}
		}
	}
	
	public void moveBomber(long time, MrBomb bombMr) {
		
		checkBomb(bombMr);
		
		if(isDie){
			if(vt == 10){
				img = null;
				return;
			}
			if(time%120 == 0)
				playerDie();
			return;
		}
		
		if(time % speed != 0)
			return;
		
		if(!isRun){
			return;
		}
		
		switch(orient) {
		case Value.UP: {
			stept++;
			stept = stept%5;
			stept += start*5;
			img = Img.arrBomberImg.get(stept);
			y -= jump;
			isRun = false;
			break;

		}
		case Value.DOWN: {
			stept++;
			stept = stept%5;
			stept += start*5;
			img = Img.arrBomberImg.get(stept);
			y += jump;
			isRun = false;
			break;

		}
		case Value.RIGHT: {
			stept++;
			stept = stept%5;
			stept += start*5;
			img = Img.arrBomberImg.get(stept);
			x += jump;
			isRun = false;
			break;
		}
		case Value.LEFT: {
			stept++;
			stept = stept%5;
			stept += start*5;
			img = Img.arrBomberImg.get(stept);
			x -= jump;
			isRun = false;
			break;

		}
		}
	}
	
	public boolean isDie() {
		if(vt == 10)
			return isDie;
		return false;
	}
	public void setDie(boolean isDie) {
		this.isDie = isDie;
	}
	public void playerDie() {
		img = Img.arrBomberImg.get(vt+20);
		vt++;
	}
	
	public void checkDie(MrFlame flameMr) {
		for(Flame flame : flameMr.getArrFlame()) {
			if((Math.abs((x+50)-flame.getXtam()) <= 25 && Math.abs(y+85-flame.getYtam())<=35)) {
				this.setDie(true);
				
				return;
			}
		}
		
	}
	
	
}
