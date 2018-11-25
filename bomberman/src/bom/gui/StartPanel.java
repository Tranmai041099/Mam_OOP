package bom.gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel start, setting, backgroud, help;
	private GUI gui;
	
	
	public StartPanel(GUI gui) {
		setLayout(null);
		setPreferredSize(new Dimension(650, 650)); 
		this.gui = gui;
		init();
	}
	
	public void init() {
		
		backgroud = new JLabel();
		backgroud.setIcon(new ImageIcon());
		//backgroud.setBounds(0, 0, , );
		
		
		start = new JLabel();
		start.setIcon(new ImageIcon("res/START.png"));
		start.setBounds(320, 300, 300, 100);
		start.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                vocabuStartMouseClicked(evt);
            }
        });
		
		setting = new JLabel();
		setting.setIcon(new ImageIcon());
		//setting.setBounds(0, 0, , );
		
		
		help = new JLabel();
		help.setIcon(new ImageIcon());
		//help.setBounds(0, 0, , );
		
		
		add(backgroud);
		add(start);
		add(setting);
		add(help);
	}
	
	private void vocabuStartMouseClicked(MouseEvent event) {
		setVisible(false);
		gui.startGame();
	}
	
}
