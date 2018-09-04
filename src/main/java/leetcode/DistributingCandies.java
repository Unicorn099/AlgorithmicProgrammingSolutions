package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DistributingCandies {

  public static void main(String[] args) {

    int[] input = new int[]{1, 1, 2, 3};
    System.out.println(new DistributingCandies().distributeCandies(input));
  }

  private int distributeCandies(int[] candies) {

    Map<Integer, Integer> countCandiesType = new HashMap<>();
    int candiesToBeDistributed = candies.length / 2;
    for (int candy : candies) {
      if (countCandiesType.containsKey(candy)) {
        countCandiesType.put(candy, countCandiesType.get(candy) + 1);
      } else {
        countCandiesType.put(candy, 1);
      }
    }

    return (int) countCandiesType.entrySet().stream().limit(candiesToBeDistributed).count();
  }
}
