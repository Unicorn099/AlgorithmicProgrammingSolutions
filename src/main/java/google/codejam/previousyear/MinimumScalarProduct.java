package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumScalarProduct {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\MinimumScalarProduct\\";

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
			new MinimumScalarProduct().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {
		int numberOfVectors = sc.nextInt();
		List<Long> vectorA = new ArrayList<Long>();
		List<Long> vectorB = new ArrayList<Long>();
		for (int i = 0; i < numberOfVectors; i++) {
			vectorA.add(sc.nextLong());
		}

		for (int i = 0; i < numberOfVectors; i++) {
			vectorB.add(sc.nextLong());
		}

		Collections.sort(vectorA);
		Collections.sort(vectorB);
		long vectorProduct = 0;
		for (int i = numberOfVectors - 1, j = 0; i >= 0 && j < numberOfVectors; i--, j++) {
			vectorProduct += (vectorA.get(i) * vectorB.get(j));
		}
		pw.print(vectorProduct);
		pw.println();
	}
}
