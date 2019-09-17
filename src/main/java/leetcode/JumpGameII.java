package year2019.practice.leetcode;

public class JumpGameII {

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 1, 4};
    JumpGameII j = new JumpGameII();
    int ans = j.jump(arr);
    System.out.println(ans);
    int[] arr1 = {0};
    System.out.println(j.canJump(arr1));
    int[] arr2 = {3, 2, 1, 0, 4};
    System.out.println(j.canJump(arr2));
  }

  public int jump(int[] nums) {
    int len = nums.length;
    int[] ans = new int[len];
    ans[0] = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
        if (ans[j] == 0) {
          ans[j] = ans[i] + 1;
        } else {
          ans[j] = Math.min(ans[i] + 1, ans[j]);
        }
      }
    }
    return ans[len - 1];
  }

  //N^2
  public boolean canNonOptimsedJump(int[] nums) {
    int len = nums.length;
    boolean[] ans = new boolean[len];
    ans[0] = true;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
        ans[j] = ans[i];
      }
    }
    return ans[len - 1];
  }

  //N --- Optimised One
  public boolean canJump(int[] nums) {
    int len = nums.length;
    boolean[] ans = new boolean[len];
    ans[0] = true;
    int lastReachableIndexSoFar = 0;
    for (int i = 0; i < len && i <= lastReachableIndexSoFar; i++) {
      if (i + nums[i] > lastReachableIndexSoFar) {
        lastReachableIndexSoFar = i + nums[i];
      }
    }
    return len - 1 <= lastReachableIndexSoFar;
  }
}
