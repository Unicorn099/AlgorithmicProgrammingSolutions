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

public class LastHit {

	static class InputData {

		public InputData(Scanner sc) {

		}

		public void solve(PrintWriter pw) {

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

	final static String WORK_DIR = "E:\\testingtestingtesting123\\LastHit\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {

		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "B-small-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();

		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			Future<String> res = stpe.submit(new Solver(new InputData(sc)));
			results.add(res);
		}

		for (Future result : results) {
			while (!result.isDone()) {
				Thread.sleep(1000);
			}
			pw.print("Case #" + (results.indexOf(result) + 1) + ": ");
			pw.print(result.get());

		}

		pw.flush();
		pw.close();
		sc.close();

	}

}
