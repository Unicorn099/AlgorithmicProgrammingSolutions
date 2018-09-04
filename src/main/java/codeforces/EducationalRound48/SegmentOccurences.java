package codeforces.EducationalRound48;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentOccurences {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);
    int q = Integer.parseInt(str[2]);

    String s = sc.nextLine();
    String t = sc.nextLine();

    int[][] qu = new int[q][2];
    for (int i = 0; i < q; i++) {
      str = sc.nextLine().split(" ");
      qu[i][0] = Integer.parseInt(str[0]);
      qu[i][1] = Integer.parseInt(str[1]);
    }

    List<int[]> xx = new ArrayList<>();
    int k = 0;
    for (int i = 0; i + m <= s.length(); i++) {
      String temp = s.substring(i, i + m);
      if (temp.equalsIgnoreCase(t)) {
        int[] range = new int[2];
        range[0] = i + 1;
        range[1] = i + t.length();
        xx.add(range);
      }
    }

    for (int i = 0; i < q; i++) {
      int count = 0;
      if (xx.size() == s.length()) {
        count = qu[i][1] - qu[i][0] + 1;
      } else {
        for (int j = 0; j < xx.size(); j++) {
          if (xx.get(j)[0] >= qu[i][0] && xx.get(j)[1] <= qu[i][1]) {
            count++;
          }
          if (xx.get(j)[1] > qu[i][1]) {
            break;
          }
        }
      }
      System.out.println(count);
    }
  }
}
