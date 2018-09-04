package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: transform
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class transform {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"transform.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"transform.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int size = Integer.parseInt(tokenizer.nextToken());
		String times[] = new String[size];
		String rctimes[] = new String[size];
		int i = 0;
		while (i < size) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			times[i] = tokenizer.nextToken();
			i++;
		}
		i = 0;
		while (i < size) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			rctimes[i] = tokenizer.nextToken();
			i++;
		}

		printWriter.println(findAnswer(times, rctimes));

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static String findAnswer(String[] times, String[] rctimes) {
		String result = "";
		String[] tempTimes = times;
		for (int i = 0; i < 3; i++) {
			tempTimes = rotate(tempTimes);
			if (compare(tempTimes, rctimes)) {
				result = String.valueOf(i + 1);
				return result;
			}
		}
		tempTimes = reflect(times);
		if (compare(tempTimes, rctimes)) {
			result = "4";
			return result;
		} else {
			for (int i = 0; i < 3; i++) {
				tempTimes = rotate(tempTimes);
				if (compare(tempTimes, rctimes)) {
					result = "5";
					return result;
				}
			}
		}
		if (compare(times, rctimes)) {
			result = "6";
			return result;
		} 

		return "7";
	}

	private static String[] rotate(String[] times) {
		char[][] timesReturn = new char[times.length][times.length];

		String[] res = new String[times.length];
		int dim = times.length;

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				timesReturn[j][Math.abs(dim - i - 1)] = times[i].charAt(j);
			}

		}
		for (int i = 0; i < dim; i++) {
			res[i] = "";
			for (int j = 0; j < dim; j++) {
				res[i] += timesReturn[i][j];
			}

		}

		return res;
	}

	private static boolean compare(String[] times, String[] rctimes) {
		int j = 0, size = times.length;
		for (; j < size; ++j) {
			if (!times[j].equals(rctimes[j])) {
				return false;
			}
		}
		return true;
	}

	private static String[] reflect(String[] times) {
		String[] timesReturn = new String[times.length];

		int dim = times.length;

		for (int i = 0; i < dim; i++) {
			String str = "";
			for (int j = 0; j < dim; j++) {
					str += times[i].charAt(Math.abs(dim - j - 1));
			}
			timesReturn[i] = str;
		}
		return timesReturn;
	}

}
