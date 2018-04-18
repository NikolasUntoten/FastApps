package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class MouseControl implements MouseListener {
	
	List<Area> areas;
	
	public MouseControl() {
		areas = new ArrayList<Area>();
	}
	
	public void addArea(int x, int y, int width, int height, String name) {
		areas.add(new Area(x, y, width, height, name));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (Area a : areas) {
			if (a.contains(e.getX() + (int) Client.panel.x, e.getY() + (int) Client.panel.y)) {
				Client.select(a.name);
				return;
			}
		}
		Client.select("blank");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private class Area {
		int x;
		int y;
		int width;
		int height;
		String name;
		
		public Area(int initX, int initY, int initWidth, int initHeight, String initName) {
			x = initX;
			y = initY;
			width = initWidth;
			height = initHeight;
			name = initName;
		}
		
		public boolean contains(int x, int y) {
			if (x < this.x || y < this.y) {
				return false;
			}
			if (x > this.x + width || y > this.y + height) {
				return false;
			}
			return true;
		}
	}
}


