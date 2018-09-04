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

public class Super2048 {

	static class InputData {

		int sizeOfPlate;
		String direction = "";
		int a[][];

		public InputData(Scanner sc) {

			sizeOfPlate = sc.nextInt();
			a = new int[sizeOfPlate][sizeOfPlate];
			direction = sc.next();
			sc.nextLine();
			for (int i = 0; i < sizeOfPlate; i++) {
				for (int j = 0; j < sizeOfPlate; j++) {
					a[i][j] = sc.nextInt();
				}
			}
		}

		public void solve(PrintWriter pw) {

			if (direction.equals("right")) {
				solveR(pw);
			} else if (direction.equals("left")) {
				solveL(pw);
			} else if (direction.equals("up")) {
				solveU(pw);
			} else {
				solveD(pw);
			}
		}

		public void solveR(PrintWriter pw) {

			int N = a.length;
			reArrangeR(a);

			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0;) {
					if (a[i][j] == a[i][j - 1]) {
						a[i][j] += a[i][j - 1];
						a[i][j - 1] = 0;
						j = j - 2;
					} else {
						j--;
					}
				}
			}
			reArrangeR(a);

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					pw.print(a[i][j] + " ");
				}
				pw.println();
			}

		}

		private void reArrangeR(int a[][]) {
			int N = a.length;
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (a[i][j] == 0 && j != 0) {
						int k = j - 1;
						while (k >= 0) {
							if (a[i][k] != 0) {
								a[i][j] = a[i][k];
								a[i][k]=0;
								j--;
							}
							k--;
						}
					}
				}
			}

		}

		/** Left */

		public void solveL(PrintWriter pw) {

			int N = a.length;
			reArrangeL(a);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1;) {
					if (a[i][j] == a[i][j + 1]) {
						a[i][j] += a[i][j + 1];
						a[i][j + 1] = 0;
						j = j + 2;
					} else {
						j++;
					}
				}

			}
			reArrangeL(a);

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					pw.print(a[i][j] + " ");
				}
				pw.println();
			}

		}

		private void reArrangeL(int a[][]) {
			int N = a.length;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (a[i][j] == 0 && j != N - 1) {
						int k = j + 1;
						while (k < N) {
							if (a[i][k] != 0) {
								a[i][j] = a[i][k];
								a[i][k]=0;
								j++;
							}
							k++;
						}
					}
				}
			}
		}

		/** Up */
		public void solveU(PrintWriter pw) {

			int N = a.length;
			reArrangeU(a);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1;) {
					if (a[j][i] == a[j + 1][i]) {
						a[j][i] += a[j + 1][i];
						a[j + 1][i] = 0;
						j = j + 2;
					} else {
						j++;
					}
				}
			}
			reArrangeU(a);

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					pw.print(a[i][j] + " ");
				}
				pw.println();
			}

		}

		private void reArrangeU(int a[][]) {
			int N = a.length;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (a[j][i] == 0 && j != N - 1) {
						int k = j + 1;
						while (k < N) {
							if (a[k][i] != 0) {
								a[j][i] = a[k][i];
								a[k][i] = 0;
								j++;
							}
							k++;
						}
					}
				}
			}
		}

		/** Down */
		public void solveD(PrintWriter pw) {

			int N = a.length;
			reArrangeD(a);

			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0;) {
					if (a[j][i] == a[j - 1][i]) {
						a[j][i] += a[j - 1][i];
						a[j - 1][i] = 0;
						j = j - 2;
					} else {
						j--;
					}
				}
			}
			reArrangeD(a);

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					pw.print(a[i][j] + " ");
				}
				pw.println();
			}

		}

		private void reArrangeD(int a[][]) {
			int N = a.length;
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (a[j][i] == 0 && j != 0) {
						int k = j - 1;
						while (k >= 0) {
							if (a[k][i] != 0) {
								a[j][i] = a[k][i];
								a[k][i]=0;
								j--;
							}
							k--;
						}
					}
				}
			}
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

	final static String WORK_DIR = "E:\\testingtestingtesting123\\Super2048\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {

		Scanner sc = new Scanner(new FileReader(WORK_DIR + "B-large-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "small.txt"));

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
			pw.println("Case #" + (results.indexOf(result) + 1) + ": ");
			pw.print(result.get());

		}

		pw.flush();
		pw.close();
		sc.close();
		stpe.shutdown();

	}
}
