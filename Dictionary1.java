package DictionaryApprun;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import DictionaryGraphic.DictionaryApp1;
import DictionaryGraphic.DictionaryManagement1;

public class Dictionary1 {

	public static void main(String[] args) {
		
		try {
			
			for (LookAndFeelInfo lookandfeelinfo : UIManager.getInstalledLookAndFeels()) {
		    	if ("Nimbus".equals(lookandfeelinfo.getName())) {
		        	UIManager.setLookAndFeel(lookandfeelinfo.getClassName());
		            break;
		        }
		    }
			//setting Nimbus look & feel.
		} catch (Exception e) {
			e.printStackTrace();
		}
		DictionaryManagement1 h = new DictionaryManagement1();
		h.insertFromFile();
		
		EventQueue.invokeLater(() -> {
        	DictionaryApp1 renderapp = new DictionaryApp1();
            renderapp.setVisible(true);
        }); 
		 //DictionaryCommandline1 Mam = new  DictionaryCommandline1();
		 //Mam.dictionaryAdvanced();
		 //Mam.dictionaryBasic();
	}
	

}