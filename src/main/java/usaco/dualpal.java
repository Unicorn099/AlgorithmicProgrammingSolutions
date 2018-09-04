package usaco;


/*

ID: mib.2oj1
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"dualpal.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"dualpal.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int count = Integer.parseInt(tokenizer.nextToken());

		int number = Integer.parseInt(tokenizer.nextToken());
		int i = number + 1;
		int palindromeCount = 0;
		for (int j = 0; j < count;) {
			palindromeCount = 0;
			int k = 2;
			for (; k <= 10; k++) {
				if (palindromeCount < 2) {
					if (isPalindrome(changeBase(i, k))) {
						palindromeCount++;
					}
				} else {
					break;
				}
			}
			if (palindromeCount == 2) {
				j++;
				printWriter.println(i);
				i++;
			} else {
				if (k > 10) {
					i++;
				}
			}
		}

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	public static String changeBase(int number, int base) {
		return Integer.toString(number, base).toUpperCase();

	}

	public static boolean isPalindrome(String str) {
		int length = str.length();
		for (int i = 0; i < length; ++i) {
			if (str.charAt(i) != str.charAt(length - 1)) {
				return false;
			}
			length--;
		}
		return true;
	}
}
