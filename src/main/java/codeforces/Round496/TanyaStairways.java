package codeforces.Round496;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TanyaStairways {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] str = sc.nextLine().split(" ");

    int countOfStairs = 0;
    List<Integer> steps = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (str[i].equalsIgnoreCase("1")) {
        countOfStairs++;
        if (i != 0) {
          steps.add(Integer.parseInt(str[i - 1]));
        }
      }
    }

    steps.add(Integer.parseInt(str[n - 1]));

    System.out.println(countOfStairs);
    for (Integer ii : steps) {
      System.out.print(ii + " ");
    }
  }
}
