package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: numtri
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class numtri {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"numtri.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"numtri.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int size = Integer.parseInt(tokenizer.nextToken());

		int array[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			for (int j = 0; j < i + 1; j++) {
				array[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		printWriter.println(findAnswer(array));
		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static int findAnswer(int[][] array) {

		int size = array.length;

		for (int i = size - 1; i > 0; i--) {
			for (int ii = 0; ii < i; ii++) {
				int max1 = 0, max2 = 0;
				max1 = array[i - 1][ii] + array[i][ii];
				max2 = array[i - 1][ii] + array[i][ii + 1];
				array[i - 1][ii] = max1 > max2 ? max1 : max2;
			}
		}

		return array[0][0];
	}
}
