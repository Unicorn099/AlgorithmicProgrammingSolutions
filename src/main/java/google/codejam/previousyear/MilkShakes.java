package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MilkShakes {

	/**
	 * @param args
	 */
	final static String WORK_DIR = "E:\\testingtestingtesting123\\MilkShakes\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "B-small-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ "output1.txt"));

		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.print("Processing test case " + (caseNum + 1));
			System.out.print(" ");
			long startTime = System.nanoTime();
			pw.print("Case #" + (caseNum + 1) + ": ");
			new MilkShakes().solve(sc, pw);
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			System.out.println(duration);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solve(Scanner sc, PrintWriter pw) {
		int noOfFlavour = sc.nextInt();
		int noOfPerson = sc.nextInt();

		List<ArrayList<ArrayList<Integer>>> flavourOpted = new ArrayList<ArrayList<ArrayList<Integer>>>();

		int[] flavourBatch = new int[noOfFlavour];
		for (int i = 0; i < noOfPerson; i++) {
			int noOfShakes = sc.nextInt();
			List<ArrayList<Integer>> personChoice = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < noOfShakes; j++) {
				List<Integer> flavourAndOption = new ArrayList<Integer>();
				flavourAndOption.add(sc.nextInt());
				flavourAndOption.add(sc.nextInt());
				personChoice.add((ArrayList<Integer>) flavourAndOption);
				if (noOfShakes == 1 && flavourAndOption.get(1) == 1) {
					flavourBatch[flavourAndOption.get(0) - 1] = 1;
				}
			}
			flavourOpted.add((ArrayList<ArrayList<Integer>>) personChoice);
		}

		boolean flag;
		for (int i = 0; i < noOfPerson; i++) {
			flag = false;
			for (int j = 0; j < flavourOpted.get(i).size(); j++) {
				if (flavourOpted.get(i).get(j).get(1) == flavourBatch[flavourOpted
						.get(i).get(j).get(0) - 1]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (int j = 0; j < flavourOpted.get(i).size(); j++) {
					if (flavourOpted.get(i).get(j).get(1) == 1) {
						if (flavourBatch[flavourOpted.get(i).get(j).get(0) - 1] != 1) {
							flavourBatch[flavourOpted.get(i).get(j).get(0) - 1] = 1;
							flag = true;
							i = -1;
							break;
						} else {
							break;
						}
					}
				}
			}
			if (!flag) {
				pw.println("IMPOSSIBLE");
				return;
			}
		}
		for (int i = 0; i < noOfFlavour; i++) {
			pw.print(flavourBatch[i]);
			pw.print(" ");
		}
		pw.println();
	}
}
