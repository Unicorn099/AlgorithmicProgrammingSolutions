package year2019.practice.leetcode;

public class SpiralMatrix {

  public static void main(String[] args) {
    int n = 8;
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    int[][] ints = spiralMatrix.generateMatrix(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(ints[i][j] + "     ");
      }
      System.out.println();
    }
  }

  public int[][] generateMatrix(int n) {

    int[][] ans = new int[n][n];
    int number = 1;
    int layer = (n + 1) / 2;
    int currentNumber = 1;
    for (int i = 0; i < layer; i++) {
      currentNumber = populateTheLayer(ans, i, n, currentNumber);
    }

    return ans;
  }

  private int populateTheLayer(int[][] ans, int layerIndex, int n, int currentNumber) {
    int maxRow = n - layerIndex;
    int maxCol = n - layerIndex;
    int minRow = layerIndex;
    int minCol = layerIndex;

    for (int i = minCol; i < maxCol; i++) {
      ans[minRow][i] = currentNumber++;
    }
    for (int i = minRow + 1; i < maxRow; i++) {
      ans[i][maxCol-1] = currentNumber++;
    }
    for (int i = maxCol - 2; i >= minCol; i--) {
      ans[maxRow - 1][i] = currentNumber++;
    }
    for (int i = maxRow - 2; i > minRow; i--) {
      ans[i][minCol]= currentNumber++;
    }

    return currentNumber;
  }
}
