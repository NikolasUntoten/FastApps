package independance;

import java.awt.Color;
import java.util.ArrayList;

import FireWorks.FireWork;
import FireWorks.RandomWork;

public class Leadup extends Thread {
	private double endX;
	private double endY;
	public double x = Math.random() * 500;
	public double y = 500;
	private double velX;
	private double velY;
	private FireWork fireWork;
	protected ArrayList<TrailParticle> trail;

	public Leadup(double x, double y, double v) {
		endX = x;
		endY = y;
		double xDif = endX - this.x;
		double yDif = endY - this.y;
		double theta = Math.atan2(-yDif, xDif);
		velX = v * Math.cos(theta) * (theta/Math.abs(theta));
		velY = v * Math.sin(theta);
		//System.out.println(velX + ", " + velY);
		//System.out.println("XDif: " + xDif + ", yDif: " + yDif + ", theta: " + theta*180/Math.PI);
		trail = new ArrayList<TrailParticle>();
	}

	public void run() {
		boolean yWithinRange = Math.abs(y - endY) < 5;
		boolean xWithinRange = Math.abs(x - endX) < 5;
		while (!xWithinRange || !yWithinRange) {
			TrailParticle tp = new TrailParticle(x, y, 20, Color.white);
			trail.add(tp);

			if (!xWithinRange) {
				x += velX;
			}
			if (!yWithinRange) {
				y -= velY;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			yWithinRange = Math.abs(y - endY) < 2;
			xWithinRange = Math.abs(x - endX) < 2;
		}
		fireWork = new RandomWork(new ArrayList<Particle>(), endX, endY);
		JulyFourth.panel.addFireWork(fireWork);
	}

}
