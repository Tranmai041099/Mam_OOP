package DictionaryGraphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
@SuppressWarnings("serial")
public class DictPanel1 extends JPanel implements ActionListener{
     	
	private JTextField searchfield;
	private JTextArea meaningarea;
	//private JTextArea historyarea;
	private JTextArea lovewordarea;
	private JButton click;
	private JButton speakword;
	private JButton deleteword;
	private JButton replaceword;
	private JButton likeword;
	private JList<String> list;
	private List<Word1> currentList;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	
	private DictionaryManagement1 s = new DictionaryManagement1();
	
	public DictPanel1() {
		setLayout(null);
		initPanel();
		initSearchingBox();
	}
	
	private void initPanel() {
		
		setPreferredSize(new Dimension(500, 450)); //cai dat size cho Panel
		this.setBackground(new Color(200,200,250));
		this.setAutoscrolls(false);
	}
	
	private void initSearchingBox() {
		
		//ImageIcon imageicon = new ImageIcon ();
		searchfield = new JTextField();
		meaningarea = new JTextArea(5,30);
		//historyarea = new JTextArea(5,30);
		lovewordarea = new JTextArea(5,30);
		click = new JButton("C");
		replaceword = new JButton("R");
		speakword = new JButton();
		deleteword = new JButton("X");
		likeword = new JButton("L");
		list = new JList<String>();
		currentList = new LinkedList<>();

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
		
		meaningarea.setBounds(5,122,355,335);
		meaningarea.setEditable(false);
		meaningarea.setLineWrap(true);
		meaningarea.setWrapStyleWord(true);
		//meaningarea.setBackground(new Color(140,240,250));
		
		list.setBounds(370,160,130,170);
		list.setModel(model);
		list.setAutoscrolls(true);
		list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vocabuListMouseClicked(evt);
            }
        });
//		historyarea.setBounds(365,157,140,180);
	//	historyarea.setEditable(false);
		//historyarea.setBackground(new Color(140,100,100));

        
		lovewordarea.setBounds(365,337,140,120);
		lovewordarea.setEditable(false);
		//lovewordarea.setBackground(new Color());
		
		click.addActionListener(this);
		click.setBounds(365,85,35,35);
		
		speakword.setBounds(365,122,35,35);
		
		deleteword.setBounds(400,122,35,35);
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
		
		likeword.setBounds(470,122,35,35);
		
		add(searchfield);
		add(meaningarea);
		//add(historyarea);
		add(lovewordarea);
		add(click);
		add(replaceword);
		add(speakword);
		add(deleteword);
		add(likeword);
		add(list);
		
	}
	private void vocabuListMouseClicked(java.awt.event.MouseEvent event) {
        int id = list.getSelectedIndex();
        if(id==-1) return;
        Word1 w = currentList.get(id);
        searchfield.setText(w.getTarget());
        meaningarea.setText(w.getMeaning());
	}
	
	private void searchfieldFocusGained(FocusEvent evt) {
        if(searchfield.getText().equals("Searching ..."))
        {
            searchfield.setText("");
        }
        searchfield.setForeground(Color.black);
	}
	private void searchfieldFocusLost(FocusEvent evt) {
        if(searchfield.getText().equals(""))
        {
            searchfield.setText("Searching ...");
        }
        if(searchfield.getText().equals("Searching ...")) {
        	searchfield.setForeground(new Color(153,153,153)); 
        }
   }
	
	private void deletedActionPerformed(ActionEvent evt) {
        Icon icon = null;
        int exit =  JOptionPane.showConfirmDialog(getRootPane(), "bạn có muốn xóa từ? ","Thông báo!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
        if(exit == JOptionPane.YES_OPTION){  
            System.exit(0);
        }
	}

	public void searcher() {

		String searchword = searchfield.getText();
		if(searchword.equals(""))
			return;
		model.clear();
		currentList.clear();
		int limit = 8;
		if(DictionaryArray.words.isEmpty()) {
			System.out.println("null");
			return;
		}
		for (Word1 word : DictionaryArray.words){
			if(limit == 0) break;
			if(word.getTarget().startsWith(searchword)) {
				limit --;
				model.addElement(word.getTarget());
				currentList.add(word);
			}	
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchfield || e.getSource() == click) {
			String searchword = searchfield.getText();
			meaningarea.setText(s.dictionaryLookup(searchword));
			//historyarea.setText(searchword + "\n" + historyarea.getText());
		}
		
		if(e.getSource() == replaceword) {
			searchfield.setEditable(meaningarea.isEditable());
			click.setEnabled(meaningarea.isEditable());
			speakword.setEnabled(meaningarea.isEditable());
			deleteword.setEnabled(meaningarea.isEditable());
			likeword.setEnabled(meaningarea.isEditable());
			meaningarea.setEditable(!meaningarea.isEditable());
			
			if(!meaningarea.isEditable()) {
				String newword = meaningarea.getText();
				String h = searchfield.getText();
				s.dictionaryLookup1(newword, h);
				try {
					s.replaceFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	/*private Image loadImage (String path) { //lay hinh anh tu path(duong dan)
		ImageIcon imageicon = new ImageIcon (path);
		Image newImage = imageicon.getImage();
		return newImage;
	}*/
	
}
