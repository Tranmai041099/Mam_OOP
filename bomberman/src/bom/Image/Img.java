package bom.Image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Img {
	
	public static ArrayList<Image> arrPlayerImg;
	
	public Img() {
		loadPlayer();
	}
	
	public void loadPlayer() {
		arrPlayerImg = new ArrayList<Image>();
		try {
			BufferedImage bfi = ImageIO.read(getClass().getResourceAsStream("/res/player1.png"));
			for(int i = 0 ; i < 7; i++){
				for(int j = 0 ; j < 5; j++){
					arrPlayerImg.add(bfi.getSubimage(i*100, j*100, 100, 100));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
