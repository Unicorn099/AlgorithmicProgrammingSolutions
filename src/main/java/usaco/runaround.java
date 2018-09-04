package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class runaround {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\ride.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\ride.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int number = Integer.parseInt(tokenizer.nextToken());

		printWriter.print(getNextNumber(++number));

		printWriter.close();
		bufferedReader.close();
		System.exit(0);

	}

	private static String getNextNumber(int i) {
		String result = String.valueOf(i);
		
		return result;
	}

}
