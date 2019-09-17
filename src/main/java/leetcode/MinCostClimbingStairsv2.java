package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class MinCostClimbingStairsv2 {

  static Map<Integer, Integer> allCost;


  public static void main(String[] args) {
    MinCostClimbingStairsv2 c = new MinCostClimbingStairsv2();
    int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int i = c.minCostClimbingStairs(cost1);
    System.out.println(i);
    int[] cost2 = {0, 0, 0, 1};
    int j = c.minCostClimbingStairs(cost2);
    System.out.println(j);
    int[] cost3 = {10, 15, 20};
    int k = c.minCostClimbingStairs(cost3);
    System.out.println(k);
  }

  public int minCostClimbingStairs(@NotNull int[] cost) {

    int len = cost.length;
    allCost = new HashMap<>();
    return Math.min(minCost(cost, len - 2), minCost(cost, len - 3) + cost[len - 1]);
  }

  private int minCost(int[] cost, int len) {
    if (len < 0) {
      return 0;
    } else if (len == 0) {
      if (!allCost.containsKey(0)) {
        allCost.put(0, cost[0]);
      }
      return allCost.get(0);
    } else if (len == 1) {
      if (!allCost.containsKey(1)) {
        allCost.put(1, cost[1]);
      }
      return allCost.get(1);
    } else if (len == 2) {
      if (!allCost.containsKey(2)) {
        allCost.put(2, cost[2] + Math.min(cost[0], cost[1]));
      }
      return allCost.get(2);
    } else {
      if (!allCost.containsKey(len - 1)) {
        allCost.put(len - 1, minCost(cost, len - 1));
      }
      if (!allCost.containsKey(len - 2)) {
        allCost.put(len - 2, minCost(cost, len - 2));
      }
      return Math.min(allCost.get(len - 1), allCost.get(len - 2)) + cost[len];
    }
  }
}
