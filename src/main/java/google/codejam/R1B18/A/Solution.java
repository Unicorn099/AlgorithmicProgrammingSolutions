package google.codejam.R1B18.A;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

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

    boolean[] flag = new boolean[peopleVotedForIthLanguage.length];
    int finalVal = 0;
    int leftPeople = numberOfPeople - peopleVoted;
    for (int j = 0; j <= leftPeople; j++) {
      for (int i = 0; i < languages; i++) {

        if (!flag[i]) {
          double exactPerVal = ((peopleVotedForIthLanguage[i] + j) * 100) / (double) numberOfPeople;
          double intExactPerVal = Math.floor(exactPerVal);

          if (exactPerVal - intExactPerVal - 0.5 >= 0) {
            leftPeople -= j;
            finalVal += Math.ceil(exactPerVal);
            flag[i] = true;
            j=-1;
            break;
          }
        }
      }
    }

    for (int k = 0; k < languages; k++) {
      if (!flag[k]) {
        double exactPerVal = ((peopleVotedForIthLanguage[k]) * 100) / (double) numberOfPeople;
        int intExactPerVal = (int) Math.floor(exactPerVal);

        if (exactPerVal - intExactPerVal - 0.5 >= 0) {
          finalVal += Math.ceil(exactPerVal);
        } else {
          finalVal += Math.floor(intExactPerVal);
        }
      }
    }

    while (leftPeople > 0) {
      int i = 1;
      for (; i <= leftPeople; i++) {
        double exactPerVal = (i * 100) / (double) numberOfPeople;
        int intExactPerVal = (int) Math.floor(exactPerVal);

        if (exactPerVal - intExactPerVal - 0.5 >= 0) {
          leftPeople -= i;
          finalVal += Math.ceil(exactPerVal);
          break;
        }
      }
      if (i >= leftPeople) {
        break;
      }
    }

    double exactPerVal = (leftPeople * 100) / (double) numberOfPeople;
    int intExactPerVal = (int) Math.floor(exactPerVal);

    if (exactPerVal - intExactPerVal - 0.5 >= 0) {
      finalVal += Math.ceil(exactPerVal);
    } else {
      finalVal += intExactPerVal;
    }

    System.out.println(finalVal);
  }
}
