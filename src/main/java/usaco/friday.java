package usaco;

/**
ID: mib.2oj1
LANG: JAVA
TASK: friday
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class friday {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"friday.in"));
		PrintWriter printWriter = new PrintWriter(new FileWriter("friday.out"));

		String line = bufferedReader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);

		int year = Integer.parseInt(tokenizer.nextToken());
		String[] weeks = { "Saturday", "Sunday", "Monday", "Tuesday",
				"Wednesday", "Thursday", "Friday" };

		int[] counts = new int[7];
		int month = 12;
		boolean leapYear = false;
		int dayIndex = 2;
		for (int i = 1900; i < 1900 + year; i++) {
			if ((i % 100 == 0 && i % 400 == 0) || (i % 100 != 0 && i % 4 == 0)) {
				leapYear = true;
			} else {
				leapYear = false;
			}
			for (int j = 1; j <= month; j++) {
				if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10
						|| j == 12) {
					dayIndex = (dayIndex + 12) % 7;
					counts[dayIndex]++;
					dayIndex = (dayIndex + 19) % 7;
				} else if (j == 4 || j == 6 || j == 9 || j == 11) {
					dayIndex = (dayIndex + 12) % 7;
					counts[dayIndex]++;
					dayIndex = (dayIndex + 18) % 7;
				} else {
					if (leapYear) {
						dayIndex = (dayIndex + 12) % 7;
						counts[dayIndex]++;
						dayIndex = (dayIndex + 17) % 7;
					} else {
						dayIndex = (dayIndex + 12) % 7;
						counts[dayIndex]++;
						dayIndex = (dayIndex + 16) % 7;
					}
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			printWriter.print(counts[i] + " ");
		}
		printWriter.print(counts[6]+"\n");
		printWriter.close();
		System.exit(0);

	}
}
