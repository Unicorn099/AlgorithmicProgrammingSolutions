package usaco;


/*

ID: mib.2oj1
LANG: JAVA
TASK: ariprog
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

public class ariprog {
	
	
	static class Answer implements Comparable<Answer> {
		int number;
		int difference;

		@Override
		public int compareTo(Answer arg0) {
			if (this.difference < arg0.difference) {
				return -1;
			} else if (this.difference > arg0.difference) {
				return 1;
			} else {
				if (this.number < arg0.number) {
					return -1;
				} else if (this.number > arg0.number) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"ariprog.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"ariprog.out"));

		String line = bufferedReader.readLine();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int A = Integer.parseInt(tokenizer.nextToken());
		line = bufferedReader.readLine();
		tokenizer = new StringTokenizer(line);
		int B = Integer.parseInt(tokenizer.nextToken());

		findAnswer(A, B, printWriter);

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static void findAnswer(int a, int b, PrintWriter printWriter) {

		List<Answer> ansList = new ArrayList<Answer>();
		boolean[] bisquares = new boolean[b*b*2+1];

		//Set<Integer> bisquares = new HashSet<Integer>();
		for (int i = 0; i <= b; i++) {
			for (int j = i; j <= b; ++j) {
				bisquares[i * i + j * j]=true;
			}
		}

		boolean found = false, noneFalse = false;

		//for (Integer i : bisquares) {
		for(int i=0;i<=(b*b*2);i++){
			if(!bisquares[i]){
				continue;
			}
			for (int difference = 1; (i + (a - 1) * difference) <= ((b * b) + (b * b)); difference++) {
				int number = i;
				found = true;
				for (int k = 0; k < a - 1; k++) {
					number += difference;
					if (!bisquares[number]) {
						found = false;
						break;
					}
				}
				if (found) {
					noneFalse = true;
					Answer ans = new Answer();
					ans.number = i;
					ans.difference = difference;
					ansList.add(ans);
				}
			}
		}
		if (!noneFalse) {
			printWriter.println("NONE");
		} else {
			Collections.sort(ansList);
			for (Answer an : ansList) {
				printWriter.println(an.number + " " + an.difference);
			}
		}
	}

}
