package usaco;

/*
ID: mib.2oj1
LANG: JAVA
TASK: namenum
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class namenum {

	static char[][] arrays = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
			{ 'G', 'H', 'I' }, { 'J', 'K', 'L' }, { 'M', 'N', 'O' },
			{ 'P', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y' } };

	static String[] names = new String[4617];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"namenum.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"namenum.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		String str = "";
		tokenizer = new StringTokenizer(line);
		str = tokenizer.nextToken();

		bufferedReader.close();
		bufferedReader = new BufferedReader(
				new FileReader(
						"dict.txt"));

		int i = 0;

		while ((line = bufferedReader.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			names[i] = tokenizer.nextToken();
			i++;
		}

		findAnswer(str,printWriter);

		printWriter.close();
		System.exit(0);

	}

private static String findAnswer(String str, PrintWriter printWriter) {
		String name = "";
		char firstChar;
		// boolean flag = false;
		for (int index = 0; index < 3; ++index) {
			for (int i = 0; i < 4617; i++) {
				if (names[i].length() == str.length()) {
					firstChar = arrays[Integer.parseInt("" + str.charAt(0)) - 2][index];
					if (names[i].charAt(0) == firstChar) {
						// flag = true;
						if (matched(names[i], str)) {
							name += names[i];
							printWriter.println(names[i]);
						}
					} else if (names[i].charAt(0) > firstChar) {
						break;
					}
				}
			}
		}

		if (name.equals("")) {
			printWriter.println("NONE");
			return "NONE";
		}
		return name;
	}

	private static boolean matched(String names, String str) {
		boolean res = true;
		char temp;
		for (int k = 1; k < names.length() && k < str.length(); k++) {
			temp = names.charAt(k);
			if (!(arrays[Integer.parseInt("" + str.charAt(k)) - 2][0] == temp
					|| arrays[Integer.parseInt("" + str.charAt(k)) - 2][1] == temp || arrays[Integer
					.parseInt("" + str.charAt(k)) - 2][2] == temp)) {
				res = false;
			}
		}
		return res;
	}
}
