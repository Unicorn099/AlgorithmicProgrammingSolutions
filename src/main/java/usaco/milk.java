package usaco;

/*
ID: mib.2oj1
LANG: JAVA
TASK: milk
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class milk {

	static class FarmerDetails implements Comparable<FarmerDetails> {
		int rate;
		int milkHas;

		@Override
		public int compareTo(FarmerDetails o) {
			if (this.rate < o.rate) {
				return -1;
			} else if (this.rate > o.rate) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"milk.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"milk.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);

		int milkNeeded = Integer.parseInt(tokenizer.nextToken());
		int numberOfFarmers = Integer.parseInt(tokenizer.nextToken());

		List<FarmerDetails> farmersDetails = new ArrayList<FarmerDetails>();

		for (int i = 0; i < numberOfFarmers; ++i) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			FarmerDetails farmerDetail = new FarmerDetails();
			farmerDetail.rate = Integer.parseInt(tokenizer.nextToken());
			farmerDetail.milkHas = Integer.parseInt(tokenizer.nextToken());
			farmersDetails.add(farmerDetail);
		}

		Collections.sort(farmersDetails);
		printWriter.println(findAnswer(milkNeeded, farmersDetails));

		printWriter.close();
		bufferedReader.close();
		System.exit(0);
	}

	private static int findAnswer(int milkNeeded,
			List<FarmerDetails> farmersDetails) {
		int amount = 0;

		for (FarmerDetails farmer : farmersDetails) {
			if (milkNeeded != 0) {
				if (milkNeeded >= farmer.milkHas) {
					milkNeeded -= farmer.milkHas;
					amount += (farmer.rate * farmer.milkHas);
				} else {
					amount += (farmer.rate * milkNeeded);
					milkNeeded = 0;
				}
			} else {
				break;
			}
		}

		return amount;
	}
}
