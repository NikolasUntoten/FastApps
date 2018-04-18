import java.awt.Color;
import java.awt.Graphics;

public class Rook extends Piece {
	public Rook (boolean color) {
		super(color);
	}
	public boolean legalKill(int x1, int y1, int x2, int y2) {
		boolean color = super.isBlack;
		boolean legal = false;
		if (x1 == x2 && y1 != y2) {
			legal = true;
		}
		if (x1 != x2 && y1 == y2) {
			legal = true;
		}
		return legal;
	}
	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean color = super.isBlack;
		boolean legal = false;
		if (x1 == x2 && y1 != y2) {
			legal = true;
		}
		if (x1 != x2 && y1 == y2) {
			legal = true;
		}
		return legal;
	}
	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		super.draw(x, y, g, c, c2);
		g.fillRect(x+=10, y+=10, 5, 5);
		g.fillRect(x+=10, y, 10, 5);
		g.fillRect(x+=15, y, 5, 5);
		g.fillRect(x-=25, y+=5, 30, 5);
		g.fillRect(x+=5, y+=5, 20, 15);
		g.fillRect(x-=5, y+=15, 30, 10);
		g.fillRect(x-=5, y+=10, 40, 5);
	}
}
