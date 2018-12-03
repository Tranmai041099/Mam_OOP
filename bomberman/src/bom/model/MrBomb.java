package bom.model;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class MrBomb {
	private ArrayList<Bomb> arrBomb = new ArrayList<Bomb>();
	
	public void addBomb(int x, int y, long time, int leng) {
		arrBomb.add(new Bomb(x, y, time, leng));
	}
	public void drawAllBomb(Graphics2D g2d) {
		for(int i=0; i<arrBomb.size();i++){
			arrBomb.get(i).drawBoom(g2d);
		}
	}
	
	public ArrayList<Bomb> getArrBomb() {
		return arrBomb;
	}
	public void update() {
		for(int i=0; i<arrBomb.size();i++){
			arrBomb.get(i).update();
		}
	}

}
