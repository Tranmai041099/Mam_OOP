package bom.Image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Img {
	
	public static ArrayList<Image> arrBomberImg;
	public static ArrayList<Image> arrFlameImg;
	public static ArrayList<Image> arrCreepImg;
	public static ArrayList<Image> arrItemImg;

	public Img() {
		loadBomber();
		loadFlame();
		loadCreep();
		loadItem();
	}
	
	public void loadBomber() {
		arrBomberImg = new ArrayList<Image>();
		try {
			BufferedImage bfi = ImageIO.read(getClass().getResourceAsStream("/res/player1.png"));
			for(int i = 0 ; i < 7; i++){
				for(int j = 0 ; j < 5; j++){
					arrBomberImg.add(bfi.getSubimage(i*100, j*100, 100, 100));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadCreep() {
		arrCreepImg = new ArrayList<Image>();
		try {
			BufferedImage bfi = ImageIO.read(getClass().getResourceAsStream("/res/boss.png"));
			for(int i = 0 ; i < 4; i++){
				for(int j = 0 ; j < 3; j++){
					arrCreepImg.add(bfi.getSubimage(i*50, j*50, 50, 50));
				}
			}
			for(int i = 0; i < 4; i++)
				arrCreepImg.add(bfi.getSubimage(i*50, 3*50, 50, 50));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadFlame() {
		arrFlameImg = new ArrayList<Image>();
		try {
			BufferedImage bfi = ImageIO.read(getClass().getResource("/res/Bomwater.png"));
			for(int i = 0 ; i <2;i++){
				for(int j = 0 ; j<3;j++){
					arrFlameImg.add(bfi.getSubimage(j*50, i*50, 50, 50));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadItem() {
		arrItemImg = new ArrayList<Image>();
		try {
			BufferedImage bfi = ImageIO.read(getClass().getResourceAsStream("/res/item.png"));
			for(int i = 0 ; i<3;i++){
				arrItemImg.add(bfi.getSubimage(0, i*50, 50, 50));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
