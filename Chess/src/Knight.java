import java.awt.Color;
import java.awt.Graphics;

public class Knight extends Piece {
	public Knight (boolean color) {
		super(color);
	}
	public boolean legalKill(int x1, int y1, int x2, int y2) {
		boolean legal = false;
		if (Math.abs(y2 - y1) == 2 && Math.abs(x2 - x1) == 1) {
			legal = true;
		}
		if (Math.abs(y2 - y1) == 1 && Math.abs(x2 - x1) == 2) {
			legal = true;
		}
		return legal;
	}
	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean legal = false;
		if (Math.abs(y2 - y1) == 2 && Math.abs(x2 - x1) == 1) {
			legal = true;
		}
		if (Math.abs(y2 - y1) == 1 && Math.abs(x2 - x1) == 2) {
			legal = true;
		}
		return legal;
	}
	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		super.draw(x, y, g, c, c2);
		g.fillRect(x+=5, y, 10, 5);
		g.fillRect(x, y+=5, 30, 5);
		g.fillRect(x-=5, y+=5, 20, 20);
		g.fillRect(x+=20, y+=5, 20, 10);
		g.fillRect(x, y+=10, 15, 5);
		g.fillRect(x+=5, y-=15, 20, 5);
		g.fillRect(x+=10, y+=5, 15, 10);
		g.fillRect(x-=30, y+=15, 25, 5);
		g.fillRect(x+=5, y+=5, 25, 5);
		g.fillRect(x, y+=5, 30, 5);
		g.fillRect(x-=5, y+=5, 40, 5);
	}
}	
