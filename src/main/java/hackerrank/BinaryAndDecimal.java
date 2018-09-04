package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryAndDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 31, 14, 15, 7, 2 };
		swap_array(a);
	}

		static class BD implements Comparable<BD> {
			int count;
			int number;
			String str;
	
			@Override
			public int compareTo(BD o) {
				if (this.count > o.count) {
					return -1;
				} else if (this.count < o.count) {
					return 1;
				} else {
					if (this.number > o.number) {
						return -1;
					} else if (this.number < o.number) {
						return 1;
					} else {
						return 0;
					}
	
				}
			}
	
		}

	static void swap_array(int[] a) {
		List<BD> result = new ArrayList<BD>();

		for (int i = 0; i < a.length; i++) {
			BD bd = new BD();
			bd.number = a[i];
			bd.str = Integer.toBinaryString(a[i]);
			bd.count = bd.str.length() - bd.str.replace("1", "").length();
			result.add(bd);
		}

		Collections.sort(result);
		for (BD bd : result) {
			System.out.println(bd.number);
		}
	}

}
