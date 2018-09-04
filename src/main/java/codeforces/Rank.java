package codeforces;

import java.util.Scanner;

public class Rank {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());

    String[][] str = new String[N][4];
    str[0] = sc.nextLine().split(" ");
    int thomasMarks =
        Integer.parseInt(str[0][0]) + Integer.parseInt(str[0][1]) + Integer.parseInt(str[0][2])
            + Integer.parseInt(str[0][3]);

    int rank = 1;
    for (int i = 1; i < N; i++) {
      str[i] = sc.nextLine().split(" ");
      int totalMarks =
          Integer.parseInt(str[i][0]) + Integer.parseInt(str[i][1]) + Integer.parseInt(str[i][2])
              + Integer.parseInt(str[i][3]);

      if (totalMarks > thomasMarks) {
        rank++;
      }
    }

    System.out.print(rank);
    sc.close();
  }
}
