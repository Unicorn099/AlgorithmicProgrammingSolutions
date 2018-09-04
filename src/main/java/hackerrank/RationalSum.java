package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RationalSum {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());

    List<String> s = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      s.add(sc.nextLine());
    }

    System.out.println(Sum(s));

  }


  static String Sum(List<String> abvalues) {

    String[] str = abvalues.get(0).split(" ");
    int a = Integer.parseInt(str[0]);
    int b = Integer.parseInt(str[1]);
    int gcdV = gcd(a,b);
    a/=gcdV;
    b/=gcdV;
    for (int k = 1; k < abvalues.size(); k++) {
      str = abvalues.get(k).split(" ");
      int a1 = Integer.parseInt(str[0]);
      int b1 = Integer.parseInt(str[1]);
      int[] x = findTheSum(a, b, a1, b1);
      a = x[0];
      b = x[1];
    }

    return a + " " + b;
  }

  private static int[] findTheSum(int a1, int b, int a11, int b1) {
    int n = a1 * b1 + a11 * b;
    int d = b * b1;

    int gcdV = gcd(n, d);

    int[] ans = new int[2];
    ans[0] = n / gcdV;
    ans[1] = d / gcdV;
    return ans;
  }

  static int gcd(int x, int y) {
    if (x < y) {
      int rem = y % x;
      if (rem == 0) {
        return x;
      } else {
        return gcd(x, rem);
      }
    } else {
      int rem = x % y;
      if (rem != 0) {
        return gcd(y, rem);
      } else {
        return y;
      }
    }
  }

}
