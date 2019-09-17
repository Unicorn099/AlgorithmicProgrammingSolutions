package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

  public static void main(String[] args) {
    LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
    List<String> a1b2 = letterCasePermutation.sletterCasePermutation("12345");
    a1b2.forEach(System.out::println);
  }

  public List<String> letterCasePermutation(String S) {

    Set<String> set = new HashSet<>();
    for (int i = 0; i < (1 << S.length()); i++) {
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < S.length(); j++) {
        if ((i & (1 << j)) != 0 && Character.isLetter(S.charAt(j))) {
          s.append(
              Character.isLowerCase(S.charAt(j))
                  ? Character.toUpperCase(S.charAt(j))
                  : Character.toLowerCase(S.charAt(j)));
        } else {
          s.append(S.charAt(j));
        }
      }
      set.add(s.toString());
    }
    return new ArrayList<>(set);
  }

  public List<String> sletterCasePermutation(String S) {
    if (S.length()>1) {
      List<String> strings = new ArrayList<>();
      if (Character.isDigit(S.charAt(0))) {
        String s = S.charAt(0) + "";
        strings.add(s);
      } else {
        String s1 = S.charAt(0) + "";
        String s2 =
            Character.isLowerCase(S.charAt(0))
                ? Character.toUpperCase(S.charAt(0)) + ""
                : Character.toLowerCase(S.charAt(0)) + "";
        strings.add(s1);
        strings.add(s2);
      }
      List<String> strings1 = sletterCasePermutation(S.substring(1));
      List<String> ans = new ArrayList<>();
      for (String str : strings) {
        for (String ss : strings1) {
          String ssss = str + ss;
          ans.add(ssss);
        }
      }
      return ans;
    }else{
      return new ArrayList<>();
    }
  }
}
