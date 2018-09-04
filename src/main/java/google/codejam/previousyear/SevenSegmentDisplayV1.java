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

public class SevenSegmentDisplayV1 {

	/**
	 * @param args
	 */

	static class InputData {

		String sequence[] = { "1111011", "1111111", "1110000", "1011111",
				"1011011", "0110011", "1111001", "1101101", "0110000",
				"1111110" };

		int[] led1 = new int[7];
		int[] led2 = new int[7];
		int numberOfRecord;
		String[] cycles;

		public InputData(Scanner sc) {

			numberOfRecord = sc.nextInt();
			cycles = new String[numberOfRecord];
			for (int i = 0; i < numberOfRecord; i++) {
				cycles[i] = sc.next();

				for (int j = 0; j < cycles[i].length(); j++) {
					if (cycles[i].charAt(j) != '0') {
						led1[j] = 1;
					}
				}
			}
		}

		public void solve(PrintWriter pw) {

			int ansSequence = -1, i = 0, j, start = 0;
			boolean flag = false, glaf = true;
			while (true) {
				j = 0;

				for (int xyz = 0; xyz < 7 && glaf; xyz++) {
					if (led2[xyz] != 0) {
						glaf = false;
					}
				}

				for (int xyz = 0; xyz < 7; xyz++) {
					led2[xyz] = 1;
				}
				while (j < numberOfRecord) {
					if (check(cycles[j], sequence[i])) {
						i = (i + 1) % 10;
						j++;
					} else {
						break;
					}
				}
				if (j == numberOfRecord) {
					if (ansSequence == -1) {
						ansSequence = i;
						flag = true;
					} else {
						if (ansSequence != i) {
							if (!glaf) {
								pw.println("ERROR!");
								return;
							}
						} else {
							String ans = "";
							for (int k = 0; k < 7; k++) {
								if (led1[k] == led2[k]) {
									if (led1[k] == 1) {
										ans += sequence[ansSequence].charAt(k);
									} else {
										ans += "0";
									}
								} else {
									if (sequence[ansSequence].charAt(k) != '0') {
										pw.println("ERROR!");
										return;
									} else {
										ans += "0";
									}
								}
							}
							pw.println(ans);
							return;
						}
					}
				}
				if (start == 9 && !flag) {
					pw.print("ERROR!");
					pw.println();
					return;
				}

				if (start == 9 && glaf) {
					pw.println("0000000");
					return;
				}
				start = (start + 1) % 10;
				i = start;
			}
		}

		private boolean check(String a, String b) {

			for (int i = 0; i < 7; i++) {
				if (!((a.charAt(i) == b.charAt(i) && led1[i] == 1) || (led1[i] == 0))) {
					return false;
				} else {
					if (a.charAt(i) != b.charAt(i) && led1[i] == 0) {
						led2[i] = 0;
					}
				}
			}
			return true;
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

	final static String WORK_DIR = "E:\\testingtestingtesting123\\SevenSegmentDisplay\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {

		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ "A-large-practice.txt"));

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
