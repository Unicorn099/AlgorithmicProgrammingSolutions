package year2019.practice.leetcode;

public class DecreasiInZigZag {

  public static void main(String[] args) {

    int[] arr = {10, 4, 4, 10, 10, 6, 2, 3};
    DecreasiInZigZag d = new DecreasiInZigZag();
    System.out.println(d.movesToMakeZigzag(arr));
  }

  public int movesToMakeZigzag(int[] nums) {

    int len = nums.length;
    CurrentStatus c1;
    CurrentStatus c2;
    int i = 1;
    if (nums[i] > nums[i - 1]) {
      c1 = new CurrentStatus(nums[i], 0, 'S');
      c2 = new CurrentStatus(nums[i - 1] - 1, Math.abs(nums[i] - (nums[i - 1] - 1)), 'G');
    } else if (nums[i] < nums[i - 1]) {
      c1 = new CurrentStatus(nums[i], 0, 'G');
      c2 = new CurrentStatus(nums[i - 1] + 1, Math.abs(nums[i] - (nums[i - 1] + 1)), 'S');
    } else {
      c1 = new CurrentStatus(nums[i - 1] - 1, Math.abs(nums[i] - (nums[i - 1] - 1)), 'G');
      c2 = new CurrentStatus(nums[i - 1] + 1, Math.abs(nums[i] - (nums[i - 1] + 1)), 'S');
    }

    i = 2;
    for (; i < len; i++) {

      c1 = geUpdatedVal(c1, nums[i]);
      c2 = geUpdatedVal(c2, nums[i]);
    }
    return Math.min(c1.moves, c2.moves);

  }

  private CurrentStatus geUpdatedVal(CurrentStatus c1, int num) {

    if (c1.expectedEle == 'S') {
      if (num < c1.lastElement) {
        c1.expectedEle = 'G';
        c1.lastElement = num;
      } else {
        c1.expectedEle = 'G';
        c1.lastElement = c1.lastElement - 1;
        c1.moves = c1.moves + Math.abs(c1.lastElement - num);
      }
    } else {
      if (num > c1.lastElement) {
        c1.expectedEle = 'S';
        c1.lastElement = num;
      } else {
        c1.expectedEle = 'S';
        c1.lastElement = c1.lastElement + 1;
        c1.moves = c1.moves + Math.abs(c1.lastElement - num);
      }
    }
    return c1;
  }

  class CurrentStatus {

    int lastElement;
    int moves;
    char expectedEle;

    public CurrentStatus(int lastElement, int moves, char expectedEle) {
      this.lastElement = lastElement;
      this.moves = moves;
      this.expectedEle = expectedEle;
    }
  }
}
