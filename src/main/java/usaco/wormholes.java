package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class wormholes {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int numberOfWormHoles = Integer.parseInt(tokenizer.nextToken());

		int[][] wormHoles = new int[numberOfWormHoles + 1][2];
		int i = 1;
		while (i <= numberOfWormHoles) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			wormHoles[i][0] = Integer.parseInt(tokenizer.nextToken());
			wormHoles[i][1] = Integer.parseInt(tokenizer.nextToken());
			i++;
		}

		int[] wormholesNeighbourOnRight = new int[numberOfWormHoles + 1];

		int[] partner = new int[numberOfWormHoles + 1];

		for (int j = 1; j < wormHoles.length; j++) {
			for (int j2 = 1; j2 < wormHoles.length; j2++) {
				if (wormHoles[j][1] == wormHoles[j2][1]
						&& wormHoles[j2][0] > wormHoles[j][0]) {
					if (wormholesNeighbourOnRight[j] == 0
							|| (wormHoles[wormholesNeighbourOnRight[j]][0] - wormHoles[j][0]) > (wormHoles[j2][0] - wormHoles[j][0])) {
						wormholesNeighbourOnRight[j] = j2;
					}
				}
			}
		}

		for (int j = 1; j < wormholesNeighbourOnRight.length; j++) {
			System.out.println(wormholesNeighbourOnRight[j]);
		}

		printWriter.println(findTrueAnswer(wormHoles,
				wormholesNeighbourOnRight, partner));

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static int findTrueAnswer(int[][] wormHoles,
			int[] wormholesNeighbourOnRight, int[] partner) {
		int result = 0;

		// first Unpaired wormHole
		int i = 1;
		for (i = 1; i < partner.length; i++) {
			if (partner[i] == 0) {
				break;
			}
		}

		if (i >= partner.length) {
			if (cycleExists(partner, wormholesNeighbourOnRight)) {
				return 1;
			} else {
				return 0;
			}
		}

		for (int k = i + 1; k < wormHoles.length; k++) {
			if (partner[k] == 0) {
				partner[k] = i;
				partner[i] = k;
				result += findTrueAnswer(wormHoles, wormholesNeighbourOnRight,
						partner);
				partner[k] = 0;
				partner[i] = 0;
			}
		}
		return result;
	}

	private static boolean cycleExists(int[] partner,
			int[] wormholesNeighbourOnRight) {
		for (int i = 1; i < partner.length; i++) {
			int pos = i;
			for (int j = 1; j < partner.length; j++) {
				pos = wormholesNeighbourOnRight[partner[pos]];
			}
			if (pos != 0)
				return true;
		}
		return false;
	}

}
