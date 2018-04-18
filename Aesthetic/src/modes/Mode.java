package modes;

import java.awt.Color;

import display.Panel;

public interface Mode {
	
	public void mousePressed(int x, int y);
	
	public void mouseMoved(int x0, int y0, int x1, int y1);
	
	public void mouseDragged(int x0, int y0, int x1, int y1);
	
	public void mouseReleased(int x, int y);
	
	public void mouseClicked(int x, int y);
	
	public void update();
	
	public Color[][] getCurrent();
}
