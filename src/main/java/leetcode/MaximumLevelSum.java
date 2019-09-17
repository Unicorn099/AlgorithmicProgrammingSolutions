package year2019.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
    TreeNode treeNode1 = maximumLevelSum.new TreeNode(1);
    TreeNode treeNode2 = maximumLevelSum.new TreeNode(7);
    TreeNode treeNode3 = maximumLevelSum.new TreeNode(0);
    TreeNode treeNode4 = maximumLevelSum.new TreeNode(7);
    TreeNode treeNode5 = maximumLevelSum.new TreeNode(-8);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    int i = maximumLevelSum.maxLevelSum(treeNode1);
    System.out.print(i);
  }

  public int maxLevelSum(TreeNode root) {
    int maxSum = Integer.MIN_VALUE;

    int ansLevel = Integer.MIN_VALUE;
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.add(root);
    int level = 0;
    while (!q1.isEmpty()) {
      int sum = 0;
      level++;
      while (!q1.isEmpty()) {
        TreeNode poll = q1.poll();
        sum += poll.val;
        if (poll.left != null) {
          q2.add(poll.left);
        }
        if (poll.right != null) {
          q2.add(poll.right);
        }
      }

      if (sum > maxSum) {
        maxSum = sum;
        ansLevel = level;
      }
      while (!q2.isEmpty()) {
        q1.add(q2.poll());
      }
    }

    return ansLevel;
  }
}
