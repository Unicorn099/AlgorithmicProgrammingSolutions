package google.codejam.QR18.C;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      int size = Integer.parseInt(sc.nextLine());
      solve(size, sc);
    }
    sc.close();
  }

  private static void solve(int size, Scanner sc) {

    int row = 100;
    int column = 100;

    if (size == 20) {
      System.out.println(row + " " + column);
      String[] s = sc.nextLine().split(" ");
      do {
        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 4; j++) {
            System.out.println((row + i) + " " + (column + j));
            s = sc.nextLine().split(" ");
            if (checkIFrequired(s)) {
              return;
            }
          }
        }
      } while (!checkIFrequired(s));
    } else if (size == 10) {
      System.out.println(row + " " + column);
      String[] s = sc.nextLine().split(" ");
      do {
        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 2; j++) {
            System.out.println((row + i) + " " + (column + j));
            s = sc.nextLine().split(" ");
            if (checkIFrequired(s)) {
              return;
            }
          }
        }
      } while (!checkIFrequired(s));
    } else if (size == 200) {
      System.out.println(row + " " + column);
      String[] s = sc.nextLine().split(" ");
      do {
        for (int i = 0; i < 25; i++) {
          for (int j = 0; j < 8; j++) {
            System.out.println((row + i) + " " + (column + j));
            s = sc.nextLine().split(" ");
            if (checkIFrequired(s)) {
              return;
            }
          }
        }
      } while (!checkIFrequired(s));
    }

  }

  private static boolean checkIFrequired(String[] s) {
    return (s[0].equalsIgnoreCase("0") && s[1].equalsIgnoreCase("0"))
        || (s[0].equalsIgnoreCase("-1") && s[1].equalsIgnoreCase("-1"));
  }
}

