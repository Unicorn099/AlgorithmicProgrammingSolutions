package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class castle {

	static boolean[][] roomChecked;
	static int maxArea, tempArea;

	static int[] area;

	class Room {
		/** S,E,N,W */
		boolean[] wall = new boolean[4];
		int color;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:\\Users\\Peeyush\\workspace_juno\\Jam\\src\\com\\peeyush\\usaco\\beads.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);

		int col = Integer.parseInt(tokenizer.nextToken());
		int row = Integer.parseInt(tokenizer.nextToken());

		castle castle = new castle();
		area = new int[row * col];

		Room[][] rooms = new Room[row][col];
		for (int i = 0; i < row; i++) {
			line = bufferedReader.readLine();
			tokenizer = new StringTokenizer(line);
			for (int j = 0; j < col; j++) {
				Room room = castle.new Room();
				String details = String.format(
						"%4s",
						Integer.toBinaryString(
								Integer.parseInt(tokenizer.nextToken()))
								.replace(' ', '0'));

				for (int k = 0; k < details.length(); k++) {
					if (details.charAt(k) == '1') {
						room.wall[k] = true;
					}
				}
				rooms[i][j] = room;
			}
		}

		roomChecked = new boolean[row][col];

		printTheCastle(rooms);

		printWriter.println(countRooms(rooms));
		printWriter.println(maxArea);

		findTheWall(rooms, printWriter);

		bufferedReader.close();
		printWriter.close();
	}

	/**
	 * Assigning the color to the rooms based on the connectivity
	 * 
	 * @param rooms
	 * @param i
	 * @param j
	 * @param colorr
	 * @return
	 */
	private static int assignColor(Room[][] rooms, int i, int j, int colorr) {
		/** S,E,N,W */
		if (!roomChecked[i][j]) {
			rooms[i][j].color = colorr;
			roomChecked[i][j] = true;
			tempArea++;

			if (!rooms[i][j].wall[0]) {
				assignColor(rooms, i + 1, j, colorr);
			}
			if (!rooms[i][j].wall[1]) {
				assignColor(rooms, i, j + 1, colorr);
			}
			if (!rooms[i][j].wall[2]) {
				assignColor(rooms, i - 1, j, colorr);
			}
			if (!rooms[i][j].wall[3]) {
				assignColor(rooms, i, j - 1, colorr);
			}

			colorr++;
			area[colorr - 1] = tempArea;

		}
		return colorr;
	}

	/**
	 * Counting the rooms which are not connected with each other
	 * 
	 * @param rooms
	 * @return
	 */
	private static int countRooms(Room[][] rooms) {

		int colorr = 0;
		maxArea = 0;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				tempArea = 0;

				colorr = assignColor(rooms, i, j, colorr);

				if (tempArea > maxArea) {
					maxArea = tempArea;
				}
			}
		}
		return colorr;
	}

	/**
	 * Printing the castle for visual representation
	 * 
	 * @param rooms
	 */
	private static void printTheCastle(Room[][] rooms) {
		int row = rooms.length;
		int col = rooms[0].length;
		for (int i = 0; i < row; i++) {
			System.out.print(" ");
			for (int j = 0; j < col; j++) {
				if (rooms[i][j].wall[2]) {
					System.out.print("--");
				} else {
					System.out.print("  ");
				}
				System.out.print(" ");
			}
			System.out.println();
			if (rooms[i][0].wall[3]) {
				System.out.print("|");
			} else {
				System.out.print(" ");
			}
			System.out.print("  ");
			for (int j = 1; j < col; j++) {
				if (rooms[i][j].wall[3]) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
				System.out.print("  ");
			}
			if (rooms[i][col - 1].wall[1]) {
				System.out.print("|");
			} else {
				System.out.print("  ");
			}

			System.out.print(" ");
			System.out.println();
		}

		for (int j = 0; j < col; j++) {
			System.out.print(" ");
			if (rooms[row - 1][j].wall[0]) {
				System.out.print("--");
			} else {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	/**
	 * Finding the wall which if removed will make the room largest of all
	 * 
	 * @param rooms
	 * @param printWriter
	 */
	private static void findTheWall(Room[][] rooms, PrintWriter printWriter) {

		/** S E N W */
		int ar = 0;
		int row = rooms.length, col = rooms[0].length;
		String direction = "";

		for (int j = 0; j <= rooms[0].length - 1; j++) {
			for (int i = rooms.length - 1; i >= 0; i--) {

				if (rooms[i][j].wall[2] && i != 0
						&& rooms[i][j].color != rooms[i - 1][j].color) {
					if (ar < area[rooms[i][j].color]
							+ area[rooms[i - 1][j].color]) {
						ar = area[rooms[i][j].color]
								+ area[rooms[i - 1][j].color];
						direction = "N";
						row = i;
						col = j;
					}
				}

				if (rooms[i][j].wall[1] && j != rooms[0].length - 1
						&& rooms[i][j].color != rooms[i][j + 1].color) {
					if (ar < area[rooms[i][j].color]
							+ area[rooms[i][j + 1].color]) {
						ar = area[rooms[i][j].color]
								+ area[rooms[i][j + 1].color];
						direction = "E";
						row = i;
						col = j;
					}
				}
			}
		}

		printWriter.println(ar);
		printWriter.println((row + 1) + " " + (col + 1) + " " + direction);
	}

}
