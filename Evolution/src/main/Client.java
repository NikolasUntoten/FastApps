package main;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.AbstractAction;
import javax.swing.Action;

import graphics.Display;

public class Client {
	
	public static Display display;
	public static MainPanel panel;
	public static MouseControl mouse;
	private static Map<String, Element> elements;
	private static Element selected;
	
	
	public static void main(String[] args) {
		panel = new MainPanel();
		mouse = new MouseControl();
		panel.addMouseListener(mouse);
		display = new Display(600, 600, "Evolution", panel);
		addPanelMovement();
		
		
		elements = new HashMap<String, Element>();
		selected = new Element(0, 0, 0, 0, "blank");
		
		elements.put("bill", new Element(50, 50, 100, 100, "bill"));
		
		display.start();
	}
	
	public static void select(String name) {
		
		if (name.equals("blank")) {
			selected = new Element(0, 0, -1, -1, "blank");
		}
		if (selected.name.equals(name)) {
			deselect();
			selected = new Element(0, 0, -1, -1, "blank");
		} else {
			elements.get(name).select();
			selected = elements.get(name);
		}
	}
	
	public static void deselect() {
		Client.display.removeTopOverlay();
	}
	
	public static void drawElements(Graphics g, int x, int y) {
		Iterator it = elements.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Element e = (Element) pair.getValue();
	        //System.out.println(e.toString());
	        e.draw(g, x, y);
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	    selected.drawOutline(g, x, y);
	}
	
	private static Set<Integer> pressedKeys;
	private static void addPanelMovement() {
		pressedKeys = new TreeSet<Integer>();
		display.getFrame().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				pressedKeys.add(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (pressedKeys.contains(e.getKeyCode())) {
					pressedKeys.remove(e.getKeyCode());
				}
				
			}
		});
		
		Thread movement = new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (display) {
						move();
					}
				}
			}
		};
		movement.start();
	}
	private static double dist;
	private static double diagDist;
	
	private static void move() {
		dist = .00001;
		diagDist = Math.sqrt(dist*dist/2);
		if (pressedKeys.contains(KeyEvent.VK_W)) {
			if (pressedKeys.contains(KeyEvent.VK_D)) {
				moveView(diagDist, -diagDist);
			} else if (pressedKeys.contains(KeyEvent.VK_A)) {
				moveView(-diagDist, -diagDist);
			} else {
				moveView(0, -dist);
			}
		} else if (pressedKeys.contains(KeyEvent.VK_S)) {
			if (pressedKeys.contains(KeyEvent.VK_D)) {
				moveView(diagDist, diagDist);
			} else if (pressedKeys.contains(KeyEvent.VK_A)) {
				moveView(-diagDist, diagDist);
			} else {
				moveView(0, dist);
			}
		} else {
			if (pressedKeys.contains(KeyEvent.VK_D)) {
				moveView(dist, 0);
			} else if (pressedKeys.contains(KeyEvent.VK_A)) {
				moveView(-dist, 0);
			}
		}
	}

	private static void moveView(double xDist, double yDist) {
		panel.x += xDist;
		panel.y += yDist;
		//System.out.println("check");
	}
}
