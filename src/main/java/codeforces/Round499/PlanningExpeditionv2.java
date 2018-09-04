package codeforces.Round499;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlanningExpeditionv2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int ep = Integer.parseInt(str[0]);
    int p = Integer.parseInt(str[1]);

    str = sc.nextLine().split(" ");
    if (p < ep) {
      System.out.println(0);
    } else {
      Map<Integer, Integer> packageTypeCount = new HashMap<>();
      for (int i = 0; i < p; i++) {
        int y = Integer.parseInt(str[i]);
        int x = packageTypeCount.getOrDefault(y, 0);
        x++;
        packageTypeCount.put(y, x);
      }


      for (int i = p; i >= 1; i--) {
        int l = 0;
        Map<Integer, Integer> integerIntegerMap = make(packageTypeCount);
        for (Map.Entry<Integer, Integer> ii : integerIntegerMap.entrySet()) {
          while (ii.getValue() >= i) {
            ii.setValue(ii.getValue() - i);
            l++;
          }
          if (l >= ep) {
            System.out.println(i);
            return;
          }
        }
      }

      System.out.println(0);

    }
  }

  private static Map<Integer, Integer> make(Map<Integer, Integer> packageTypeCount) {
    Map<Integer, Integer> ans = new HashMap<>();
    for (Map.Entry<Integer, Integer> uu : packageTypeCount.entrySet()) {
      ans.put(uu.getKey(), uu.getValue());
    }

    return ans;
  }
}
