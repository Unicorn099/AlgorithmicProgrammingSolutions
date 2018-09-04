package google.codejam.R1C18.A;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * R1C18-- A
 */
public class Solution {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1C18\\";
  final static String fileName = "A-small";

  static boolean[] flag;
  static String[] strings;
  static Set<String> s;
  static int L = 0;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));

//    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      String[] x = sc.nextLine().split(" ");
      int N = Integer.parseInt(x[0]);
      L = Integer.parseInt(x[1]);
      s = new HashSet<>();
      strings = new String[N];
      for (int j = 0; j < N; j++) {
        String string = sc.nextLine();
        strings[j] = string;
        s.add(string);
      }

      System.out.print("Case #" + (i + 1) + ": ");
      solve();
    }

    sc.close();
  }

  private static void solve() {
    String res = "";

    flag = new boolean[strings.length];
//    res = formString("", 0);
    res = form("", 0);
    if (res.length() == L) {
      System.out.println(res);
      return;
    } else {
      System.out.println("-");
      return;
    }
  }

  private static String form(String res, int index) {

    String str = "";

    //For Large Dataset change the code

    int i = 0;
    int j = 0;
    int iMax = L - 1;
    while (i != -1) {
      str += strings[j].charAt(i) + "";
      if (str.length() >= L) {
        if (!s.contains(str)) {
          return str;
        } else {
          if (j >= strings.length - 1) {
            iMax--;
            while (i > iMax) {
              i--;
            }
            if (i == -1) {
              return "";
            }
            str = str.substring(0, i);
            j=0;
          } else {
            j++;
            str = str.substring(0, i);
          }
        }
      } else {
        i++;
      }
    }
    return str;
  }

  private static String formString(String res, int i) {
    if (res.length() >= L) {
      return res;
    } else {
      String tempres = "";
      for (String str : strings) {
        tempres = res;
        tempres += str.substring(i, i + 1);
        tempres = formString(tempres, i + 1);
        if (tempres.length() >= L && !s.contains(tempres)) {
          return tempres;
        }
      }
      return res;
    }
  }
}
