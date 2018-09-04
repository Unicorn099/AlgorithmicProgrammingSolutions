package usaco;


/*

ID: mib.2oj1
LANG: JAVA
TASK: sprime
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sprime {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"sprime.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"sprime.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int a = Integer.parseInt(tokenizer.nextToken());

		List<String> result = findDivineAnswer(a);
		for (String r : result) {
			printWriter.println(r);
		}

		printWriter.close();
		System.exit(0);
		bufferedReader.close();
	}

	private static boolean isPrime(int number) {
		boolean res = true;

		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				res = false;
				break;
			}
		}
		return res;
	}

	private static List<String> findDivineAnswer(int a) {
		List<String> res = new ArrayList<String>();
		List<String> rrr = new ArrayList<String>();
		res.add("2");
		res.add("3");
		res.add("5");
		res.add("7");
		if (a == 1) {
			return res;
		} else {
			for (int i = 0; i < a - 1; i++) {
				for (String strr : res) {
					for (int j = 1; j <= 9; j++) {
						String str = strr + "" + j;
						if (isPrime(Integer.parseInt(str))) {
							rrr.add(str);
						}
					}
				}
				res.clear();
				res.addAll(rrr);
				rrr.clear();
			}
		}

		return res;
	}
}
