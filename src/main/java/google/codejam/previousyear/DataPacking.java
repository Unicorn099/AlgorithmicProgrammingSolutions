package google.codejam.previousyear;

import static java.util.Arrays.sort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.peeyush.util.MergeSorter;

public class DataPacking {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\DataPacking\\";

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
			new DataPacking().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		int numberOfFiles = sc.nextInt();
		int capacity = sc.nextInt();

		List<Integer> fileSizes = new ArrayList<Integer>();

		for (int i = 0; i < numberOfFiles; i++) {
			fileSizes.add(sc.nextInt());
		}

		fileSizes = new MergeSorter<Integer>().sortFunction(fileSizes);

		boolean[] chkflag = new boolean[numberOfFiles];
		int count = 0;
		int j = 0;
		for (int i = numberOfFiles - 1; i >= 0; i--) {
			if (!chkflag[i]) {
				j = 0;
				for (; j < i;) {
					if (!chkflag[j]) {
						if (fileSizes.get(i) + fileSizes.get(j) <= capacity) {
							j++;
						} else {
							break;
						}
					} else {
						j++;
					}
				}
				j--;
				while (j >= 0) {
					if (j == 0) {
						if (!chkflag[j]) {
							chkflag[j] = true;
							break;
						}
					} else {
						if (!chkflag[j]) {
							chkflag[j] = true;
							break;
						}
					}
					j--;
				}
				chkflag[i] = true;
				count++;
			}
		}
		pw.println(count);
	}

	public void solveMan(Scanner sc, PrintWriter pw) {

		int numberOfFiles = sc.nextInt();
		int capacity = sc.nextInt();

		int[] fileSizes = new int[numberOfFiles];

		for (int i = 0; i < numberOfFiles; i++) {
			fileSizes[i] = sc.nextInt();
		}

		boolean[] used = new boolean[numberOfFiles];
		int num = 0;
		sort(fileSizes);
		for (int i = 0; i < numberOfFiles; i++)
			if (!used[i]) {
				used[i] = true;
				for (int j = numberOfFiles - 1; j >= 0; j--)
					if (!used[j] && fileSizes[i] + fileSizes[j] <= capacity) {
						used[i] = used[j] = true;
						break;
					}
				num++;
			}
		pw.println(num);
	}

}
