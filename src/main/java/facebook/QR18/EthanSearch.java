package facebook.QR18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EthanSearch {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\QRF18\\EthanSearch\\";

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
//        + "ethan_searches_for_a_string.txt"));
        + "A-small.in"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();
    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new EthanSearch().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String A = sc.nextLine();
    if (A.length() <= 2) {
      pw.println("Impossible");
    } else {
      char s = A.charAt(0);
      int index = -1;
      for (int i = A.length()-2; i >=1; i--) {
        if (A.charAt(i) == s) {
          index = i;
          break;
        }
      }
      if (index != -1) {
        String tempString = A.substring(0, index);
        if (tempString.length() + index > A.length() || !tempString.equalsIgnoreCase(A.substring(index, tempString.length() + index)) || (s != A.charAt(tempString.length() + index))) {
          pw.println(tempString + A);
        } else {
          pw.println("Impossible");
        }
      } else {
        pw.println("Impossible");
      }
    }
  }
}
