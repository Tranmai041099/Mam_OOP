package bom.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;


public class MrFlame {
	private ArrayList<Flame> arrFlame = new ArrayList<Flame>();
	
	public void addFlame(int x, int y, int x1, int y1, long time, Image img, int type) {
		arrFlame.add(new Flame(x, y, x1, y1, time, img, type));
	}
	public void drawAllFlame(Graphics2D g2d) {
		for(int i = 0; i < arrFlame.size(); i++){
			arrFlame.get(i).drawFlame(g2d);
		}
	}
	
	public ArrayList<Flame> getArrFlame() {
		return arrFlame;
	}
}
