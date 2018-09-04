package codeforces.EducationalRound48;

import java.util.Scanner;

public class DeathNote {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    str = sc.nextLine().split(" ");

    String ans = "";
    long left = 0;
    for (int i = 0; i < N; ) {
      long count = 0;
      long curLimit = 0;
      curLimit = left + Integer.parseInt(str[i]);
      if (curLimit < M) {
        left = 0;
        while (curLimit < M && i < N) {
          ans += "0 ";
          i++;
          if (i < N) {
            curLimit += Integer.parseInt(str[i]);
          }
        }
        if (curLimit > M) {
          count = curLimit / M;
          ans += String.valueOf(count) + " ";
          left = curLimit % M;
        }
      } else if (curLimit > M) {
        count = curLimit / M;
        ans += String.valueOf(count) + " ";
        left = curLimit % M;
      } else {
        ans += "1 ";
      }

      i++;
    }

    System.out.println(ans);
  }
}
