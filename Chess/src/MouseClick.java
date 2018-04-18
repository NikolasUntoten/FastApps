import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

public class MouseClick implements MouseInputListener {
	int x1;
	int y1;
	int x2;
	int y2;
	boolean isPressed = false;
	public boolean pressed() {
		return isPressed;
	}
	public Point pos1() {
		Point p1 = new Point(x1, y1);
		return p1;
	}
	public Point pos2() {
		Point p2 = new Point(x2, y2);
		return p2;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		isPressed = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		isPressed = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}