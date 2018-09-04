package google.codejam.QR18.A;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      String[] checkLine = sc.nextLine().split(" ");
      long point = Long.parseLong(checkLine[0]);
      String command = checkLine[1];
      System.out.print("Case #" + (i + 1) + ": ");
      solve(point, command);
    }
    sc.close();
  }

  private static void solve(long point, String command) {
    long damaage = 0;
    long initialD = 1;
    int countOfC = 0;
    for (int i = 0; i < command.length(); i++) {
      if (command.charAt(i) == 'S') {
        damaage += initialD;
      } else if (command.charAt(i) == 'C') {
        initialD *= 2;
        countOfC++;
      }
    }

    if (damaage <= point) {
      System.out.println(0);
    } else {
      if (countOfC == 0) {
        System.out.println("IMPOSSIBLE");
      } else {
        long noOfSwap = 0;
        long D = damaage;
        long previousD = 0;
        while (D > point) {
          for (int i = command.length() - 1; i >= 1; i--) {
            previousD = D;
            if (command.charAt(i) == 'S' && command.charAt(i - 1) == 'C') {
              command = command.substring(0, i - 1) + "S" + "C" + (i < command.length() - 1 ? command.substring(i + 1) : "");
              noOfSwap++;
              D = findTheDamage(command);
              if (D <= point) {
                System.out.println(noOfSwap);
                return;
              } else {
                break;
              }
            }
          }
          if (previousD == D) {
            System.out.println("IMPOSSIBLE");
            return;
          }
        }
      }
    }
  }

  private static long findTheDamage(String command) {
    long initialD = 1;
    long damaage = 0;
    for (int i = 0; i < command.length(); i++) {
      if (command.charAt(i) == 'S') {
        damaage += initialD;
      } else if (command.charAt(i) == 'C') {
        initialD *= 2;
      }
    }
    return damaage;
  }
}
