package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modes.Blank;
import modes.Mode;

public class Panel extends JPanel {
	
	Mode currentMode;
	
	public Panel() {
		setVisible(true);
		setLayout(null);
		this.setPreferredSize(new Dimension(100, 100));
		
		currentMode = new Blank();
		setupMouseListeners();
	}
	
	private void setupMouseListeners() {
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = getRelativeCoord(e.getX(), e.getY());
				currentMode.mouseClicked(p.x, p.y);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Point p = getRelativeCoord(e.getX(), e.getY());
				currentMode.mousePressed(p.x, p.y);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Point p = getRelativeCoord(e.getX(), e.getY());
				currentMode.mouseClicked(p.x, p.y);
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			Point previousCoord = new Point(0, 0);
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getRelativeCoord(e.getX(), e.getY());
				currentMode.mouseDragged(previousCoord.x, previousCoord.y, p.x, p.y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = getRelativeCoord(e.getX(), e.getY());
				currentMode.mouseMoved(previousCoord.x, previousCoord.y, p.x, p.y);
			}
		});
	}
	
	private Point getRelativeCoord(int x, int y) {
		int xLength = currentMode.getCurrent().length;
		int yLength = currentMode.getCurrent()[0].length;
		double xRatio = (1.0 * this.getWidth() / xLength);
		double yRatio = (1.0 * this.getHeight() / yLength);
		Point p = new Point((int) (x / xRatio), (int) (y / yRatio));
		
		if (p.x < 0) p.x = 0;
		if (p.x >= xLength) p.x = xLength - 1;
		if (p.y < 0) p.y = 0;
		if (p.y >= yLength) p.y = yLength - 1;
		
		return p;
	}
	
	public void setMode(Mode m) {
		currentMode = m;
	}
	
	public void update() {
		currentMode.update();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color[][] arr = currentMode.getCurrent();
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				g.setColor(arr[x][y]);
				double xRatio = (1.0 * this.getWidth() / arr.length);
				double yRatio = (1.0 * this.getHeight() / arr[0].length);
				g.fillRect((int) (x*xRatio), (int) (y*yRatio), (int) (xRatio + 1), (int) (yRatio + 1));
			}
		}
		
		update();
	}
}
