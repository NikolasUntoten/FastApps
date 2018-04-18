package independance;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Particle extends Thread {
	public Color color;
	public double x;
	public double y;
	public double velocityX;
	public double velocityY;
	public int charge;
	public int initCharge;
	protected ArrayList<TrailParticle> trail;

	public Particle(double x, double y, double vel, double theta, int charge, Color c) {
		this.x = x;
		this.y = y;
		velocityX = vel * Math.cos(theta * (Math.PI / 180));
		velocityY = -1 * vel * Math.sin(theta * (Math.PI / 180));
		color = c;
		this.charge = charge;
		initCharge = charge;
		trail = new ArrayList<TrailParticle>();
	}

	public void drawParticle(Graphics g) {
		g.setColor(color);
		g.drawLine((int) x, (int) y, (int) (x - (velocityX * charge)), (int) (y - (velocityY * charge)));
		for (int i = 0; i < trail.size(); i++) {
			TrailParticle tp = trail.get(i);
			if (tp != null) {
				if (tp.timeOut <= 0) {
					trail.remove(tp);
				} else {
				tp.draw(g);
				}
			}
		}
	}

	public void run() {
		for (int i = 0; i < charge; i++) {
			trail.add(new TrailParticle(x, y, initCharge, color));
			x += velocityX * charge;
			y += velocityY * charge;
			velocityY -= JulyFourth.gravity;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Particle run is the problem");
				e.printStackTrace();
			}
		}
		x = -200;
		y = -200;
	}
}
