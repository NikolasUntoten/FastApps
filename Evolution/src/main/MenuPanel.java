package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	public int width = 100;
	public int height = 200;
	private Element parent;
	public MenuPanel(Element elem) {
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, Client.panel.width, Client.panel.height);
		parent = elem;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(parent.x - (int) Client.panel.x, parent.y - (int) Client.panel.y - height, width, height);
	}
}
