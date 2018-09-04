package facebook.R118;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EthanTraverseTree {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1F18\\EthanTraverseTree\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "EthanTraverseTree.txt"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();

    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new EthanTraverseTree().solve(sc, pw);
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

  boolean[] marked;
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
    marked = new boolean[N];
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

    find(K, pw);

  }

  private void find(int k, PrintWriter pw) {
    int[] ans = new int[postO.length + 1];
    int tempK = 1;
    int length = preO.length;
    int i = 0;
    boolean flag = false;
    for (; i < preO.length; i++) {
      if (preO[i] != postO[i]) {
        if (ans[preO[i]] == 0 && ans[postO[i]] == 0) {
          ans[preO[i]] = tempK;
          ans[postO[i]] = tempK;
          markAllMapping(ans, preO[i], postO[i], tempK);
          tempK++;
          if (tempK >= k) {
            flag = true;
            tempK = 1;
          }
        } else {
//          if(ans[preO[i]] !=ans[postO[i]]){
//            System.out.println(ans[preO[i]] +",*******," +ans[postO[i]]);
//          }
          ans[preO[i]] = ans[preO[i]] == 0 ? ans[postO[i]] : ans[preO[i]];
          ans[postO[i]] = ans[preO[i]] == 0 ? ans[postO[i]] : ans[preO[i]];
        }
      } else {
        if (ans[preO[i]] == 0 && ans[postO[i]] == 0) {
          ans[preO[i]] = tempK;
          ans[postO[i]] = tempK;
          tempK++;
        } else {
//          if(ans[preO[i]] !=ans[postO[i]]){
//            System.out.println(ans[preO[i]] +",*******," +ans[postO[i]]);
//          }
          ans[preO[i]] = ans[preO[i]] == 0 ? ans[postO[i]] : ans[preO[i]];
          ans[postO[i]] = ans[preO[i]] == 0 ? ans[postO[i]] : ans[preO[i]];
        }
      }
    }
    if (!flag) {
      pw.println("Impossible");
    } else {
      for (int j = 1; j < ans.length - 1; j++) {
        pw.print(ans[j] + " ");
      }
      pw.println(ans[ans.length - 1]);

//      for (int j = 0; j < preO.length; j++) {
//        System.out.print(preO[j] + " ");
//      }
//      System.out.println();
//      for (int j = 0; j < preO.length; j++) {
//        System.out.print(postO[j] + " ");
//      }
//      System.out.println();
//      for (int j = 0; j < preO.length; j++) {
//        System.out.print(ans[preO[j]] + " ");
//      }
//      System.out.println();
//
//      for (int j = 0; j < preO.length; j++) {
//        System.out.print(ans[postO[j]] + " ");
//      }
//      System.out.println();
    }
  }

  private void markAllMapping(int[] ans, int preE, int postE, int tempK) {
    int len = preO.length;
    for (int i = 0; i < len; i++) {
      if (postO[i] == preE && ans[preO[i]] == 0) {
        ans[preO[i]] = tempK;
        markAllMapping(ans, preO[i], postO[i], tempK);
        break;
      } else if (postO[i] == preE && ans[preO[i]] != 0) {
        break;
      }
    }
    for (int i = 0; i < len; i++) {
      if (preO[i] == postE && ans[postO[i]] == 0) {
        ans[postO[i]] = tempK;
        ans[preO[i]] = tempK;
        markAllMapping(ans, preO[i], postO[i], tempK);
        break;
      } else if (preO[i] == postE && ans[postO[i]] != 0) {
        break;
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
