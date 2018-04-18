package modes;

import java.awt.Color;

public class Blank implements Mode {
	
	private int[][] map = new int[200][200];
	
	int count = 0;
	@Override
	public void update() {
		if (count > 20) {
			count = 0;
			map[map.length/2][map[0].length/2] = 1000000;
		}
		count++;
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				map[x][y] = average(x, y) ;//+ (int) (Math.random() * 20);
			}
		}
	}
	
	private int average(int x, int y) {
		int average = 0;
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x+i >= 0 && x+i < map.length && y+j >= 0 && y+j < map[0].length) {
					average = (map[x+i][y+j] + average*count) / (count+1);
					count++;
				}
			}
		}
		
		return average;
	}

	@Override
	public Color[][] getCurrent() {
		Color[][] temp = new Color[map.length][map[0].length];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				int num = map[x][y] % 255;
				//num = (int) (((1 / (1 + Math.pow(Math.E, -num/100))) - 0.5) * 255);
				
				temp[x][y] = new Color(num, num, num);
			}
		}
		return temp;
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
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
		map[x][y] = 1000000;
	}

	@Override
	public void mouseDragged(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}
	
}
