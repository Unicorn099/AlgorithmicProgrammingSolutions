package codeforces.EducationalRound48;

import java.util.Scanner;

public class VasyaAndMushroomsv3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    String[] a = sc.nextLine().split(" ");
    String[] b = sc.nextLine().split(" ");

    int[] aa = new int[T];
    int[] bb = new int[T];

    for (int i = 0; i < T; i++) {
      aa[i] = Integer.parseInt(a[i]);
      bb[i] = Integer.parseInt(b[i]);
    }

    long ans = solve(aa, bb);

    System.out.println(ans);
  }

  private static long solve(int[] aa, int[] bb) {
    long ans = 0;

    int len = aa.length;

    int tempAns = 0;
    for (int i = 0; i < len; i++) {
      tempAns += i * aa[i] + bb[i] * ((2 * len) - 1 - i);
    }
    if (tempAns > ans) {
      ans = tempAns;
    }
    tempAns = bb[0];
    int n = 0;
    for (int i = 2; i <= len; i++) {
      tempAns += i * bb[i - 1] + aa[i - 1] * ((2 * len) - 1 - n);
      n++;
    }
    if (tempAns > ans) {
      ans = tempAns;
    }

    int k = 3;
    int[] arr = new int[len];
    arr[0] = bb[0];
    boolean flag2 = true;

    while (k < 2 * len) {
      boolean flag1 = true;
      tempAns = 0;
      int colCount = 0;

      int ii = k;
      while (arr[ii] == 0) {
        if (flag1) {
          tempAns += ii * aa[colCount] + (ii + 1) * bb[colCount];
        } else {
          tempAns += ii * bb[colCount] + (ii + 1) * aa[colCount];
        }
      }

      for (int i = 0; i < k; i = i + 2) {
        if (flag1) {
          tempAns += i * aa[colCount] + (i + 1) * bb[colCount];
        } else {
          tempAns += i * bb[colCount] + (i + 1) * aa[colCount];
        }
        colCount++;
        flag1 = !flag1;
      }

      int j = colCount;
      int m = 0;
      k++;
      int multiplier = k;
      for (int l = j; l < len; l++) {
        if (flag2) {
          tempAns += multiplier * aa[l] + bb[l] * ((2 * len) - 1 - m);
        } else {
          tempAns += multiplier * bb[l] + aa[l] * ((2 * len) - 1 - m);
        }
        multiplier++;
        m++;
      }

      flag2 = !flag2;
      if (tempAns > ans) {
        ans = tempAns;
      }
      k++;
    }

    return ans;
  }
}
