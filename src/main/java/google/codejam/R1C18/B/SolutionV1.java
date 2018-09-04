package google.codejam.R1C18.B;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * R1C18-- B
 */
public class SolutionV1 {

  static boolean flag[];

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());//T
    for (int i = 0; i < caseCnt; i++) {

      int N = Integer.parseInt(sc.nextLine());//lollypop
      double[] prob = new double[N];
      int[] numberOfPeopleLiked = new int[N];
      flag = new boolean[N];
      String[] input;
      int j = 0;
      if (N > 0) {
        do {
          input = sc.nextLine().split(" ");
          if (input[0].equals("-1")) {
            break;
          }
          solve(prob, input, numberOfPeopleLiked);
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

  private static void solve(double[] prob, String[] input, int[] numberOfPeopleLiked) {

    if (input[0].equals("0")) {
      System.out.println(-1);
      return;
    } else {
      int index = -1;
      double minProb=1.0;
      findProb(prob, input, numberOfPeopleLiked);
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
      System.out.println(index);
      return;
    }
  }

  private static void findProb(double[] prob, String[] input, int[] numberOfPeopleLiked) {
    int totalCount=0;
    for(int i=1;i<input.length;i++){
      numberOfPeopleLiked[Integer.parseInt(input[i])] +=1;
    }
    for(int i=0;i<numberOfPeopleLiked.length;i++){
      totalCount+=numberOfPeopleLiked[i];
    }
    for(int i=0;i<numberOfPeopleLiked.length;i++){
      prob[i]=numberOfPeopleLiked[i]/(double) totalCount;
    }

  }

  private static double getRandomNumber() {

    Random randomValue = new Random();
    int randomInt = randomValue.nextInt(100) - 5; //Will get integer values between 100 and 5
    double rangedValue = (randomInt) / 1000.0;

    return rangedValue;
  }

}
