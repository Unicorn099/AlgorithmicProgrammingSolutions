package google.codejam.R1B18.forSubmission;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

  static boolean[] flag;
  static String[] ingredientsWeHave;
  static String[][] ingredients;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {
      System.out.print("Case #" + (i + 1) + ": ");
      int numberOfMetal = Integer.parseInt(sc.nextLine());
      flag = new boolean[numberOfMetal];
      ingredients = new String[numberOfMetal][2];
      for (int j = 0; j < numberOfMetal; j++) {
        ingredients[j] = sc.nextLine().split(" ");
      }
      ingredientsWeHave = sc.nextLine().split(" ");
      solve();
    }

    sc.close();
  }

  static class Tree {
    int id;
    int left;
    Tree ingredients1;
    Tree ingredients2;

    @Override
    public String toString() {
      return "Tree{" +
          "id=" + id +
          ", left=" + left +
          ", ingredients1=" + ingredients1 +
          ", ingredients2=" + ingredients2 +
          '}';
    }
  }

  private static void solve() {

    Tree rootTree = new Tree();
    rootTree.id = 0;
    rootTree.left = Integer.parseInt(ingredientsWeHave[0]);

    flag[0] = true;
    makeTree(rootTree, ingredients[0]);

    int leadweHave = rootTree.left;
    int leadWeCanAdd = findUsingBFS(rootTree);

    System.out.println(rootTree);
    System.out.println(leadWeCanAdd + leadweHave);
  }

  private static int findUsingBFS(Tree rootTree) {
    int count = 0;

    if (rootTree != null) {
      if (rootTree.ingredients2 != null & rootTree.ingredients1 != null) {
        count += Math.min(rootTree.ingredients1.left, rootTree.ingredients2.left);
        rootTree.ingredients1.left -= count;
        rootTree.ingredients2.left -= count;
        count += findUsingBFS(rootTree.ingredients1);
        count += findUsingBFS(rootTree.ingredients2);
      }
    }
    return count;
  }


  private static void makeTree(Tree rootTree, String[] ingredient) {

    Tree t1 = rootTree;

    Tree tree1 = new Tree();
    tree1.id = Integer.parseInt(ingredient[0]) - 1;
    Tree tree2 = new Tree();
    tree2.id = Integer.parseInt(ingredient[1]) - 1;
    if (!flag[tree1.id] && !flag[tree2.id]) {
      tree1.left = Integer.parseInt(ingredientsWeHave[tree1.id]);
      t1.ingredients1 = tree1;
      flag[tree1.id] = true;
      makeTree(tree1, ingredients[tree1.id]);

//      flag[tree1.id]=false;
      tree2.left = Integer.parseInt(ingredientsWeHave[tree2.id]);
      t1.ingredients2 = tree2;
      flag[tree2.id] = true;
      makeTree(tree2, ingredients[tree2.id]);
//      flag[tree1.id] = true;
    }

  }

}
