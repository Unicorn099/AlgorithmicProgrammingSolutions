package usaco;


/*

ID: mib.2oj1
LANG: JAVA
TASK: milk2
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"milk2.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"milk2.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int numberOfCows = Integer.parseInt(tokenizer.nextToken());
		long times[][] = new long[numberOfCows][2];
		int i = 0;
		while ((line = bufferedReader.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			times[i][0] = Long.parseLong(tokenizer.nextToken());
			times[i][1] = Long.parseLong(tokenizer.nextToken());
			i++;
		}

		printWriter.println(findAnswer(times));
		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static String findAnswer(long[][] times) {

		long max = 0, min = times[0][0];
		String result = "";
		boolean[] state = new boolean[1000000];
		long j = 0;
		for (int i = 0; i < times.length; i++) {
			j = times[i][0];
			if (min > times[i][0]) {
				min = times[i][0];
			}
			while (j < times[i][1]) {
				state[(int) j] = true;
				j++;
			}
			if (max < times[i][1]) {
				max = times[i][1];
			}
		}

		int count1 = 0, count2 = 0, tempCount1 = 0, tempCount2 = 0;
		for (int i = (int)min; i <= max+1; ++i) {
			if (state[i]) {
				tempCount1++;
				if (count2 < tempCount2) {
					count2 = tempCount2;
					
				}
				tempCount2=0;
			} else {
				tempCount2++;
				if (count1 < tempCount1) {
					count1 = tempCount1;
					
				}
				tempCount1=0;
			}
		}
		result = String.valueOf(count1) + " " + String.valueOf(count2);
		return result;
	}
}
