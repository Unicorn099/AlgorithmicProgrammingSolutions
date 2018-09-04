package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Co implements Comparable<Co> {
	int count;
	String cc;

	@Override
	public int compareTo(Co o) {

		if (this.count > o.count) {
			return -1;
		} else if (this.count < o.count) {
			return 1;
		}
		return 0;
	}
}

public class CountTheString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String str = in.next();

			System.out.println(findAnswer(str, n, k));

		}

		in.close();

	}

	private static String findAnswer(String str, int n, int k) {

		String res = "";

		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[str.charAt(i) - 97]++;
		}

		List<Co> cos = new ArrayList<Co>();
		for (int i = 0; i < 26; i++) {
			if (count[i] > k) {
				Co co = new Co();
				co.cc = String.valueOf(Character.toChars(i + 97));
				co.count = count[i];
				cos.add(co);
			}
		}

		Collections.sort(cos);
		if (cos.isEmpty()) {
			return "NONE";
		}
		for (Co c : cos) {
			res += c.cc;
		}

		return res;
	}
}
