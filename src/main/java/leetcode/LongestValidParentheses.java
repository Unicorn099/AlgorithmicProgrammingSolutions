package year2019.practice.leetcode;

public class LongestValidParentheses {

  public static void main(String[] args) {

//    String s = ")()())";
//    String s = "(()()))(";
    String s = "(()";
//    String s = ")(";
//    String s = "()(()";
    System.out.println(new LongestValidParentheses().longestValidParentheses(s));
  }

//  public int longestValidParentheses(String s) {
//    int maxans = 0;
//    int dp[] = new int[s.length()];
//    for (int i = 1; i < s.length(); i++) {
//      if (s.charAt(i) == ')') {
//        if (s.charAt(i - 1) == '(') {
//          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//        }
//        maxans = Math.max(maxans, dp[i]);
//      }
//    }
//    return maxans;
//  }

  public int longestValidParentheses(String s) {

    int length = 0;
    int len = s.length();
    int l = 0;
    int r = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') {
        l++;
      } else {
        r++;
      }
      if (r > l) {
        l = 0;
        r = 0;
      }
      if (r == l) {
        length = length < (l + r) ? (l + r) : length;
      }
    }

    l=0;
    r=0;
    for (int i = len - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        l++;
      } else {
        r++;
      }
      if (l > r) {
        l = 0;
        r = 0;
      }
      if (r == l) {
        length = length < (l + r) ? (l + r) : length;
      }
    }
    return length;
  }

}
