package year2019.practice.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SumOfMinArraySubArrv3 {

  public static void main(String[] args) {

    int[] arr = {3,1,2,4};
    SumOfMinArraySubArrv3 s = new SumOfMinArraySubArrv3();
    int i = s.sumSubarrayMins(arr);
    System.out.println(i);
  }

  public int sumSubarrayMins(int[] A) {
    int MOD = 1_000_000_007;
    int len = A.length;
    int[] ple = new int[len];
    int[] nle = new int[len];

    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    for (int i = 0; i < len; i++) {

      while (!s1.isEmpty() && A[s1.peek()] > A[i]) {
        s1.pop();
      }
//      ple[i] = s1.empty() ? -1 : s1.peek();
      s1.push(i);
    }
    for (int i = len-1; i >=0; i--) {
      while (!s2.isEmpty() && A[s2.peek()] > A[i]) {
        s2.pop();
      }
//      nle[i] = s2.empty() ? -1 : s2.peek();
      s2.push(i);
    }

    for (int i = 0; i < len; i++) {
      ans += A[i] * (ple[i]==-1?1:(i-ple[i])) * (nle[i]==-1?1:(nle[i]-i));
      ans %= MOD;
    }

    return ans;
  }

}