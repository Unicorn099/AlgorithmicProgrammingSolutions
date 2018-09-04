package hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class MansaAndStones {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\rank\\test.in"));
		int T, numberOfStones, a, b;
		T = in.nextInt();

		SortedSet<Integer> res = new TreeSet<Integer>();

		for (int i = 0; i < T; i++) {
			numberOfStones = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();

			for (int j = 0; j < numberOfStones; j++) {
				res.add(a * (numberOfStones - 1 - j) + b * j);
			}

			for (Integer r : res) {
				System.out.print(r);
				System.out.print(" ");
			}
			System.out.println();
			res.clear();
		}
		in.close();
	}

}
