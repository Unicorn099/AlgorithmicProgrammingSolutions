package hackerrank;

public class Maximize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] { 1, 6, 5, 4, 6 };
		int swaps = 2;

		int[] x = maximize(a, swaps);
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
		}

	}

	static int[] maximize(int[] arr, int swaps) {

		int max = -999999;
		boolean[] flag = new boolean[arr.length];
		int index = 0;
		int ii=0;
		while (swaps > 0) {
			max = -999999;
			
			int xx = ii+swaps+1;
			for (int i = 0; i <= xx && i < arr.length; i++) {
				if (max < arr[i] && !flag[i]) {
					max = arr[i];
					index = i;
				}
			}

			ii = index;
			for (; ii > 0 && swaps > 0; ii--) {
				if (flag[ii - 1]) {
					break;
				}
				int temp = arr[ii];

				arr[ii] = arr[ii - 1];
				arr[ii - 1] = temp;
				swaps--;
			}
			flag[ii] = true;
		}
		return arr;
	}
}
