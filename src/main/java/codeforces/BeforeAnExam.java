package codeforces;

import java.util.Scanner;

public class BeforeAnExam {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int d = Integer.parseInt(str[0]);
    int sumTime = Integer.parseInt(str[1]);

    int[][] minMaxData = new int[d][2];
    for (int i = 0; i < d; i++) {
      str = sc.nextLine().split(" ");
      minMaxData[i][0] = Integer.parseInt(str[0]);
      minMaxData[i][1] = Integer.parseInt(str[1]);
    }

    solveAndPrintTheAnswer(minMaxData, sumTime);
  }

  private static void solveAndPrintTheAnswer(int[][] minMaxData, int sumTime) {
    int len = minMaxData.length;
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      ans[i] = minMaxData[i][0];
      sumTime -= ans[i];
    }

    if (sumTime < 0) {
      System.out.println("NO");
      return;
    } else {
      for (int i = 0; i < len; i++) {
        if (sumTime - (minMaxData[i][1] - minMaxData[i][0]) < 0) {
          ans[i] += sumTime;
          sumTime=0;
          break;
        } else {
          ans[i] += minMaxData[i][1] - minMaxData[i][0];
          sumTime -= minMaxData[i][1] - minMaxData[i][0];
        }
      }
    }
    if(sumTime>0){
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
    for (int i = 0; i < len; i++) {
      System.out.print(ans[i] + " ");
    }
  }
}
