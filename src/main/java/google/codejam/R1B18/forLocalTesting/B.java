package google.codejam.R1B18.forLocalTesting;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1B18\\";
  final static String fileName = "B-small";

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));
    PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
        + fileName + ".out"));

    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {
      System.out.println("Processing test case " + (i + 1));
      pw.print("Case #" + (i + 1) + ": ");
      solve(pw);
    }

    pw.flush();
    pw.close();
    sc.close();
  }

  private static void solve(PrintWriter pw) {
  }
}
