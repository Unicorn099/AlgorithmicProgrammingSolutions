package google.codejam.QR18.B;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      int numbers = Integer.parseInt(sc.nextLine());
      String[] checkLine = sc.nextLine().split(" ");
      long[] numbersList = new long[numbers];
      for (int j = 0; j < numbers; j++) {
        numbersList[j] = Long.parseLong(checkLine[j]);
      }

      System.out.print("Case #" + (i + 1) + ": ");
      solve(numbersList);
    }
    sc.close();
  }

  private static void solve(long[] checkLine) {

    long[] finalArrayWithTroubleSort = callTroubleSort(checkLine);
    for (int i = 0; i < checkLine.length - 1; i++) {
      if (checkLine[i] > checkLine[i + 1]) {
        System.out.println(i);
        return;
      }
    }
    System.out.println("OK");
  }

  private static long[] callTroubleSort(long[] checkLine) {
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < checkLine.length - 2; i++) {
        if (checkLine[i] > checkLine[i + 2]) {
          long temp = checkLine[i + 2];
          checkLine[i + 2] = checkLine[i];
          checkLine[i] = temp;
          flag = false;
        }
      }
    }
    return checkLine;
  }

}
