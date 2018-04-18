package modes;

import java.awt.Color;

public class Functions implements Mode {
	
	private static final double TICK_RATE = 0.1;
	
	private static final int TABLE_WIDTH = 200;
	private static final int TABLE_HEIGHT = 200;
	
	private double time;
	
	private Function red;
	private Function green;
	private Function blue;
	
	public Functions() {
		time = 0;
		red = new Function();
		green = new Function();
		blue = new Function();
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int x0, int y0, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		time += TICK_RATE;
		
	}

	@Override
	public Color[][] getCurrent() {
		Color[][] table = new Color[TABLE_WIDTH][TABLE_HEIGHT];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				table[i][j] = getCurrentColor(i, j);
			}
		}
		return table;
	}
	
	private Color getCurrentColor(int x, int y) {
		int r = red.get(time, x, y);
		int g = red.get(time, x, y);
		int b = red.get(time, x, y);
		return new Color(r, g, b);
	}
	
	/*
	 * A function of multiple Sine waves with random rates, added together and then scaled to within RGB scale (256)
	 * this function has three inputs and one output.
	 */
	class Function {
		private static final int MAX_REPS = 5;
		private static final double RATE_RANGE = 0.5;
		private static final double COE_RANGE = 10;
		
		//number of sine functions added to function
		private int reps;
		
		//rate for each sine function (i.e. sin(rate*time))
		private double[] rates;
		
		private double[] coefficients;
		
		//randomly initialize reps and rates
		public Function() {
			
			reps = (int) (Math.random() * MAX_REPS) + 1;
			
			rates = new double[reps];
			coefficients = new double[reps];
			
			for (int i = 0; i < reps; i++) {
				rates[i] = Math.random() * RATE_RANGE;
				coefficients[i] = Math.random() * COE_RANGE;
			}
			
		}
		
		public int get(double time, int x, int y) {
			double answer = 0;
			double totalCoe = 0;
			
			for (int i = 0; i < reps; i++) {
				answer += coefficients[i] * Math.sin(time + x*rates[i]);
				answer += coefficients[i] * Math.sin(time + y*rates[i]);
				totalCoe += coefficients[i];
			}
			
			answer = answer / (totalCoe * reps * 2); //scale to between -1 and 1
			answer += 1; //move to between 0 and 2
			answer *= 0.5; //scale to between 0 and 1
			answer *= 256; //scale to between 0 and 256
			return (int) (answer);
		}
	}
}
