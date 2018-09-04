package google.codejam.R218;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FallingBall {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R218\\";
  final static String fileName = "A-small";


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

    int len = ele.length;
    if (Arrays.stream(ele).sum() != ele.length || (ele[0] == 0 || ele[len - 1] == 0)) {
      System.out.println("IMPOSSIBLE");
      return;
    }
    ArrayList<String[]> xx = new ArrayList<>();
    boolean[] colContainsRamp = new boolean[len];
    if (ele[0] > 1) {
      int row = 0;
      int col = 1;
      for (int i = 1; i < ele[0]; i++) {
        String[] x = new String[len];
        x[col] = "/";
        xx.add(row, x);
        colContainsRamp[col] = true;
        row++;
        col++;
      }
    }

    for (int i = 1; i < len - 1; i++) {
      int row = 0;
      int col = i;
      for (int b = 1, f = 1, j = 1; ((i - b) >= 1 || (i + f) < len) && j < ele[i]; ) {
        String[] x = new String[len];
        if (!colContainsRamp[i - b] && ele[i - b] == 0) {
          if (xx.size() > row && xx.get(row) != null) {
            xx.get(row)[i - b] = "\\";
          } else {
            x[i - b] = "\\";
            xx.add(row, x);
          }
          j++;
          colContainsRamp[i - b] = true;
          b++;
        }
        if (j >= ele[i]) {
          break;
        } else {
          if (xx.size() > row && xx.get(row) != null) {
            xx.get(row)[i + f] = "/";
          } else {
            x[i + f] = "/";
            xx.add(row, x);
          }
          j++;
          colContainsRamp[i + f] = true;
          f++;
          row++;
        }
      }
    }

    //last column
    if (ele[len - 1] > 1) {
      int row = 0;
      int col = len - 1;
      for (int i = 1; i < ele[len - 1]; i++) {
        String[] x = new String[len];
        if (!colContainsRamp[col - 1]) {
          if (xx.size() > row && xx.get(row) != null) {
            xx.get(row)[col - 1] = "\\";
          } else {
            col--;
            x[col] = "\\";
            xx.add(row, x);
          }
          colContainsRamp[col] = true;
          row++;
        } else {
          System.out.println("IMPOSSIBLE");
        }
      }
    }

    //Printing the ramp outline
    System.out.println(xx.size() + 1);
    for (int i = xx.size() - 1; i >= 0; i--) {
      for (int j = 0; j < len; j++) {
        if (xx != null && xx.get(i) != null && xx.get(i)[j] != null && (xx.get(i)[j].equals("/") || xx.get(i)[j].equals("\\"))) {
          System.out.print(xx.get(i)[j]);
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
    for (int i = 0; i < len; i++) {
      System.out.print(".");
    }
    System.out.println();

  }
}

