package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

  public static void main(String[] args) {
    System.out.println(new Isomorphic().isIsomorphic("aa", "aa"));
  }

  public boolean isIsomorphic(String s, String t) {

    Map<Character, Character> mapping = new HashMap<>();
    Map<Character, Character> reverseMapping = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if ((mapping.containsKey(s.charAt(i)) && mapping.get(s.charAt(i)) != t.charAt(i))
          || (reverseMapping.containsKey(t.charAt(i))
              && reverseMapping.get(t.charAt(i)) != s.charAt(i))) {
        return false;
      } else {
        mapping.put(s.charAt(i), t.charAt(i));
        reverseMapping.put(t.charAt(i), s.charAt(i));
      }
    }
    return true;
  }
}
