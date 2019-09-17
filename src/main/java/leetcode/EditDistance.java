package year2019.practice.leetcode;

public class EditDistance {

  public static void main(String[] args) {
//    String s1 = "zoologicoarchaeologist";
//    String s2 = "zoogeologist";
    String s1="intention";
    String s2="execution";
    EditDistance e = new EditDistance();
    System.out.print(e.minDistance(s1, s2));
  }

  public int minDistance(String word1, String word2) {

    int x = 0;
    /**
     * If word2 is empty, removing
     */
    int[][] ans = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      ans[i][0] = i;
    }
    /**
     * if word1 is empty, adding
     */
    for (int i = 0; i <= word2.length(); i++) {
      ans[0][i] = i;
    }

    /**
     * None is empty
     */
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int min = findMin(ans, i, j);
        ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
      }
    }

    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

    return ans[word1.length()][word2.length()];
  }

  private int findMin(int[][] ans, int i, int j) {
    return Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
  }
}
