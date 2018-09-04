package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartElf {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\PartElf\\";

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
			new PartElf().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();

		// System.out.println(new PartElf().gcd(936140679572L, 959328636067L));
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		String str = sc.next();
		String[] number = str.split("/");
		long P = Long.parseLong(number[0]);
		long Q = Long.parseLong(number[1]);

		/**
		 * For large input only
		 */
		long gcd1 = gcd(P, Q);
		P = P / gcd1;
		Q = Q / gcd1;

		/**
		 * For large input only
		 */

		String res = new String("");
		int count = 0;
		long temp = Q;
		while (temp % 2 == 0) {
			temp = temp / 2;
			count++;
			if (temp == 1) {
				break;
			}
		}
		if (temp != 1) {
			pw.println("impossible");
			return;
		}

		int fI = 0;
		if (P == 1) {
			pw.println(count);
		} else {
			res = Long.toBinaryString(P);
			fI = res.length() - res.indexOf("1") - 1;
			pw.println(count - fI);
		}
	}

	private long gcd(long P, long Q) {
		long temp = 0;
		while (Q % P != 0) {
			temp = Q % P;
			Q = P;
			P = temp;
		}
		return P;

	}
}
