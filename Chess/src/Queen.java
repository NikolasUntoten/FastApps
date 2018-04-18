import java.awt.Color;
import java.awt.Graphics;

public class Queen extends Piece {
	public Queen (boolean color) {
		super(color);
	}
	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean legal = false;
		if (x1 == x2 && y1 != y2) {
			legal = true;
		}
		if (x1 != x2 && y1 == y2) {
			legal = true;
		}
		if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
			legal = true;
		}
		if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			legal = true;
		}
		return legal;
	}
	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		super.draw(x, y, g, c, c2);
		g.fillRect(x+=10, y+=5, 5, 5);
		g.fillRect(x+=10, y, 10, 5);
		g.fillRect(x+=15, y, 5, 5);
		g.fillRect(x-=20, y+=5, 20, 10);
		g.fillRect(x+=5, y+=10, 10, 20);
		g.fillRect(x-=5, y+=20, 20, 5);
		g.fillRect(x-=5, y+=5, 30, 5);
	}
}
