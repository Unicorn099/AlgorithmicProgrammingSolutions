package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class CubeIV {

	static class InputData {

		int numberOfRecord;
		int[][] A;
		boolean flagArray[];
		int totalNumbers;

		String strings;

		public InputData(Scanner sc) {

			numberOfRecord = sc.nextInt();
			totalNumbers = (int) Math.pow(numberOfRecord, 2);
			flagArray = new boolean[totalNumbers];
			A = new int[numberOfRecord][numberOfRecord];
			int k = 0;
			for (int i = 0; i < numberOfRecord; i++) {
				for (int j = 0; j < numberOfRecord; j++) {
					A[i][j] = sc.nextInt();
					flagArray[k++] = true;
				}
			}
		}

		public void solve(PrintWriter pw) {
			boolean flag;
			for (int i = 0; i < numberOfRecord; i++) {
				for (int j = 0; j < numberOfRecord; j++) {
					flag = false;
					if ((j != numberOfRecord - 1)
							&& (A[i][j + 1] == A[i][j] + 1)) {
						flag = true;
					} else if (i != numberOfRecord - 1
							&& A[i + 1][j] == A[i][j] + 1) {
						flag = true;
					} else if (i != 0 && A[i - 1][j] == A[i][j] + 1) {
						flag = true;
					} else if (j != 0 && A[i][j - 1] == A[i][j] + 1) {
						flag = true;
					}
					if (!flag) {
						flagArray[A[i][j] - 1] = false;
					}
				}
			}

			int len = 0;
			int startElement = -1;
			int tempStartElement = 0;
			int tempLength = 0;
			for (int ii = 0; ii < flagArray.length; ii++) {
				if (flagArray[ii]) {
					tempLength++;
				} else {
					tempLength++;
					if (len < tempLength) {
						startElement = tempStartElement + 1;
						len = tempLength;
					}
					tempLength = 0;
					tempStartElement = ii + 1;
				}
			}
			pw.println(startElement + " " + len);
		}
	}

	static class Solver implements Callable<String> {

		private InputData in;

		public Solver(InputData in) {
			this.in = in;
		}

		@Override
		public String call() throws Exception {
			StringWriter out = new StringWriter();
			in.solve(new PrintWriter(out));
			return out.toString();
		}

	}

	/**
	 * @param args
	 */

	final static String WORK_DIR = "E:\\testingtestingtesting123\\CubeIV\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR + "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "A-large-practice.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();

		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			Future<String> res = stpe.submit(new Solver(new InputData(sc)));
			results.add(res);
		}
		for (Future<String> result : results) {
			while (!result.isDone()) {
				Thread.sleep(1000);
			}
			pw.print("Case #" + (results.indexOf(result) + 1) + ": ");
			pw.print(result.get());

		}

		pw.flush();
		pw.close();
		sc.close();
		stpe.shutdown();

	}

}
