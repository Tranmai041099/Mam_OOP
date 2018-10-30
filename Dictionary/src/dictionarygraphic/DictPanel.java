package dictionarygraphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import DictionaryManagement.DictionaryArrayList;
import DictionaryManagement.DictionaryManagement;
import DictionaryManagement.Word;


public class DictPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField searchfield;
	public static JTextPane meaningarea;
	private JButton click;
	private JButton speakword;
	public JButton deleteword;
	private JButton replaceword;
	private JButton likeword;
	
	private JList<String> list = new JList<String>();
	public static ArrayList<Word> currentList = new ArrayList<Word>();
	public static DefaultListModel<String> modelList = new DefaultListModel<String>();
	
	private JList<String> listlove = new JList<String>();
	public static  ArrayList<Word> currentListLove = new  ArrayList<Word>();
	public static DefaultListModel<String> modelListLove = new DefaultListModel<String>();
	
	private JList<String> listhistory = new JList<String>();
	public static ArrayList<Word> currentListHistory = new ArrayList<Word>();
	public static DefaultListModel<String> modelListHistory = new DefaultListModel<String>();
	
	private JScrollPane verticalmeaning;
	
	
	private JLabel DICTIONARY = new JLabel();
	private JLabel Name = new JLabel();
	private JLabel date = new JLabel();
	private JLabel time = new JLabel();
	private JComboBox<String> Kind;
	private String love = "";
	private String h = "";
	public JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	private DictionaryManagement s = new DictionaryManagement();
	public static String kindOfdic = "res/avdict.txt";
	public static boolean change = false;
	
	public void setKindOfdic(String s) {
		DictPanel.kindOfdic = s;
	}
	
	public String getKindOfdic() {
		return DictPanel.kindOfdic;
	}
	
	public DictPanel() {
		setLayout(null);
		initPanel();
		initSearchingBox();
		showDate();
		showTime();
	}
	
	private void initPanel() {
		
		setPreferredSize(new Dimension(500, 480)); 
		this.setBackground(Color.decode("#87CEFA"));
	}
	
	private void initSearchingBox() {
		
		searchfield = new JTextField();
		meaningarea = new JTextPane();
		click = new JButton(new ImageIcon("res/search3.png"));
		replaceword = new JButton(new ImageIcon("res/repair1.png"));
		speakword = new JButton(new ImageIcon("res/speaker2.png"));
		deleteword = new JButton(new ImageIcon("res/delete2.png"));
		likeword = new JButton(new ImageIcon("res/tim2.png"));
		
		String s[] = {"Anh - Việt", "Việt - Anh"}; 
		Kind = new JComboBox<String>(s);
		Kind.addActionListener(this);
		Kind.setBounds(400, 85, 105, 35);
		
		DICTIONARY.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		DICTIONARY.setForeground(Color.decode("#1B3035"));
        DICTIONARY.setText("DICTIONARY");
        DICTIONARY.setBounds(136, 10, 300, 35);

        Name.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        Name.setForeground(new Color(51, 51, 0));
        Name.setText("<html><u>Designed by MamTeam</u></html>");
        Name.setForeground(Color.RED);
        Name.setBounds(300, 35, 200, 50);
        
        date.setBounds(5, 35, 150, 20);
        date.setForeground(Color.decode("#512F1D"));
        
        time.setBounds(5, 49, 150, 30);
        time.setForeground(Color.decode("#512F1D"));
        
        searchfield.addActionListener(this);
		searchfield.setBounds(5,87,355,31);
		searchfield.setForeground(new Color(153, 153, 153));
		searchfield.setText("Searching ...");
		searchfield.addFocusListener(new FocusAdapter() {
	            public void focusGained(FocusEvent evt) {
	            	searchfieldFocusGained(evt);
	            }
	            public void focusLost(FocusEvent evt) {
	            	searchfieldFocusLost(evt);
	            }
	        });
		
		meaningarea.setEditable(false);
		meaningarea.setBackground(Color.decode("#ECFAF9"));
		
		list.setModel(modelList);
		list.setBackground(Color.decode("#F3FBFB"));
		list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                vocabuListMouseClicked(evt);
            }
        });

		listlove.setBounds(367,360,135,121);
		listlove.setBackground(Color.decode("#F3FBFB"));
		listlove.setModel(modelListLove);
		listlove.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		listlove.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                vocabuListLoveMouseClicked(evt);
            }
        });
		
		listhistory.setBackground(Color.decode("#F3FBFB"));
		listhistory.setModel(modelListHistory);
		listhistory.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                vocabuListHistoryMouseClicked(evt);
            }
        });
		
		click.addActionListener(this);
		click.setBounds(365,85,35,35);
		
		speakword.addActionListener(this);
		speakword.setBounds(365,122,35,35);
		speakword.setToolTipText("Click vào nút này hoặc nhấn Alt+S để nghe phát âm");
		speakword.setMnemonic(KeyEvent.VK_S);
		
		deleteword.setBounds(400,122,35,35);
		deleteword.setToolTipText("Click vào nút này hoặc ấn Alt+Delete để loại bỏ từ");
		deleteword.setMnemonic(KeyEvent.VK_DELETE);
		deleteword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	deletedActionPerformed(evt);
            }
		});
		
		searchfield.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  searcher();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  searcher();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  searcher();
			  }
		});
		replaceword.addActionListener(this);
		replaceword.setBounds(435,122,35,35);
		replaceword.setToolTipText("Click vào nút này hoặc ấn Alt+R để thao tác sửa từ");
		replaceword.setMnemonic(KeyEvent.VK_R);
		
		likeword.setBounds(470,122,35,35);
		likeword.setToolTipText("Click vào để thích từ");
		likeword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	likeword();
            }
		});
		
		verticalmeaning = new JScrollPane(meaningarea);
		verticalmeaning.setBounds(5,122,355,362);
		
		tabbedPane.setBounds(367,155,135,197);
		tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		tabbedPane.addTab("list", null, list, null);
		tabbedPane.addTab("history", null, listhistory, null);
		
		
		add(searchfield);
		add(click);
		add(replaceword);
		add(speakword);
		add(deleteword);
		add(likeword);
		add(verticalmeaning);
		add(listlove);
		add(DICTIONARY);
		add(Name);
		add(Kind);
		add(listlove);
		add(tabbedPane);
		add(date);
		add(time);
	}
	
	private void searchfieldFocusGained(FocusEvent evt) { // su kien search
        if(searchfield.getText().equals("Searching ..."))
        {
            searchfield.setText("");
            meaningarea.setText("");
        }
        if(!searchfield.getText().equals("Searching ...")) {
        	 searchfield.setForeground(Color.black);
        }
	}
	private void searchfieldFocusLost(FocusEvent evt) { // su kien search
        if(searchfield.getText().equals(""))
        {
            searchfield.setText("Searching ...");
            meaningarea.setText("");
        }
        if(searchfield.getText().equals("Searching ...")) {
        	searchfield.setForeground(new Color(153,153,153)); 
        }
   }
	
	private void deletedActionPerformed(ActionEvent evt) { // su kien nut xoa
		Icon icon = null;
		int delete =  JOptionPane.showConfirmDialog(getRootPane(), "bạn có muốn loại bỏ từ? ","Thông báo!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
		if(delete == JOptionPane.YES_OPTION){  
        	String searchword = searchfield.getText();
        	String meaning = h;
			try {
				if(!love.equals("") && love.equals(searchfield.getText())) {
					int id = listlove.getSelectedIndex();
			        if(id == -1) return;
			        modelListLove.removeElementAt(id);
			        currentListLove.remove(id);
			        love = "";
				}
			else
				s.dictionaryLookuptoDelete(searchword, meaning,  getKindOfdic());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
	}

	public void searcher() {

		String searchword = searchfield.getText();
		if(searchword.equals(""))
			return;
		modelList .clear();
		currentList.clear();
		int limit = 8;
		for (Word word : DictionaryArrayList.words){
			if(limit == 0) break;
			if(word.getTarget().equals(searchword)) {
				limit --;
				modelList.addElement(word.getTarget());
				currentList.add(word);
			}	
		}
		for (Word word : DictionaryArrayList.words){
			boolean check = true;
			if(limit == 0) break;
			if(word.getTarget().startsWith(searchword)) {
				if(!currentList.isEmpty()) {
					for(int i = 0; i <currentList.size(); i++) {
						if(word.getTarget().equals(currentList.get(i).getTarget()))
							check = false;
					}
				}
				if(check) {
					limit --;
					modelList.addElement(word.getTarget());
					currentList.add(word);
				}
				
			}	
		}
		for (Word word : DictionaryArrayList.words){
			boolean check = true;
			if(limit == 0) break;
			if(word.getTarget().toLowerCase().startsWith(searchword)) {
				if(!currentList.isEmpty()) {
					for(int i = 0; i <currentList.size(); i++) {
						if(word.getTarget().toLowerCase().equals(currentList.get(i).getTarget()))
							check = false;
					}
				}
				if(check) {
					limit --;
					modelList.addElement(word.getTarget());
					currentList.add(word);
				}
				
			}	
		}
		for (Word word : DictionaryArrayList.words){
			boolean check = true;
			if(limit == 0) break;
			if(word.getTarget().toLowerCase().startsWith(searchword.toLowerCase())) {
				if(!currentList.isEmpty()) {
					for(int i = 0; i <currentList.size(); i++) {
						if(word.getTarget().toLowerCase().equals(currentList.get(i).getTarget().toLowerCase()))
							check = false;
					}
				}
				if(check) {
					limit --;
					modelList.addElement(word.getTarget());
					currentList.add(word);
				}
			}	
		}
	}
	
	
	private void vocabuListMouseClicked(MouseEvent event) { //su kien click jlist
		listlove.setEnabled(false);
		listlove.setEnabled(true);
		int id = list.getSelectedIndex();
        if(id == -1) return;
        Word w = currentList.get(id);
        searchfield.setText(w.getTarget());
        meaningarea.setText(w.getMeaning());
        searchfield.setForeground(Color.black);
                
        boolean check = true;
        if(!currentListHistory.isEmpty()) {
			for(int i = 0; i < currentListHistory.size(); i++) {
				if(searchfield.getText().equals(currentListHistory.get(i).getTarget()) && meaningarea.getText().equals(currentListHistory.get(i).getMeaning()))
					check = false;
			}
		}
		if(check) {
			modelListHistory.add(0, searchfield.getText());
			Word word = new Word(searchfield.getText(), meaningarea.getText());
			currentListHistory.add(0, word);
		}
		if(modelListHistory.size() == 9) {
			modelListHistory.removeElementAt(8);
			currentListHistory.remove(8);
		}
		try {
			colorText();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
	}
	
	public void likeword() {
		String searchword = searchfield.getText();
		String meaning = h;
		if(searchword.equals("") || searchword.equals("Searching ..."))
			return;
		if(meaning.equals("No such word"))
			return;
		if(meaning.equals("")) {
			for (Word word : DictionaryArrayList.words) {
				if(searchword.equals(word.getTarget()))
					meaning = word.getMeaning();		
			}
		}
		else {
			boolean check = true;
	        if(!currentListLove.isEmpty()) {
				for(int i = 0; i < currentListLove.size(); i++) {
					if(searchword.equals(currentListLove.get(i).getTarget()) && meaning.equals(currentListLove.get(i).getMeaning()))
						check = false;
				}
			}
			if(check) {
				modelListLove.add(0, searchword);
				Word word = new Word(searchword, meaning);
				currentListLove.add(0, word);
			}
		}
		if(modelListLove.size() == 7) {
			modelListLove.removeElementAt(6);
			currentListLove.remove(6);
		}
		change = true;
	}
	
	private void vocabuListLoveMouseClicked(MouseEvent event) { //su kien love jlistLove
        
		int id = listlove.getSelectedIndex();
        if(id == -1) return;
        Word wordtemp = currentListLove.get(id);
        searchfield.setText(wordtemp.getTarget());
        searchfield.setForeground(Color.black);
        meaningarea.setText(wordtemp.getMeaning());
        love =  wordtemp.getTarget();
           
        boolean check = true;
        if(!currentListHistory.isEmpty()) {
            for(int i = 0; i < currentListHistory.size(); i++) {
				if(searchfield.getText().equals(currentListHistory.get(i).getTarget()) && wordtemp.getMeaning().equals(currentListHistory.get(i).getMeaning()))
					check = false;
			}
		}
		if(check) {
			modelListHistory.add(0, searchfield.getText());
			Word word = new Word(searchfield.getText(), meaningarea.getText());
			currentListHistory.add(0, word);
		}
		if(modelListHistory.size() == 9) {
			modelListHistory.removeElementAt(8);
			currentListHistory.remove(8);
		}
		
		try {
			colorText();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	private void vocabuListHistoryMouseClicked(MouseEvent event) { //su kien love jlistHistory
        
		int id = listhistory.getSelectedIndex();
        if(id == -1) return;
        Word wordtemp = currentListHistory.get(id);
        searchfield.setText(wordtemp.getTarget());
        meaningarea.setText(wordtemp.getMeaning());
        searchfield.setForeground(Color.black);
        
        try {
			colorText();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchfield || e.getSource() == click) {
			String searchword = searchfield.getText();
			String meaning = s.dictionaryLookup(searchword);
			
			if(meaning.equals("No such word")) {
				if(!modelList.isEmpty()) {
					if(!modelList.getElementAt(0).equals("")) {
						searchfield.setText(modelList.getElementAt(0));
						searchword = searchfield.getText();
					}
					else {
						searchword = searchfield.getText();
					}
				}
			}
			
			meaningarea.setText(s.dictionaryLookup(searchword));

			boolean check = true;
			if(!meaningarea.getText().equals("No such word")) {
				if(!currentListHistory.isEmpty()) {
					for(int i = 0; i < currentListHistory.size(); i++) {
						if(searchword.equals(currentListHistory.get(i).getTarget()) && meaningarea.getText().equals(currentListHistory.get(i).getMeaning()))
							check = false;
					}
				}
				if(check) {
					modelListHistory.add(0, searchword);
					Word wordtemp = new Word(searchword, meaning);
					currentListHistory.add(0, wordtemp);
				}
				if(modelListHistory.size() == 9) {
					for(int i = 8; i <= modelListHistory.size(); i++) {
						modelListHistory.removeElementAt(8);
						currentListHistory.remove(8);
					}
				}
				try {
					colorText();
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
			
			for (Word word : DictionaryArrayList.words) {
				if(searchword.equals(word.getTarget()))
					return;
				if(searchword.toLowerCase().equals(word.getTarget().toLowerCase()))
					searchfield.setText(word.getTarget());
			}
			
		}
		
		if(e.getSource() == replaceword) {
			change = true;
			replaceword.setIcon(new ImageIcon("res/tick.png"));
			searchfield.setEditable(meaningarea.isEditable());
			click.setEnabled(meaningarea.isEditable());
			speakword.setEnabled(meaningarea.isEditable());
			deleteword.setEnabled(meaningarea.isEditable());
			likeword.setEnabled(meaningarea.isEditable());
			list.setEnabled(meaningarea.isEditable());
			listlove.setEnabled(meaningarea.isEditable());
			listhistory.setEnabled(meaningarea.isEditable());
			Kind.setEnabled(meaningarea.isEditable());
			tabbedPane.setEnabled(meaningarea.isEditable());
			meaningarea.setEditable(!meaningarea.isEditable());
			
			if(!meaningarea.isEditable()) {
				replaceword.setIcon(new ImageIcon("res/repair1.png"));
				String newword = meaningarea.getText();
				String k = searchfield.getText();
				if(!newword.equals("") && !k.equals("") ) {
					s.dictionaryLookuptoReplace(newword, k);
				}
			}
		}
		
		if(e.getSource() == speakword) {
			String searchword = searchfield.getText();
			if(!searchword.equals(""))
				s.Speech(searchword);
		}
		
		if(e.getSource() == Kind) {
			if(Kind.getSelectedItem().equals("Việt - Anh")) {
				searchfield.setText("Searching ...");
				searchfield.setForeground(new Color(153,153,153));
				meaningarea.setText("");
				setKindOfdic("res/vnedict.txt");
				DictionaryArrayList.words.clear();
				DictionaryArrayList.words = new ArrayList <Word>();
				s.insertFromFile(getKindOfdic(), DictionaryArrayList.words);
				try {
					s.dictionaryExpertToFile("res/loveword.txt", currentListLove);
					s.dictionaryExpertToFile("res/history.txt", currentListHistory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				modelList.clear();
				modelListLove.clear();
				modelListHistory.clear();
				
				currentList.clear();
				currentListLove.clear();
				currentListHistory.clear();	
				s.insertFromFile("res/vnhistory.txt", DictPanel.currentListHistory);
				for (int i = 0; i < currentListHistory.size(); i++) {
					modelListHistory.addElement(currentListHistory.get(i).getTarget());
				}
				s.insertFromFile("res/vnloveword.txt", DictPanel.currentListLove);
				for (int i = 0; i < currentListLove.size(); i++) {
					modelListLove.addElement(currentListLove.get(i).getTarget());
				}
			}
			else {
				searchfield.setText("Searching ...");
				searchfield.setForeground(new Color(153,153,153));
				meaningarea.setText("");
				setKindOfdic("res/avdict.txt");
				DictionaryArrayList.words.clear();
				DictionaryArrayList.words = new ArrayList <Word>();
				s.insertFromFile(getKindOfdic(), DictionaryArrayList.words);
				try {
					s.dictionaryExpertToFile("res/vnloveword.txt", currentListLove);
					s.dictionaryExpertToFile("res/vnhistory.txt", currentListHistory);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				modelList.clear();
				modelListLove.clear();
				modelListHistory.clear();
				
				currentList.clear();
				currentListLove.clear();
				currentListHistory.clear();	
				s.insertFromFile("res/history.txt", DictPanel.currentListHistory);
				for (int i = 0; i < currentListHistory.size(); i++) {
					modelListHistory.addElement(currentListHistory.get(i).getTarget());
				}
				s.insertFromFile("res/loveword.txt", DictPanel.currentListLove);
				for (int i = 0; i < currentListLove.size(); i++) {
					modelListLove.addElement(currentListLove.get(i).getTarget());
				}
			}
		}
	}
	
	private void colorText() throws BadLocationException{
		StyledDocument doc = meaningarea.getStyledDocument();
		Style style = meaningarea.addStyle("Style", null);
		StyleConstants.setForeground(style, Color.BLACK);
		String[] meaningtext = meaningarea.getText().split("\n");
		h = meaningarea.getText();
		meaningarea.setText("");
		for (String line: meaningtext) {
			if (line.startsWith(" *")) {
				StyleConstants.setForeground(style, Color.BLUE);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
			else if (line.startsWith("No such word")) {
				StyleConstants.setForeground(style, Color.BLACK);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
			else if (line.startsWith(" =")) {
				StyleConstants.setForeground(style, Color.darkGray);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
			else if (line.startsWith(" -")) {
				StyleConstants.setForeground(style, Color.BLACK);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
			else if (line.startsWith(" /")){
				StyleConstants.setForeground(style, Color.RED);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
			else {
				StyleConstants.setForeground(style, Color.BLACK);
				doc.insertString(doc.getLength(), line + "\n", style);
			}
		}        
		
	}
	
	private Image loadImage (String path) { 
		ImageIcon imageicon = new ImageIcon (path);
		Image newImage = imageicon.getImage();
		return newImage;
	}
	public void paintComponent (Graphics g) {
		Dimension d = getSize();
		g.drawImage(loadImage("res/1.jpg"), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	void showDate () {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		date.setText("Today: " + s.format(d));
	}
	
	void showTime() {
		new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
				time.setText("Time: " + s.format(d));
			}
		}).start();
	}
}
