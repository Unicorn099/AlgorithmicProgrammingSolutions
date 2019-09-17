package year2019.practice.leetcode;

public class MinPathSum {

  public static void main(String[] args) {

    int[][] grid = {{1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}};

    System.out.print(new MinPathSum().minPathSum(grid));
  }

  public int minPathSum(int[][] grid) {

    int r = grid.length;
    int c = grid[0].length;
    int[][] ans = new int[r][c];
    ans[0][0] = grid[0][0];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int tempSum1 = 0;
        int tempSum2 = 0;
        if (j != 0) {
          tempSum1 = grid[i][j] + ans[i][j - 1];
        }
        if (i != 0) {
          tempSum2 = grid[i][j] + ans[i - 1][j];
        }
        if (tempSum1 != 0 && tempSum2 != 0) {
          ans[i][j] = tempSum1 > tempSum2 ? tempSum2 : tempSum1;
        } else {
          ans[i][j] = tempSum1 == 0 ? tempSum2 : tempSum1;
        }
      }
    }
    return ans[r - 1][c - 1];
  }
}
