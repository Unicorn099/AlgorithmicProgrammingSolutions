package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpAndDown {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\UpAndDown\\";

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
			new UpAndDown().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		int numberOfElements = sc.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < numberOfElements; i++) {
			arr.add(sc.nextInt());
		}

		int swaps = 0;
		for (int k = 0; k < numberOfElements; k++) {
			int temp = arr.get(0);
			for (int i = 1; i < arr.size(); i++) {
				if (temp > arr.get(i)) {
					temp = arr.get(i);
				}
			}
			int index = arr.indexOf(temp);
			if (index < (arr.size() - index - 1)) {
				swaps += index;
			} else {
				swaps += (arr.size() - index - 1);
			}
			arr.remove(index);
		}

		pw.println(swaps);
	}
}
