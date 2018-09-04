package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFixIt {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\FileFixIt\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A-large-practice.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new FileFixIt().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		int existingDir = sc.nextInt();
		int toBeCreated = sc.nextInt();
		sc.nextLine();
		int numberOfCommands = 0;

		List<String> existingDirList = new ArrayList<String>();
		List<String> toBeDirList = new ArrayList<String>();

		for (int i = 0; i < existingDir; i++) {
			existingDirList.add(sc.nextLine());
		}
		for (int i = 0; i < toBeCreated; i++) {
			toBeDirList.add(sc.nextLine());
		}

		existingDirList = makeFolder(existingDirList);
		toBeDirList = makeFolder(toBeDirList);

		/**
		 * Processing
		 */

		for (String str : toBeDirList) {
			if (!existingDirList.contains(str)) {
				numberOfCommands++;
				existingDirList.add(str);
			}
		}

		pw.println(numberOfCommands);
	}

	private List<String> makeFolder(List<String> toBeDirList) {
		List<String> newList = new ArrayList<String>();
		for (String str : toBeDirList) {
			String[] dir = str.split("/");
			String temp = "/";
			for (int i = 1; i < dir.length; i++) {
				temp += dir[i];
				newList.add(temp);
				temp += "/";
			}
		}
		return newList;
	}
}
