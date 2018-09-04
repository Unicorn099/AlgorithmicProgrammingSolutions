package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class skidesign {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int hills = Integer.parseInt(tokenizer.nextToken());

		int[] hillDetails = new int[hills];
		int i = 0;
		while (i < hills) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			hillDetails[i] = Integer.parseInt(tokenizer.nextToken());
			i++;
		}
		printWriter.println(findTrueAnswer(hillDetails));

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static int findTrueAnswer(int[] hillDetails) {
		int result = 0;

		Arrays.sort(hillDetails);
		int difference = 0;
		List<Integer> extraHeight = new ArrayList<Integer>();
		for (int i = 0, j = hillDetails.length - 1; i < j; i++, j--) {
			difference = hillDetails[j] - hillDetails[i];
			difference -= 17;
			if (difference > 0)
				extraHeight.add(difference);
		}

		int sum = 0;
		for (Integer var : extraHeight) {
			System.out.println(var);
			sum += var;
		}
		System.out.println("SUM " + sum + " and length " + extraHeight.size());

		return result;
	}

	private static int findAnswer(int[] hillDetails) {
		int result = 0;

		Arrays.sort(hillDetails);
		int difference = hillDetails[hillDetails.length - 1] - hillDetails[0];
		while (difference > 17) {
			System.out.println(difference);
			difference = difference - 17;
			if (difference == 1) {
				result += 2;
				break;
			}
			difference = difference % 2 == 0 ? difference : difference - 1;
			result += 2 * (difference) / 2 * (difference) / 2;
			hillDetails[0] += difference / 2;
			hillDetails[hillDetails.length - 1] -= difference / 2;
			Arrays.sort(hillDetails);

			difference = hillDetails[hillDetails.length - 1] - hillDetails[0];

		}

		return result;
	}
}
