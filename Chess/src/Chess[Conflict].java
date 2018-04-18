import java.awt.*;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Chess extends Pieces implements MouseListener {
	private static Board board;

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(550, 450);
		Graphics g = panel.getGraphics();
		Color c = Color.red;
		Color c2 = Color.blue;
		int x = 0;
		int y = 0;
		boardSetup(g);
		Scanner console = new Scanner(System.in);
		board = new Board();
		Piece[][] board2 = board.boardReturn();
		refreshBoard(g, c, c2, board2);
		// Point p = new Point(x, y);
		int s = 50;
		System.out.println("Coordinate Choices: Letters a-h for x, numbers 1-8 for y");
		System.out.println("Formula: '[x][y] to [new x][new y]'");
		System.out.println("You can also type '[x][y] kill [new x][new y]' to take an opponent's piece.");
		boolean end = true;
		while (end) {
			System.out.println("Choice? (Type \"Quit\" to quit)");
			String input = console.nextLine();
			if (input.substring(3, 5).equals("to")) {
				movePiece(input, g, board2, c, c2);
			} else if (input.substring(3, 7).equals("kill")) {
				killPiece(input, g, board2, c, c2);
			} else {
				System.out.println("An error occured");
			}
			refreshBoard(g, c, c2, board2);
			if (input.equals("quit") || input.equals("Quit")) {
				end = false;
			}
		}
	}

	public static void killPiece(String input, Graphics g, Piece[][] board2, Color c, Color c2) {
		int x1 = input.charAt(0) - 'a';
		int y1 = Integer.parseInt(input.substring(1, 2)) - 1;
		int x2 = input.charAt(8) - 'a';
		int y2 = Integer.parseInt(input.substring(9, 10)) - 1;
		Piece current = board2[x1][y1];
		Piece killedPiece = board2[x2][y2];
		if (killedPiece == null) {
			System.out.println("No piece to kill");
		} else {
			if (current == null || x1 > 8 || x2 > 8 || y1 > 8 || y2 > 8) {
				System.out.println("Sorry, no piece there");
			} else if (current.legalKill(x1, y1, x2, y2)) {
				board2[x1][y1] = null;
				drawTile(x1 * 50 + 25, y1 * 50 + 25, g);
				board2[x2][y2] = null;
				drawTile(x2 * 50 + 25, y2 * 50 + 25, g);
				board2[x2][y2] = current;
				current.draw(x2 * 50 + 25, y2 * 50 + 25, g, c, c2);
			} else {
				System.out.println("Illegal Move");
			}
		}

	}

	public static void movePiece(String input, Graphics g, Piece[][] board2, Color c, Color c2) {
		int x1 = input.charAt(0) - 'a';
		int y1 = Integer.parseInt(input.substring(1, 2)) - 1;
		int x2 = input.charAt(6) - 'a';
		int y2 = Integer.parseInt(input.substring(7, 8)) - 1;

		Piece current = board2[x1][y1];
		if (current == null || x1 > 8 || x2 > 8 || y1 > 8 || y2 > 8) {
			System.out.println("Sorry, no piece there");
		} else if (current.legalMove(x1, y1, x2, y2)) {
			board2[x1][y1] = null;
			drawTile(x1 * 50 + 25, y1 * 50 + 25, g);
			board2[x2][y2] = current;
			current.draw(x2 * 50 + 25, y2 * 50 + 25, g, c, c2);
		} else {
			System.out.println("Illegal Move");
		}
	}

	public static void refreshBoard(Graphics g, Color c, Color c2, Piece[][] board2) {
		int a = 25;
		int b = 25;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				Piece current = board2[y][x];
				if (current == null) {
					drawTile(a, b, g);
				} else {
					current.draw(a, b, g, c, c2);
				}
				a += 50;
			}
			a = 25;
			b += 50;
		}
	}

	public static void drawTile(int x, int y, Graphics g) {
		int xTest = ((x - 25) % 100) / 10;
		int yTest = ((y - 25) % 100) / 10;
		if (xTest == 5 && yTest == 5) {
			g.setColor(Color.black);
			g.fillRect(x, y, 50, 50);
		}
		if (xTest == 5 && yTest == 0) {
			g.setColor(Color.white);
			g.fillRect(x, y, 50, 50);
		}
		if (xTest == 0 && yTest == 0) {
			g.setColor(Color.black);
			g.fillRect(x, y, 50, 50);
		}
		if (xTest == 0 && yTest == 5) {
			g.setColor(Color.white);
			g.fillRect(x, y, 50, 50);
		}
	}

	public static void boardSetup(Graphics g) {
		drawBorder(g);
		int x = 25;
		int y = 25;
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				int newX = x + b * 50;
				int newY = y + a * 50;
				drawTile(newX, newY, g);
			}
		}
	}

	public static int coordPosX(String a) {
		int x = (a.charAt(0) - 'a');
		return x;
	}

	public static int coordPosY(String a) {
		int y = Integer.parseInt(a.substring(1, 2)) - 1;
		return y;
	}

	public static int coordX(String a) {
		int x = (a.charAt(0) - 'a') * 50 + 25;
		return x;
	}

	public static int coordY(String a) {
		int y = Integer.parseInt(a.substring(1, 2)) * 50 - 25;
		return y;
	}

	public static void rect(int x, int y, Graphics g, int s) {
		g.fillRect(x, y, s, s);
	}

	public static void drawBorder(Graphics g) {
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		g.setColor(Color.gray);
		g.fillRect(0, 0, 450, 25);
		g.fillRect(0, 0, 25, 450);
		g.fillRect(425, 0, 25, 450);
		g.fillRect(0, 425, 450, 25);
		g.setColor(Color.BLACK);
		g.drawString("A", 40, 23);
		g.drawString("B", 90, 23);
		g.drawString("C", 140, 23);
		g.drawString("D", 190, 23);
		g.drawString("E", 240, 23);
		g.drawString("F", 290, 23);
		g.drawString("G", 340, 23);
		g.drawString("H", 390, 23);
		g.drawString("1", 3, 60);
		g.drawString("2", 3, 110);
		g.drawString("3", 3, 160);
		g.drawString("4", 3, 210);
		g.drawString("5", 3, 260);
		g.drawString("6", 3, 310);
		g.drawString("7", 3, 360);
		g.drawString("8", 3, 410);
	}

	public void mouseDetector(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		System.out.println(xPos + ", " + yPos);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		System.out.println(xPos + ", " + yPos);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}