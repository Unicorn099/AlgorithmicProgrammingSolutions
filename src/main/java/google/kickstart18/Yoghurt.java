package google.kickstart18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Yoghurt {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\KickStart\\Yoghurt\\";
  //  final static String fileName = "A-small";
  final static String fileName = "A-large-practice";

  static int[] str;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));
    PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
        + fileName + ".out"));

    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {

      //Read Input here
      pw.print("Case #" + (i + 1) + ": ");

      String[] s;
      s = sc.nextLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int K = Integer.parseInt(s[1]);

      s = sc.nextLine().split(" ");
      str = new int[N];
      for (int j = 0; j < N; j++) {
        str[j] = Integer.parseInt(s[j]);
      }
      /**
       * Call Solver here
       */
      solve(pw, N, K);

    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private static void solve(PrintWriter pw, int n, int k) {

    Arrays.sort(str);

    int numberOfyogHurt = 0;
    int numberOfDays = 0;
    for (int i = 0; i < n; ) {
      for (int j = 0; j < k && i < n; ) {
        if (numberOfDays < (str[i])) {
          numberOfyogHurt++;
          j++;
        }
        i++;
      }
      numberOfDays++;
    }
    pw.println(numberOfyogHurt);
  }

}
