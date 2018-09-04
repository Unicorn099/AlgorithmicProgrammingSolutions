package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 ID: mib.2oj1
 LANG: JAVA
 TASK: ride
 */

class ride {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\ride.in"));
		// input file name goes above
		PrintWriter printWriter = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer stringTokenizer = new StringTokenizer(
				bufferedReader.readLine());
		// Get line, break into tokens

		String comet = stringTokenizer.nextToken();
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String groupName = stringTokenizer.nextToken();

		Long cometValue = new Long(1);
		Long groupNameValue = new Long(1);
		for (int i = 0; i < comet.length(); i++) {
			cometValue *= comet.charAt(i) - 64;
		}

		for (int i = 0; i < groupName.length(); i++) {
			groupNameValue *= groupName.charAt(i) - 64;
		}

		if (groupNameValue % 47 == cometValue % 47) {
			printWriter.println("GO"); // output result
		} else {
			printWriter.println("STAY");
		}

		printWriter.close(); // close the output file
		System.exit(0); // don't omit this!

	}

}
