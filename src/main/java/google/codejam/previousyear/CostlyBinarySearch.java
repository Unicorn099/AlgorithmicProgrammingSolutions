package google.codejam.previousyear;

import java.util.Arrays;

public class CostlyBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int[] input = new int[] { 1, 1, 1, 1, 1, 1, 9 };
		//int[] input = new int[] { 4, 6 };
		System.out.println(new CostlyBinarySearch().cost(input));
	}

	private int cost(int[] input) {
		int result = 0, result1 = 0, result2 = 0;
		int start = 0, end = input.length - 1;
		int mid = (start + end) / 2;
		result = input[mid];
		if (start < mid) {
			result1 += cost(Arrays.copyOfRange(input, start, mid));
		}
		if ((mid + 1) <= end) {
			result2 += cost(Arrays.copyOfRange(input, mid + 1, end + 1));
		}
		result += result1 > result2 ? result1 : result2;
		return result;
	}
}
