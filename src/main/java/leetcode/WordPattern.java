package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

  public static void main(String[] args) {
    System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
  }

  public boolean wordPattern(String pattern, String str) {

    Map<String, String> mapping = new HashMap<>();
    Map<String, String> reverseMapping = new HashMap<>();
    int len = pattern.length();
    String[] strings = str.split(" ");
    if (len != strings.length) {
      return false;
    }
    for (int i = 0; i < len; i++) {
      if ((mapping.containsKey(pattern.charAt(i) + "")
              && !mapping.get(pattern.charAt(i) + "").equals(strings[i]))
          || (reverseMapping.containsKey(strings[i])
              && !reverseMapping.get(strings[i]).equals(pattern.charAt(i) + ""))) {
        return false;
      } else {
        mapping.put(pattern.charAt(i) + "", strings[i]);
        reverseMapping.put(strings[i], pattern.charAt(i) + "");
      }
    }
    return true;
  }
}
