package codeforces.Round495;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SonyaMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    String[] str = sc.nextLine().split(" ");
    int[] count = new int[n];

//    Map<Integer, Integer> xx = new HashMap<>();
    for (int i = 0; i < n; i++) {
      count[Integer.parseInt(str[i])] += 1;
//      int count = xx.getOrDefault(Integer.parseInt(str[i]), 0);
//      xx.put(Integer.parseInt(str[i]), count + 1);
    }

    int minMult4 = -1;

    for (int i = 1; i < n && count[i] != 0; i++) {
      if (count[i] % 4 != 0) {
        minMult4 = i;
        break;
      }
    }

    if (minMult4 == -1) {
      System.out.println("-1");
    } else {
      List<int[]> allTheOptions = getFactor(n);
      for (int[] option : allTheOptions) {
//        int[] tempCount = new int[n];
        for (int i = 0; i < option[1]; i++) {
//          for (int ii = 0; ii < n; ii++) {
//            tempCount[ii] = count[ii];
//          }
          if (formTheMatrix(option, minMult4-1, i, count)) {
            System.out.println(option[0] + " " + option[1]);
            System.out.println(minMult4 + " " + (i+1));
            return;
          }
        }
      }
      System.out.println("-1");
    }
  }

  private static boolean formTheMatrix(int[] option, int minMult4, int i, int[] xx) {

//    Map<Integer,Integer> yy = new HashMap<>();
    for (int j = 0; j < option[0]; j++) {
      for (int k = 0; k < option[1]; k++) {
        int d = Math.abs(j - minMult4) + Math.abs(k - i);
        if (d < xx.length && xx[d] > 0) {
//          int x = yy.getOrDefault(d,0);
//          yy.put(d,x+1);
//          xx[d] -= 1;
//            xx.put(d, xx.get(d) - 1);
        } else {
          return false;
        }
      }
    }
//    for(Map.Entry<Integer,Integer> xx:)
    return true;
  }

  private static List<int[]> getFactor(int n) {
    List<int[]> ans = new ArrayList<>();

    int sqrt = (int) Math.sqrt(n);
    for (int i = 1; i <= sqrt; i++) {
      if (n % i == 0) {
        int[] a1 = new int[2];
        a1[0] = i;
        a1[1] = n / i;
//        int[] a2 = new int[2];
//        a2[0] = a1[1];
//        a2[1] = a1[0];
        ans.add(a1);
//        ans.add(a2);
      }
    }
    return ans;
  }
}
