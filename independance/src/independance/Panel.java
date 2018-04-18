package independance;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import FireWorks.FireWork;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<FireWork> fireWorks;
	public List<Leadup> leadups;

	public Panel() {
		fireWorks = new ArrayList<FireWork>();
		leadups = new ArrayList<Leadup>();
		setVisible(true);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 2000, 2000);
		for (int i = 0; i < fireWorks.size(); i++) {
			FireWork f = fireWorks.get(i);
			if (f.particles.size() == 0) {
				fireWorks.remove(i);
			} else {
				for (int j = 0; j < f.particles.size(); j++) {
					Particle p = f.particles.get(j);
					p.drawParticle(g);
					// g.fillRect((int) p.x, (int) p.y, 2, 2);
				}
			}
		}
		for (int i = 0; i < leadups.size(); i++) {
			Leadup l = leadups.get(i);
			if (l.trail.size() == 0) {
				leadups.remove(i);
			} else {
				for (int j = 0; j < l.trail.size(); j++) {
					TrailParticle p = l.trail.get(j);
					if (p != null) {
						if (p.timeOut <= 0) {
							l.trail.remove(j);
						} else {
							p.draw(g);
						}
					}

				}
			}
		}
	}

	public void addFireWork(FireWork f) {
		fireWorks.add(f);
	}

	public void addLeadup(Leadup l) {
		leadups.add(l);
	}
}
