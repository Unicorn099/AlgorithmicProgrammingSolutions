package google.codejam.R1A18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1A18\\";
  final static String fileName = "A-small";

  public static void main(String[] args) throws FileNotFoundException {

//    Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      String[] s = sc.nextLine().split(" ");
      int R = Integer.parseInt(s[0]);
      int C = Integer.parseInt(s[1]);
      int H = Integer.parseInt(s[2]);
      int V = Integer.parseInt(s[3]);
      String[] data = new String[R];

      for (int j = 0; j < R; j++) {
        data[j] = sc.nextLine();
      }

      System.out.print("Case #" + (i + 1) + ": ");
      solve(data, R, C, H, V);
    }
    sc.close();
  }

  private static void solve(String[] data, int r, int c, int h, int v) {

    int countOfChocolate = 0;
    int[] countOfChocolateInARow = new int[r];
    int[] countOfChocolateInACol = new int[c];
    for (int i = 0; i < r; i++) {

      for (int j = 0; j < c; j++) {
        if ((data[i].charAt(j) + "").equalsIgnoreCase("@")) {
          countOfChocolate++;
          countOfChocolateInACol[j]++;
          countOfChocolateInARow[i]++;
        }
      }
    }
    if (countOfChocolate == 0) {
      System.out.println("POSSIBLE");
      return;
    }

    if (countOfChocolate % (h + 1) != 0 || countOfChocolate % (v + 1) != 0) {
      System.out.println("IMPOSSIBLE");
    }

    int xh = h;
    int leftChoc = countOfChocolate;
    int[] rowIndex = new int[h + 1];
    for (int i = 0; i < r; i++) {
      int sum = 0;
      if (xh != 0) {
        for (int j = i; j < r; j++) {
          if (i == j) {
            sum += countOfChocolateInARow[i];
            leftChoc -= countOfChocolateInARow[i];
          } else {
            sum += countOfChocolateInARow[j];
            leftChoc -= countOfChocolateInARow[j];
          }
          if (sum == countOfChocolate / (h + 1)) {
            i = j;
            rowIndex[h - xh] = j;
            xh--;
            break;
          } else if (sum > countOfChocolate / (h + 1)) {
            System.out.println("IMPOSSIBLE");
            return;
          }
        }
      } else {
        if (countOfChocolate / (h + 1) != leftChoc) {
          System.out.println("IMPOSSIBLE");
          return;
        }
      }
    }


    int xv = v;
    leftChoc = countOfChocolate;
    int[] colIndex = new int[v + 1];
    for (int i = 0; i < c; i++) {
      int sum = 0;
      if (xv != 0) {
        for (int j = i; j < c; j++) {
          if (j == i) {
            sum += countOfChocolateInACol[i];
            leftChoc -= countOfChocolateInACol[i];
          } else {
            sum += countOfChocolateInACol[j];
            leftChoc -= countOfChocolateInACol[j];
          }
          if (sum == countOfChocolate / (v + 1)) {
            i = j;
            colIndex[v - xv] = j;
            xv--;
            break;
          } else if (sum > countOfChocolate / (v + 1)) {
            System.out.println("IMPOSSIBLE");
            return;
          }
        }
      } else {
        if (countOfChocolate / (v + 1) != leftChoc) {
          System.out.println("IMPOSSIBLE");
          return;
        }
      }
    }

    rowIndex[h] = r - 1;
    colIndex[v] = c - 1;
    int countOfChocolateonCell = (countOfChocolate / (h + 1)) / (v + 1);

    int x = -1;

    while (x < rowIndex.length-1) {
      int y=-1;
      while (y < colIndex.length-1) {
        int sum = 0;
        int i = x == -1 ? 0 : rowIndex[x] + 1;
        int ll = rowIndex[x + 1];
        for (; i <= ll; i++) {
          int j = y==-1?0:colIndex[y] + 1;
          int lastlimit = colIndex[y + 1];
          for (; j <= lastlimit; j++) {
            if ((data[i].charAt(j) + "").equalsIgnoreCase("@")) {
              sum++;
            }
          }
        }
        if (countOfChocolateonCell != sum) {
          System.out.println("IMPOSSIBLE");
          return;
        }
        y++;
      }
      x++;
    }

    System.out.println("POSSIBLE");

  }
}

