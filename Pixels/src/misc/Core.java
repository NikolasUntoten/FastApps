package misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Core {
	public static Pixel[][] world = new Pixel[1000][1000];
	public static JFrame frame;
	public static JPanel panel;
	private static Pixel myPixel;
	private static Cluster myCluster;
	private static HashMap<Integer, Pixel> pixelMap;

	public static void main(String[] args) throws LineUnavailableException {
		/*pixelMap = new HashMap<Integer, Pixel>();
		
		setUpFrame();
		setUpPanel();
		populateWorld();
//		byte r = 127;
//		byte g = 127;
//		byte b = 127;
//		myPixel = new Pixel(500, 500, r, g, b);
//		world[myPixel.x][myPixel.y] = myPixel;
		createCluster();
		checkSize();
		startRefresh();
		startControls();*/
		//HashMap2D<Integer, Integer, String> c = new HashMap2D<Integer, Integer, String>();
		PointMap<String> c = new PointMap<String>();
		/*int size = 10;
		System.out.println("Generating Map");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				c.put(i, j, i + ", " + j);
			}
		}
		System.out.println("Starting search");
		int length = 10;
		long[] arr = new long[length];
		long totalDur = 0;
		c.get(size / 2, size / 2);
		c.get((int) (Math.random() * size), (int) (Math.random() * size));
		for (int i = 0; i < length; i++) {
			long startTime = System.nanoTime();
		
			c.get((int) (Math.random() * size), (int) (Math.random() * size));
		
			long endTime = System.nanoTime();
		
			long duration = (endTime - startTime);
			//System.out.println(duration);
			totalDur += duration;
		}
		
		totalDur /= arr.length;
		System.out.println("Finished Search. Average time over " + length + " iterations: " + totalDur);
		*/
		c.put(1, 1, "ayyy");
		c.put(1, 3, "lmaoy");
		c.load(1, 1);
		c.load(1, 3);
		System.out.println(c.toString());
	    c.saveMap();
		
	}
	//1000 2Dhashmap = 15,800 ns, 510,000 i (TRUE: ~2,500)
	//1000 pointTreeMap = 11,000 ns, 480,000 i (TRUE: ~3,000)
	//1000 pointHashMap = 9,500 ns, 660,000 i (TRUE: ~1,500)
	private static void createCluster() {
		myCluster = new Cluster(200, 200);
		for (int row = 0; row < 200; row++) {
			for (int col = 0; col < 200; col++) {
				byte r = 127;
				byte g = 127;
				byte b = 127;
				Pixel p = new Pixel(row, col, r, g, b);
				myCluster.addPixel(p);
				world[row][col] = p;
			}
		}
	}
	
	private static void startControls() {
		InputMap inMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap acMap = panel.getActionMap();
		Action moveLeft = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				myCluster.move(-1, 0);
				
			}
		};
		Action moveRight = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				myCluster.move(1, 0);
			}
		};
		Action moveUp = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				myCluster.move(0, -1);
				
			}
		};
		Action moveDown = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				myCluster.move(0, 1);
			}
		};
		
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "move left");
		acMap.put("move left", moveLeft);
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "move right");
		acMap.put("move right", moveRight);
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "move up");
		acMap.put("move up", moveUp);
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "move down");
		acMap.put("move down", moveDown);
	}

	private static void populateWorld() {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				byte r = -127;
				byte g = 127;
				byte b = -127;
				world[i][j] = new Pixel(i, j, r, g, b);
			}
		}
		
	}

	private static void startRefresh() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					frame.revalidate();
					frame.repaint();
					try {
						sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
	
	private static void checkSize() {
		try {
			System.out.println(serialize(world).length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void setUpFrame() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1016, 1038);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private static void setUpPanel() {
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				BufferedImage buffer = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
				for (int row = 0; row < 1000; row++) {
					for (int col = 0; col < 1000; col++) {
						Pixel pixel = world[row][col];
						if (pixel != null) {
							Color c = new Color(pixel.r + 127, pixel.g + 127, pixel.b + 127);
							buffer.setRGB(row, col, c.getRGB());
						}
					}
				}
				g.drawImage(buffer, 0, 0, 1000, 1000, null);
			}
		};
		panel.setLayout(null);
		frame.add(panel);
	}

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		return baos.toByteArray();
	}
}
