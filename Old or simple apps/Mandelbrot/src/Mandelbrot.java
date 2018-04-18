import java.awt.*;
public class Mandelbrot {
	public static int width = 500;
	public static int hieght = 500;
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(width, hieght);
		Graphics g = panel.getGraphics();
	}
	public static boolean mandelbrot(double x, double y) {
		boolean a = false;
		double wide = width;
		double high = hieght;
		//double newx = (x / wide);
		//double newy = y / high;
		int i = 1;
		while (i < 1000) {
			
			i++;
		}
		return a;
	}
}
