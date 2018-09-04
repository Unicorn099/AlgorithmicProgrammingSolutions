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

public class MagicalMarvelousTourThreaded {

	static class InputData {
		int N;
		long p;
		long q;
		long r;
		long s;
		long sum[];
		int length;

		public InputData(Scanner sc) {

			N = sc.nextInt();
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			s = sc.nextInt();

			long[] transistor = new long[N];

			for (int i = 0; i < N; i++) {
				transistor[i] = ((i * p + q) % r + s);
			}

			length = transistor.length;
			sum = new long[length + 1];
			for (int i = 0; i < length; i++) {
				sum[i + 1] = sum[i] + transistor[i];
			}

		}

		public void solve(PrintWriter pw) {

			long leftValuePartition, middleValuePartition, rightValuePartition = 0;
			double maxTransistor = 0;
			for (int indices = 0; indices < length; indices++) {

				int partitionedPoint = 0;
				int tempLength = length - indices;
				int index = 0;
				int k = 0;
				long minDifference = sum[length];

				while (index < tempLength) {
					k = (index + tempLength) / 2;
					long leftSum = sum[k + indices + 1] - sum[indices];
					long rightSum = sum[length] - sum[k + indices + 1];
					if (leftSum < rightSum) {
						if (minDifference > (rightSum - leftSum)) {
							minDifference = rightSum - leftSum;
							partitionedPoint = k;
						}
						index = k + 1;
					} else if (leftSum > rightSum) {
						if (minDifference > (leftSum - rightSum)) {
							minDifference = leftSum - rightSum;
							partitionedPoint = k;
						}
						tempLength = k;
					} else {
						minDifference = 0;
						partitionedPoint = k;
						break;
					}
				}

				leftValuePartition = sum[indices];
				middleValuePartition = sum[partitionedPoint + indices + 1]
						- sum[indices];
				rightValuePartition = sum[length]
						- sum[partitionedPoint + indices + 1];

				long max = sum[length]
						- Math.max(leftValuePartition, Math.max(
								rightValuePartition, middleValuePartition));
				if (maxTransistor <= max) {
					maxTransistor = max;
				}

			}

			double probabilty = maxTransistor / (double) sum[length];
			pw.printf("%.15f", probabilty);
			pw.println();

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

	final static String WORK_DIR = "E:\\testingtestingtesting123\\MagicalMarvelousTour\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {

		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();

		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			Future res = stpe.submit(new Solver(new InputData(sc)));
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
		stpe.shutdown();
		long duration = System.currentTimeMillis() - startTime;
		System.out.println(duration);
	}
}
