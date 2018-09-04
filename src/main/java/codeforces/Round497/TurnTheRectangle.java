package codeforces.Round497;

import java.util.Scanner;

public class TurnTheRectangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    int[][] x = new int[n][2];
    String[] str;
    for (int i = 0; i < n; i++) {
      str = sc.nextLine().split(" ");
      x[i][0] = Integer.parseInt(str[0]);
      x[i][1] = Integer.parseInt(str[1]);
    }

    System.out.println(solve(x));
  }

  private static String solve(int[][] x) {
    int maxHeight = x[0][0] > x[0][1] ? x[0][0] : x[0][1];
    for (int i = 1; i < x.length; i++) {
      int maxH = x[i][0] > x[i][1] ? x[i][0] : x[i][1];
      int minH = x[i][0] < x[i][1] ? x[i][0] : x[i][1];
      if (maxH > maxHeight) {
        if (minH > maxHeight) {
          return "NO";
        } else {
          maxHeight = minH;
        }
      } else {
        maxHeight = maxH;
      }
    }
    return "YES";
  }
}
