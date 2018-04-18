package main;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	public int width = 500;
	public int height = 500;
	public double x;
	public double y;
	public MainPanel() {
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, width, height);
		x = 0;
		y = 0;
	}
	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("tesT");
		g.fillRect(0, 0, width, height);
		Client.drawElements(g, (int) x, (int) y);
	}
}
