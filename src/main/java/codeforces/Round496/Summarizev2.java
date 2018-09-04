package codeforces.Round496;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Summarizev2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    String[] str = sc.nextLine().split(" ");

    List<Long> serList = new ArrayList<>();
    long k = 1;
    serList.add(k);
    while (k < 2000000000) {
      k *= 2;
      serList.add(k);
    }

    int count = 0;

    Map<Long, Integer> maps = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = maps.getOrDefault(Long.parseLong(str[i]), 0);
      maps.put(Long.parseLong(str[i]), x + 1);
    }


    for (int i = 0; i < n; i++) {
      boolean flag = false;
      for (Long xx : serList) {
        long firstNumber = Long.parseLong(str[i]);
        long anotherNumber = xx - firstNumber;
        if (((firstNumber != anotherNumber && maps.containsKey(anotherNumber))
            || (firstNumber == anotherNumber && maps.containsKey(anotherNumber) && maps.get(anotherNumber) > 1))) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        count++;
      }
    }

    System.out.println(count);
  }
}
