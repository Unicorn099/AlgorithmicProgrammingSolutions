package google.codejam.R1C18.C;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * R1C18-- C
 */
public class Solution {

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

  private static void solve(int[] ele) {
    int N = ele.length;
    int[] weight = new int[N];
    int[] index = new int[N];

    weight[0] = ele[0];
    index[0] = 1;
    for (int i = 1; i < N; i++) {
      int tempWeight = ele[i];
      int tempIndex = 1;
      for (int j = 0; j < i; j++) {
        if (ele[i] * 6 >= weight[j]) {
          if (tempIndex < index[j] + 1) {
            tempIndex = index[j] + 1;
            tempWeight = ele[i] + weight[j];
          } else if (tempIndex == index[j] + 1) {
            if (tempWeight > ele[i] + weight[j]) {
              tempWeight = ele[i] + weight[j];
            }
          }
        } else {
          if (ele[i] * 6 >= ele[j]) {
            tempWeight += ele[j];
          }
        }
      }
      index[i] = tempIndex;
      weight[i] = tempWeight;
    }

    System.out.println(Arrays.stream(index).max().getAsInt());
  }
}