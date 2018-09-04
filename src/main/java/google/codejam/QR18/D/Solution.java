package google.codejam.QR18.D;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

  private static DecimalFormat df2 = new DecimalFormat("##.#########");

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int caseCnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < caseCnt; i++) {

      double area = Double.parseDouble(sc.nextLine());
      System.out.println("Case #" + (i + 1) + ": ");
      solve(area);
    }
    sc.close();
  }

  private static void solve(double area) {
    double newArea = 0;

    int lowerIndex = -1;
    if (1.414213 > area) {
      for (int j = 0; j <= 45; j++) {
        newArea = 1 *
            (Math.sin(Math.toRadians(j)) + Math.cos(Math.toRadians(j)));

        if (newArea < area) {
          lowerIndex = j;
        }
        if (Math.abs(newArea - area) < 0.000001) {
          findTheCoordinates(0, j);
          return;
        }
      }
      double index = Math.toRadians(lowerIndex);
      double higherIndex = Math.toRadians(lowerIndex + 1);

      while (index < higherIndex) {
        index += 0.000001;
        newArea = 1 *
            (Math.sin(index) + Math.cos(index));
        if (Math.abs(newArea - area) < 0.000001) {
          findTheCoordinates(0, Math.toDegrees(index));
          return;
        }
      }
    } else {
      for (int i = 0; i <= 45; i++) {
        newArea = (Math.sin(Math.toRadians(i)) + Math.cos(Math.toRadians(i))) *
            (Math.sin(Math.toRadians(45)) + Math.cos(Math.toRadians(45)));
        if (newArea < area) {
          lowerIndex = i;
        }
        if (Math.abs(newArea - area) < 0.000001) {
          findTheCoordinates(i, 45);
          return;
        }
      }
      double index = Math.toRadians(lowerIndex);
      double higherIndex = Math.toRadians(lowerIndex + 1);

      while (index < higherIndex) {
        index += 0.000001;
        newArea = (Math.sin(Math.toRadians(45)) + Math.cos(Math.toRadians(45)))*
            (Math.sin(index) + Math.cos(index));
        if (Math.abs(newArea - area) < 0.000001) {
          findTheCoordinates(Math.toDegrees(index),45);
          return;
        }
      }
    }

  }

  private static void findTheCoordinates(double i, double j) {
    if (i == 0) {
      System.out.println(df2.format(0.5 * Math.cos(Math.toRadians(j))) + " " + df2.format(0.5 * Math.sin(Math.toRadians(j))) + " 0");
      System.out.println(df2.format(0.5 * Math.cos(Math.toRadians(90 + j))) + " " + df2.format(0.5 * Math.sin(Math.toRadians(90 + j))) + " 0");
      System.out.println("0 0 0.5");
    } else {
      System.out.println(df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.cos(Math.toRadians(j))) + " "
          + df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j))) + " " + df2.format(0.5 * Math.cos(Math.toRadians(i))));
      System.out.println(df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.cos(Math.toRadians(90 + j))) + " "
          + df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(90 + j))) + " " + df2.format(0.5 * Math.cos(Math.toRadians(i))));
      System.out.println(df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.cos(Math.toRadians(j))) + " "
          + df2.format(0.5 * Math.sin(Math.toRadians(i)) * Math.sin(Math.toRadians(j))) + " " + df2.format(0.5 * Math.cos(Math.toRadians(i))));
    }
  }
}