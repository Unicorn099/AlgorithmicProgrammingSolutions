package year2019.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

  public static void main(String[] args) {
    int[][] arr = {{5, 4}, {3, 2}, {1, 1}, {8, 5}, {7, 5}, {8, 6}};
    //    int[][] arr = {{1, 1}, {3, 196}, {4, 2}, {5, 3}};
    //    int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    RussianDollEnvelopes r = new RussianDollEnvelopes();
    System.out.println(r.maxEnvelopes(arr));
  }

  public int maxEnvelopes(int[][] envelopes) {

    Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));

    int len = envelopes.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return 1;
    }

    int[][] ans = new int[len][len];
    for (int i = 0; i < len; i++) {
      ans[0][i] = 1;
    }

    int max = 1;
    for (int j = 0; j < len; j++) {
      for (int i = j + 1; i < len; i++) {
        if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
          ans[j + 1][i] = Math.max(ans[j][j] + 1, ans[j][i]);
          if (max < ans[j + 1][i]) {
            max = ans[j + 1][i];
          }
        } else {
          ans[j + 1][i] = ans[j][i];
        }
      }
    }
    return max;
  }
}
