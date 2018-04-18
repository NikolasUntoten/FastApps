package independance;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import FireWorks.FireWork;
import FireWorks.GenericWork;
import FireWorks.RainBowWork;
import FireWorks.RandomWork;

public class JulyFourth {
	public static final double gravity = -.00004;
	public static JFrame frame;
	public static Panel panel;
	
	public static void main(String[] args) {
		setupFrame();
		setupPanel();
		//wat();
		playerControl();
	}
	
	private static void playerControl() {
		MouseClick mouse = new MouseClick();
		panel.addMouseListener(mouse);
		while(true) {
			synchronized (mouse) {
				try {
					mouse.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			Leadup l = new Leadup(mouse.clickX, mouse.clickY, 3);
			panel.addLeadup(l);
			l.start();
			int type = (int) (Math.random() * 2);
			/*switch(type) {
			case 0: panel.addFireWork(new RainBowWork(new ArrayList<Particle>(), mouse.clickX, mouse.clickY));
				break;
			case 1: panel.addFireWork();
				break;
			default: panel.addFireWork(new GenericWork(new ArrayList<Particle>(), mouse.clickX, mouse.clickY));
				break;
			}*/
		}
	}
	
	private static void setupFrame() {
		frame = new JFrame("HAPPY 4TH");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Refresh r1 = new Refresh();
		r1.start();
	}
	
	private static void setupPanel() {
		panel = new Panel();
		frame.add(panel);
	}
	private static void wat() {
		while (true) {
			panel.addFireWork(new RainBowWork(new ArrayList<Particle>(), Math.random() * 2000, Math.random() * 1000));
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("\"wat\" sleep is the problem");
				e.printStackTrace();
			}
		}
	}
}
