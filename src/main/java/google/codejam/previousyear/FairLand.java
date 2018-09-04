package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FairLand {

	final static String WORK_DIR = "E:\\testingtestingtesting123\\FairLand\\";
	static boolean removed[];
	static String[] managerEmployee;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "A.in"));
		PrintWriter pw = new PrintWriter(
				new FileWriter(WORK_DIR + "output.txt"));
		int caseCnt = sc.nextInt();
		sc.nextLine();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new FairLand().solveReal(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private void solveReal(Scanner sc, PrintWriter pw) {

		int N = sc.nextInt();
		int D = sc.nextInt();

		int peopleSalary[] = new int[N];
		int manager[] = new int[N];
		int managerDetails[] = new int[N];

		managerEmployee = new String[N];
		for (int i = 0; i < N; i++) {
			managerEmployee[i] = "";
		}

		int S0 = sc.nextInt();
		int As = sc.nextInt();
		int Cs = sc.nextInt();
		int Rs = sc.nextInt();

		int M0 = sc.nextInt();
		int Am = sc.nextInt();
		int Cm = sc.nextInt();
		int Rm = sc.nextInt();
		peopleSalary[0] = S0;
		manager[0] = M0;
		managerDetails[0] = 0;
		int employee[] = new int[N];

		for (int i = 1; i < N; i++) {
			peopleSalary[i] = (peopleSalary[i - 1] * As + Cs) % Rs;
			manager[i] = (manager[i - 1] * Am + Cm) % Rm;
			managerDetails[i] = manager[i] % i;
			employee[manager[i] % i]++;
			managerEmployee[managerDetails[i]] += i;
		}

		int minRange = (peopleSalary[0] - D) < 0 ? peopleSalary[0]
				: (peopleSalary[0] - D);
		int maxRange = peopleSalary[0] + D;

		int numbersOfRemoval = N, tempCount = 0;
		for (int i = minRange; i <= maxRange - D && i <= i + D; i++) {
			tempCount = 0;
			removed = new boolean[N];
			for (int j = 0; j < N; j++) {
				if (peopleSalary[j] < i || peopleSalary[j] > (i + D)) {
					tempCount += removeThisEmployee(j);
				}
			}
			if (numbersOfRemoval > tempCount) {
				numbersOfRemoval = tempCount;
			}
		}
		pw.println(N - numbersOfRemoval);
	}

	private static int removeThisEmployee(int j) {

		if (removed[j]) {
			return 0;
		} else {
			int count = 1;
			for (int i = 0; i < managerEmployee[j].length(); i++) {
				count += removeThisEmployee(
				Character.getNumericValue(managerEmployee[j].charAt(i)));
			}
			removed[j] = true;
			return count;
		}
	}

}
