package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MagicalMarvelousTourFinalVersion {

	/**
	 * @param args
	 */

	final static String WORK_DIR = "E:\\testingtestingtesting123\\MagicalMarvelousTour\\";

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new MagicalMarvelousTourFinalVersion().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
		long duration = System.currentTimeMillis() - startTime;
		System.out.println(duration);
	}

	public void solve(Scanner sc, PrintWriter pw) {

		int N = sc.nextInt();
		long p = sc.nextInt();
		long q = sc.nextInt();
		long r = sc.nextInt();
		long s = sc.nextInt();

		long[] transistor = new long[N];

		for (int i = 0; i < N; i++) {
			transistor[i] = ((i * p + q) % r + s);
		}

		int length = transistor.length;
		long[] sum = new long[length + 1];
		for (int i = 0; i < length; i++) {
			sum[i + 1] = sum[i] + transistor[i];
		}

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
					- Math.max(leftValuePartition,
							Math.max(rightValuePartition, middleValuePartition));
			if (maxTransistor <= max) {
				maxTransistor = max;
			}

		}

		double probabilty = maxTransistor / (double)sum[length];
		pw.printf("%.15f", probabilty);
		pw.println();
	}

}
