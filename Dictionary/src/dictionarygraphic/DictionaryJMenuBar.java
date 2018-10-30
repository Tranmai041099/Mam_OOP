package dictionarygraphic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import DictionaryManagement.DictionaryArrayList;
import DictionaryManagement.DictionaryManagement;

public class DictionaryJMenuBar extends JMenuBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu file;
	private JMenuItem exit, New, save;
	
	DictPanel panel = new DictPanel();
	DictionaryManagement d = new DictionaryManagement()	;
	
	public DictionaryJMenuBar() {
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		New = new JMenuItem("New");
		save = new JMenuItem("Save");

		New.addActionListener(this);
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.SHIFT_MASK| InputEvent.CTRL_MASK ));
		
		save.addActionListener(this);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		exit.addActionListener(this);
		
		file.add(New);
		file.add(save);
		file.add(exit);
		
		
		
		
		add(file);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == New) {
			DictPanel.searchfield.setText("Searching ...");
			DictPanel.searchfield.setForeground(new Color(153,153,153)); 
			DictPanel.meaningarea.setText("");
			
			DictPanel.modelList.clear();
			DictPanel.modelListLove.clear();
			DictPanel.modelListHistory.clear();
			
			DictPanel.currentList.clear();
			DictPanel.currentListLove.clear();
			DictPanel.currentListHistory.clear();	
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
		}
		
		if(e.getSource() == exit) {
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
					System.exit(0);
					break;
				case JOptionPane.CANCEL_OPTION:
					break;
				default:
					break;
				}
			}
			else {
				System.exit(0);
			}
		}
		
		if(e.getSource() == save) {
			Icon icon = null;
	        int save =  JOptionPane.showConfirmDialog(getRootPane(), "bạn có muốn lưu dữ liệu? ","Thông báo!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
	        if(save == JOptionPane.YES_OPTION){  
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
	        }
		}
	}
	
}
