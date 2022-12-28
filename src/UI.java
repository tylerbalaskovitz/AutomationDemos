import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {
	Font font1 = new Font("Helvetica", Font.PLAIN, 24);
	JPanel textPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JTextArea jTextArea = new JTextArea();
	JFrame window = new JFrame();
	JButton fishingButton = new JButton();
	JButton woodCuttingButton = new JButton();
	public void createUI() {
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.blue);
		window.setTitle("Cheongi Shock");
		window.setLayout(null);
		
		textPanel.setBounds(20, 20, 400, 200);
		textPanel.setVisible(true);
		
		jTextArea.setText("Hello, welcome to Cheongi shock, an OSRS bot :) ");
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setSize(400, 200);
		jTextArea.setBackground(Color.white);
		jTextArea.setEditable(false);
		jTextArea.setVisible(true);
		jTextArea.setFont(font1);
		
		textPanel.add(jTextArea);
		
		window.add(textPanel);
		
		buttonPanel.setLayout(new GridLayout(2, 12));
		buttonPanel.setBounds(20, 300, 500, 200);
		buttonPanel.setBackground(Color.yellow);
		buttonPanel.setVisible(true);
		
		fishingButton.setText("Fishing");
		fishingButton.setBackground(Color.black);
		fishingButton.setForeground(Color.white);
		fishingButton.setBounds(20, 300, 100, 100);
		fishingButton.setActionCommand(null);
		fishingButton.setVisible(true);
		
		buttonPanel.add(fishingButton);
		
		window.add(buttonPanel);
		
		window.setVisible(true);
		
		
		
		
		
	}
	
	public void buttonConfiguration(JButton newButton, Font font, Color colorBG, Color colorFG, boolean painted, ActionListener actionHandler, String actionCommand, MouseListener mouseListener,JPanel targetPanel   ) {
		newButton.setFont(font);
		newButton.setBackground(colorBG);
		newButton.setForeground(colorFG);
		newButton.setFocusPainted(painted);
		newButton.addActionListener(actionHandler);
		newButton.setActionCommand(actionCommand);
		newButton.addMouseListener(mouseListener);
		targetPanel.add(newButton);
	}
	
}
