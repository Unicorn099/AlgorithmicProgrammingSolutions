package google.codejam.QR18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TroubleSort {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\QR18\\";
  final static String fileName = "B-small";

  public static void main(String[] args) throws FileNotFoundException {

//    Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      int numbers = Integer.parseInt(sc.nextLine());
      String[] checkLine = sc.nextLine().split(" ");
      long[] numbersList = new long[numbers];
      for (int j = 0; j < numbers; j++) {
        numbersList[j] = Long.parseLong(checkLine[j]);
      }

      System.out.print("Case #" + (i + 1) + ": ");
//      solve(numbersList);
      solveForLargeOne(numbersList);
    }
    sc.close();
  }

  private static void solveForLargeOne(long[] numbersList) {

    List<Long> oddOnes = new ArrayList<>();
    List<Long> evenOnes = new ArrayList<>();
    for (int i = 0; i < numbersList.length; i++) {
      if (i % 2 == 0) {
        evenOnes.add(numbersList[i]);
      } else {
        oddOnes.add(numbersList[i]);
      }
    }
    Collections.sort(evenOnes);
    Collections.sort(oddOnes);
    int ii = 0;
    for (Long x : evenOnes) {
      numbersList[ii] = x;
      ii = ii + 2;
    }
    ii = 1;
    for (Long x : oddOnes) {
      numbersList[ii] = x;
      ii+=2;
    }
//    for (int i = 0; i < numbersList.length - 1; i = i + 2) {
//      numbersList[i] = evenOnes.get(i);
//      numbersList[i + 1] = oddOnes.get(i);
//    }

    //find the error
//    System.out.print("New results::");
//    Arrays.stream(numbersList).forEach(value -> System.out.print(value + ", "));
    for (int i = 0; i < numbersList.length - 1; i++) {
      if (numbersList[i] > numbersList[i + 1]) {
        System.out.println(i);
        return;
      }
    }
    System.out.println("OK");

  }

  private static void solve(long[] checkLine) {

    long[] finalArrayWithTroubleSort = callTroubleSort(checkLine);
    for (int i = 0; i < checkLine.length - 1; i++) {
      if (checkLine[i] > checkLine[i + 1]) {
        System.out.println(i);
        return;
      }
    }
    System.out.println("OK");
  }

  private static long[] callTroubleSort(long[] checkLine) {
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < checkLine.length - 2; i++) {
        if (checkLine[i] > checkLine[i + 2]) {
          long temp = checkLine[i + 2];
          checkLine[i + 2] = checkLine[i];
          checkLine[i] = temp;
          flag = false;
        }
      }
    }
    return checkLine;
  }

//  private static long[] callTroubleSort(long[] checkLine) {
//    for (int i = 0; i < checkLine.length; i++) {
//      for (int j = i + 2; j < checkLine.length; j++) {
//        if (checkLine[i] > checkLine[j]) {
//          long temp = checkLine[j];
//          checkLine[j] = checkLine[i];
//          checkLine[i] = temp;
//        }
//      }
//    }
//    return checkLine;
//  }

}
