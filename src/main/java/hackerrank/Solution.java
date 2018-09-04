package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//
//    int caseCnt = Integer.parseInt(sc.nextLine());
//
//    for (int i = 0; i < caseCnt; i++) {
//
//      int numbers = Integer.parseInt(sc.nextLine());
//      String[] s = sc.nextLine().split(" ");
//      int[] val = new int[s.length];
//      for (int j = 0; j < numbers; j++) {
//        val[j] = Integer.parseInt(s[j]);
//      }

//      System.out.println(solve(val));
    int[] counts = {3, 3, 3, 3, 3, 1, 3};
    int[] counts1 = {2, 1, 1, 2, 1};
    socialGraphs(counts);
    socialGraphs(counts1);
  }

  private static String solve(int[] val) {
    String ans = "YES";
    int length = val.length;
    boolean printinRight = false;
    Stack<Integer> stack = new Stack<>();
    int poppedEle = -1;
    stack.push(val[0]);
    for (int i = 1; i < length; i++) {
      if (stack.peek() >= val[i]) {
        if (poppedEle < val[i]) {
          stack.push(val[i]);
        } else {
          ans = "NO";
          return ans;
        }

      } else {
        while (!stack.empty() && stack.peek() < val[i]) {
          poppedEle = stack.pop();
        }
        stack.push(val[i]);
      }
    }
    return ans;
  }

  static void socialGraphs(int[] counts) {

    int length = counts.length;
    Map<Integer, Integer> count = new HashMap<>();
    int countOfI;
    Map<Integer, List<Integer>> listOfPeople = new HashMap<>();
    for (int i = 0; i < length; i++) {
      countOfI = count.getOrDefault(counts[i], 0);
      count.put(counts[i], countOfI + 1);
      List<Integer> xx = listOfPeople.getOrDefault(counts[i], new ArrayList<>());
      xx.add(i);
      listOfPeople.put(counts[i], xx);
    }

    int numberOfGroups = 0;
    for (Map.Entry<Integer, Integer> c : count.entrySet()) {
      numberOfGroups += c.getValue() / c.getKey();
    }

    ArrayList<Integer>[] ans = new ArrayList[numberOfGroups];
    for (int i = 0; i < numberOfGroups; ) {
      for (Map.Entry<Integer, List<Integer>> x : listOfPeople.entrySet()) {
        Collections.sort(x.getValue());
        for (int ll=0; ll< x.getValue().size();) {
          ArrayList<Integer> xxx = new ArrayList<>();
          for (int j = 0; j < x.getKey(); j++) {
            xxx.add(x.getValue().get(ll));
            ll++;
          }
          ans[i++] = xxx;
        }
      }
    }

    for (int i = 0; i < numberOfGroups; i++) {
      for (Integer xy : ans[i]) {
        System.out.print(xy + " ");
      }
      System.out.println();
    }
  }
}
