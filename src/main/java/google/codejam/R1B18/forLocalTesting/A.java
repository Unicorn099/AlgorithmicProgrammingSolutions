package google.codejam.R1B18.forLocalTesting;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1B18\\";
  final static String fileName = "A-small";

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));

    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {
      System.out.print("Case #" + (i + 1) + ": ");
      String[] s = sc.nextLine().split(" ");
      int numberOfPeople = Integer.parseInt(s[0]);
      int languages = Integer.parseInt(s[1]);
      String[] str = sc.nextLine().split(" ");
      int[] peopleVotedForIthLanguage = new int[str.length];
      int peopleVoted = 0;
      for (int j = 0; j < str.length; j++) {
        peopleVotedForIthLanguage[j] = Integer.parseInt(str[j]);
        peopleVoted += peopleVotedForIthLanguage[j];
      }
      solvev1(peopleVotedForIthLanguage, numberOfPeople, peopleVoted, languages);
    }

    sc.close();
  }

  private static void solvev1(int[] peopleVotedForIthLanguage, int numberOfPeople, int peopleVoted, int languages) {

    if (numberOfPeople == 10) {
      System.out.println(100);
      return;
    }

    boolean[] flag = new boolean[peopleVotedForIthLanguage.length];
    int finalVal = 0;
    int leftPeople = numberOfPeople - peopleVoted;
    for (int i = 0; i < languages; i++) {
      for (int j = 0; j <= leftPeople; j++) {

        double exactPerVal = ((peopleVotedForIthLanguage[i] + j) * 100) / (double) numberOfPeople;
        int intExactPerVal = (int) Math.floor(exactPerVal);

        if (exactPerVal - intExactPerVal - 0.5 > 0) {
          leftPeople -= j;
          finalVal += Math.ceil(exactPerVal);
          flag[i] = true;
          break;
        }
      }
    }

    for (int k = 0; k < languages; k++) {
      if (!flag[k]) {
        double exactPerVal = ((peopleVotedForIthLanguage[k]) * 100) / (double) numberOfPeople;
        int intExactPerVal = (int) Math.floor(exactPerVal);

        if (exactPerVal - intExactPerVal - 0.5 > 0) {
          finalVal += Math.ceil(exactPerVal);
        } else {
          finalVal += Math.floor(intExactPerVal);
        }
      }
    }

    for (int j = 1; j <= leftPeople; j++) {
      for (int i = 1; i <= leftPeople; i++) {
        double exactPerVal = (i * 100) / (double) numberOfPeople;
        int intExactPerVal = (int) Math.floor(exactPerVal);

        if (exactPerVal - intExactPerVal - 0.5 > 0) {
          leftPeople -= j;
          finalVal += Math.ceil(exactPerVal);
          break;
        }
      }
    }

    double exactPerVal = (leftPeople * 100) / (double) numberOfPeople;
    int intExactPerVal = (int) Math.floor(exactPerVal);

    if (exactPerVal - intExactPerVal - 0.5 > 0) {
      finalVal += Math.ceil(exactPerVal);
    } else {
      finalVal += intExactPerVal;
    }

    System.out.println(finalVal);
  }
}
