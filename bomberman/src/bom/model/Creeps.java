package bom.model;

import java.awt.Graphics2D;
import java.util.Random;

import bom.Image.Img;
import bom.map.Setmap;

public class Creeps extends Enemy{
	Random rd = new Random();
	public static final int LEFT = 3, RIGHT =2, UP = 0, DOWN = 1;
	private boolean isRun = false , test = false, isDie = false;
	private int vt = 0, vt1 = 0;
	
	public Creeps(int x, int y, int speed, int orient) {
		super(x, y, speed, orient);
	}
	
	public boolean isRun() {
		return isRun;
	}
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	public boolean isDie() {
		return isDie;
	}
	public void setVt(int vt) {
		this.vt = vt;
	}
	
	public int getVt() {
		return vt;
	}
	
	public void setDie(boolean isDie) {
		this.isDie = isDie;
		vt = 0;
	}

	private void creepDie() {
		this.setImg(Img.arrCreepImg.get(12+vt));
		vt++;
	}
	
	public void drawCreeps(Graphics2D g2d) {
		g2d.drawImage(this.getImg(), this.getX(), this.getY(), null);
	}
	
	@Override
	public void moveEnemy(Setmap map, Bomber bomber, long time) {
		
		if(time % this.getSpeed() != 0)
			return;
		
		if(isDie) {
			if(time%30 == 0)
				creepDie();
			return;
		}
		
		switch (this.getOrient()) {
		case LEFT:
			int count = 0;
			vt++;
			vt = vt%3;
			vt += 3*3;
			this.setImg(Img.arrCreepImg.get(vt));
			if(this.checkMoveLeft(this.getX(), this.getY() , map, 50))
				this.setX(this.getX()- this.getJump());
			if(!this.checkMoveLeft(this.getX(), this.getY() , map, 50) && this.checkMoveRight(this.getX()+50, this.getY(), map, 50))
				this.setOrient(RIGHT);
//			if(this.checkMoveUp(this.getX(), this.getY(), map, 50))
//				count++;
//			if(this.checkMoveDown(this.getX(), this.getY(), map, 50))
//				count++;
//			if(count!=0) {
//				int a = rd.nextInt(count);
//				if(a == 0)
//					this.setOrient(UP);
//				else
//					this.setOrient(DOWN);
//			}
			break;
		case RIGHT:
			vt++;
			vt = vt%3;
			vt += 2*3;
			this.setImg(Img.arrCreepImg.get(vt));
			if(this.checkMoveRight(this.getX(), this.getY(), map, 50))
				this.setX(this.getX()+this.getJump());
			if(!this.checkMoveRight(this.getX(), this.getY(), map, 50) && this.checkMoveLeft(this.getX(), this.getY(), map, 50))
				this.setOrient(LEFT);
//			else if(this.checkMoveUp(this.getX(), this.getY(), map, 50))
//				this.setOrient(UP);
//			else if(this.checkMoveDown(this.getX(), this.getY(), map, 50))
//				this.setOrient(DOWN);
			break;
		case UP:
			vt++;
			vt = vt%3;
			vt += 0*3;
			this.setImg(Img.arrCreepImg.get(vt));
			if(this.checkMoveUp(this.getX(), this.getY(), map, 50))
				this.setY(this.getY()-this.getJump());
			if(!this.checkMoveUp(this.getX(), this.getY(), map, 50) && this.checkMoveDown(this.getX(), this.getY(), map, 50))
				this.setOrient(DOWN);
//			else if(this.checkMoveLeft(this.getX(), this.getY(), map, 50))
//				this.setOrient(LEFT);
//			else if(this.checkMoveRight(this.getX(), this.getY(), map, 50))
//				this.setOrient(RIGHT);
			break;
		case DOWN:
			vt++;
			vt = vt%3;
			vt += 1*3;
			this.setImg(Img.arrCreepImg.get(vt));
			
			if(this.checkMoveDown(this.getX(), this.getY(), map, 50))
				this.setY(this.getY()+this.getJump());
			if(!this.checkMoveDown(this.getX(), this.getY(), map, 50) && this.checkMoveUp(this.getX(), this.getY(), map, 50))
//				this.setOrient(UP);
//			else if(this.checkMoveLeft(this.getX(), this.getY(), map, 50))
//				this.setOrient(LEFT);
//			else if(this.checkMoveRight(this.getX(), this.getY(), map, 50))
//				this.setOrient(RIGHT);
			break;
		default:
			break;
		}
	}


	


	@Override
	public void searchPath(Setmap map, Bomber bomber) {
		
	}

	@Override
	public void checkBomb(MrBomb bombMr) {
		// TODO Auto-generated method stub
		
	}
}