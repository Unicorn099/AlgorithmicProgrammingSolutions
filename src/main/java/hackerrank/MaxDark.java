package hackerrank;

public class MaxDark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str=new String[]{
		"1001","0001","0001","0000"
		};
		System.out.println(max_dark(str));
	}

	static String max_dark(String[] arr) {

		String str = "";

		int area = arr.length * arr[0].length();
		int ans = 0;

		for (int ii = arr.length - 1; ii >= 0; ii--) {
			for (int i = 0; i < ii; i++) {
				for (int j = 0; j < arr[i].length(); j++) {
					for (int k = arr[i].length() - 1; k > j; k--) {
						ans &= Integer.parseInt(arr[i].substring(j, k));
						if (ans == 0) {
							str = "" + (j * k) + " " + ((j * k) / area);
							return str;
						}
					}
				}
			}
		}
		return str;
	}
}
