package year2019.practice.leetcode;

import org.jetbrains.annotations.NotNull;

//Not Correct
public class MinCostClimbingStairs {

  public static void main(String[] args) {
    MinCostClimbingStairs c = new MinCostClimbingStairs();
    int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int[] cost2 = {0, 0, 0, 1};
    int i = c.minCostClimbingStairs(cost1);
    int j = c.minCostClimbingStairs(cost2);
    System.out.println(i);
    System.out.println(j);
  }

  public int minCostClimbingStairs(@NotNull int[] cost) {
    int[][] finalCost = new int[cost.length][2];
    finalCost[0][0] = cost[0];//current stairs is used
    finalCost[0][1] = cost[0];//current stairs is not used, not possible for this case, hence same value

    finalCost[1][0] = finalCost[0][1];
    finalCost[1][1] = cost[1];

    finalCost[2][0] = finalCost[0][1]+cost[2];
    finalCost[2][1] = finalCost[1][0];

    for (int i = 3; i < cost.length; i++) {

      finalCost[i][0] = finalCost[i - 2][1]+cost[i];
      finalCost[i][1] = finalCost[i - 1][1];
    }
    return Math.min(finalCost[cost.length - 1][0], finalCost[cost.length - 1][1]);
  }
}
