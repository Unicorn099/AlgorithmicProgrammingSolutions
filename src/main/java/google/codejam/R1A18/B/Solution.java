package google.codejam.R1A18.B;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1A18\\";
  final static String fileName = "B-small";

  public static void main(String[] args) throws FileNotFoundException {

//    Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));
    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      String[] s = sc.nextLine().split(" ");
      int R = Integer.parseInt(s[0]);
      int B = Integer.parseInt(s[1]);
      int C = Integer.parseInt(s[2]);
      long[] M = new long[C];
      long[] S = new long[C];
      long[] P = new long[C];
      for (int j = 0; j < C; j++) {
        String[] ss = sc.nextLine().split(" ");
        M[j] = Long.parseLong(ss[0]);
        S[j] = Long.parseLong(ss[1]);
        P[j] = Long.parseLong(ss[2]);
      }

      System.out.print("Case #" + (i + 1) + ": ");
//      solve(M, S, P, B, R, C);
      solveV2(M, S, P, B, R, C);
    }
    sc.close();
  }

  private static void solveV2(long[] m, long[] s, long[] p, int b, int r, int c) {
    int t = 1;
    long[] capacity = new long[c];
    boolean flag = true;
    while (flag) {
      capacity = callForAll(m, s, p, c, t);
      Arrays.sort(capacity);
      int totalBitsProcessed = 0;
      for (int i = c - 1; i >= c - r; i--) {
        totalBitsProcessed += capacity[i];
      }
      if (totalBitsProcessed >= b) {
        flag = false;
        break;
      }
      t *= 2;
    }

    int low = t / 2;
    int high = t;
    int mid = 0;
    while (low + 1 < high) {
      mid = (low + high) / 2;
      if (timeisRight(m, s, p, c, mid, r, b)) {
        high = mid;
      } else {
        low = mid;
      }
    }
    System.out.println(high);
  }

  private static long[] callForAll(long[] m, long[] s, long[] p, int c, int t) {
    long[] x = new long[c];
    for (int i = 0; i < c; i++) {
      x[i] = Math.max(0, Math.min(m[i], (t - p[i]) / s[i]));
    }
    return x;
  }

  private static boolean timeisRight(long[] m, long[] s, long[] p, int c, int t, int r, int b) {
    long[] capacity = callForAll(m, s, p, c, t);
    Arrays.sort(capacity);
    int totalBitsProcessed = 0;
    for (int i = c - 1; i >= c - r; i--) {
      totalBitsProcessed += capacity[i];
    }
    if (totalBitsProcessed >= b) {
      return true;
    } else {
      return false;
    }
  }

  private static void solve(long[] m, long[] s, long[] p, int b, int r, int c) {
    long[] ans = new long[b];
    int count = 0;

    Map<Long, Integer> indices = new TreeMap<>();
    for (int i = 0; i < c; i++) {
      indices.put(s[i] * b * p[i], i);
    }

    for (int i = 1; i <= b; i++) {
      for (int j = 0; j < c; j++) {
        if (m[j] >= i) {
          ans[count] = s[j] * i + p[j];
          count++;
        }
      }
    }
    Arrays.sort(ans);
    Arrays.stream(ans).forEach(value -> System.out.print(value));
    System.out.println();
    System.out.println(ans[b - 1]);
  }
}
