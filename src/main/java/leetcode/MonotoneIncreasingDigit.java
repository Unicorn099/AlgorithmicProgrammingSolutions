package year2019.practice.leetcode;

public class MonotoneIncreasingDigit {

  public static void main(String[] args) {
    MonotoneIncreasingDigit m = new MonotoneIncreasingDigit();
    test(m.monotoneIncreasingDigits(332), 299);
    test(m.monotoneIncreasingDigits(1234), 1234);
    test(m.monotoneIncreasingDigits(10), 9);
  }

  public static void test(int x, int y) {
    if (x == y) {
      System.out.println("PASSED");
    } else {
      System.out.println("NOT PASSED " + x + " " + y);
    }
  }

  public int monotoneIncreasingDigits(int N) {
    StringBuilder str = new StringBuilder(String.valueOf(N));
    int len = str.length();
    for (int i = str.length() - 1; i >= 0; i--) {
      while (i >= 1 && str.charAt(i - 1) <= str.charAt(i)) {
        i--;
      }
      if (i == 1) {
        str = new StringBuilder(str.charAt(i - 1) - '1' + "");
        break;
      } else if (i == 0) {
        break;
      } else {
        str = new StringBuilder(str.substring(0, i - 1) + (str.charAt(i - 1) - '1' + ""));
      }
    }
    for (int i = str.length(); i < len; i++) {
      str.append("9");
    }
    return Integer.parseInt(str.toString());
  }
}
