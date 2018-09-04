package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: pprime
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class pprime {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"pprime.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"pprime.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());

		List<Integer> result = findAnswer(a, b);
		for (Integer r : result) {
			printWriter.println(r);
		}

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static List<Integer> findAnswer(int a, int b) {

		List<Integer> pprime = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		if (a < 10) {
			for (int i = a; i <= 9; i += 2)
				result.add(i);
		}
		if (b > 10 && a <= 10) {
			for (int i = 1; i <= 9; i += 2) {
				result.add(i * 10 + i);
			}
		}

		if (b > 100) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					result.add(i * 100 + j * 10 + i);
				}
			}
		}
		if (b > 1000) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					result.add(i * 1000 + j * 100 + j * 10 + i);
				}
			}
		}

		if (b > 10000) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						result.add(i * 10000 + j * 1000 + k * 100 + j * 10 + i);
					}

				}
			}
		}
		if (b > 100000) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						result.add(i * 100000 + j * 10000 + k * 1000 + k * 100
								+ j * 10 + i);
					}

				}
			}
		}

		if (b > 1000000) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						for (int l = 0; l <= 9; l++) {
							result.add(i * 1000000 + j * 100000 + k * 10000 + l
									* 1000 + k * 100 + j * 10 + i);
						}
					}
				}
			}
		}

		if (b > 10000000) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						for (int l = 0; l <= 9; l++) {
							result.add(i * 10000000 + j * 1000000 + k * 100000
									+ l * 10000 + l * 1000 + k * 100 + j * 10
									+ i);
						}
					}
				}
			}
		}
		for (Integer r : result) {
			if (r > b) {
				break;
			}
		if(r<a){
			continue;
		}
			boolean flag = true;
			for (int i = 2; i * i <= r; i++) {
				if (r % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				pprime.add(r);
		}
		return pprime;
	}
}