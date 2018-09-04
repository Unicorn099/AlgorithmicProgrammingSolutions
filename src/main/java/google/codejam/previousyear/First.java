package google.codejam.previousyear;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class First {

	public static void main(String args[]) throws IOException {

		FileInputStream in = new FileInputStream(
				new File(
						"E:\\testingtestingtesting123\\SevenSegmentDisplay\\A-large-practice.in"));
		FileOutputStream out = new FileOutputStream(new File(
				"E:\\testingtestingtesting123\\SevenSegmentDisplay\\a.txt"));
		Scanner scan = new Scanner(new BufferedInputStream(in));
		// System.out.println("wokao ");
		int num = scan.nextInt();
		scan.nextLine();
		String[] wellFlag = { "1111110", "0110000", "1101101", "1111001",
				"0110011", "1011011", "1011111", "1110000", "1111111",
				"1111011" };
		for (int i = 0; i < num; i++) {
			String line = scan.nextLine();
			String[] strs = line.split(" ");
			int n = Integer.parseInt(strs[0]);
			String[] flags = new String[n];
			for (int j = 0; j < n; j++) {
				flags[j] = strs[j + 1];
			}
			HashSet<Character> well = new HashSet<Character>();
			HashSet<Character> broken = new HashSet<Character>();
			int nextNum = 0;
			int next = 0;
			boolean allFail = false;
			String nextStr = "";
			boolean success = false;
			for (int k = 0; k < 10 && !allFail; k++) {
				int value = k;
				boolean fail = false;
				well.clear();
				broken.clear();
				for (int k1 = 0; k1 < n && !fail; k1++) {
					for (int k2 = 0; k2 < 7; k2++) {
						char wellc = wellFlag[value].charAt(k2);
						char flagc = flags[k1].charAt(k2);
						if (wellc == '0' && flagc == '0') {
							continue;
						} else if (wellc == '1' && flagc == '1') {
							if (broken
									.contains(new Character((char) ('A' + k2)))) {
								fail = true;
								break;
							} else {
								well.add(new Character((char) ('A' + k2)));
							}
						} else if (wellc == '1' && flagc == '0') {
							if (well.contains(new Character((char) ('A' + k2)))) {
								fail = true;
								break;
							} else {
								broken.add(new Character((char) ('A' + k2)));
							}
						} else {
							fail = true;
							break;
						}
					}
					value = (value - 1 + 10) % 10;
				}
				if (fail == false && nextNum == 0) {
					next = getNext(k, n);
					nextStr = wellFlag[next];
					char[] chars = new char[7];
					for (int k3 = 0; k3 < 7; k3++) {
						if (nextStr.charAt(k3) == '1'
								&& well.contains(new Character(
										(char) ('A' + k3)))) {
							chars[k3] = '1';
						} else if (nextStr.charAt(k3) == '1'
								&& broken.contains(new Character(
										(char) ('A' + k3)))) {
							chars[k3] = '0';
						} else if (nextStr.charAt(k3) == '0') {
							chars[k3] = '0';
						} else {
							allFail = true;
							break;
						}
					}
					if (allFail == false) {
						success = true;
						nextStr = new String(chars);
					}
					nextNum++;
				} else if (fail == false && nextNum > 0) {
					allFail = true;
					success = false;
				} else {
					continue;
				}
			}
			StringBuilder sb = new StringBuilder("Case #" + (i + 1) + ": ");
			if (success) {
				sb.append(nextStr + "\r\n");
			} else {
				sb.append("ERROR!\r\n");
			}
			out.write(sb.toString().getBytes());
			System.out.print(sb.toString());
		}
		out.close();
	}

	public static int getNext(int s, int n) {
		int next = s;
		for (int j = 0; j < n; j++) {
			next = (next - 1 + 10) % 10;
		}
		return next;
	}

}
