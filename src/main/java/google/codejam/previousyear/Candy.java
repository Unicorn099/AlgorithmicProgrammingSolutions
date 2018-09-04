package google.codejam.previousyear;

public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long arr[] = new long[3];
		arr[0] = 8;
		arr[1] = 8;
		arr[2] = 8;
		System.out.println(result(arr));
	}

	public static long result(long arr[]) {
		long res = 0;

		int index = 0;
		long temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (temp > arr[i]) {
				temp = arr[i];
				index = i;
			}
		}
		res = temp;
		for (int i = 0; i < arr.length; i++) {
			if (index != i) {
				res += arr[i] - 1;
			}
		}
		return res;
	}

}
