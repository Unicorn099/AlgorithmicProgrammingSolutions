package year2019.practice.leetcode;

public class LicenseKeyFormatting {

  public static void main(String[] args) {

    LicenseKeyFormatting l = new LicenseKeyFormatting();
    String s = l.licenseKeyFormatting("--a-a-a-a--", 2);
//    String s1 = l.licenseKeyFormatting("2-5g-3-J", 2);
    System.out.println(s);
//    System.out.println(s1);
  }

  public String licenseKeyFormatting(String S, int K) {

    int len = S.length();
    StringBuilder ansString = new StringBuilder();

    int i = len - 1;
    for (; i > K - 1; ) {

      for (int j = K; j > 0 && i >= 0; ) {
        if (S.charAt(i) != '-') {
          ansString.insert(0, S.charAt(i) >= 0 && S.charAt(i) <= 9 ? S.charAt(i) : Character.toUpperCase(S.charAt(i)));
          j--;
        }
        i--;
      }
      if (i >= 0) {
        ansString.insert(0, "-");
      }
    }
    if (i >= 0) {
      StringBuilder sb = new StringBuilder();
      for (int m = 0; m < K && m < len; m++) {
        if (S.charAt(m) != '-') {
          sb.append(S.charAt(m) >= 0 && S.charAt(m) <= 9 ? S.charAt(m) : Character.toUpperCase(S.charAt(m)));
        }
      }
      ansString.insert(0, sb);
    }
    return ansString.toString();
  }
}
