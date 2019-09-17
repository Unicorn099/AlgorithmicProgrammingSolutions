package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordsFromChars {

  public static void main(String[] args) {
    //
    WordsFromChars w = new WordsFromChars();
    String[] s1 = {"cat", "bt", "hat", "tree"};
    String c1 = "atach";
    String[] s2 = {"hello", "world", "leetcode"};
    String c2 = "welldonehoneyr";
    int i1 = w.countCharacters(s1, c1);
    int i2 = w.countCharacters(s2, c2);
    System.out.println(i1);
    System.out.println(i2);
  }

  public int countCharacters(String[] words, String chars) {

    int ans = 0;
    Map<Character, Integer> charCountMap = new HashMap<>();
    for (int j = 0; j < chars.length(); j++) {
      Integer orDefault = charCountMap.getOrDefault(chars.charAt(j), 0);
      orDefault++;
      charCountMap.put(chars.charAt(j), orDefault);
    }

    for (int i = 0; i < words.length; i++) {
      Map<Character, Integer> count = new HashMap<>();
      for (int j = 0; j < words[i].length(); j++) {
        Integer orDefault = count.getOrDefault(words[i].charAt(j), 0);
        orDefault++;
        count.put(words[i].charAt(j), orDefault);
      }
      if (compare(count, charCountMap)) {
        ans += words[i].length();
      }
    }
    return ans;
  }

  private boolean compare(Map<Character, Integer> count, Map<Character, Integer> charCountMap) {
    for (Map.Entry<Character, Integer> entry : count.entrySet()) {
      if (!charCountMap.containsKey(entry.getKey())
          || entry.getValue() > charCountMap.get(entry.getKey())) {
        return false;
      }
    }
    return true;
  }
}
