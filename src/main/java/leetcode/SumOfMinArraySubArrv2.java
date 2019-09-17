package year2019.practice.leetcode;

import java.util.Stack;

public class SumOfMinArraySubArrv2 {

  public static void main(String[] args) {

    int[] arr = {59, 91, 85, 45};
    SumOfMinArraySubArrv2 s = new SumOfMinArraySubArrv2();
    int i = s.sumSubarrayMins(arr);
    System.out.println(i);
  }

  public int sumSubarrayMins(int[] A) {
    int MOD = 1_000_000_007;

    Stack<RepInteger> stack = new Stack();
    int ans = 0, dot = 0;
    for (int j = 0; j < A.length; ++j) {
      // Add all answers for subarrays [i, j], i <= j
      int count = 1;
      while (!stack.isEmpty() && stack.peek().val >= A[j]) {
        RepInteger node = stack.pop();
        count += node.count;
        dot -= node.val * node.count;
      }
      stack.push(new RepInteger(A[j], count));
      dot += A[j] * count;
      ans += dot;
      ans %= MOD;
    }

    return ans;
  }

  class RepInteger {

    int val, count;

    RepInteger(int v, int c) {
      val = v;
      count = c;
    }
  }

}