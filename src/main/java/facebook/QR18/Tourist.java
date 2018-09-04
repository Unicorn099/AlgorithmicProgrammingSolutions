package facebook.QR18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tourist {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\QRF18\\Tourist\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "tourist.txt"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();
    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new Tourist().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String[] str = sc.nextLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);
    long V = Long.parseLong(str[2]);

    String[] attractions = new String[N];
    for (int i = 0; i < N; i++) {
      attractions[i] = sc.nextLine();
    }


    long mul = K * V;
    if (mul < N) {
      for (int i = (int) (V - 1); i < (V + K - 1); i++) {
        pw.print(attractions[i] + " ");
      }
      pw.println();
      return;
    } else {
      int r = (int) (mul % N);
      if (K < r) {
        for (int i = r-K; i < r; i++) {
          pw.print(attractions[i] + " ");
        }
      } else {
        for (int i = 0; i < r; i++) {
          pw.print(attractions[i] + " ");
        }
      }
      for (int i = N - (K - r); i < N; i++) {
        pw.print(attractions[i] + " ");
      }
      pw.println();
      return;
    }
  }

}
