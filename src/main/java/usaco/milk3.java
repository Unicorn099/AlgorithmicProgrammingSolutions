package usaco;


/*
ID: mib.2oj1
LANG: JAVA
TASK: milk3
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class milk3 {

	static Map<Container, Container> containerMap = new HashMap<Container, Container>();

	static class Container {
		int A;
		int B;
		int C;

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Container)) {
				return false;
			} else {

				Container container = (Container) obj;
				if (this.A == container.A && this.B == container.B
						&& this.C == container.C) {
					return true;
				} else {
					return false;
				}
			}
		}

		@Override
		public int hashCode() {
			return Integer.parseInt(A + "" + B + "" + C);

		}

		@Override
		public String toString() {

			return (A + " " + B + " " + C);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						"milk3.in"));
		PrintWriter printWriter = new PrintWriter(
				new FileWriter(
						"milk3.out"));

		String line = bufferedReader.readLine();

		Container container = new Container();

		StringTokenizer tokenizer = new StringTokenizer(line);
		int A = Integer.parseInt(tokenizer.nextToken());
		int B = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());

		container.A = 0;
		container.B = 0;
		container.C = C;

		Set<Integer> sets = new TreeSet<Integer>();

		findAnswer(container, sets, A, B, C);

		String str = "";
		for (Integer r : sets) {
			str+=r+" ";
		}
		str.trim();
		printWriter.println(str.substring(0,str.length()-1));

		printWriter.close();
		System.exit(0);
		bufferedReader.close();

	}

	private static void findAnswer(Container container, Set<Integer> sets,
			int a, int b, int c) {
		Container tempContainer = new Container();
		tempContainer.A = container.A;
		tempContainer.B = container.B;
		tempContainer.C = container.C;

		int transferred;
		if (containerMap.containsKey(tempContainer)) {
			return;
		} else {

			containerMap.put(tempContainer, tempContainer);
			if (container.A == 0) {
				sets.add(container.C);
			}

			// pouring from C to B
			transferred = b > (container.C + container.B) ? container.C : b
					- container.B;
			container.B += transferred;
			container.C -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

			// pouring from C to A
			transferred = a > (container.C + container.A) ? container.C : a
					- container.A;
			container.A += transferred;
			container.C -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

			// pouring from B to C
			transferred = c > (container.B + container.C) ? container.B : c
					- container.C;
			container.C += transferred;
			container.B -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

			// pouring from B to A
			transferred = a > (container.B + container.A) ? container.B : a
					- container.A;
			container.A += transferred;
			container.B -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

			// pouring from A to B
			transferred = b > (container.A + container.B) ? container.A : b
					- container.B;
			container.B += transferred;
			container.A -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

			// pouring from A to C
			transferred = c > (container.A + container.C) ? container.A : c
					- container.C;
			container.C += transferred;
			container.A -= transferred;
			findAnswer(container, sets, a, b, c);

			container.A = tempContainer.A;
			container.B = tempContainer.B;
			container.C = tempContainer.C;

		}
	}

}
