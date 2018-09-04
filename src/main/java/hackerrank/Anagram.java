package hackerrank;

import java.util.Scanner;

public class Anagram {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int T;
    T = Integer.parseInt(in.nextLine());

    String str;

    for (int i = 0; i < T; i++) {
      str = in.nextLine();
      if (str.length() % 2 != 0) {
        System.out.println(-1);
      } else {
        String s1 = str.substring(0, str.length() / 2);
        String s2 = str.substring(str.length() / 2);
        System.out.println(solve(s1, s2));
      }
    }

  }

  private static int solve(String s1, String s2) {
    int ans = 0;

//    char[] x = s1.toCharArray();
//    Arrays.sort(x);
//    char[] y = s2.toCharArray();
//    Arrays.sort(y);

    boolean[] flag = new boolean[s1.length()];
    for (int i = 0; i < s1.length(); i++) {
      boolean temp = false;
      for (int j = 0; j < s2.length(); j++) {
        if (!flag[j] && s1.charAt(i) == s2.charAt(j)) {
          flag[j] = true;
          temp = true;
          break;
        }
      }
      if (!temp) {
        ans++;
      }
    }

    return ans;
  }
}
