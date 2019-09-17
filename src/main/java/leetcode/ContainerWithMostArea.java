package year2019.practice.leetcode;

public class ContainerWithMostArea {

  public static void main(String[] args) {
    ContainerWithMostArea containerWithMostArea = new ContainerWithMostArea();
    int[] height1 = {2, 3, 4, 5, 18, 17, 6};
    int[] height2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(containerWithMostArea.maxArea(height1));
    System.out.println(containerWithMostArea.maxArea(height2));
  }

  public int maxArea_nSquare(int[] height) {
    int len = height.length;
    //    int i = 0;
    //    int j = len - 1;
    int area = Integer.MIN_VALUE;

    for (int i = 0; i < len - 1; i++) {
      for (int j = len - 1; j >= i; j--) {
        int tempArea = Math.min(height[i], height[j]) * (j - i);
        if (tempArea > area) {
          area = tempArea;
        }
      }
    }

    return area;
  }

  public int maxArea(int[] height) {

    int i = 0;
    int len = height.length;
    int j = len - 1;
    int area = Math.min(height[i], height[j]) * j;
    while (i < j) {
      area = Math.max(Math.min(height[i], height[j]) * (j - i), area);
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return area;
  }
}
