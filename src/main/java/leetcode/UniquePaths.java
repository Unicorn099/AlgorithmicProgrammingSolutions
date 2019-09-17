package year2019.practice.leetcode;

public class UniquePaths {

  public static void main(String[] args) {
//    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] obstacleGrid = {{0,1}};
    System.out.print(new UniquePaths().uniquePathsWithObstacles(obstacleGrid));
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int r = obstacleGrid.length;
    int c = obstacleGrid[0].length;
    int[][] ans = new int[r][c];
    if (obstacleGrid[0][0] == 0) {
      ans[0][0] = 1;
    } else {
      ans[0][0] = 0;
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (j != 0 && obstacleGrid[i][j - 1] != 1) {
          ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : ans[i][j] + ans[i][j - 1];
        }
        if (i != 0 && obstacleGrid[i - 1][j] != 1) {
          ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : ans[i][j] + ans[i - 1][j];
        }
      }
    }
    return ans[r - 1][c - 1];
  }
}
