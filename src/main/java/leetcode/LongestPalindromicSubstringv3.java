package year2019.practice.leetcode;

public class LongestPalindromicSubstringv3 {

  public static void main(String[] args) {

    String str = "cbbd";
    LongestPalindromicSubstringv3 l = new LongestPalindromicSubstringv3();
    System.out.println(l.longestPalindrome(str));
  }

  private String longestPalindrome(String str) {
    String s = "";
    int len = Integer.MIN_VALUE;
    for (int i = 0; i < str.length(); i++) {

      int len1 = getTheLength(str, i, i);
      if (len1 > len) {
        s = str.substring((i - (len1 - 1) / 2), i + ((len1 - 1) / 2)+1);
        len = len1;
      }
      int len2 = getTheLength(str, i, i + 1);
      if (len2 > len) {
        s = str.substring(i - ((len2 / 2) - 1), i + ((len2 / 2)+1));
        len = len2;
      }
    }
    return s;
  }

  private int getTheLength(String str, int i, int i1) {
    while (i >= 0 && i1 < str.length() && str.charAt(i) == str.charAt(i1)) {
      i--;
      i1++;
    }
    return i1 - i - 1;
  }
}
