package codeforces.Round496;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Summarize {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    String[] str = sc.nextLine().split(" ");

    Set<Long> ser = new HashSet<>();
    long k = 1;
    ser.add(k);
    while (k < 2000000000) {
      k *= 2;
      ser.add(k);
    }

    int count = 0;

    boolean[] flagList = new boolean[n];
    boolean[] removedOnes = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!flagList[i]) {
        boolean flag = false;
        for (int j = 0; j < n; j++) {
          if (j != i && !removedOnes[j]) {
            if (ser.contains(Long.parseLong(str[j]) + Long.parseLong(str[i]))) {
              flagList[i] = true;
              flagList[j] = true;
              flag = true;
              j = n;
            }
          }
        }
        if (!flag) {
          removedOnes[i] = true;
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
