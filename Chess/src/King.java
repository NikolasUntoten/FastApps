import java.awt.Color;
import java.awt.Graphics;

public class King extends Piece {
	public King (boolean color) {
		super(color);
	}
	public boolean legalKill(int x1, int y1, int x2, int y2) {
		boolean legal = false;
		if (Math.abs(x2-x1) <= 1 && Math.abs(y2 - y1) <= 1) {
			legal = true;
		}
		return legal;
	}
	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean legal = false;
		if (Math.abs(x2-x1) <= 1 && Math.abs(y2 - y1) <= 1) {
			legal = true;
		}
		return legal;
	}
	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		super.draw(x, y, g, c, c2);
		g.fillRect(x+=20, y, 10, 40);
		g.fillRect(x-=10, y+=10, 30, 10);
		g.fillRect(x+=5, y+=30, 20, 5);
		g.fillRect(x-=5, y+=5, 30, 5);
	}
}
