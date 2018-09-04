package usaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Roman implements Comparable<Roman> {
	public String numeral;
	public int count;

	public Roman(String numeral, int count) {
		this.numeral = numeral;
		this.count = count;
	}

	@Override
	public int compareTo(Roman o) {
		if (this.count < o.count) {
			return -1;
		} else if (this.count > o.count) {
			return 1;
		} else
			return 0;
	}
}

public class preface {

	public static Roman[] numbersInRoman = new Roman[] { new Roman("I", 0),
			new Roman("V", 0), new Roman("X", 0), new Roman("L", 0),
			new Roman("C", 0), new Roman("D", 0), new Roman("M", 0) };

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"C:/Users/Peeyush/workspace_juno/Jam/src/com/peeyush/usaco/preface.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"C:/Users/Peeyush/workspace_juno/Jam/src/com/peeyush/usaco/preface.out"));

		String line = bufferedReader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int pageNumber = Integer.parseInt(tokenizer.nextToken());
		solve(pageNumber, printWriter);
		printWriter.close();
		bufferedReader.close();
	}

	private static void solve(int pageNumber, PrintWriter printWriter) {

		int thp = pageNumber / 1000;
		for (int firstIndex = 0; firstIndex < thp; firstIndex++) {
			for (int secondIndex = 0; secondIndex <= 9; secondIndex++) {
				for (int thirdIndex = 0; thirdIndex <= 9; thirdIndex++) {
					for (int fourthIndex = 0; fourthIndex <= 9; fourthIndex++) {
						handleOneToNine(fourthIndex, 0);
						handleOneToNine(thirdIndex, 2);
						handleOneToNine(secondIndex, 4);
						handleOneToNine(firstIndex, 6);
					}
				}
			}
		}
		for (int firstIndex = 0; firstIndex <= (pageNumber % 1000); firstIndex++) {
			handleOneToNine(thp, 6);
		}
		pageNumber = pageNumber % 1000;
		int hp = pageNumber / 100;
		for (int secondIndex = 0; secondIndex < hp; secondIndex++) {
			for (int thirdIndex = 0; thirdIndex <= 9; thirdIndex++) {
				for (int fourthIndex = 0; fourthIndex <= 9; fourthIndex++) {
					handleOneToNine(fourthIndex, 0);
					handleOneToNine(thirdIndex, 2);
					handleOneToNine(secondIndex, 4);
				}
			}
		}
		for (int secondIndex = 0; secondIndex <= pageNumber % 100; secondIndex++) {
			handleOneToNine(hp, 4);
		}

		pageNumber = pageNumber % 100;
		int tp = pageNumber / 10;
		for (int thirdIndex = 0; thirdIndex < tp; thirdIndex++) {
			for (int fourthIndex = 0; fourthIndex <= 9; fourthIndex++) {
				handleOneToNine(fourthIndex, 0);
				handleOneToNine(thirdIndex, 2);
			}
		}
		for (int thirdIndex = 0; thirdIndex <= pageNumber % 10; thirdIndex++) {
			handleOneToNine(thirdIndex, 0);
			handleOneToNine(tp, 2);
		}

		for (Roman rom : numbersInRoman) {
			if (rom.count != 0)
				printWriter.println(rom.numeral + " " + rom.count);
		}
	}

	public static void handleOneToNine(int number, int mainIndex) {
		switch (number) {
		case 1:
		case 2:
		case 3:
			numbersInRoman[mainIndex].count += number;
			break;
		case 4:
		case 6:
			numbersInRoman[mainIndex].count++;
			numbersInRoman[mainIndex + 1].count++;
			break;
		case 5:
			numbersInRoman[mainIndex + 1].count++;
			break;
		case 7:
		case 8:
			numbersInRoman[mainIndex].count += (number - 5);
			numbersInRoman[mainIndex + 1].count++;
			break;
		case 9:
			numbersInRoman[mainIndex].count++;
			numbersInRoman[mainIndex + 2].count++;
			break;
		default:
			break;
		}
	}

	/**
	 * Leave it currently implemented oh shit, unimplemented
	 * 
	 * @param number
	 * @return
	 */
	private String convertToRoman(int number) {

		String str = "";

		String[] romanNumber = new String[1000];
		romanNumber[1] = "I";
		romanNumber[4] = "IV";
		romanNumber[5] = "V";
		romanNumber[9] = "IX";
		romanNumber[10] = "X";
		romanNumber[40] = "XL";
		romanNumber[50] = "L";
		romanNumber[90] = "XC";
		romanNumber[100] = "C";
		romanNumber[400] = "CD";
		romanNumber[500] = "D";
		romanNumber[900] = "CM";
		romanNumber[1000] = "M";

		int length = String.valueOf(number).length();

		return str;
	}

}
