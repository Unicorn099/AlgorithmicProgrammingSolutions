package year2019.practice.leetcode;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
//    int[] arr = {-2, -1};
    int[] arr = {10,9,2,5,3,7,101,18};
    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    System.out.println(longestIncreasingSubsequence.lengthOfLIS(arr));
  }

  public int lengthOfLIS(int[] nums) {

    int len = nums.length;
    int[][] ans = new int[len][len];
    for (int i = 0; i < len; i++) {
      ans[0][i] = 1;
    }

    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[j] > nums[i]) {
          ans[i + 1][j] = Math.max(ans[i][j], ans[i][i] + 1);
          if (maxVal < ans[i + 1][j]) {
            maxVal = ans[i + 1][j];
          }
        } else {
          ans[i+1][j] = ans[i][j];
        }
      }
    }
    return maxVal;
  }

}
