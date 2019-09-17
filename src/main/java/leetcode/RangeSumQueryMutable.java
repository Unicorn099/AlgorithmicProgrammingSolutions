package year2019.practice.leetcode;

public class RangeSumQueryMutable {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5};
    NumArray numArray = new NumArray(nums);
    int i = numArray.sumRange(0, 2);
    System.out.println(i);
    numArray.update(1, 2);
    i = numArray.sumRange(0, 2);
    System.out.println(i);
  }

  static class NumArray {

    int[] nums;
    int[] prefixSum;

    public NumArray(int[] nums) {
      this.nums = nums;
      this.prefixSum = new int[nums.length];
      int sumSoFar = 0;
      for (int i = 0; i < nums.length; i++) {
        sumSoFar += nums[i];
        this.prefixSum[i] = sumSoFar;
      }
    }

    public void update(int i, int val) {

      for (int j = i; j < nums.length; j++) {
        this.prefixSum[j] += val - this.nums[i];
      }
      this.nums[i] = val;
    }

    public int sumRange(int i, int j) {
      return this.prefixSum[j] - this.prefixSum[i] + this.nums[i];
    }
  }
}
