package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.peeyush.util.InversionInAPermutation;

public class RopeIntranet {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\RopeIntranet\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ "output1.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.print("Processing test case " + (caseNum + 1));
			System.out.print(" ");
			long startTime = System.nanoTime();
			pw.print("Case #" + (caseNum + 1) + ": ");
			new RopeIntranet().solveOptimalReal(sc, pw);
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			System.out.println(duration);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		int numberOfwires = sc.nextInt();
		int A[] = new int[numberOfwires];
		int B[] = new int[numberOfwires];
		int intersections = 0;
		for (int i = 0; i < numberOfwires; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		if (numberOfwires == 1) {
			pw.println(intersections);
		} else {
			/**
			 * Processing starts here
			 */
			for (int i = 0; i < numberOfwires; i++) {
				for (int j = i + 1; j < numberOfwires; j++) {
					if ((A[i] > A[j] && B[i] < B[j])
							|| (A[i] < A[j] && B[i] > B[j])) {
						intersections++;
					}
				}
			}
			pw.println(intersections);
		}
	}

	private void solveOptimalReal(Scanner sc, PrintWriter pw) {

		int numberOfwires = sc.nextInt();
		int A[] = new int[numberOfwires];
		int B[] = new int[numberOfwires];
		List<Integer> AA = new ArrayList<Integer>();
		List<Integer> BB = new ArrayList<Integer>();
		for (int i = 0; i < numberOfwires; i++) {
			A[i] = sc.nextInt();
			AA.add(A[i]);
			B[i] = sc.nextInt();
			BB.add(B[i]);
		}

		AA = sortFunction(AA);
		BB = sortFunction(BB);

		int permutations[] = new int[numberOfwires];
		// BinarySearch<Integer> binSearch = new BinarySearch<Integer>();
		for (int i = 0; i < numberOfwires; i++) {
			permutations[binarySearchRecursive(AA, A[i])] = binarySearchRecursive(
					BB, B[i]);
		}

		int intersections = 0;

		List<Integer> perms = new ArrayList<Integer>();
		for (int i = 0; i < numberOfwires; i++) {
			perms.add(permutations[i]);
		}
		InversionInAPermutation inp = new InversionInAPermutation();
		inp.sortFunction(perms);
		intersections = inp.count;
		pw.println(intersections);
	}

	public List<Integer> sortFunction(List<Integer> tempListOfInteger) {

		int totalNumberOfElements = tempListOfInteger.size();
		if (totalNumberOfElements == 1) {
			return tempListOfInteger;
		} else {
			List<Integer> list1 = tempListOfInteger.subList(0,
					(totalNumberOfElements) / 2);
			List<Integer> list2 = tempListOfInteger.subList(
					((totalNumberOfElements) / 2), totalNumberOfElements);

			List<Integer> tempList1 = sortFunction(list1);
			List<Integer> tempList2 = sortFunction(list2);
			List<Integer> tobeListOfInteger = merge(tempList1, tempList2);
			return tobeListOfInteger;
		}
	}

	public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
		List<Integer> toBeReturnedList = new ArrayList<Integer>();
		int list1Size = list1.size();
		int list2Size = list2.size();

		int i = 0, j = 0;
		while (i < list1Size && j < list2Size) {
			if (list1.get(i).doubleValue() < list2.get(j).doubleValue()) {
				toBeReturnedList.add(list1.get(i));
				i++;
			} else {
				toBeReturnedList.add(list2.get(j));
				j++;
			}
		}

		if (i >= list1Size) {
			for (; j < list2Size; j++) {
				toBeReturnedList.add(list2.get(j));
			}
		}
		if (j >= list2Size) {
			for (; i < list1Size; i++) {
				toBeReturnedList.add(list1.get(i));
			}
		}
		return toBeReturnedList;
	}

	public int binarySearchRecursive(List<Integer> intList, int i) {
		int length = intList.size();
		int mid = length / 2;
		if (length == 0) {
			return -1;
		} else {
			if (intList.get(mid).doubleValue() == i) {
				return mid;
			} else if (intList.get(mid).doubleValue() < i) {
				int temp = binarySearchRecursive(
						intList.subList(mid + 1, length), i);
				if (temp == -1) {
					return -1;
				} else {
					mid += temp + 1;
					return mid;
				}
			} else {
				int temp = binarySearchRecursive(intList.subList(0, mid), i);
				if (temp == -1) {
					return -1;
				} else {
					return temp;
				}
			}

		}
	}

}
