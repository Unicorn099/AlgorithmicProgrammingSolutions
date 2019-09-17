package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DifferentWaysToAddParentheses {
  Map<String, List<Tree>> ans;
  public static void main(String[] args) {
    String exp = "10+5";
    DifferentWaysToAddParentheses differentWaysToAddParentheses =
        new DifferentWaysToAddParentheses();
    List<Integer> solve = differentWaysToAddParentheses.diffWaysToCompute(exp);
    solve.forEach(System.out::println);
  }

  class Tree {
    Tree leftTree;
    Tree rightTree;
    int sum;
    String nodeVal;

    public Tree(String nodeVal) {
      this.nodeVal = nodeVal;
    }
  }

  public List<Integer> diffWaysToCompute(String input) {

    List<Tree> root = solve(input);
    ans = new HashMap<>();
    return root.stream().map(tree -> tree.sum).collect(Collectors.toList());
  }

  private List<Tree> solve(String substring) {
    if (!substring.contains("*") && !substring.contains("+") && !substring.contains("-")) {
      Tree tree = new Tree(substring);
      tree.sum = Integer.parseInt(tree.nodeVal);
      List<Tree> trees = new ArrayList<>();
      trees.add(tree);
      return trees;
    } else {
      List<Tree> trees = new ArrayList<>();
      for (int i = 0; i < substring.length(); i++) {
        if (Arrays.asList("*", "+", "-").contains(substring.charAt(i) + "")) {
          List<Tree> tl;
          if (ans.containsKey(substring.substring(0, i))) {
            tl = ans.get(substring.substring(0, i));
          } else {
            tl = solve(substring.substring(0, i));
          }
          List<Tree> tr;
          if (ans.containsKey(substring.substring(i + 1))) {
            tr = ans.get(substring.substring(i + 1));
          } else {
            tr = solve(substring.substring(i + 1));
          }
          List<Tree> treesList = applyOpAndMakeTheTree(substring.charAt(i) + "", tl, tr);
          trees.addAll(treesList);
        }
      }
      return trees;
    }
  }

  private List<Tree> applyOpAndMakeTheTree(String s, List<Tree> tl, List<Tree> tr) {
    List<Tree> trees = new ArrayList<>();
    for (Tree t1 : tl) {
      for (Tree t2 : tr) {
        Tree t = new Tree(s);
        switch (s) {
          case "*":
            t.sum = t1.sum * t2.sum;
            break;
          case "+":
            t.sum = t1.sum + t2.sum;
            break;
          case "-":
            t.sum = t1.sum - t2.sum;
            break;
          default:
            break;
        }
        t.leftTree = t1;
        t.rightTree = t2;
        trees.add(t);
      }
    }
    return trees;
  }
}
