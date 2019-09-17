package year2019.practice.leetcode;

import java.util.Stack;

public class RemoveDuplicates {
  public static void main(String[] args) {
    String s = "abbaaksjhdi7ukuk";
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    System.out.println(removeDuplicates.removeDuplicates(s));
  }

  public String removeDuplicates(String S) {

    Stack<Character> stack = new Stack<>();
    int len = S.length();
    for (int i = 0; i < len; ) {
      while (i < len && (stack.isEmpty() || stack.peek() != S.charAt(i))) {
        stack.push(S.charAt(i));
        i++;
      }
      while (!stack.isEmpty() && i < len && stack.peek() == S.charAt(i)) {
        stack.pop();
      }
      i++;
    }

    StringBuilder s = new StringBuilder();
    while (!stack.isEmpty()) {
      s.insert(0, stack.pop());
    }
    return s.toString();
  }
}
