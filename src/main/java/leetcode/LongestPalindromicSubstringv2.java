package year2019.practice.leetcode;

public class LongestPalindromicSubstringv2 {

  public static void main(String[] args) {

//    String str = "abccdedcchccde";
    String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//    String str = "abcccba";
//    String str = "";
//    String str = "aaaa";
    LongestPalindromicSubstringv2 l = new LongestPalindromicSubstringv2();
    System.out.println(l.longestPalindrome(str));
  }

  private String longestPalindrome(String str) {
    int[][] arr = new int[str.length()][str.length()];
    for (int i = 0; i < str.length(); i++) {
      arr[0][i] = 1;
    }
    for (int i = 1; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        if (str.charAt(j - i) == str.charAt(j)) {
          arr[i][j] = 1;
        } else {
          arr[i][j] = 0;
        }
      }
    }

    String strr = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      for (int j = str.length() - 1; j >= i; j--) {
        if (arr[i][j] == 1) {
          int k = i;
          int m = j;
          String tempStr1 = "";
          String tempStr2 = "";
          while (k > 0 && arr[k][m] == 1) {
            tempStr1 += str.charAt(m);
            tempStr2 = str.charAt(m) + tempStr2;
            k -= 2;
            m--;
          }
          if (k == 0 && arr[k][m] == 1) {
            if (strr.length() < tempStr1.length() + tempStr2.length() + 1) {
              strr = tempStr1 + str.charAt(m) + tempStr2;
              return strr;
            }
          } else if (k == -1 && arr[k + 1][m] == 1) {
            if (strr.length() < tempStr1.length() + tempStr2.length()) {
              strr = tempStr1 + tempStr2;
              return strr;
            }
          }
        }
      }
    }
    return strr;
  }

}