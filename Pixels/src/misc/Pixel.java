package misc;

import java.io.Serializable;

public class Pixel implements Serializable {
	public int x;
	public int y;
	public byte r;
	public byte g;
	public byte b;
	public Pixel(int x, int y, byte r, byte g, byte b) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void move(int deltaX, int deltaY) {
		Pixel temp = Core.world[x + deltaX][y + deltaY];
		Core.world[x + deltaX][y + deltaY] = this;
		Core.world[x][y] = temp;
		temp.x = x;
		temp.y = y;
		x += deltaX;
		y += deltaY;
	}
}
