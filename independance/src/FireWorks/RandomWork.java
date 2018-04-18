package FireWorks;

import java.awt.Color;
import java.util.ArrayList;

import independance.Particle;

public class RandomWork extends FireWork {

	public RandomWork(ArrayList<Particle> p, double clickX, double clickY) {
		super(p);
		Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		int charge = (int) (Math.random() * 200) + 50;
		for (int i = 0; i < 20; i++) {
			Particle particle = new Particle(clickX, clickY, .005, i * 18, charge, c);
			particles.add(particle);
			particle.start();
		}
	}
}
