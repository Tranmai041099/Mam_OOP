package dictionarygraphic;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DictionaryManagement.DictionaryArrayList;
import DictionaryManagement.DictionaryManagement;



public class DictionaryApp extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DictionaryJMenuBar menu = new DictionaryJMenuBar();
	DictionaryManagement d = new DictionaryManagement();
	DictPanel panel = new DictPanel();
	
	public DictionaryApp () {
		initUI();
	}
		
	private void initUI() {
		add(new DictPanel());
		setJMenuBar(menu);
		pack();
		setIconImage(loadImage("res/cup.png"));
		setTitle("Dictionary"); 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		setResizable(false); 
		setLocationRelativeTo(null); 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(DictPanel.change) {
					switch(JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi?", "Thông báo", 1)){
					case JOptionPane.YES_OPTION:
						try {
							d.dictionaryExpertToFile(DictPanel.kindOfdic, DictionaryArrayList.words);
			        		if(panel.getKindOfdic().equals("res/avdict.txt")){
			        			d.dictionaryExpertToFile("res/loveword.txt", DictPanel.currentListLove);
								d.dictionaryExpertToFile("res/history.txt", DictPanel.currentListHistory);
			        		}
			        		else {
			        			d.dictionaryExpertToFile("res/vnloveword.txt", DictPanel.currentListLove);
								d.dictionaryExpertToFile("res/vnhistory.txt", DictPanel.currentListHistory);
			        		}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						System.exit(0);
						break;
					case JOptionPane.NO_OPTION:
						if(DictPanel.kindOfdic.equals("res/avdict.txt")){
		        			try {
								d.dictionaryExpertToFile("res/history.txt", DictPanel.currentListHistory);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
		        		}
		        		else {
		        			try {
								d.dictionaryExpertToFile("res/vnhistory.txt", DictPanel.currentListHistory);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
		        		}
						System.exit(0);
						break;
					case JOptionPane.CANCEL_OPTION:
						break;
					default:
						break;
					}
				}
				else {
					if(DictPanel.kindOfdic.equals("res/avdict.txt")){
	        			try {
							d.dictionaryExpertToFile("res/loveword.txt", DictPanel.currentListLove);
							d.dictionaryExpertToFile("res/history.txt", DictPanel.currentListHistory);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
	        		}
	        		else {
	        			try {
							d.dictionaryExpertToFile("res/vnloveword.txt", DictPanel.currentListLove);
							d.dictionaryExpertToFile("res/vnhistory.txt", DictPanel.currentListHistory);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	        		}
					System.exit(0);
				}
			}
		});
			
		}
		
		private Image loadImage (String path) { 
			ImageIcon imageicon = new ImageIcon (path);
			Image newImage = imageicon.getImage();
			return newImage;
		}
}
