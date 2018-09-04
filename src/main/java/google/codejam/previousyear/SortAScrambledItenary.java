package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class SortAScrambledItenary {

	static class InputData {

		int numberOfTicket;
		Hashtable<String, String> hash1 = new Hashtable<>();
		Hashtable<String, String> hash2 = new Hashtable<>();

		public InputData(Scanner sc) {
			numberOfTicket = Integer.parseInt(sc.nextLine());
			String src = "", des = "";
			for (int i = 0; i < numberOfTicket; i++) {
				src = sc.nextLine();
				des = sc.nextLine();
				hash1.put(src, des);
				hash2.put(des, src);
			}
		}

		public void solve(PrintWriter pw) {
			String src = "", des = "";
			String source = "", destination = "";
			for (Map.Entry<String, String> ent : hash1.entrySet()) {
				src = ent.getKey();
				des = ent.getValue();
				if (!hash2.containsKey(src)) {
					source = src;
				}
				if (!hash1.containsKey(des)) {
					destination = des;
				}
			}

			String temp = source;
			while (!temp.equalsIgnoreCase(destination)) {
				pw.print(temp + "-" + hash1.get(temp));
				temp = hash1.get(temp);
				pw.print(" ");
			}
			pw.println();
		}
	}

	static class Solver implements Callable<String> {

		private InputData in;

		public Solver(InputData in) {
			this.in = in;
		}

		@Override
		public String call() throws Exception {
			StringWriter out = new StringWriter();
			in.solve(new PrintWriter(out));
			return out.toString();
		}

	}

	final static String WORK_DIR = "E:\\testingtestingtesting123\\SortAScrambledItenary\\";

	public static void main(String[] args) throws IOException,
			InterruptedException, ExecutionException {
		Scanner sc = new Scanner(new FileReader(WORK_DIR
				+ "C-large-practice.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ "C-large-practice.txt"));

		int caseCnt = Integer.parseInt(sc.nextLine());

		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			Future<String> res = stpe.submit(new Solver(new InputData(sc)));
			results.add(res);
		}
		for (Future<String> result : results) {
			while (!result.isDone()) {
				Thread.sleep(1000);
			}
			pw.print("Case #" + (results.indexOf(result) + 1) + ": ");
			pw.print(result.get());

		}

		pw.flush();
		pw.close();
		sc.close();
		stpe.shutdown();

	}

}
