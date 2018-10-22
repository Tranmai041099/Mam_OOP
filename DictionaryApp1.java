package DictionaryGraphic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DictionaryApp1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DictionaryApp1 () {
		initUI();
	}
	
	private void initUI() {
		
		add(new DictPanel1());
		pack();
		setIconImage(loadImage(""));
		setTitle("Dictionary"); // dat ten cho cua so
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit upon close
		setResizable(false); //prevent resize window
		setLocationRelativeTo(null); //set center position for window
	}
	
	private Image loadImage (String path) { //lay hinh anh tu path(duong dan)
		ImageIcon imageicon = new ImageIcon (path);
		Image newImage = imageicon.getImage();
		return newImage;
	}
}
