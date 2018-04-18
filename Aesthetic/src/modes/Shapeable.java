package modes;

import java.awt.Color;

import display.Panel;

public class Shapeable implements Mode {
	
	private Col[][] map = new Col[200][200];
	
	private Col cursor;
	
	public Shapeable() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				map[x][y] = new Col(0, 0, 0);
				
			}
		}
	}
	
	@Override
	public Color[][] getCurrent() {
		Color[][] temp = new Color[map.length][map[0].length];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				Col c = map[x][y].normalize();
				temp[x][y] = new Color(c.r, c.g, c.b);
			}
		}
		return temp;
	}
	
	@Override
	public void update() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				
			}
		}
	}
	
	private void spread(int x, int y, int range) {
		int r = 0;
		Col change = map[x][y];
		while (r < range) {
			r++;
			for (int theta = 0; theta < 360; theta += 45/r) {
				int xPos = (int) (x+r*Math.cos(theta));
				int yPos = (int) (y+r*Math.sin(theta));
				if (xPos >= 0 && xPos < map.length && yPos >= 0 && yPos < map[0].length) {
					map[xPos][yPos].r += change.r / (r*2);
					map[xPos][yPos].g += change.g / (r*2);
					map[xPos][yPos].b += change.b / (r*2);
				}
			}
		}
	}
	
	private Col average(int x, int y) {
		Col average = map[x][y];
		int var = 50;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x+i >= 0 && x+i < map.length && y+j >= 0 && y+j < map[0].length) {
					average.r += (map[x+i][y+j].r / (var));
					average.g += (map[x+i][y+j].g / (var));
					average.b += (map[x+i][y+j].b  / (var));
				}
			}
		}
		
		return average;
	}

	@Override
	public void mousePressed(int x, int y) {
		cursor = new Col((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	@Override
	public void mouseMoved(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		
	}

	@Override
	public void mouseDragged(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}
	
	class Col {
		int r;
		int g;
		int b;
		
		public Col(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
		
		Col normalize() {
			int r = this.r, g = this.g, b = this.b;
			if (r < 0) r = 0;
			if (r > 255) r = 255;
			if (g < 0) g = 0;
			if (g > 255) g = 255;
			if (b < 0) b = 0;
			if (b > 255) b = 255;
			return new Col(r, g, b);
		}
		
		public String toString() {
			return "[r=" + r + ", g=" + g + ", b=" + b + "]";
		}
	}

}
