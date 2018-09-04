package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Numbers {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\Numbers\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "C-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));
		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new Numbers().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	/**
	 * Not Complete yet
	 */
	private void solveReal(Scanner sc, PrintWriter pw) {
		long power = sc.nextInt();
		double number = 3 + Math.sqrt(5);

		double f1 = powerOf(number, power) % 1000;
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.DOWN); // Note this extra step
		String str = df.format(f1);
		System.out.println(f1);
		int tempInt = Integer.parseInt(str);
		if (tempInt < 10) {
			str = "00" + str;
		} else if (tempInt < 100) {
			str = "0" + str;
		}
		pw.println(str);
		System.out.println(f1);
	}

	private static double powerOf(double n, long x) {

		double y = 0;
		if (x == 0) {
			return 1;
		} else if (x % 2 == 0) {
			y = powerOf(n, x / 2);
			return y * y;
		} else {
			y = powerOf(n, (x - 1) / 2);
			return y * y * n;
		}

	}

}
