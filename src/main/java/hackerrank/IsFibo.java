package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsFibo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T;

		List<Long> listFib = new ArrayList<Long>();

		listFib.add(0l);
		listFib.add(1l);
		long fibNext = 1;
		long fibPrevious = 0;
		long fibCurrent = 1;

		while (fibNext < 10000000000l) {
			fibNext = fibPrevious + fibCurrent;
			listFib.add(fibNext);
			fibPrevious = fibCurrent;
			fibCurrent = fibNext;
		}

		long number;
		T = in.nextInt();
		for (int i = 0; i < T; i++) {
			number = in.nextLong();
			System.out.println(listFib.contains(number) ? "isFibo"
					: "isNotFibo");
		}

	}

}
