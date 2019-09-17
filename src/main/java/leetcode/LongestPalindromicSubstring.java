package year2019.practice.leetcode;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {

//    String str = "abccdedcchccde";
//    String str = "abcccba";
//    String str = "";
    String str = "aaaa";
    LongestPalindromicSubstring l = new LongestPalindromicSubstring();
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
          int l = j;
          String tempStr1 = "";
          String tempStr2 = "";
          if (k == 1) {
            tempStr1 = str.charAt(l) + tempStr1;
            tempStr2 = tempStr2 + str.charAt(l);
            if(strr.length()<tempStr1.length()+tempStr2.length()){
              strr= tempStr2+tempStr1;
            }
          } else {
            while (k > 0 && arr[k][l] == 1) {
              tempStr1 = str.charAt(l) + tempStr1;
              tempStr2 = tempStr2 + str.charAt(l);
              k -= 2;
              l--;
            }
            if (k < 0) {
              tempStr1 = str.charAt(l) + tempStr1;
              tempStr2 = tempStr2 + str.charAt(l);
              if (strr.length() < tempStr2.length() * 2) {
                strr = tempStr2 + tempStr1;
              }
            } else if (k <= 0) {
              tempStr1 = str.charAt(l) + tempStr1;
              if (strr.length() < tempStr2.length() + tempStr1.length()) {
                strr = tempStr2 + tempStr1;
              }
            }
          }
        }
      }
    }
    return strr;
  }

  public String longestPalindromeOld(String s) {

    String str = "";
    if (s.length() >= 1) {
      str += s.charAt(0);
      String tempStr = "";
      int i = 0;
      for (int j = 1; j < s.length(); j++) {
        if (i >= 0 && s.charAt(i) == s.charAt(j)) {
          tempStr = s.substring(i, j + 1);
          if (str.length() < tempStr.length()) {
            str = tempStr;
          }
          i--;
        } else if (--i >= 0 && s.charAt(i) == s.charAt(j)) {
          tempStr = s.substring(i, j + 1);
          if (str.length() < tempStr.length()) {
            str = tempStr;
          }
          i--;
        } else if (++i >= 0 && s.charAt(i) == s.charAt(j)) {
          tempStr = s.substring(i - 1, j + 1);
          if (str.length() < tempStr.length()) {
            str = tempStr;
          }
          i--;
        } else {
          i = j;
        }
      }

    }
    return str;
  }

  public String longestPalindromeNotCorrect(String s) {
    int len = s.length();
    String str = "";
    for (int i = len; i >= 1; i--) {
      for (int index = 0; index < len; index++) {
        boolean flag = true;
        for (int j = index, k = index + len - 1; j <= k && j < len && k < len; j++, k--) {
          if (s.charAt(j) != s.charAt(k)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          if (str.length() < i && i + index < s.length()) {
            str = s.substring(index, index + i);
            break;
          }
        }
      }
    }
    return str;
  }
}