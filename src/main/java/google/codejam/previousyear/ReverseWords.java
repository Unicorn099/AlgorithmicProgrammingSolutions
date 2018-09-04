package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReverseWords {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\ReverseWords";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "B-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));
		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new ReverseWords().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solve(Scanner sc, PrintWriter pw) {

		String sentence = sc.nextLine();
		String str[] = sentence.split(" ");

		for (int i = str.length - 1; i >= 0; i--) {
			pw.print(str[i] + " ");
		}

		pw.println();
	}
}
