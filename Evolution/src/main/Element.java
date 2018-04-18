package main;

import java.awt.Color;
import java.awt.Graphics;

public class Element {
	
	public int x;
	public int y;
	public int width;
	public int height;
	public String name;
	private MenuPanel menu;
	
	public Element(int initX, int initY, int initWidth, int initHeight, String initName) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
		name = initName;
		Client.mouse.addArea(x, y, width, height, name);
	}
	
	public String toString() {
		return name + " at (" + x + ", " + y + ")";
	}
	
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.blue);
		g.fillRect(this.x - x, this.y - y, width, height);
	}
	
	public void drawOutline(Graphics g, int x, int y) {
		g.setColor(Color.YELLOW);
		g.drawRect(this.x - x, this.y - y, width, height);
	}
	
	public void select() {
		Client.display.addOverlay(new MenuPanel(this));
	}
}
