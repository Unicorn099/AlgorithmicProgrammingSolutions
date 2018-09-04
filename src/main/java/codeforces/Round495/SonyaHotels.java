package codeforces.Round495;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SonyaHotels {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int d = Integer.parseInt(str[1]);

    str = sc.nextLine().split(" ");
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      h[i] = Integer.parseInt(str[i]);
    }
    //

    Arrays.sort(h);
    Set<Integer> ans = new HashSet<>();
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      x = h[i] + d;
      y = h[i] - d;
      boolean flagx = true;
      boolean flagy = true;
      for (int j = 0; j < n; j++) {
        if (Math.abs(x - h[j]) < d) {
          flagx = false;
        }
        if (Math.abs(y - h[j]) < d) {
          flagy = false;
        }
      }
      if (flagx) {
        ans.add(x);
      }
      if (flagy) {
        ans.add(y);
      }
    }

    System.out.println(ans.size());

  }
}
