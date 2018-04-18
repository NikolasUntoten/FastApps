import java.util.*;

//test 1_3/4 + 2/3
public class Calculator {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean end = true;
		String input;
		int space1Location;
		int space2Location;
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		String frac1;
		String frac2;
		int wholeNumber;
		String operator;
		String improperNumber;
		String properNumber;
		String finalNumber;
		while (end) {
			System.out.println("input your fraction now. (type \"quit\" to quit)");
			input = console.nextLine();
			if (input.equals("quit") || input.equals("Quit")) {
				end = false;
			} else if (input.indexOf(" ") == -1) {
				if (input.indexOf("_") == -1) {
					finalNumber = reduceNumberFrac(input, f1);
				} else {
					finalNumber = reduceNumberMixed(input);
				}
				System.out.println(finalNumber);
			} else {
				// breaking down the input
				space1Location = space1Location(input);
				space2Location = space1Location + 2;
				frac1 = input.substring(0, space1Location);
				frac2 = input.substring(space2Location + 1);
				operator = input.substring(space1Location + 1, space2Location);
				// where the fun begins
				frac1 = improperTest(frac1);
				frac2 = improperTest(frac2);
				if (frac1.indexOf("/") == -1) {
					wholeNumber = Integer.parseInt(frac1);
					f1.numerator = wholeNumber;
					f1.denominator = 1;
				} else {
					f1.numerator = Integer.parseInt(frac1.substring(0, frac1.indexOf("/")));
					f1.denominator = Integer.parseInt(frac1.substring(frac1.indexOf("/") + 1));
				}
				if (frac2.indexOf("/") == -1) {
					wholeNumber = Integer.parseInt(frac2);
					f2.numerator = wholeNumber;
					f2.denominator = 1;
				} else {
					f2.numerator = Integer.parseInt(frac2.substring(0, frac2.indexOf("/")));
					f2.denominator = Integer.parseInt(frac2.substring(frac2.indexOf("/") + 1));
				}
				//System.out.println(f1.numerator + "/" + f1.denominator);
				improperNumber = operation(f1, f2, operator);
				properNumber = improperToProper(improperNumber, f1);
				System.out.println(properNumber);
			}
		}
	}

	public static String reduceNumberFrac(String properNumber, Fraction f1) {
		String reducedNumber = properNumber;
		f1.numerator = Integer
				.parseInt(properNumber.substring(properNumber.indexOf("_") + 1, properNumber.indexOf("/")));
		f1.denominator = Integer.parseInt(properNumber.substring(properNumber.indexOf("/") + 1));
		for (int x = 1; x <= 10; x++) {
			if (f1.numerator % x == 0 && f1.denominator % x == 0) {
				f1.numerator /= x;
				f1.denominator /= x;
			}
		}
		if (f1.numerator > f1.denominator) {
			f1.numerator = (f1.numerator % f1.denominator);
			int remainder = f1.numerator % f1.denominator;
			int wholeNumber = f1.numerator % f1.denominator;
			reducedNumber = (wholeNumber + "_" + remainder + "/" + f1.denominator);
		} else {
			reducedNumber = (f1.numerator + "/" + f1.denominator);
		}
		return reducedNumber;
	}

	public static String reduceNumberMixed(String properNumber) {
		String reducedNumber = properNumber;
		int numerator = Integer
				.parseInt(properNumber.substring(properNumber.indexOf("_") + 1, properNumber.indexOf("/")));
		int denominator = Integer.parseInt(properNumber.substring(properNumber.indexOf("/") + 1));
		int wholeNumber = (Integer.parseInt(properNumber.substring(0, properNumber.indexOf("_"))));
		for (int x = 1; x <= 10; x++) {
			if (numerator % x == 0 && numerator % x == 0) {
				numerator /= x;
				denominator /= x;
			}
		}
		reducedNumber = (wholeNumber + "_" + numerator + "/" + denominator);
		return reducedNumber;
	}

	public static String improperToProper(String improperNumber, Fraction f1) {
		String properNumber;
		int wholeNumber;
		int remainder = 0;
		f1.numerator = Integer.parseInt(improperNumber.substring(0, improperNumber.indexOf("/")));
		f1.denominator = Integer.parseInt(improperNumber.substring(improperNumber.indexOf("/") + 1));
		if (f1.denominator == 0) {
			properNumber = ("0");
		} else {
			remainder = f1.numerator % f1.denominator;
			wholeNumber = (f1.numerator - remainder) / f1.denominator;
			if (remainder == 0) {
				properNumber = (wholeNumber + "");
			} else if (wholeNumber == 0) {
				properNumber = (remainder + "/" + f1.denominator);
				properNumber = reduceNumberFrac(properNumber, f1);
			} else {
				properNumber = (wholeNumber + "_" + remainder + "/" + f1.denominator);
				properNumber = reduceNumberMixed(properNumber);
			}
		}
		return properNumber;
	}

	public static String operation(Fraction f1, Fraction f2, String operator) {
		String finalNumber;
		if (f1.denominator != f2.denominator) {
			f1.numerator *= f2.denominator;
			f1.denominator *= f2.denominator;
			f2.numerator *= f1.denominator / f2.denominator;
			f2.denominator *= f1.denominator / f2.denominator;
		}
		if (operator.equals("+")) {
			finalNumber = add(f1, f2);

		} else if (operator.equals("-")) {
			finalNumber = subtract(f1, f2);

		} else if (operator.equals("*")) {
			finalNumber = multiply(f1, f2);

		} else if (operator.equals("/")) {

			finalNumber = divide(f1, f2);
		} else {
			finalNumber = ("0");
		}
		return finalNumber;
	}

	public static int space1Location(String input) {
		int x = input.indexOf(" ");
		return x;
	}

	public static String improperTest(String number) {
		String refinedNumber;
		int underscore = number.indexOf("_");
		if (underscore == -1) {
			refinedNumber = number;
		} else {
			int wholeNumber = Integer.parseInt(number.substring(0, underscore));
			String fraction = number.substring(underscore + 1);
			int numerator = Integer.parseInt(number.substring(underscore + 1, number.indexOf("/")));
			int denominator = Integer.parseInt(number.substring(number.indexOf("/") + 1));
			int newNumerator = (wholeNumber * denominator) + numerator;
			refinedNumber = (newNumerator + "/" + denominator);
		}
		return refinedNumber;
	}

	public static String multiply(Fraction f1, Fraction f2) {
		String finalNumber;
		int finalNume = f1.numerator * f2.numerator;
		int finalDen = f1.denominator * f2.denominator;
		finalNumber = (finalNume + "/" + finalDen);
		return finalNumber;
	}

	public static String divide(Fraction f1, Fraction f2) {
		String finalNumber;
		int finalNume = f1.numerator * f2.denominator;
		int finalDen = f1.denominator * f2.numerator;
		finalNumber = (finalNume + "/" + finalDen);
		return finalNumber;
	}

	public static String add(Fraction f1, Fraction f2) {
		String finalNumber;
		int finalNume = f1.numerator + f2.numerator;
		int finalDen = f1.denominator;
		finalNumber = (finalNume + "/" + finalDen);
		return finalNumber;
	}

	public static String subtract(Fraction f1, Fraction f2) {
		String finalNumber;
		int finalNume = f1.numerator - f2.numerator;
		int finalDen = f1.denominator;
		finalNumber = (finalNume + "/" + finalDen);
		return finalNumber;
	}
}
