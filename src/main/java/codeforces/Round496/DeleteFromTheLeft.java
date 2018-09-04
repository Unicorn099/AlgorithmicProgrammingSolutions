package codeforces.Round496;

import java.util.Scanner;

public class DeleteFromTheLeft {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String t = sc.nextLine();
    int i = s.length() - 1;
    int j = t.length() - 1;
    for (; i >= 0 && j >= 0; i--, j--) {
      if (s.charAt(i) != t.charAt(j)) {
        break;
      }
    }
    int ans = (i + 1) + (j + 1);
    System.out.println(ans);
  }
}
