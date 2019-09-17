package year2019.practice.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String[] args) {
    ThreeSumClosest t = new ThreeSumClosest();
    int[] arr = {-1, 2, 1, -4};
    System.out.println(t.threeSumClosest(arr, 1));
  }

  public int threeSumClosest(int[] nums, int target) {

    int diff = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int sum = 0;
        for (int k = j + 1; k < nums.length; k++) {
          sum = nums[i] + nums[j] + nums[k];
          if (sum > target && Math.abs(target - sum) > diff) {
            break;
          }
          if (Math.abs(target - sum) < diff) {
            diff = Math.abs(target - sum);
            ans = sum;
          }
        }
      }
    }
    return ans;
  }
}
