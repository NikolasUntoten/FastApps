import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
public class DrawPanel extends JPanel{
	int x = 0;
	int y = 0;
	int direction;
	//Graphics g;
	public DrawPanel() {
		super();
        setBackground(Color.WHITE);
	}
	public void turn(String t) {
		if (t == "right") {
			direction += 1;
			if (direction == 5) {
				direction = 1;
			}
		}
		if (t == "left") {
			direction -= 1;
			if (direction == 0) {
				direction = 4;
			}
		}
	}
	public void forward(int dir, int d, Graphics g) {
		if (dir == 1) {
			g.drawLine(x, y, x, y-=d);
		}
		if (dir == 2) {
			g.drawLine(x, y, x+=d, y);
		}
		if (dir == 3) {
			g.drawLine(x, y, x, y+=d);
		}
		if (dir == 4) {
			g.drawLine(x, y, x-=d, y);
		}
		//System.out.println(direction);
	}
	public void hilbert (Graphics g, int min, int d) {
		if (min <= 0) return;
		turn("left");
		curve(g, min - 1, d);
		forward(direction, d, g);
		turn("right");
		hilbert(g, min - 1, d);
		forward(direction, d, g);
		hilbert(g, min - 1, d);
		turn("right");
		forward(direction, d, g);
		curve(g, min - 1, d);
		turn("left");
	}
	public void curve (Graphics g, int min, int d) {
		if (min <= 0) return;
		turn("right");
		hilbert(g, min - 1, d);
		forward(direction, d, g);
		turn("left");
		curve(g, min - 1, d);
		forward(direction, d, g);
		curve(g, min - 1, d);
		turn("left");
		forward(direction, d, g);
		hilbert(g, min - 1, d);
		turn("right");
	}
	 public void paintComponent(Graphics g) { // draw graphics in the panel
	        int width = getWidth();             // width of window in pixels
	        int height = getHeight();           // height of window in pixels
	        System.out.println("What size would you like?");
	    	Scanner scanner = new Scanner(System.in);
	    	String input = scanner.nextLine();
	    	int size = Integer.parseInt(input);
	        int division = (int) Math.pow(2, size);
	    	int d = 512/(division);
	        super.paintComponent(g);            // call superclass to make panel display correctly
	        // Drawing code goes here
	        direction  = 3;
	        hilbert(g, size, d);
	        //System.out.println(halfd);
	        //g.drawString("Hello, World", 100, 150);
	        /*g.drawLine(99, 151, 167, 151);
	        g.drawLine(167, 151, 167, 139);
	        g.drawLine(167, 139, 99, 139);
	        g.drawLine(99, 151, 99, 139);
	        g.drawString("Hello, Hilbert", 300, 100);
	        g.drawLine(385, 100, 385, 90);
	        g.drawLine(385, 90, 375, 90);
	        g.drawLine(375, 90, 375, 100);*/
	    }
	public static void main(String[] args) {
		DrawPanel panel = new DrawPanel();
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel); 
		application.setSize(465, 487);         // window is 500 pixels wide, 400 high
        application.setVisible(true);
        application.setTitle("Hilbert Curve");
	}
}
