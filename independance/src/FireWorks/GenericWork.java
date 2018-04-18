package FireWorks;

import java.awt.Color;
import java.util.ArrayList;

import independance.Particle;

public class GenericWork extends FireWork {

	public GenericWork(ArrayList<Particle> p, double clickX, double clickY) {
		super(p);
		for (int i = 0; i < 20; i++) {
			Particle particle = new Particle(clickX, clickY, .005, i*18, 100, Color.green);
			particles.add(particle);
			particle.start();
		}
	}

}
