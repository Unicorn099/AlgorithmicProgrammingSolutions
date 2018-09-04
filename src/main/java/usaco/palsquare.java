package usaco;


/*

ID: mib.2oj1
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class palsquare {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"palsquare.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"palsquare.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int base = Integer.parseInt(tokenizer.nextToken());

		for (int i = 1; i <=300; i++) {
			if(isPalindrome(changeBase(i*i, base))){
				printWriter.println(changeBase(i, base)+" "+changeBase(i*i, base));
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
