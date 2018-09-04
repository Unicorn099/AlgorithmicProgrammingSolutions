package google.codejam.previousyear;

import java.util.Stack;

public class Sets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] setElement = new int[3];
		setElement[0] = 1;
		setElement[1] = 2;
		setElement[2] = 3;
		int[] Z = new int[5];
		Z[0] = 1;
		Z[1] = 2;
		Z[2] = 3;
		Z[3] = 4;
		Z[4] = 7;
		solve(setElement, Z[4]);

	}

	private static void solve(int itemPrice[], int totalAmount) {

		int totalItem = itemPrice.length;
		int totalAmountSpent = 0;
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
			} else {
				break;
			}
		}

		if (stack.isEmpty()) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

}
