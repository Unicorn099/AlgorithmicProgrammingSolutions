package codeforces;

import java.util.Scanner;

public class Watermelon {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int x = Integer.parseInt(sc.nextLine());
    System.out.println(findIfPossible(x) ? "YES" : "NO");
  }

  private static boolean findIfPossible(int x) {
    for (int i = 1; i < x; i++) {
      if (i % 2 == 0 && (x - i) % 2 == 0) {
        return true;
      }
    }
    return false;
  }

}
