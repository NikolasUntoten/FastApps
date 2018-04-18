package misc;

import java.util.*;

public class Cluster {
	private Pixel[][] pixels;
	private int width;
	private int height;
	public Cluster(int width, int height) {
		pixels = new Pixel[width][height];
		this.width = width;
		this.height = height;
	}
	
	public void addPixel(Pixel p) {
		pixels[p.x][p.y] = p;
	}
	//I am so sorry for this bad code but i am lazy
	public void move(int deltaX, int deltaY) {
		if (deltaX > 0) {
			for (int i = width; i > 0; i--) {
				if (deltaY > 0) {
					for (int j = height; j > 0; j--) {
						pixels[i][j].move(deltaX, deltaY);
					}
				} else {
					for (int j = 0; j < height; j++) {
						pixels[i][j].move(deltaX, deltaY);
					}
				}
			}
		} else {
			for (int i = 0; i < width; i++) {
				if (deltaY > 0) {
					for (int j = height; j > 0; j--) {
						pixels[i][j].move(deltaX, deltaY);
					}
				} else {
					for (int j = 0; j < height; j++) {
						pixels[i][j].move(deltaX, deltaY);
					}
				}
			}
		}
	}
}
