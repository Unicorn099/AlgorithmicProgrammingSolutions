package codeforces.Round496;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Polycarp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String number = sc.nextLine();

    int count = 0;

    List<String> strs = new ArrayList<>();
    String anotherNumber = "";
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) == '0') {
        count++;
        if (anotherNumber.length() != 0) {
          strs.add(anotherNumber);
        }
        anotherNumber = "";
      } else {
        anotherNumber += number.charAt(i) + "";
      }
    }
    if (anotherNumber.length() != 0) {
      strs.add(anotherNumber);
    }

    for (String ss : strs) {
      for (int i = 0; i < ss.length(); i++) {
        long sum = 0;
        for (int j = i; j < ss.length(); j++) {
//          Long n = Long.parseLong(ss.substring(i, j));
          sum += Long.parseLong(ss.charAt(j) + "");
          if (sum % 3 == 0) {
            count++;
            i = j;
            break;
          }
        }
      }
    }


//    for (String ss : strs) {
//      for (int i = 0; i < ss.length(); i++) {
//        long sum = 0;
//        for (int j = i; j < ss.length(); j++) {
////          Long n = Long.parseLong(ss.substring(i, j));
//          sum += Long.parseLong(ss.charAt(j) + "");
//          if (sum % 3 == 0) {
//            count++;
//            i = j;
//            break;
//          }
//        }
//      }
//    }

    System.out.println(count);
  }

  static int[] delta_encode(int[] array) {
    /*
     * Write your code here.
     */
    int len = array.length;
    List<Integer> ans = new ArrayList<>();
    ans.add(array[0]);
    for (int i = 1; i < len; i++) {
      int x = array[i] - array[i - 1];
      if (x > 127 || x < -127) {
        ans.add(-128);
        ans.add(x);
      }
    }
    int[] res = new int[ans.size()];
    for (int k = 0; k < ans.size(); k++) {
      res[k] = ans.get(k);
    }
    return res;
  }

  static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
    /*
     * Write your code here.
     */

    int maxOverlap = 0;
    boolean[] flag = new boolean[callsTimes.length];
    for (int i = 0; i < callsTimes.length; i++) {
      if (!flag[i]) {
        for (int j = i + 1; j < callsTimes.length; j++) {
          if (!flag[j]) {
            if (callsTimes[i][0] < callsTimes[j][1] && callsTimes[j][0] < callsTimes[i][1]) {
              flag[i] = true;
              flag[j] = true;
              maxOverlap += 2;
            }
          }
        }
      }
    }

    return maxOverlap!=0||maxOverlap<noOfCurrentAgents?maxOverlap-noOfCurrentAgents:0;
  }
}
