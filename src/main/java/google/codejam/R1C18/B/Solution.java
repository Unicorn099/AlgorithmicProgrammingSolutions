package google.codejam.R1C18.B;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * R1C18-- B -- Not Correct
 */
public class Solution {

  static boolean flag[];

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());//T
    for (int i = 0; i < caseCnt; i++) {

      int N = Integer.parseInt(sc.nextLine());//lollypop
      double[] prob = new double[N];
      flag = new boolean[N];
//      for (int j = 0; j < N; j++) {
//        prob[j] = getRandomNumber();
//      }
//      Arrays.sort(prob);

      String[] input;
      int j = 0;
      if (N > 0) {
        do {
          input = sc.nextLine().split(" ");
          if (input[0].equals("-1")) {
            break;
          }
          int canBeSkipped = N - (int) Math.ceil(N * 0.9);
          if (j <= canBeSkipped) {
            solve(prob, input, false, canBeSkipped);
          } else {
            solve(prob, input, true, canBeSkipped);
          }
          j++;
          if (!iceCreamAvailable()) {
            break;
          }
        } while (!input[0].equals("-1") && j < N);
      }
    }
    sc.close();
  }

  private static boolean iceCreamAvailable() {
    for (int i = 0; i < flag.length; i++) {
      if (!flag[i]) {
        return true;
      }
    }
    return false;
  }

  private static void solveAgain(double[] prob, String[] input, boolean canBeSkipped, int beSkipped) {

    if (input[0].equals("0")) {
      System.out.println(-1);
      return;
    } else {
      double minProb = 0.2;
      int index = -1;
      for (int k = 1; k < input.length; k++) {
        if (!flag[Integer.parseInt(input[k])]) {
          if (minProb > prob[Integer.parseInt(input[k])]) {
            minProb = prob[Integer.parseInt(input[k])];
            index = Integer.parseInt(input[k]);
          }
        }
      }
      if (index != -1) {
        flag[index] = true;
      }
      if (canBeSkipped) {
        if (index > beSkipped && index < prob.length - 1) {
          System.out.println("-1");
          return;
        } else {
          System.out.println(index);
          return;
        }
      }
      System.out.println(index);
      return;
    }
  }


  private static void solve(double[] prob, String[] input, boolean canBeSkipped, int beSkipped) {

    if (input[0].equals("0")) {
      System.out.println(-1);
      return;
    } else {
      double minProb = 0.2;
      int index = -1;
      for (int k = 1; k < input.length; k++) {
        if (!flag[Integer.parseInt(input[k])]) {
          if (minProb > prob[Integer.parseInt(input[k])]) {
            minProb = prob[Integer.parseInt(input[k])];
            index = Integer.parseInt(input[k]);
          }
        }
      }
      if (index != -1) {
        flag[index] = true;
      }
      if (canBeSkipped) {
        if (index > beSkipped && index < prob.length - 1) {
          System.out.println("-1");
          return;
        } else {
          System.out.println(index);
          return;
        }
      }
      System.out.println(index);
      return;
    }
  }

  private static double getRandomNumber() {

    Random randomValue = new Random();
    int randomInt = randomValue.nextInt(100) - 5; //Will get integer values between 100 and 5
    double rangedValue = (randomInt) / 1000.0;

    return rangedValue;
  }

}
