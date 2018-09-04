package usaco;

/*
ID: mib.2oj1
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class gift1 {

	public static void main(String[] args) throws IOException {

		Map<String, Integer> status = new LinkedHashMap<String, Integer>();
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"gift1.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"gift1.out"));

		String line = bufferedReader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);

		int numberOfPerson = Integer.parseInt(tokenizer.nextToken());

		for (int index = 0; index < numberOfPerson
				&& (line = bufferedReader.readLine()) != null; index++) {
			tokenizer = new StringTokenizer(line);
			if (tokenizer.hasMoreElements())
				status.put(tokenizer.nextToken(), 0);
		}

		String name = "";
		int ng = 0, amount = 0, tempamount = 0;
		while ((line = bufferedReader.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			name = tokenizer.nextToken();

			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);

			amount = Integer.parseInt(tokenizer.nextToken());
			ng = Integer.parseInt(tokenizer.nextToken());

			tempamount = status.get(name);
			tempamount = tempamount - amount
					+ (ng == 0 ? (amount) : (amount % ng));
			status.put(name, tempamount);

			for (int i = 0; i < ng; i++) {

				line = bufferedReader.readLine();
				tokenizer = new StringTokenizer(line);

				name = tokenizer.nextToken();
				tempamount = status.get(name);
				tempamount += amount / ng;
				status.put(name, tempamount);
			}
		}

		for (Map.Entry<String, Integer> var : status.entrySet()) {
			System.out.println("Key = " + var.getKey() + ", Value = "
					+ var.getValue());
			printWriter.println(var.getKey() + " " + var.getValue());
		}

		printWriter.close();
		System.exit(0);
	}
}
