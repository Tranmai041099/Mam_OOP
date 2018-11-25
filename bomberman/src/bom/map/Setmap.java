package bom.map;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import bom.model.Wall;


public class Setmap {
	private ArrayList<Wall> listWall;
	
	public Setmap(int level) {
		listWall = new ArrayList<>();
		ReadMap("res/map" + level + ".txt");
	}
	
	public ArrayList<Wall> getListWall() {
		return listWall;
	}
	
	public void ReadMap( String path) {
		BufferedReader br = null;
		File f = new File(path);
		path = f.getAbsolutePath();
		
		try {
			
			FileInputStream fileInPutStream = new FileInputStream(path);
            Reader reader = new InputStreamReader(fileInPutStream, "utf8");
            br = new BufferedReader(reader);
            String s;
            int j = 0;
            while((s = br.readLine()) != null) {
            	for (int i = 0; i < s.length(); i++) {
            		if(s.charAt(i) == '#') {
            			Image img = new ImageIcon("res/wall1.png").getImage();
            			listWall.add(new Wall(i*30, j*30, img));
            		}
            		else if(s.charAt(i) == '*') {
            			Image img = new ImageIcon("res/wall3.png").getImage();
            			listWall.add(new Wall(i*30, j*30, img));
            		}
            		else {
            			Image img = new ImageIcon("res/wall0.png").getImage();
            			listWall.add(new Wall(i*30, j*30, img));
            		}
				}
				j++;
            }
            
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	public void drawBottomUnit(Graphics2D g) {
		for (int i = 0; i < listWall.size(); i++) {
				listWall.get(i).drawUnit(g);
		}
	}
}
