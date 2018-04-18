import java.util.*;
public class Distance {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
			System.out.println("Input numbers x1 y1 x2 y2)");
			int x1 = console.nextInt();
			int y1 = console.nextInt();
			int x2 = console.nextInt();
			int y2 = console.nextInt();
			double dist = distance(x1, y1, x2, y2);
			System.out.println(dist);
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		double dist;
		double xDist = Math.pow(x2-x1, 2);
		double yDist = Math.pow(y2-y1, 2);
		dist = Math.sqrt(xDist + yDist);
		return dist;
	}
}
