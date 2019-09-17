package year2019.practice.leetcode;

public class MinSwaps {

  public static void main(String[] args) {
//    int[] a1 = {1, 2, 3, 6, 3, 2};
//    int[] a2 = {2, 1, 2, 2, 2, 4};
    int[] a1 = {1, 2, 1, 2};
    int[] a2 = {2, 6, 1, 2};
    MinSwaps m = new MinSwaps();
    System.out.println(m.minSwaps(a1, a2));
  }

  public int minSwaps(int[] a1, int[] a2) {
    int len = a1.length;
    int count1 = 0;
    int count2 = 0;
    for (int i = 1; i < len; i++) {
      if (a1[i] == a1[0]) {
        continue;
      } else {
        if (a2[i] == a1[0]) {
          count1++;
        } else {
          count1 = -1;
          break;
        }
      }
    }

    for (int i = 1; i < len; i++) {
      if (a2[i] == a2[0]) {
        continue;
      } else {
        if (a1[i] == a2[0]) {
          count2++;
        } else {
          count2 = -1;
          break;
        }
      }
    }

    if (count1 == -1 && count2 == -1) {
      return -1;
    } else {
      if (count1 == -1) {
        return Math.min(count2, len - count2);
      } else if (count2 == -1) {
        return Math.min(count1, len - count1);
      } else {
        return Math.min(Math.min(len - count1, count1), Math.min(len - count2, count2));
      }
    }
  }
}
