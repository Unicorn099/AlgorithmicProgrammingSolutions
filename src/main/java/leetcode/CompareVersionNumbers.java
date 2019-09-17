package year2019.practice.leetcode;

public class CompareVersionNumbers {

  public static void main(String[] args) {

    CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
    System.out.println(compareVersionNumbers.compareVersion("0.1", "1.1"));
    System.out.println(compareVersionNumbers.compareVersion("1.0.1", "1"));
    System.out.println(compareVersionNumbers.compareVersion("1.0", "1"));
    System.out.println(compareVersionNumbers.compareVersion("1", "1.1"));
    System.out.println(compareVersionNumbers.compareVersion("7.5.2.4", "7.5.3"));
    System.out.println(compareVersionNumbers.compareVersion("7.5.3", "7.5.3"));

  }

  public int compareVersion(String version1, String version2) {
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");

    int len1 = ver1.length;
    int len2 = ver2.length;
    int len = len1 > len2 ? len2 : len1;
    int ans = -99;
    for (int i = 0; i < len; i++) {
      if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
        ans = 1;
        break;
      } else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
        ans = -1;
        break;
      } else {
        continue;
      }
    }

    if (ans == -99) {
      if (len1 > len2) {
        for (int i = len2; i < len1; i++) {
          if (Integer.parseInt(ver1[i]) != 0) {
            ans = 1;
            break;
          }
        }
      } else if (len1 < len2) {
        for (int i = len1; i < len2; i++) {
          if (Integer.parseInt(ver2[i]) != 0) {
            ans = -1;
            break;
          }
        }
      } else {
        ans = 0;
      }
    }

    if (ans == -99) {
      ans = 0;
    }

    return ans;
  }

}
