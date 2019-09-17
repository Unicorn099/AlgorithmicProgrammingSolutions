package year2019.practice.leetcode;

public class LicenseKeyFormattingv1 {

  public static void main(String[] args) {

    LicenseKeyFormattingv1 l = new LicenseKeyFormattingv1();
    String s =l.licenseKeyFormatting("2-5g-3-J-",2);
    System.out.println(s);
  }

  public String licenseKeyFormatting(String S, int K) {
    int len = S.length();
    StringBuilder ansString = new StringBuilder();

    int i = len - 1;
    for (; i > K - 1; ) {

      for (int j = K; j > 0 && i >= 0; ) {
        if (S.charAt(i) != '-') {
          ansString.insert(0, Character.toUpperCase(S.charAt(i)));
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
      for (int m = 0; m < K && m <= i; m++) {
        if (S.charAt(m) != '-') {
          sb.append(Character.toUpperCase(S.charAt(m)));
        }
      }
      ansString.insert(0, sb);
    }

    for (int n = 0; n < ansString.length()&& ansString.charAt(n) == '-'; n++) {
      ansString.deleteCharAt(n);
    }
    return ansString.toString();
  }
}
