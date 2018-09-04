package facebook.R118;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EthanTraverseTreev2 {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1F18\\EthanTraverseTree\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "ethan_traverses_a_tree.txt"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "outputv2.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();

    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new EthanTraverseTreev2().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  static class Tree {
    int value;
    Tree leftTree;
    Tree rightTree;
  }

  boolean[] mark;
  List<List<Integer>> connectedComponents;
  int[][] t;
  int index1 = 0;
  int index2 = 0;
  int[] preO;
  int[] postO;

  private void solve(Scanner sc, PrintWriter pw) {
    String[] str = sc.nextLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);

    Tree tree = new Tree();
    tree.value = 1;

    t = new int[N + 1][2];
    mark = new boolean[N];
    for (int i = 1; i < N + 1; i++) {
      str = sc.nextLine().split(" ");
      t[i][0] = Integer.parseInt(str[0]);
      t[i][1] = Integer.parseInt(str[1]);
    }
    //Making a tree

    makeATree(tree);
    preO = new int[N];
    postO = new int[N];
    preOrder(tree);
    postOrder(tree);


    connectedComponents = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      List<Integer> a = new ArrayList<>();
      aNewMethod(i, a);
      if (a.size() != 0)
        connectedComponents.add(a);
    }

    boolean f = false;
    int[] result = new int[N + 1];
    int in = 1;
    if (connectedComponents.size() < K) {
      pw.println("Impossible");
    } else {
      for (List<Integer> xx : connectedComponents) {
        for (Integer yy : xx) {
          result[yy] = in;
        }
        in++;
        if (in > K) {
          f = true;
          in = 1;
        }
      }
      if (f) {
        for (int j = 0; j < preO.length; j++) {
          System.out.print(preO[j] + " ");
        }
        System.out.println();
        for (int j = 0; j < preO.length; j++) {
          System.out.print(postO[j] + " ");
        }
        System.out.println();
        for (int j = 0; j < preO.length; j++) {
          System.out.print(result[preO[j]] + " ");
        }
        System.out.println();

        for (int j = 0; j < preO.length; j++) {
          System.out.print(result[postO[j]] + " ");
        }
        System.out.println();

        for (int j = 1; j < result.length - 1; j++) {
          pw.print(result[j] + " ");
        }
        pw.println(result[result.length - 1]);
      } else {
        pw.println("Impossible");
      }
    }

  }

  private void aNewMethod(int i, List<Integer> a) {
    if (!mark[preO[i] - 1]) {
      a.add(preO[i]);
      for (int ii = 0; ii < postO.length; ii++) {
        if (!mark[postO[ii] - 1] && postO[ii] == preO[i]) {
          mark[preO[i] - 1] = true;
          aNewMethod(ii, a);
          break;
        }
      }
    }
    if (!mark[postO[i] - 1]) {
      a.add(postO[i]);

      for (int ii = 0; ii < preO.length; ii++) {
        if (!mark[preO[ii] - 1] && preO[ii] == postO[i]) {
          mark[postO[i] - 1] = true;
          aNewMethod(ii, a);
        }
      }
    }
  }

  private void makeATree(Tree tree) {
    if (tree.value != 0) {
      if (t[tree.value][0] != 0) {
        Tree t1 = new Tree();
        t1.value = t[tree.value][0];
        tree.leftTree = t1;
        makeATree(t1);
      }
      if (t[tree.value][1] != 0) {
        Tree t2 = new Tree();
        t2.value = t[tree.value][1];
        tree.rightTree = t2;
        makeATree(t2);
      }
    }
  }


  private void preOrder(Tree t) {
    if (t != null) {
      preO[index1] = t.value;
      index1++;
      preOrder(t.leftTree);
      preOrder(t.rightTree);
    }
  }

  private void postOrder(Tree t) {
    if (t != null) {
      postOrder(t.leftTree);
      postOrder(t.rightTree);
      postO[index2] = t.value;
      index2++;
    }
  }
}
