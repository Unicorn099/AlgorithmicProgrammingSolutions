package codeforces.Round499;

import java.util.Scanner;

public class Fly {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    int M = Integer.parseInt(sc.nextLine());
    String[] takeoff = sc.nextLine().split(" ");
    String[] landing = sc.nextLine().split(" ");

    double ans = 0.0;
    ans += M;
    double landingCharge = Double.parseDouble(landing[0]);
    double takeOffCharge = 0;
    ans *= landingCharge;
    ans /= (landingCharge - 1);
    for (int i = N - 1; i >= 1; i--) {

      takeOffCharge = Double.parseDouble(takeoff[i]);
      ans *= takeOffCharge;
      ans /= (takeOffCharge - 1);

      landingCharge = Double.parseDouble(landing[i]);
      ans *= landingCharge;
      ans /= (landingCharge - 1);

    }
    takeOffCharge = Double.parseDouble(takeoff[0]);
    ans *= takeOffCharge;
    ans /= (takeOffCharge - 1);

    ans -= M;

    if (Double.isInfinite(ans)) {
      System.out.println(-1);
    } else {
      System.out.println(ans - M);
    }
  }
}
