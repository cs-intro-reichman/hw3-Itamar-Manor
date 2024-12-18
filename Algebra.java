// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));

		for (int i = 0; i <= 100; i++) {
			System.out.printf("i %d: correct=%d mine=%d\n", i, (int) Math.sqrt(i), sqrt(i));
		}
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			for (int i = x2; i < 0; i++) {
				x1--;
			}
			return x1;
		}
		for (int i = 0; i < x2; i++) {
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			for (int i = x2; i < 0; i++) {
				x1++;
			}
			return x1;
		}
		for (int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num = 0;
		if (x2 < 0) {
			for (int i = x2; i < 0; i++) {
				num = minus(num, x1);
			}
			return num;
		}
		for (int i = 0; i < x2; i++) {
			num = plus(num, x1);
		}
		return num;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num = 1;
		for (int i = 0; i < n; i++) {
			num = times(num, x);
		}
		return num;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int count = 0;
		boolean isPositive = true;
		if (x1 < 0) {
			x1 = minus(0, x1);
			isPositive = !isPositive;
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
			isPositive = !isPositive;
		}

		while (x1 >= x2) {
			count++;
			x1 = minus(x1, x2);
		}

		if (isPositive) {
			return count;
		} else {
			return minus(0, count);
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int q = div(x1, x2);
		if (x1 < 0) {
			q--;
		}
		return minus(x1, times(x2, q));
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int i = 0;
		while (pow(i,2) < x && pow(i+1,2) <= x) {
			i++;
		}
		return i;
	}
}