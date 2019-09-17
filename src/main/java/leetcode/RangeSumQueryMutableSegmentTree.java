package year2019.practice.leetcode;

public class RangeSumQueryMutableSegmentTree {

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

    int[] tree;

    public NumArray(int[] nums) {
      this.tree = new int[2 * nums.length];
      for (int i = nums.length; i < 2 * nums.length; i++) {
        this.tree[i] = nums[i - nums.length];
      }
      for (int i = nums.length - 1; i >= 0; --i) {
        this.tree[i] = this.tree[i * 2] + this.tree[i * 2 + 1];
      }
    }

    public void update(int i, int val) {

      int pos = i + this.tree.length / 2;
      this.tree[pos] = val;

      while (pos > 0) {
        int left = pos;
        int right = pos;
        if (pos % 2 == 0) {
          right = pos + 1;
        } else {
          left = pos - 1;
        }
        this.tree[pos / 2] = this.tree[left] + this.tree[right];
        pos /= 2;
      }
    }

    public int sumRange(int i, int j) {
      int l = i + this.tree.length / 2;
      int r = j + this.tree.length / 2;
      int sum = 0;
      while (l <= r) {
        if ((l % 2) == 1) {
          sum += tree[l];
          l++;
        }
        if ((r % 2) == 0) {
          sum += tree[r];
          r--;
        }
        l /= 2;
        r /= 2;
      }
      return sum;
    }
  }
}
