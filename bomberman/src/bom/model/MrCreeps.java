package bom.model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import bom.audio.SoundManager;
import bom.map.Setmap;

public class MrCreeps {

	private Creeps creeps;
	
	private ArrayList<Creeps> arrCreeps;
	private SoundManager soudManager = new SoundManager();
	public MrCreeps() {
		arrCreeps = new ArrayList<Creeps>();
		addCreeps();
	}
	public void moveAllCreeps(Setmap map, Bomber bomber,long time) {
		for (int i =0; i <arrCreeps.size(); i++) {
			arrCreeps.get(i).moveEnemy(map,bomber, time);
			if(arrCreeps.get(i).getVt() == 4 && arrCreeps.get(i).isDie()){
				arrCreeps.remove(i);
			}
		}
	}
	public void checkImpactBomber(Bomber bomber) {
		for(int i = 0 ; i < arrCreeps.size(); i++) {
			if(Math.sqrt((arrCreeps.get(i).getXtam()-bomber.getX()-50)*(arrCreeps.get(i).getXtam()-bomber.getX()-50)
					+(arrCreeps.get(i).getYtam()-bomber.getY()-85)*(arrCreeps.get(i).getYtam()-bomber.getY()-85)) <= 30) {
				if(!bomber.isDie()){
					soudManager.getSoundBomNo();
					bomber.setDie(true);
				}
			}
		}
	}
	public void drawAllCreeps(Graphics2D g2d) {
		for (int i =0; i <arrCreeps.size(); i++) {
			arrCreeps.get(i).drawCreeps(g2d);
		}
		
	}
	
	public void addCreeps() {
		for(int i = 0; i < Setmap.listWall.size(); i++) {
			if(Setmap.listWall.get(i).getType() == -1)
					arrCreeps.add(new Creeps(Setmap.listWall.get(i).getX()*50, Setmap.listWall.get(i).getY()*50, 90, 3));
		}
	}
	
	public void checkDie(MrFlame flameMr) {
		for(int i = 0 ; i < arrCreeps.size(); i++) {
			for(Flame flame : flameMr.getArrFlame()) {
				if(Math.abs(flame.getXtam() - arrCreeps.get(i).getXtam()) < 25 && flame.getYtam() == arrCreeps.get(i).getYtam()
				|| Math.abs(flame.getYtam() - arrCreeps.get(i).getYtam()) < 25 && Math.abs(flame.getXtam()-arrCreeps.get(i).getXtam())< 25) {
					arrCreeps.get(i).setDie(true);
					return;
				}
			}
		}
		
	}
	
	public ArrayList<Creeps> getArrCreeps() {
		return arrCreeps;
	}
}
