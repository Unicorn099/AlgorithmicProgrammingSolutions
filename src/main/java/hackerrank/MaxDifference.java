package hackerrank;

public class MaxDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 7, 2, 3, 10, 2, 4, 8, 1 };

		System.out.println(maxDifference(a));

	}

	static int maxDifference(int[] a) {
		int result = 0;
		int min = a[0], max = a[1];
		result = max - min;
		for (int i = 1; i < a.length; i++) {
			if ((a[i] - min) > (result)) {
				result = a[i] - min;
				System.out.println(result);
			}
			if (min > a[i]) {
				min = a[i];
			}
		}
		return result;

	}

}
