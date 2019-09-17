package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AsFarFromLandAsPossible {
  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int maxDistance(int[][] grid) {
    List<Point> waterPoints = new ArrayList<>();
    List<Point> landPoints = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] == 0) {
          Point p = new Point(i, j);
          waterPoints.add(p);
        } else {
          Point p = new Point(i, j);
          landPoints.add(p);
        }
      }
    }

    if(waterPoints.isEmpty() || landPoints.isEmpty()){
      return -1;
    }
    int distance = Integer.MIN_VALUE;
    int tempDistance;
    for (Point wp : waterPoints) {
      int minDistance = Integer.MAX_VALUE;
      for (Point lp : landPoints) {
        tempDistance = Math.abs(lp.x - wp.x) + Math.abs(lp.y - wp.y);
        if (tempDistance < minDistance) {
          minDistance = tempDistance;
        }
      }
      if (minDistance > distance) {
        distance = minDistance;
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    AsFarFromLandAsPossible a = new AsFarFromLandAsPossible();
    int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    System.out.println(a.maxDistance(grid));
  }
}
