package independance;

public class Refresh extends Thread {
	public void run() {
		try {
			while (true) {
				JulyFourth.frame.getContentPane().validate();
				JulyFourth.frame.getContentPane().repaint(); 
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted");
		}
	}
}
