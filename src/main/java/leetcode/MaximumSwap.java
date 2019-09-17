package year2019.practice.leetcode;

public class MaximumSwap {

  public static void main(String[] args) {
    MaximumSwap maximumSwap = new MaximumSwap();
    test(maximumSwap.maximumSwap(2736), 7236);
    test(maximumSwap.maximumSwap(98368), 98863);
    test(maximumSwap.maximumSwap(9973), 9973);
    test(maximumSwap.maximumSwap(12), 21);
  }

  public static void test(int x, int y) {
    if (x == y) {
      System.out.println("PASSED");
    } else {
      System.out.println("NOT PASSED " + x + " " + y);
    }
  }

  public int maximumSwap(int num) {

    String str = String.valueOf(num);
    int len = str.length();

    int max = Integer.MIN_VALUE;
    int[] maxVal = new int[len];
    int[] index = new int[len];
    for (int k = len - 2; k >= 0; k--) {
      int numericValue = Character.getNumericValue(str.charAt(k + 1));
      if (maxVal[k+1] < numericValue) {
        maxVal[k] = numericValue;
        index[k] = k + 1;
      } else {
        maxVal[k] = maxVal[k+1];
        index[k] = index[k + 1];
      }
    }
    for (int i = 0; i < len; i++) {
      if (maxVal[i] > Character.getNumericValue(str.charAt(i))) {
        String s =
            str.substring(0, i)
                + str.charAt(index[i])
                + str.substring(i + 1, index[i])
                + str.charAt(i)
                + str.substring(index[i] + 1);
        return Integer.parseInt(s);
      }
    }
    return num;
  }
}
