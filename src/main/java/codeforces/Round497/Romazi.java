package codeforces.Round497;

import java.util.Scanner;

public class Romazi {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {

      } else {
        if (str.charAt(i) != 'n') {
          boolean flag = checkIfNextIsVowel(str, i + 1);
          if (!flag) {
            System.out.println("NO");
            return;
          }
        }
      }
    }

    System.out.println("YES");
  }

  private static boolean checkIfNextIsVowel(String str, int i) {
    if (i >= str.length()) {
      return false;
    }
    if (str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
      return true;
    }
    return false;
  }
}
