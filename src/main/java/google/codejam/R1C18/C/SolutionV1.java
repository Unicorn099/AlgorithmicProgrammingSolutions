package google.codejam.R1C18.C;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * R1C18-- C
 */
public class SolutionV1 {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1C18\\";
  final static String fileName = "C-small";

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));

//    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {

      System.out.print("Case #" + (i + 1) + ": ");
      int N = Integer.parseInt(sc.nextLine());
      String[] str = sc.nextLine().split(" ");
      int[] ele = new int[str.length];
      for (int ii = 0; ii < N; ii++) {
        ele[ii] = Integer.parseInt(str[ii]);
      }
      solve(ele);
    }
    sc.close();
  }

  static class Temp {
    int weight;
    int count;
  }

  private static void solve(int[] ele) {
    int N = ele.length;

    Temp[][] subResult = new Temp[N][N];
    for (int i = 0; i < N; i++) {
      Temp temp = new Temp();
      temp.weight = ele[i];
      temp.count = 1;
      subResult[0][i] = temp;
    }

    for (int i = 1; i < N; i++) {
      for (int j = i; j < N; j++) {
        int wtAllowed = 6 * ele[j];
        int maxWeight = wtAllowed+ele[j];
        int tempWeight = -1;
        for (int k = i - 1; k < j; k++) {
          if (subResult[i-1][k] != null && subResult[i - 1][k].weight <= wtAllowed) {
            tempWeight = subResult[i - 1][k].weight + ele[j];
            if (tempWeight < maxWeight) {
              maxWeight = tempWeight;
            }
          }
        }
        if (tempWeight != -1) {
          Temp t2 = new Temp();
          t2.weight = maxWeight;
          t2.count = i + 1;
          subResult[i][j] = t2;
        } else {
          subResult[i][j] = null;
        }
      }
    }

    for (int i = N - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (subResult[i][j] != null) {
          System.out.println(subResult[i][j].count /*+" wt "+subResult[i][j].weight*/);
          return;
        }
      }
    }

//    System.out.println(Arrays.stream(index).max().getAsInt());
  }
}