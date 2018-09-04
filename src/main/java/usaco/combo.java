package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class combo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);

		int options = Integer.parseInt(tokenizer.nextToken());
		int[] farmerLock = new int[3];
		int[] masterLock = new int[3];

		line = bufferedReader.readLine();
		tokenizer = new StringTokenizer(line);
		for (int j = 0; j < 3; j++) {
			farmerLock[j] = Integer.parseInt(tokenizer.nextToken());
		}

		line = bufferedReader.readLine();
		tokenizer = new StringTokenizer(line);
		for (int i = 0; i < 3; i++) {

			masterLock[i] = Integer.parseInt(tokenizer.nextToken());
		}

		printWriter.println(findAnswer(farmerLock, masterLock, options));

		printWriter.close();
		bufferedReader.close();
		System.exit(0);

	}

	private static int findAnswer(int[] farmerLock, int[] masterLock,
			int options) {
		int count = 0;

		int size = options < 5 ? options : 5;
		int[][] farmersOption = new int[size][3];
		int[][] masterOption = new int[size][3];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < farmerLock.length; j++) {
				farmersOption[i][j] = (farmerLock[j] - 2 + i) < 1 ? options
						+ (farmerLock[j] - 2 + i)
						: (farmerLock[j] - 2 + i) > options ? (farmerLock[j] - 2 + i)
								- options
								: (farmerLock[j] - 2 + i);
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < masterLock.length; j++) {
				masterOption[i][j] = (masterLock[j] - 2 + i) < 1 ? options
						+ (masterLock[j] - 2 + i)
						: (masterLock[j] - 2 + i) > options ? (masterLock[j] - 2 + i)
								- options
								: (masterLock[j] - 2 + i);
			}
		}

		Map<Integer, Integer> possibleLock = new HashMap<Integer, Integer>();
		int lock;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					lock = farmersOption[i][0] * 100 + farmersOption[j][1] * 10
							+ farmersOption[k][2];
					possibleLock.put(lock, lock);
				}
			}

		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					lock = masterOption[i][0] * 100 + masterOption[j][1] * 10
							+ masterOption[k][2];
					possibleLock.put(lock, lock);
				}
			}

		}
		count = possibleLock.size();
		return count;
	}
}
