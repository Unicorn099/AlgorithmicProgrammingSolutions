package hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class AshtonAndString {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\rank\\test.in"));

		int T = in.nextInt();
		String str = "", res = "";
		String sorted1 = "";
		int charIndex;
		StringBuffer buffer = new StringBuffer("");

		SortedSet<String> resList = new TreeSet<String>();

		for (int i = 0; i < T; i++) {
			str = in.next();
			charIndex = in.nextInt();
			for (int j1 = 0; j1 < str.length(); j1++) {
				for (int j2 = j1 + 1; j2 <= str.length(); j2++) {
					resList.add(str.substring(j1, j2));
				}
			}

			for (String s : resList) {
				buffer.append(s);
			}
			res = buffer.toString();
			System.out.println(res);
			System.out.println(res.charAt(charIndex - 1));
		}
	}

}
