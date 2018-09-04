package google.codejam.previousyear;

public class Substring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "XxAa";
		System.out.println(count(str));
	}

	public static int count(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String substring = str.substring(i, j);
				System.out.println(substring);
				boolean flag = false;
				for (int k = 0; k < substring.length(); k++) {
					flag = false;
					if (substring.charAt(k) != 'A'
							&& substring.charAt(k) != 'a'
							&& substring.charAt(k) != 'B'
							&& substring.charAt(k) != 'b'
							&& substring.charAt(k) != 'C'
							&& substring.charAt(k) != 'c') {
						break;
					} else {
						flag = true;
					}
				}
				if (flag) {
					count++;
				}
			}
		}
		return count;
	}
}
