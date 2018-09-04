package codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bitsv2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String a = sc.nextLine();
    String b = sc.nextLine();

    List<Integer> indexListAone = new ArrayList<>();
    List<Integer> indexListAzero = new ArrayList<>();
    Map<Integer, Integer> indexListB = new HashMap<>();
    long countao = 0;
    long countaz = 0;
    for (int i = 0; i < n; i++) {
      if (b.charAt(i) == '1') {
        indexListB.put(i, 1);
      } else {
        indexListB.put(i, 0);
      }
      if (a.charAt(i) == '1') {
        indexListAone.add(i);
        countao++;
      } else {
        indexListAzero.add(i);
        countaz++;
      }
    }

    long count1 = 0;
    for (Integer i : indexListAone) {
      if (indexListB.get(i) == 1) {
        count1++;
      }
    }
    long count2 = 0;
    for (Integer i : indexListAzero) {
      if (indexListB.get(i) == 1) {
        count2++;
      }
    }

    long ans =
        ((countao * countaz) - (count1 * count2)) > 0 ? ((countao * countaz) - (count1 * count2))
            : 0;

    System.out.println(ans);

  }
}
