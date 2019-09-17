package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KConcatenationMaximumSum {

  int mod = 1000000007;

  public static void main(String[] args) {
    KConcatenationMaximumSum kConcatenationMaximumSum = new KConcatenationMaximumSum();
    int[] arr = {6, -9, -8, 11, 3, -12, 13, -7, 1, -8, 13, -12, 13, -6};
    int k = 10;
    System.out.println(kConcatenationMaximumSum.kConcatenationMaxSum(arr, k));
  }

  public int kConcatenationMaxSum(int[] arr, int k) {

    List<Integer> sum = new ArrayList<>();
    int s = 0;
    boolean anyLeft = false;
    int allSum = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 0) {
        anyLeft = true;
        s = addSelf(s, arr[i]);
      } else {
        sum.add(s);
        anyLeft = false;
        s = 0;
      }
      allSum += arr[i];
    }
    if (anyLeft) {
      sum.add(s);
    }
    if (k == 1) {
      int max = 0;
      for (Integer ii : sum) {
        max = Math.max(max, ii);
      }
      return max;
    } else {
      if (sum.size() == 1) {
        int max = 0;
        for (int i = 0; i < k; i++) {
          max = addSelf(max, sum.get(0));
        }
        return max;
      } else {
        int max = 0;
        int max2 = 0;
        if (allSum > 0) {
          int maxNegativeFromStarting = 0;
          int maxNegativeFromEnd = 0;
          int temp1 = 0;
          int temp2 = 0;
          for (int i = 0; i < arr.length; i++) {
            temp1 += arr[i];
            temp2 += arr[arr.length - 1 - i];
            if (temp1 < 0 && temp1 < maxNegativeFromStarting) {
              maxNegativeFromStarting = temp1;
            }
            if (temp2 < 0 && temp2 < maxNegativeFromEnd) {
              maxNegativeFromEnd = temp2;
            }
          }
          for (int i = 0; i < k; i++) {
            max2 = addSelf(max2, allSum);
          }
          if (maxNegativeFromStarting < 0) {
            max2 = subAndMod(max2, maxNegativeFromStarting);
          }
          if (maxNegativeFromEnd < 0) {
            max2 = subAndMod(max2, maxNegativeFromEnd);
          }
        }
        max = addSelf(max, sum.get(0) + sum.get(sum.size() - 1));
        for (Integer ii : sum) {
          max = Math.max(max, ii);
        }
        return Math.max(max, max2);
      }
    }
  }

  private int addSelf(int s, int i) {
    s += i;
    if (s >= mod) {
      s -= mod;
    }
    return s;
  }

  private int subAndMod(int s, int i) {
    s -= i;
    if (s < 0) {
      s += mod;
    }
    return s;
  }
}
