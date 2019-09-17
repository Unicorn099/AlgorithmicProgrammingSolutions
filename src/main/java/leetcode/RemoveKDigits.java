package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveKDigits {

  public static void main(String[] args) {
    RemoveKDigits kDigits = new RemoveKDigits();
        test(kDigits.removeKdigits("1432219", 3), "1219");
        test(kDigits.removeKdigits("10200", 1), "200");
        test(kDigits.removeKdigits("10", 2), "0");
        test(kDigits.removeKdigits("1897", 2), "17");
        test(kDigits.removeKdigits("1878234299", 2), "18");
    test(kDigits.removeKdigits("99641436378815361153471", 2), "18");
  }

  public static void test(String s, String ss) {
    if (s.equalsIgnoreCase(ss)) {
      System.out.println("PASSED");
    } else {

      System.out.println("NOT PASSED " + s + " " + ss);
    }
  }

  public String removeKdigits(String num, int k) {
    List<Integer> indices;
    String updatedNum = num;
    boolean noChangeHappening = false;
    while (k > 0 && !noChangeHappening) {
      indices = new ArrayList<>();
      for (int i = 0; i < updatedNum.length() && k > 0; i++) {

        while (i < updatedNum.length() - 1 && updatedNum.charAt(i) <= updatedNum.charAt(i + 1)) {
          i++;
        }
        if (i < updatedNum.length() - 1 && updatedNum.charAt(i + 1) < updatedNum.charAt(i)) {
          indices.add(i);
          k--;
        }
        if (indices.isEmpty()) {
          updatedNum = updatedNum.substring(0, updatedNum.length() - k);
          k = 0;
        } else {
          String temp = updateTheString(updatedNum, indices);
          if (temp.equals(updatedNum)) {
            noChangeHappening = true;
          } else {
            updatedNum = temp;
            break;
          }
        }
      }
    }

    if (k > 0) {
      updatedNum = updatedNum.substring(k + 1);
    }
    return updatedNum.equalsIgnoreCase("") ? "0" : updatedNum;
  }

  private String updateTheString(String num, List<Integer> indices) {
    int k = indices.get(0);
    StringBuilder updatedNum = new StringBuilder(num.substring(0, k));
    for (int ii = 1; ii < indices.size(); ii++) {
      updatedNum.append(num, indices.get(ii - 1) + 1, indices.get(ii));
    }
    if (indices.get(indices.size() - 1) < num.length() - 1) {
      updatedNum.append(num.substring(indices.get(indices.size() - 1) + 1));
    }
    // Removing 0 if present in the beginning
    for (int i = 0; i < updatedNum.length(); ) {
      while (i < updatedNum.length() && updatedNum.charAt(i) == '0') {
        i++;
      }
      if (i < updatedNum.length()) {
        updatedNum = new StringBuilder(updatedNum.substring(i));
      } else {
        updatedNum = new StringBuilder("0");
      }
      break;
    }
    return updatedNum.toString();
  }
}
