package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MagicalMarvelousTourV1 {

	/**
	 * @param args
	 */

	final static String WORK_DIR = "E:\\testingtestingtesting123\\MagicalMarvelousTour\\";

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new MagicalMarvelousTourV1().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();

	}

	public void solve(Scanner sc, PrintWriter pw) {

		int N = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int r = sc.nextInt();
		int s = sc.nextInt();

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
		int bestLeftPartitionedPivot, bestMiddlePartitionedPivot = 0;
		for (int indices = 0; indices < length; indices++) {
			int pivot = pivotPoint(
					Arrays.copyOfRange(transistor, indices, length), sum,
					indices, length);

			leftValuePartition = sum[indices];
			middleValuePartition = sum[pivot + indices + 1] - sum[indices];
			rightValuePartition = sum[length] - sum[pivot + indices + 1];

			/*
			 * System.out.print(pivot + " " + leftValuePartition + " " +
			 * middleValuePartition + " " + rightValuePartition + " ");
			 */
			if (leftValuePartition >= middleValuePartition
					&& leftValuePartition >= rightValuePartition) {
				/* System.out.println(leftValuePartition); */
				if (maxTransistor < (rightValuePartition + middleValuePartition)) {
					maxTransistor = rightValuePartition + middleValuePartition;
					bestLeftPartitionedPivot = indices;
					bestMiddlePartitionedPivot = indices + pivot;
				}
			} else if (leftValuePartition < middleValuePartition
					&& middleValuePartition >= rightValuePartition) {
				/* System.out.println(middleValuePartition); */
				if (maxTransistor < (leftValuePartition + rightValuePartition)) {
					maxTransistor = leftValuePartition + rightValuePartition;
					bestLeftPartitionedPivot = indices;
					bestMiddlePartitionedPivot = indices + pivot;
				}
			} else {
				if (maxTransistor < (leftValuePartition + middleValuePartition)) {
					maxTransistor = leftValuePartition + middleValuePartition;
					bestLeftPartitionedPivot = indices;
					bestMiddlePartitionedPivot = indices + pivot;
				}
				/* System.out.println(rightValuePartition); */
			}
		}

		double probabilty = maxTransistor / (double)sum[length];
		pw.printf("%.10f", probabilty);
		pw.println();
	}

	private int pivotPoint(long[] arr, long[] sum, int indices, int length) {

		int partitionedPoint = 0;
		int tempLength = arr.length;
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

		return partitionedPoint;
	}
}
