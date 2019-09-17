package year2019.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

  public static void main(String[] args) {

    LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
    System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(l.lengthOfLongestSubstring("bbbbb"));
    System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    System.out.println(l.lengthOfLongestSubstring(""));
    System.out.println(l.lengthOfLongestSubstring(" "));
    System.out.println(l.lengthOfLongestSubstring("dvdf"));
  }

  public int lengthOfLongestSubstring(String s) {

    int length = 0;
    int len = s.length();
    Set<Character> chars = new HashSet<>();
    int i = 0;
    int j = 0;
    while (i < len && j < len) {
      if (!chars.contains(s.charAt(j))) {
        chars.add(s.charAt(j));
        j++;
      } else {
        chars.clear();
        if (j - i > length) {
          length = j - i;
        }
        i++;
        j=i;
      }
    }
    if (j - i > length) {
      length = j - i;
    }
    return length;
  }
}
