package facebook.R1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PieProgress {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\PieProgress\\";

  private int[][] costOfPie;
  private int[][] anotherCostOfPie;

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
      new PieProgress().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String[] firstLineSplit = sc.nextLine().split(" ");
    int noOfDays = Integer.parseInt(firstLineSplit[0]);
    int noOfPies = Integer.parseInt(firstLineSplit[1]);
    costOfPie = new int[noOfDays][noOfPies];
    anotherCostOfPie = new int[noOfDays][noOfDays];
    for (int i = 0; i < noOfDays; i++) {
      String[] afterFirstLineSplit = sc.nextLine().split(" ");
      for (int j = 0; j < noOfPies; j++) {
        costOfPie[i][j] = Integer.parseInt(afterFirstLineSplit[j]);
      }
      Arrays.sort(costOfPie[i]);
      for (int j = 1; j < noOfPies; j++) {
        costOfPie[i][j] += costOfPie[i][j - 1];
      }
      for (int j = 0; j < noOfPies; j++) {
        costOfPie[i][j] += (j + 1) * (j + 1);
      }
    }
//    for (int i = 0; i < noOfDays; i++) {
//      for (int j = 0; j < noOfPies; j++) {
//        System.out.print(costOfPie[i][j] + ",");
//      }
//      System.out.println();
//    }

    /**
     * New testing
     */
    for (int i = 0; i < (noOfPies>noOfDays?noOfDays:noOfPies); i++) {
      anotherCostOfPie[0][i] = costOfPie[0][i];
    }
    for (int i = noOfPies; i < noOfDays; i++) {
      anotherCostOfPie[0][i] = 300000001;
    }
    for (int i = 1; i < noOfDays; i++) {
      for (int j = i; j < noOfDays; j++) {
        anotherCostOfPie[i][j] = findMin(i, j);
      }
    }
    pw.println(anotherCostOfPie[noOfDays - 1][noOfDays - 1]);

//    System.out.println("+++++++++++++++");
//    for (int i = 0; i < noOfDays; i++) {
//      for (int j = 0; j < noOfDays; j++) {
//        System.out.print(anotherCostOfPie[i][j] + ",");
//      }
//      System.out.println();
//    }
//    System.out.println("+++++++++++++++");

  }

  private int findMin(int i, int j) {
    int res = anotherCostOfPie[i - 1][j];
    int tempRes = 0;
    for (int jj = j - 1; jj >= 0 && anotherCostOfPie[i - 1][jj] > 0; jj--) {
      if (j - jj - 1 < costOfPie[i].length) {
        tempRes = anotherCostOfPie[i - 1][jj] + costOfPie[i][j - jj - 1];
        if (tempRes < res) {
          res = tempRes;
        }
      }
    }
    return res;
  }
}
