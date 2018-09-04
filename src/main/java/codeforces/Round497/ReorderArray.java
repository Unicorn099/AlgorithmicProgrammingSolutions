package codeforces.Round497;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReorderArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = Integer.parseInt(sc.nextLine());
    String[] str = sc.nextLine().split(" ");

    int[] x1 = new int[number];
    int[] x2 = new int[number];
    for (int i = 0; i < number; i++) {
      x1[i] = Integer.parseInt(str[i]);
      x2[i] = Integer.parseInt(str[i]);
    }

    Arrays.sort(x1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < number; i++) {
      map.put(x1[i], i);
    }

    boolean[] flag = new boolean[number];
    int count = 0;
    for (int i = 0; i < number; i++) {
      int index = map.get(x2[i]);
      for (int j = index + 1; j < number; j++) {
        if (!flag[j] && x1[j] > x2[i]) {
          count++;
          flag[j] = true;
          map.put(x2[i], j);
          break;
        }
      }
    }

    System.out.println(count);
  }
}
