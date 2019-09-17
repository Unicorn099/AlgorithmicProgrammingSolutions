package year2019.practice.leetcode;

public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs c = new ClimbingStairs();
    int i = c.climbStairs(3);
    System.out.println(i);
  }

  public int climbStairs(int n) {
    int[] ans = new int[n + 1];
    if (n == 1) {
      ans[1] = 1;
      return 1;
    }
    if (n == 2) {
      ans[2] = 2;
      return 2;
    } else {
      for (int i = 3; i < n; i++) {
        ans[i] = ans[i - 2] + ans[i - 1];
      }
      return ans[n];
    }

  }
}
