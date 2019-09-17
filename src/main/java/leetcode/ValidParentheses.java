package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {

    String s = "([)]";
    System.out.print(new ValidParentheses().isValid(s));
  }

  public boolean isValid(String s) {

    boolean ans = true;

    Map<String, String> nemesis = new HashMap<>();
    nemesis.put("}", "{");
    nemesis.put(")", "(");
    nemesis.put("]", "[");

    Stack<String> stringStack = new Stack<>();
    if (s.length() > 0) {
      stringStack.push(s.charAt(0) + "");
      for (int i = 1; i < s.length(); i++) {
        if (stringStack.isEmpty()) {
          if (((s.charAt(i) + "").equalsIgnoreCase("}")
              || (s.charAt(i) + "").equalsIgnoreCase(")")
              || (s.charAt(i) + "").equalsIgnoreCase("]"))) {
            return false;
          } else {
            stringStack.push(s.charAt(i) + "");
          }
        } else {
          String ss = stringStack.peek();
          if (ss.equalsIgnoreCase(nemesis.get(s.charAt(i) + ""))) {
            stringStack.pop();
          } else {
            stringStack.push(s.charAt(i) + "");
          }
        }
      }
      return stringStack.isEmpty() ? true : false;
    } else {
      return ans;
    }
  }

}
