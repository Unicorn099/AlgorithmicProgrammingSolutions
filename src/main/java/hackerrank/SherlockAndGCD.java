package hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SherlockAndGCD {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\rank\\test.in"));
		int T;
		T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int count = in.nextInt();
			int[] N = new int[count];
			for (int j = 0; j < count; j++) {
				N[j] = in.nextInt();
			}
			int result = N[0];
			for (int ii = 1; ii < count; ii++) {
				result = gcd(result, N[ii]);
			}

			if (result == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

		in.close();

	}

	public static int gcd(int a, int b) {
		int rem = 0, temp=0;
		if (b > a) {
			rem = a;
			while (rem != 1) {
				if (b % rem == 0) {
					return rem;
				} else {
					temp = rem;
					rem = b % rem;
					b = temp;
				}
			}
			return rem;
		} else {
			rem = b;
			while (rem != 1) {
				if (a % rem == 0) {
					return rem;
				} else {
					temp=rem;
					rem = a % rem;
					a = temp;
				}
			}
		}
		return rem;
	}

}
