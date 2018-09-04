package codeforces.EducationalRound48;

import java.util.Scanner;

public class VasyaAndMushrooms {

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

//    int ans = 0;
//    int anotherTemp = 0;
//    int time = 0;
//
//    if (T == 1) {
//      ans = 1 * bb[0];
//    } else {
//
//      for (int i = 0; i < T; i++) {
//        int tempAns = 0;
//        for (int k = 0; k < i; k++) {
//          anotherTemp += i * aa[k] + (i + 1) * bb[k];
//        }
//        for (int j = i; j < T; j++) {
//          tempAns += i * aa[i] + (T - i) * bb[i];
//        }
//        if (ans < tempAns) {
//          ans = tempAns;
//        }
//      }
//    }

    System.out.println(ans);
  }

  //Has to be completed

  private static long solve(int[] aa, int[] bb) {
    long ans = 0;
    int len = aa.length;

    for (int i = 0; i < len; i++) {
      int sum1 = 0;
      int sum2 = 0;
      int time = 0;
      int sum3=0;


      for(int k=0;k<i;k++){
//        sum3+=aa[k]*(time+k%2)+bb[k]*(time+1+);
        time++;
      }
      for (int j = i; j < len; j++) {
        sum1 += time * aa[i] + (2 * len - 1 - time) * bb[i];
        time++;
      }

      time=0;
      sum2 += time * aa[i] + (time + 1) * bb[i];
      time++;
      for (int j = i + 1; j < len; j++) {
        sum2+=(time+1)*bb[i]+(2*len-1-(time-1));
      }
    }
    return ans;
  }
}
