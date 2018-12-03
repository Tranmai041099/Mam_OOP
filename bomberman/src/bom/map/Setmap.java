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
	public static ArrayList<Wall> listWall;
	private static ArrayList<Wall> listWall_0;
	private static ArrayList<Wall> listWall_1;
	private static ArrayList<Wall> listWall_2;
	public static ArrayList<String> coppy_map = new ArrayList<String>();
	
	public Setmap(int level) {
		coppy_map = new ArrayList<>();
		listWall = new ArrayList<Wall>();
		listWall_0 = new ArrayList<Wall>();
		listWall_1 = new ArrayList<Wall>();
		listWall_2 = new ArrayList<Wall>();
		ReadMap("res/map" + level + ".txt");
	}
	
	public ArrayList<Wall> getListWall() {
		return listWall;
	}
	
	public ArrayList<Wall> getListWall_0() {
		return listWall_0;
	}
	
	public ArrayList<Wall> getListWall_1() {
		return listWall_1;
	}
	
	public ArrayList<Wall> getListWall_2() {
		return listWall_2;
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
            	coppy_map.add(s);
            	for (int i = 0; i < s.length(); i++) {
            		if(s.charAt(i) == '#') {
            			Image img = new ImageIcon("res/wall1.png").getImage();
            			listWall.add(new Wall(i, j, img, 1));
            			listWall_1.add(new Wall(i, j, img, 1));
            		}
            		else if(s.charAt(i) == '*') {
            			Image img = new ImageIcon("res/wall2.png").getImage();
            			listWall.add(new Wall(i, j, img, 2));
            			listWall_2.add(new Wall(i, j, img, 2));

            		}
            		else {
            			Image img = new ImageIcon("res/wall0.png").getImage();
            			if(s.charAt(i) == '1')
            				listWall.add(new Wall(i, j, img, -1));
            			else if(s.charAt(i) == '2')
            				listWall.add(new Wall(i, j, img, -2));
            			else if(s.charAt(i) == '3')
            				listWall.add(new Wall(i, j, img, -3));
            			else
            				listWall.add(new Wall(i, j, img, 0));
            			listWall_0.add(new Wall(i, j, img, 0));

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
}
