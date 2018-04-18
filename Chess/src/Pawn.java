import java.awt.*;
import java.util.*;

public class Pawn extends Piece {
	public Pawn(boolean color) {
		super(color);
	}
	
	public boolean legalKill(int x1, int y1, int x2, int y2) {
		boolean color = super.isBlack;
		boolean legal = false;
		if (color && y2-y1 == 1 && x2-x1 == 1) {
			legal = true;
		}
		
		if (y2-y1 == 1 && x2-x1 == 1 || y2-y1 == 1 && x1-x2 == 1) {
			legal = true;
		} else if(y1-y2 == 1 && x2-x1 == 1 || y1-y2 == 1 && x2-x1 == -1 ) {
			legal = true;
		}
		return legal;
	}

	public boolean legalMove(int x1, int y1, int x2, int y2) {
		boolean color = super.isBlack;
		boolean legal = false;
		if (color && y1 == 1 && y2 - y1 <= 2 && x1 == x2) {
			legal = true;
		}
		if (color && y2-y1 == 1 && x1 == x2) {
			legal = true;
		}
		if (!color && y1 == 6 && y1 - y2 <= 2 && x1 == x2) {
			legal = true;
		}
		if (!color && y1 - y2 == 1 && x1 == x2) {
			legal = true;
		}
		return legal;
	}

	public void draw(int x, int y, Graphics g, Color c, Color c2) {
		super.draw(x, y, g, c, c2);
		g.fillRect(x + 20, y + 10, 10, 5);
		g.fillRect(x + 15, y + 15, 20, 10);
		g.fillRect(x + 20, y + 25, 10, 10);
		g.fillRect(x + 15, y + 35, 20, 10);
		g.fillRect(x + 10, y + 45, 30, 5);
	}
}