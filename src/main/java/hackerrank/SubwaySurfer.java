package hackerrank;

public class SubwaySurfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr1[] = { 9, 15, 21, 27, 60, 75, 90, 120, 165, 168, 171, 180, 186 };
		int arr2[] = { 3, 12, 21, 33, 42, 75, 132, 141, 165, 171, 300 };

		System.out.println(solve(arr1, arr2));
	}

	private static int solve(int[] arr1, int[] arr2) {

		int finalAnswer = 0;
		String fullPath = "";
		int sum1 = 0, sum2 = 0;
		String s1 = "", s2 = "";
		int index = 0;
		for (; index < arr1.length && index < arr2.length;) {
			sum1 = 0;
			sum2 = 0;
			s1 = "";
			s2 = "";

			while (index < arr1.length && index < arr2.length
					&& arr1[index] != arr2[index]) {
				sum1 += arr1[index];
				s1 += arr1[index] + " ";
				sum2 += arr2[index];
				s2 += arr2[index] + " ";
				index++;
			}

			if (index >= arr1.length)
				while (index < arr2.length) {
					sum2 += arr2[index];
					s2 += arr2[index] + " ";
					index++;
				}
			if (index >= arr2.length)
				while (index < arr1.length) {
					sum1 += arr1[index];
					s1 += arr1[index] + " ";
					index++;
				}

			if (sum1 > sum2) {
				finalAnswer += sum1;
				fullPath += s1 + " ";
			} else {
				finalAnswer += sum2;
				fullPath += s2 + " ";
			}

			if (index < arr1.length && index < arr2.length) {
				finalAnswer += arr2[index];
				fullPath += arr2[index] + " ";
				index++;
			}
		}

		System.out.println(fullPath);
		return finalAnswer;
	}

}
