package codeforces.EducationalRound48;

import java.util.Scanner;

public class DeathNotev2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    str = sc.nextLine().split(" ");


    long left = 0;
    for (int i = 0; i < N;i++ ) {
      int count = (int) ((left+Integer.parseInt(str[i]))/M);
      left = ((left+Integer.parseInt(str[i]))%M);
      System.out.print(count+" ");
    }

  }
}
