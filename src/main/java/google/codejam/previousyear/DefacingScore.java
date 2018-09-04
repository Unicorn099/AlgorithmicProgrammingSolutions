package google.codejam.previousyear;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DefacingScore {

	/**
	 * @param args
	 * @throws IOException
	 */

	static int lookUp[][] = new int[][] { { 8, -1, -1, -1, -1 },
			{ 9, 8, 7, -1, -1 }, { 8, -1, -1, -1, -1 }, { 9, 8, -1, -1, -1 },
			{ 9, 8, 6, 5, -1 }, { 9, 8, 6, -1, -1 }, { 8, -1, -1, -1, -1 },
			{ 9, 8, 0, -1, -1 }, { -1, -1, -1, -1, -1 }, { 8, -1, -1, -1, -1 } };

	public static void main(String[] args) throws IOException {

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in));
		 */
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"E:\\testingtestingtesting123\\DefacingScore\\test.txt")));
		int testCases = Integer.parseInt(br.readLine());

		String sAndm = "";
		String sAndMinArray[] = new String[2];
		int S, M, newS, diff, extra;
		String tempS, tempM;
		for (int i = 1; i <= testCases; i++) {
			sAndm = br.readLine();
			sAndMinArray = sAndm.split(" ");
			tempS = sAndMinArray[0];
			tempM = sAndMinArray[1];
			S = Integer.parseInt(tempS);
			M = Integer.parseInt(tempM);
			diff = sAndMinArray[1].length() - sAndMinArray[0].length();
			extra = (int) Math.pow(10, (tempM.length() - diff));
			newS = ((int) (M / extra)) * extra + S;
			tempS = String.valueOf(newS);

			if (M == 0) {
				System.out.println(0);
			} else {
				if (newS < M) {
					System.out.println(commonTask(tempS, M, newS, diff));
				} else if (newS == M) {
					System.out.println(newS);
				} else {
					int max = differentTask(tempS, M, newS, diff);
					if (max > M) {
						newS = newS - extra;
						max = newS;
						if (String.valueOf(newS).length() != tempS.length()) {
							diff--;
						}
						tempS = String.valueOf(newS);
						System.out.println(commonTask(tempS, M, newS, diff));
					} else {
						System.out.println(max);
					}
				}

			}
		}
	}

	public static int commonTask(String tempS, int M, int newS, int diff) {

		int len = tempS.length();
		int tempNewS = newS;
		for (int j = diff; j < len; j++) {
			int charToBeConsidered = Integer.parseInt("" + tempS.charAt(j));
			for (int k = 0; k < 5 && lookUp[charToBeConsidered][k] != -1; k++) {
				tempNewS = Integer.parseInt(changeCharInPosition(j,
						(char) ('0' + lookUp[charToBeConsidered][k]), tempS));
				if (tempNewS > M) {
					continue;
				} else if (tempNewS == M) {
					return tempNewS;
				} else {
					tempS = String.valueOf(tempNewS);
					break;
				}
			}
		}
		return tempNewS;
	}

	public static int differentTask(String tempS, int M, int newS, int diff) {

		int len = tempS.length();
		int tempNewS = newS;
		for (int j = len - 1; j >= diff; j--) {
			int charToBeConsidered = Integer.parseInt("" + tempS.charAt(j));
			for (int k = 0; k < 5 && lookUp[charToBeConsidered][k] != -1; k++) {
				if (lookUp[charToBeConsidered][k] < charToBeConsidered) {
					tempNewS = Integer
							.parseInt(changeCharInPosition(
									j,
									(char) ('0' + lookUp[charToBeConsidered][k]),
									tempS));
					if (tempNewS > M) {
						tempS = String.valueOf(tempNewS);
						continue;
					} else if (tempNewS == M) {
						return tempNewS;
					} else {
						break;
					}
				}
			}
		}
		return tempNewS;
	}

	public static String changeCharInPosition(int position, char ch, String str) {
		char[] charArray = str.toCharArray();
		charArray[position] = ch;
		return new String(charArray);
	}
}
