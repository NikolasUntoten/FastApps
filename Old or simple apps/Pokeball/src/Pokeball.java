
public class Pokeball {
	public static void main(String[] args) {
		space(0);
		space(2);
		sign(-1);
		System.out.println();
		for(int x = 1; x < 4; x += 1){
			space(x);
			sign(x);
			System.out.println();
		}
		line();
		System.out.print("{\"\"\"\"\"}");
		line();
		System.out.println();
		line();
		System.out.print("{.....}");
		line();
		System.out.println();
		for (int x = 0; x<4; x+=1) {
			oSign(x);
		}
	}
	public static void space(int a) {
		for(int s = 4; s > 1 + a; s -= 1) {
		System.out.print(" ");
		}
	}
	public static void sign(int l) {
		for(int b = 1; b < 10 + l*2; b += 1) {
			System.out.print("@");
		}
	}
	public static void line() {
		for(int x = 1; x < 5; x += 1) {
			System.out.print("|");
		}
	}
	public static void oSign(int l) {
		for(int x = l; x>0; x -= 1) {
			System.out.print(" ");
		}
		for(int b = 16 - l*2; b > 1; b -= 1) {
			System.out.print("O");
		}
		System.out.println();
	}
}
