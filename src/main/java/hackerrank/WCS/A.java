package hackerrank.WCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A {

  public static void main(String[] args) {
    Arrays.stream(findTheAbsentStudents(10, new int[]{1, 2, 2, 3, 4, 5, 2, 8, 9, 10})).forEach(System.out::println);
    List<String> x = Arrays.asList("2A","a1","A1");
    Collections.sort(x);
    x.stream().forEach(System.out::println);

  }

  static int[] findTheAbsentStudents(int n, int[] a) {
    // Return the list of student IDs of the missing students in increasing order.

    boolean[] flag = new boolean[n];

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      flag[a[i]-1] = true;
    }
    for (int i = 0; i < n; i++) {
      if (!flag[i]) {
        ans.add(i);
      }
    }
    int[] result = new int[ans.size()];
    int j = 0;
    for (Integer i : ans) {
      result[j++] = i+1;
    }
    return result;
  }
}
