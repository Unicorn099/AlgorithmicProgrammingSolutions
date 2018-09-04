/*
ID: mib.2oj1
LANG: JAVA
TASK: crypt1
 */
package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class crypt1 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int numbersCount = Integer.parseInt(tokenizer.nextToken());

		line = bufferedReader.readLine();
		tokenizer = new StringTokenizer(line);

		int[] numbers = new int[numbersCount];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(tokenizer.nextToken());
		}

		// System.out.println(validate(423, new int[] { 2, 3, 4 }));

		printWriter.println(findAnswer(numbers));

		printWriter.close();
		bufferedReader.close();
		System.exit(0);

	}

	private static int findAnswer(int[] numbers) {

		int firstNumber = 0, secondNumber = 0, count = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				for (int j2 = 0; j2 < numbers.length; j2++) {
					firstNumber = numbers[i] * 100 + numbers[j] * 10
							+ numbers[j2];
					for (int k = 0; k < numbers.length; k++) {
						if ((firstNumber * numbers[k]) > 999) {
							continue;
						}
						for (int k2 = 0; k2 < numbers.length; k2++) {
							secondNumber = numbers[k] * 10 + numbers[k2];
							if ((firstNumber * numbers[k2]) > 999
									|| (firstNumber * secondNumber) > 9999) {
								continue;
							} else {
								if (validate(firstNumber * numbers[k], numbers)
										&& validate(firstNumber * numbers[k2],
												numbers)
										&& validate(firstNumber * secondNumber,
												numbers)) {
									count++;
								}
							}
						}
					}
				}
			}
		}

		return count;
	}

	private static boolean validate(int i, int[] numbers) {
		String number = String.valueOf(i);
		boolean res1 = true, res2 = false;
		for (int j = 0; j < number.length(); j++) {
			res2 = false;
			for (int j2 = 0; j2 < numbers.length; j2++) {
				if ((numbers[j2] == Character.digit(number.charAt(j), 10))) {
					res2 = true;
					break;
				}
			}
			res1 = res1 && res2;
			if (!res1) {
				return false;
			}
		}
		return res1 && res2;
	}
}
