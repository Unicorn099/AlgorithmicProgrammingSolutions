package year2019.practice.leetcode;

import java.util.Arrays;

public class SumOfMinArraySubArr {

  public static void main(String[] args) {

    int[] arr = {59, 91, 85, 45};
    int[] arr1 = {1,7,5,2,4,3,9};
    SumOfMinArraySubArr s = new SumOfMinArraySubArr();
    int i = s.sumSubArrayMins(arr1);
    System.out.println(i);
  }

  public int sumSubArrayMins(int[] A) {
    int ans = 0;
    int len = A.length;
    long x = 1000000007;
    int[][] dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      dp[0][i] = A[i];
      ans += dp[0][i];
    }
    for (int i = 1; i < len; i++) {
      for (int j = i; j < len; j++) {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
        ans += dp[i][j];
        ans %= x;
      }
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        System.out.print(dp[i][j]+"  ");
      }
      System.out.println();
    }
    return ans;
  }


  public int sumSubarrayMins(int[] A) {
    int ans = 0;
    int len = A.length;
    long x = 1000000007;
    Arrays.sort(A);
    for (int i = 0; i < len; i++) {
      ans+=A[i]*(len-i);
      ans%=x;
    }
    return ans;
  }

}
