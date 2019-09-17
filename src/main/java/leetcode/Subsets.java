package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    Subsets s = new Subsets();
    int[] nums = {1, 2, 3};
    List<List<Integer>> subsets = s.subsets(nums);
    subsets.forEach(
        integers -> {
          integers.forEach(integer -> System.out.print(integer + " "));
          System.out.println();
        });
  }

  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> ans = new ArrayList();

    for (int i = 0; i < (1 << nums.length); i++) {
      List<Integer> a = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((i & (1 << j)) != 0) {
          a.add(nums[j]);
        }
      }
      ans.add(a);
    }
    return ans;
  }
}
