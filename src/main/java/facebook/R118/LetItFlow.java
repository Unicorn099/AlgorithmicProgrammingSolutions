package facebook.R118;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LetItFlow {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1F18\\LetItFlow\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "let_it_flow.txt"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();

    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new LetItFlow().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    int N = Integer.parseInt(sc.nextLine());
    String[] s = new String[3];
    for (int i = 0; i < 3; i++) {
      s[i] = sc.nextLine();
    }

    long ans = 1;
    if (s[0].length() % 2 != 0) {
      pw.println(0);
      return;
    } else {
      if (s[1].contains("#") || s[0].charAt(0) == '#' || s[2].charAt(N - 1) == '#') {
        pw.println(0);
        return;
      }
      for (int i = 1; i < N - 2; i += 2) {
        boolean f1 = s[0].charAt(i) == '#';
        boolean f2 = s[2].charAt(i) == '#';
        boolean f3 = s[0].charAt(i + 1) == '#';
        boolean f4 = s[2].charAt(i + 1) == '#';
        if ((f1 || f3) && (f2 || f4)) {
          pw.println(0);
          return;
        } else if (!f1 && !f2 && !f3 && !f4) {
          ans *= 2;
          ans %= 1000000007;
        } /*else if (f1 || f2 || f3 || f4) {
          ans *= 1;
        }*/
      }
      pw.println(ans);
    }
  }

}
