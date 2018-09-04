package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.peeyush.util.PowerApp;

public class AllYourBase {

	final static String WORK_DIR = "E:\\testingtestingtesting123\\AllYourBase\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new AllYourBase().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solve(Scanner sc, PrintWriter pw) {

		String str = sc.nextLine();
		int length = str.length();
		char[] chrArray = str.toCharArray();
		int[] intArray = new int[length];
		int base = 1;
		Map<Character, Integer> charInt = new HashMap<Character, Integer>();
		charInt.put(chrArray[0], base);
		intArray[0] = base;
		for (int i = 1; i < length; i++) {
			if (charInt.containsKey(chrArray[i])) {
				intArray[i] = charInt.get(chrArray[i]);
			} else if (charInt.containsValue(0)) {
				base++;
				charInt.put(chrArray[i], base);
				intArray[i] = base;
			} else {
				charInt.put(chrArray[i], 0);
				intArray[i] = 0;
			}
		}
		base++;
		long minSeconds = 0;

		for (int i = 0; i < length; i++) {
			minSeconds += PowerApp.powerOf(base, (length - 1 - i))
					* intArray[i];
		}
		pw.println(minSeconds);
	}
}
