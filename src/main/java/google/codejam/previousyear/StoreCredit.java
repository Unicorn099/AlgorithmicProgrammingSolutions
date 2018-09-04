package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StoreCredit {

	final static String WORK_DIR = "E:\\testingtestingtesting123\\StoreCredit\\";

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
			new StoreCredit().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	/**
	 * Only two items should be bought, this was asked for
	 */

	private void solveReal(Scanner sc, PrintWriter pw) {
		int totalAmount = sc.nextInt();
		int totalItem = sc.nextInt();
		Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		int[] items = new int[totalItem];
		int temp, key = -1;
		for (int i = 0; i < totalItem; i++) {
			temp = sc.nextInt();
			itemMap.put(i + 1, temp);
			items[i] = temp;
		}
		for (int i = 0; i < totalItem; i++) {
			for (int j = i + 1; j < totalItem; j++) {
				if (items[j] == (totalAmount - items[i])) {
					key = j + 1;
					pw.print(i + 1);
					pw.print(" ");
					pw.println(key);
				}
			}
			if (key != -1) {
				break;
			}
		}
	}

	/**
	 * Minimum index of items should be bought could be more than 2 , this was
	 * not asked for
	 */
	private void solve(Scanner sc, PrintWriter pw) {

		int totalAmount = sc.nextInt();
		int totalItem = sc.nextInt();
		int totalAmountSpent = 0;
		int itemPrice[] = new int[totalItem];
		for (int i = 0; i < totalItem; i++) {
			itemPrice[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (totalAmountSpent != totalAmount) {
			for (; i < totalItem; i++) {
				if (itemPrice[i] > totalAmount
						|| itemPrice[i] > (totalAmount - totalAmountSpent)) {
					continue;
				} else {
					stack.push(i);
					totalAmountSpent += itemPrice[i];
				}
			}
			if (totalAmount != totalAmountSpent && !stack.isEmpty()) {
				i = stack.pop();
				totalAmountSpent -= itemPrice[i];
				i++;
			} else if (totalAmount == totalAmountSpent) {
				break;
			}
		}

		for (Integer st : stack) {
			pw.print(st + 1);
			pw.print(" ");
		}
		pw.println();
	}
}
