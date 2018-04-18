package independance;

import java.awt.Color;
import java.awt.Graphics;

public class TrailParticle {
	public double x;
	public double y;
	public int timeOut = 0;
	public Color color;

	public TrailParticle(double x, double y, int time, Color color) {
		this.x = x;
		this.y = y;
		timeOut = time;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, 1, 1);
		timeOut -= 20;
	}
}
