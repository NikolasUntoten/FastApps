package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modes.*;

public class Main extends JFrame {

	public static final long FRAMES_PER_SECOND = 25;
	
	private Panel panel;

	public static void main(String[] args) {

		JFrame f = new Main();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					f.revalidate();
					f.repaint();
					try {
						this.sleep(1000 / FRAMES_PER_SECOND);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public Main() {
		super("Aesthetic");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		Mode m = new Shapeable();
		panel = new Panel();
		this.add(panel, BorderLayout.CENTER);
		
		ModeChooser chooser = new ModeChooser();
		this.add(chooser, BorderLayout.SOUTH);
	}

	class ModeChooser extends JPanel {
		public ModeChooser() {
			setVisible(true);
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.setPreferredSize(new Dimension(1000, 300));
			
			this.add(new ModeChoice(new Blank(), "Blank"));
			this.add(new ModeChoice(new Shapeable(), "Shapeable"));
			this.add(new ModeChoice(new Functions(), "Functions"));
		}
	}

	class ModeChoice extends JButton {
		public ModeChoice(Mode m, String name) {
			super(name);
			this.setPreferredSize(new Dimension(400, 300));
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.setMode(m);
				}
			});
		}
	}
}
