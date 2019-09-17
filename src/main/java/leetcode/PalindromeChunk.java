package year2019.practice.leetcode;

public class PalindromeChunk {

  public static void main(String[] args) {
    PalindromeChunk p = new PalindromeChunk();
    int ghiabcdefhelloadamhelloabcdefghi = p.longestDecomposition("antaprezatepzapreanta");
    System.out.println(ghiabcdefhelloadamhelloabcdefghi);
  }

  public int longestDecomposition(String text) {
    int len = text.length();
    int i = len - 1;
    int j = 0;
    int ans = 0;
    int lastSuccessIndex = -1;
    boolean evenCase = false;
    for (; i >= 0 && j < i; ) {
      if (text.charAt(i) == text.charAt(j)) {
        int k = i;
        int m = j;
        while (k >= 0 && m > lastSuccessIndex && text.charAt(k) == text.charAt(m)) {
          k--;
          m--;
        }
        if (m == lastSuccessIndex) {
          i = k;
          ans += 2;
          lastSuccessIndex = j;
          j++;
          if (i < j) {
            evenCase = true;
          }
        } else {
          j++;
        }
      } else {
        j++;
      }
    }
    return evenCase ? ans : ans + 1;
  }
}
