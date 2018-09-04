package facebook.QR;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class LazyLoading {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\LazyLoading\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "A-large-practice.in"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();
    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new LazyLoading().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    int noOfWeights = Integer.parseInt(sc.nextLine());
    int[] weights = new int[noOfWeights];
    int tripCount = 0;
    for (int i = 0; i < noOfWeights; i++) {
      weights[i] = Integer.parseInt(sc.nextLine());
    }
    Arrays.sort(weights);
    int elementLeft = noOfWeights;
    for (int i = noOfWeights - 1; i >= 0 && elementLeft > 0; i--) {

      for (int j = 1; j <= elementLeft; j++) {
        if (weights[i] * j >= 50) {
          tripCount++;
          elementLeft -= j;
          break;
        }
      }
    }
    pw.println(tripCount);
  }
}
