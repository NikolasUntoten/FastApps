package FireWorks;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import independance.Particle;

public class RainBowWork extends FireWork {

	public RainBowWork(ArrayList<Particle> p, double clickX, double clickY) {
		super(p);
		particles = p;
		Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		int charge = (int) (Math.random() * 200) + 50;
		for (int i = 0; i < 20; i++) {
			Particle particle = new Particle(clickX, clickY, .005, i * 18, charge, c);
			particles.add(particle);
			particle.start();
		}
		Thread t = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
							(int) (Math.random() * 255));
					for (int j = 0; j < particles.size(); j++) {
						particles.get(j).color = c;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println("RainbowWork is the problem");
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}

}
