package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: barn1
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class barn1 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"barn1.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"barn1.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);

		int numberOfBoards = Integer.parseInt(tokenizer.nextToken());
		int numberOfStalls = Integer.parseInt(tokenizer.nextToken());
		int numberOfCows = Integer.parseInt(tokenizer.nextToken());

		int[] stallIdHavingCows = new int[numberOfCows];

		for (int i = 0; i < numberOfCows; ++i) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			stallIdHavingCows[i] = Integer.parseInt(tokenizer.nextToken());
		}

		printWriter.println(findAnswer(numberOfBoards, numberOfStalls,
				numberOfCows, stallIdHavingCows));

		printWriter.close();
		bufferedReader.close();
		System.exit(0);
	}

	private static int findAnswer(int numberOfBoards, int numberOfStalls,
			int numberOfCows, int[] stallIdHavingCows) {
		int stallsCovered = 0;
		List<Integer> vacantStalls = new ArrayList<Integer>();
		Arrays.sort(stallIdHavingCows);
		for (int i = 0; i < numberOfCows - 1; i++) {
			if (stallIdHavingCows[i + 1] - stallIdHavingCows[i] > 1) {
				vacantStalls.add(stallIdHavingCows[i + 1]
						- stallIdHavingCows[i] - 1);
			}
		}

		Collections.sort(vacantStalls);

		stallsCovered = stallIdHavingCows[numberOfCows-1] - stallIdHavingCows[0]
				+ 1;
		for (int i = vacantStalls.size() - 1; i >= 0; i--) {
			if (numberOfBoards != 1) {
				stallsCovered -= vacantStalls.get(i);
				numberOfBoards--;
			} else {
				break;
			}

		}

		return stallsCovered;
	}
}
