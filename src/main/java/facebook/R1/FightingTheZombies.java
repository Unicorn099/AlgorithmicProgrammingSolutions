package facebook.R1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FightingTheZombies {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\FightingTheZombies\\";

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
      new FightingTheZombies().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String[] firstLine = sc.nextLine().split(" ");
    int numberOfZombies = Integer.parseInt(firstLine[0]);
    int radius = Integer.parseInt(firstLine[1]);
    int[][] coordinates = new int[numberOfZombies][2];
    for (int i = 0; i < numberOfZombies; i++) {
      String[] anotherLine = sc.nextLine().split(" ");
      coordinates[i][0] = Integer.parseInt(anotherLine[0]);
      coordinates[i][1] = Integer.parseInt(anotherLine[1]);
    }

    /**
     * Logic goes here
     */

  }
}