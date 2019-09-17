package year2019.practice.leetcode;

public class TrappingTheRainWater {

  public static void main(String[] args) {
    TrappingTheRainWater trappingTheRainWater = new TrappingTheRainWater();
    int[] h1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] h2 = {5, 6, 2, 1, 8, 3};
    int[] h3 = {2, 1, 0, 3};
    int[] h4 = {5, 2, 1, 2, 1, 5};
    System.out.println(trappingTheRainWater.trap(h1));
    System.out.println(trappingTheRainWater.trap(h2));
    System.out.println(trappingTheRainWater.trap(h3));
    System.out.println(trappingTheRainWater.trap(h4));
  }

  public int trap(int[] height) {

    int len = height.length;
    int waterCollectedSoFar =0;

    int i = 0;
    int j = len - 1;
    if(len<=1){
      return waterCollectedSoFar;
    }
    while (height[i] == 0) {
      i++;
    }
    while (height[j] == 0) {
      j--;
    }
    int leftMax = height[i];
    int rightMax = height[j];
    if(j-1<=i){
      return waterCollectedSoFar;
    }
    int maxHeightFoundSoFar = Math.min(rightMax, leftMax);
    waterCollectedSoFar = maxHeightFoundSoFar * (j - i - 1);

    while (i < j - 1) {
      int newHeightFound;
      if (height[i] <= height[j]) {
        i++;
        newHeightFound = height[i];
      } else {
        j--;
        newHeightFound = height[j];
      }
      if (newHeightFound <= maxHeightFoundSoFar) {
        waterCollectedSoFar -= newHeightFound;
      } else {
        waterCollectedSoFar -= maxHeightFoundSoFar;
        waterCollectedSoFar += (Math.min(height[i], height[j]) - maxHeightFoundSoFar) * (j - i - 1);
        maxHeightFoundSoFar = Math.min(height[i], height[j]);
      }
    }

    return waterCollectedSoFar;
  }
}
