package year2019.practice.leetcode;

import java.util.Scanner;

public class MinDeletionToMakePalindrome {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(findTheMinNumber(str, 0, str.length() - 1));
  }

  private static int findTheMinNumber(String str, int i, int length) {

    if (i > length) {
      return 0;
    }
    int ans = 0;
    if (str.charAt(i) == str.charAt(length)) {
      ans += findTheMinNumber(str, i + 1, length - 1);
    } else {
      ans += 1;
      ans += Math.min(findTheMinNumber(str, i, length - 1), findTheMinNumber(str, i + 1, length));
    }
    return ans;
  }
}
