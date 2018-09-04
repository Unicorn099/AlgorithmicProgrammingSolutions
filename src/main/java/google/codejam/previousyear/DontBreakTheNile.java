package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DontBreakTheNile {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\DontBreakTheNile\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "C-small-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));
		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new DontBreakTheNile().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		long width = sc.nextLong();
		long height = sc.nextLong();
		int building = sc.nextInt();

		long[][] buildingCoordinate = new long[building][building];
		for (int i = 0; i < building; i++) {
			for (int j = 0; j < building; j++) {
				buildingCoordinate[i][j] = sc.nextLong();
			}
		}
	}
}
