package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: beads
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class beads {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"beads.in"));
		PrintWriter printWriter = new PrintWriter(new FileWriter("beads.out"));

		String line = bufferedReader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int length = Integer.parseInt(tokenizer.nextToken());

		line = bufferedReader.readLine();
		tokenizer = new StringTokenizer(line);
		String str = tokenizer.nextToken();
		printWriter.println(findsumm(str));
		printWriter.close();
		System.exit(0);
		bufferedReader.close();
	}

	private static String findsumm(String str) {
		str += str;
		int tempCount = 1, count = 1;
		int lastIndex = 0;
		char charBeingChecked;
		for (int i = 0; i < str.length() - 1;) {
			charBeingChecked = 'f';
			tempCount = 1;
			while (charBeingChecked == 'f' && i < str.length()
					&& str.charAt(i) == 'w') {
				i++;
				tempCount++;
			}
			if (i == str.length()) {
				if (tempCount > str.length() / 2) {
					return String.valueOf(str.length() / 2);
				}
				return count > tempCount ? String.valueOf(count) : String
						.valueOf(tempCount);
			}
			charBeingChecked = str.charAt(i);
			int j = i + 1;
			lastIndex = j;
			for (; j < str.length(); j++) {
				if (charBeingChecked == str.charAt(j)) {
					lastIndex = j + 1;
				} else if (str.charAt(j) == 'w') {
				} else {
					break;
				}
				tempCount++;
			}
			i = j;
			j = i + 1;
			tempCount++;
			for (; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j) || str.charAt(j) == 'w') {
					tempCount++;
				} else {
					break;
				}
			}

			i = lastIndex;

			if (tempCount > str.length() / 2) {
				return String.valueOf(str.length() / 2);
			} else {
				if (count < tempCount) {
					count = tempCount;
				}
			}
		}
		return String.valueOf(count);
	}

}
