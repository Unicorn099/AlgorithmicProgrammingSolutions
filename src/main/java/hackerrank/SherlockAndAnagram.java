package hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagram {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\rank\\test.in"));

		int T = in.nextInt();
		String str = "";
		for (int i = 0; i < T; i++) {
			str = in.next();
			System.out.println(finAnswer(str));
		}
		in.close();
	}

	private static int finAnswer(String str) {
		int result = 0;
		String sorted1 = "", sorted2 = "";

		char[] chars1;// = new char[str.length()];
		char[] chars2;// = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {

			for (int ii = i + 1; ii <= str.length(); ii++) {
				chars1 = str.substring(i, ii).toCharArray();
				Arrays.sort(chars1);
				sorted1 = new String(chars1);

				for (int j = i + 1; j <= str.length() - sorted1.length(); j++) {
					chars2 = str.substring(j, j + sorted1.length())
							.toCharArray();
					Arrays.sort(chars2);
					sorted2 = new String(chars2);
					if (sorted1.equals(sorted2)) {
						result++;
					}
				}

			}
		}
		return result;
	}

}
