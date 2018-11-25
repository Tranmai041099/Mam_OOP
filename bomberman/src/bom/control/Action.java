package bom.control;

import java.awt.Graphics2D;

import bom.map.Setmap;
import bom.model.Bomber;

public class Action {
	private Setmap map = new Setmap(1);
	private Bomber bomber = new Bomber(60, 60, 50, 5);
	
	public Bomber getBomber() {
		return bomber;
	}
	
	public void drawBottomUnit(Graphics2D g) {
		for (int i = 0; i < map.getListWall().size(); i++) {
			map.getListWall().get(i).drawUnit(g);
		}
		bomber.drawPlayer(g);
	}
}
