package dictionaryapprun;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import DictionaryManagement.DictionaryArrayList;
import DictionaryManagement.DictionaryManagement;
import dictionarygraphic.DictPanel;
import dictionarygraphic.DictionaryApp;

public class Dictionary {
	private static DictionaryManagement s = new DictionaryManagement();
	
	public static void insert(String kindOfdic) {
		s.insertFromFile("res/avdict.txt", DictionaryArrayList.words);
		s.insertFromFile("res/history.txt", DictPanel.currentListHistory);
		for (int i = 0; i < DictPanel.currentListHistory.size(); i++) {
			DictPanel.modelListHistory.addElement(DictPanel.currentListHistory.get(i).getTarget());
		}
		s.insertFromFile("res/loveword.txt", DictPanel.currentListLove);
		for (int i = 0; i < DictPanel.currentListLove.size(); i++) {
			DictPanel.modelListLove.addElement(DictPanel.currentListLove.get(i).getTarget());
		}
	}
	
	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo lookandfeelinfo : UIManager.getInstalledLookAndFeels()) {
		    	if ("Nimbus".equals(lookandfeelinfo.getName())) {
		        	UIManager.setLookAndFeel(lookandfeelinfo.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		insert("res/avdict.txt");
		
		EventQueue.invokeLater(() -> {
        	DictionaryApp renderapp = new DictionaryApp();
            renderapp.setVisible(true);
        }); 
	}

	

}