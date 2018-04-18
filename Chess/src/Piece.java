import java.awt.Color;
import java.awt.Graphics;

public abstract class Piece {
	boolean isBlack;
	private int x = this.x;
	private int y = this.y;
	public Piece (boolean color) {
		isBlack = color;
	}
	public void move() {
		
	}
	public String toString() {
		String information = (this.getClass().getName() + " " + isBlack);
		return information;
	}
	public boolean legalKill(int x1, int y1, int x2, int y2) {
		boolean legal = true;
		return legal;
	}
	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean legal = true;
		return legal;
	}
	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		if (isBlack) {
			g.setColor(c);
		} else {
			g.setColor(c2);
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
