package year2019.practice.leetcode;

public class MaximumSubArray {

  public static void main(String[] args) {

    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    MaximumSubArray maximumSubArray = new MaximumSubArray();
    int i = maximumSubArray.maxSubArray(nums);
    System.out.println(i);
  }

  public int maxSubArray(int[] nums) {

    int[] ans = new int[nums.length];
    int max = nums[0];
    ans[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      ans[i] = Math.max(nums[i] + ans[i - 1], nums[i]);
      max = Math.max(max, ans[i]);
    }
    return max;
  }
}
