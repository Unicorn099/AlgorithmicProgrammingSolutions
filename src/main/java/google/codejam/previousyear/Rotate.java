package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rotate {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\Rotate\\";

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
			new Rotate().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solve(Scanner sc, PrintWriter pw) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		char[][] arr1 = new char[N][N];

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextLine().toCharArray();
		}

		for (int i = 0; i < N; ++i) {
			int x = N - 1;
			for (int j = N - 1; j >= 0; j--)
				if (arr1[i][j] != '.') {
					arr1[i][x] = arr1[i][j];
					x--;
				}
			while (x >= 0) {
				arr1[i][x] = '.';
				x--;
			}
		}

		String blueString = "";
		String redString = "";
		for (int i = 0; i < K; i++) {
			blueString += "B";
			redString += "R";
		}

		boolean flagRed = false, flagBlue = false;
		for (int i = 0; i < N; i++) {
			String str = "";
			for (int j = 0; j < N; j++) {
				str += arr1[i][j];
			}

			flagRed = str.contains(redString) ? true : flagRed;
			flagBlue = str.contains(blueString) ? true : flagBlue;
			if (flagRed && flagBlue) {
				pw.println("Both");
				return;
			}
		}
		for (int i = 0; i < N; i++) {
			String str = "";
			for (int j = 0; j < N; j++) {
				str += arr1[j][i];
			}
			flagRed = str.contains(redString) ? true : flagRed;
			flagBlue = str.contains(blueString) ? true : flagBlue;
			if (flagRed && flagBlue) {
				pw.println("Both");
				return;
			}
		}

		for (int i = 0; i <= (N - K); i++) {
			for (int j = N - 1; j >= (K - 1); j--) {
				String str = "";
				for (int k = 0; k < K; k++) {
					str += arr1[i + k][j - k];
				}
				flagRed = str.contains(redString) ? true : flagRed;
				flagBlue = str.contains(blueString) ? true : flagBlue;
				if (flagRed && flagBlue) {
					pw.println("Both");
					return;
				}
			}
		}

		for (int i = N - 1; i >= (K - 1); i--) {
			for (int j = N - 1; j >= (K - 1); j--) {
				String str = "";
				for (int k = 0; k < K; k++) {
					str += arr1[i - k][j - k];
				}
				flagRed = str.contains(redString) ? true : flagRed;
				flagBlue = str.contains(blueString) ? true : flagBlue;
				if (flagRed && flagBlue) {
					pw.println("Both");
					return;
				}
			}
		}
		if (flagRed) {
			pw.println("Red");
			return;
		}
		if (flagBlue) {
			pw.println("Blue");
			return;
		}
		pw.println("Neither");

		/**
		 * Not Needed
		 */
		/*
		 * char[][] arr2 = new char[N][N]; for (int i = 0; i < N; i++) { for
		 * (int j = 0; j < N; j++) { arr2[j][N + 1 - i] = arr1[i][j]; } }
		 */

	}
}
