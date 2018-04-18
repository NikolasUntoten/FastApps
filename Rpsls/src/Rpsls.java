import java.io.*;
import java.util.*;
import java.util.Random;
public class Rpsls {
	// 0 = Rock, 1 = Paper, 2 = Scissors, 3 = Lizard, 4 = Spock
	public static void Judge(int x, int y) {
		if (x == 0) { //rock
			if (y == 0) {
				System.out.println("TIE");
			}
			if (y == 1 || y == 4) { // Paper and Spock beat Rock
				System.out.println("I WIN");
			}
			if (y == 2 || y == 3) { // Rock beats Scissors and Lizard
				System.out.println("Aww, you win :(");
			}
		}
		if (x == 1) {
			if (y == 1) {
				System.out.println("TIE");
			}
			if (y == 2 || y == 3) {
				System.out.println("I WIN");
			}
			if (y == 0 || y == 4) {
				System.out.println("Aww, you win :(");
			}
		}
		if (x == 2) {
			if (y == 2) {
				System.out.println("TIE");
			}
			if (y == 0 || y == 4) {
				System.out.println("I WIN");
			}
			if (y == 1 || y == 3) {
				System.out.println("Aww, you win :(");
			}
		}
		if (x == 3) {
			if (y == 3) {
				System.out.println("TIE");
			}
			if (y == 0 || y == 2) {
				System.out.println("I WIN");
			}
			if (y == 1 || y == 4) {
				System.out.println("Aww, you win :(");
			}
		}
		if (x == 4) {
			if (y == 4) {
				System.out.println("TIE");
			}
			if (y == 1 || y == 3) {
				System.out.println("I WIN");
			}
			if (y == 0 || y == 2) {
				System.out.println("Aww, you win :(");
			}
			// 0 = Rock, 1 = Paper, 2 = Scissors, 3 = Lizard, 4 = Spock
		}
	}
	public static int shoot(String choice) {
		if (choice.equalsIgnoreCase("Rock")|| choice.equalsIgnoreCase("r")) {
			return 0;
		}
		if (choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("p")) {
			return 1;
		}
		if (choice.equalsIgnoreCase("Scissors") || choice.equalsIgnoreCase("s")) {
			return 2;
		}
		if (choice.equalsIgnoreCase("Lizard") || choice.equalsIgnoreCase("l")) {
			return 3;
		}
		if (choice.equalsIgnoreCase("Spock") || choice.equalsIgnoreCase("sp")) {
			return 4;
		}
		else {
			return 5;
		}
}
	public static String compChoice(int x) {
		if (x == 0) {
			return("Rock");
		}
		if (x == 1) {
			return("Paper");
		}
		if (x == 2) {
			return("Scissors");
		}
		if (x == 3) {
			return("Lizard");
		}
		if (x == 4) {
			return("Spock");
		}
		else {
			return null;
		}
	}
	public static void main(String[] args) {
		boolean end = true;
		String input = "yes";
		while (end) {
			Random rnJesus = new Random();
			Scanner scanner = new Scanner(System.in);
			System.out.print("1...");
			System.out.print("2...");
			System.out.print("3...");
			System.out.print("shoot\n");
			System.out.println("Pick One: Rock(r), Paper(p), Scissors(s), Lizard(l), Spock(sp)");
			int y = rnJesus.nextInt(5);
			String comp = compChoice(y);
			input = scanner.nextLine();
			int in = shoot(input);
			System.out.println(comp);
			Judge(in, y);
			System.out.println("Wanna play again?");
			input = scanner.nextLine();
			if (input.equals("No")) {
				end = false;
			}
		}
	}
}