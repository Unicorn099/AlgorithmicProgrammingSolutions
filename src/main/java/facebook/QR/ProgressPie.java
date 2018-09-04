package facebook.QR;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProgressPie {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\ProgressPie\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "A-large-practice.in"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();
    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new ProgressPie().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String[] str = sc.nextLine().split(" ");
    int P = Integer.parseInt(str[0]);
    int X = Integer.parseInt(str[1]);
    int Y = Integer.parseInt(str[2]);

    if (distanceLessThanRadius(X, Y) && angleLessThanPercentage(P, X, Y)) {
      pw.println("black");
    } else {
      pw.println("white");
    }

  }

  private boolean angleLessThanPercentage(int p, int x, int y) {
    boolean res = false;
    double angle = Math.toDegrees(Math.atan2((y - 50), (x - 50)));
    if (angle < 90) {
      angle = 90 - angle;
    } else {
      angle = 360 - (angle - 90);
    }
    double anotherAngle = p * 360 / 100.0;
    if (angle <= anotherAngle) {
      res = true;
    } else {
      res = false;
    }
    return res;
  }

  private boolean distanceLessThanRadius(int X, int Y) {
    boolean result = false;
    if (Math.pow((Math.pow(X - 50, 2) + Math.pow(Y - 50, 2)), 0.5) <= 50) {
      result = true;
    }
    return result;
  }

}
