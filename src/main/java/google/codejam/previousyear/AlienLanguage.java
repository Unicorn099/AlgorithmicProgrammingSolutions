package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlienLanguage {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\AlienLanguage\\";

	private static List<String> strList = new ArrayList<String>();
	private static int lengths;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		lengths = sc.nextInt();
		int accpetableStrings = sc.nextInt();
		int caseCnt = sc.nextInt();
		sc.nextLine();

		String str = new String("");
		for (int i = 0; i < accpetableStrings; i++) {
			str = sc.nextLine();
			strList.add(str);
		}

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new AlienLanguage().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();

	}

	private void solveReal(Scanner sc, PrintWriter pw) {
		String alienString = sc.nextLine();
		int count = 0;
		boolean flag = false;
		for (String str : strList) {
			flag = true;
			if ((lengths != alienString.length() && !alienString.contains("("))
					|| (lengths > alienString.length())) {
				flag = false;
			} else {
				for (int i = 0; i < lengths;) {
					for (int j = 0; j < alienString.length();) {
						if (alienString.charAt(j) != '(') {
							if (alienString.charAt(j) == str.charAt(i)) {
								i++;
								j++;
							} else {
								i = lengths;
								flag = false;
								break;
							}
						} else {
							do {
								j++;
								flag = false;
								if (alienString.charAt(j) == str.charAt(i)) {
									i++;
									j++;
									flag = true;
									while (alienString.charAt(j) != ')') {
										j++;
									}
								}
							} while (alienString.charAt(j) != ')');
							j++;
							if (!flag) {
								i = lengths;
								break;
							}
						}
					}
				}
			}
			if (flag) {
				count++;
			}
		}
		pw.println(count);
	}
}