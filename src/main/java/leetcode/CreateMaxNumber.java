package year2019.practice.leetcode;

public class CreateMaxNumber {

  public static void main(String[] args) {
    CreateMaxNumber createMaxNumber = new CreateMaxNumber();
//    int[] num7 = {3, 4, 6, 5};
//    int[] num8 = {9, 1, 2, 5, 8, 3};
//    int[] ans3 = {9, 8, 6, 5, 3};
//    test(createMaxNumber.maxNumber(num7, num8, 5), ans3);
//    int[] num1 = {6, 7};
//    int[] num2 = {6, 0, 4};
//    int[] ans = {6, 7, 6, 0, 4};
//    int[] num5 = {8, 9};
//    int[] num6 = {3, 9};
//    int[] ans2 = {9, 8, 9};
//    test(createMaxNumber.maxNumber(num1, num2, 5), ans);
//    test(createMaxNumber.maxNumber(num5, num6, 3), ans2);
//
//    int[] num3 = {8, 6, 9};
//    int[] num4 = {1, 7, 5};
//    int[] ans1 = {9, 7, 5};
//    test(createMaxNumber.maxNumber(num3, num4, 3), ans1);
//
//    int[] num9 = {6, 7, 5};
//    int[] num10 = {4, 8, 1};
//    int[] ans5 = {8, 7, 5};
//    test(createMaxNumber.maxNumber(num9, num10, 3), ans5);
    int[]n1={3,8,5,3,4};
    int[]n2={8,7,3,6,8};
    int[]ans11={8,8,8,5,4};
    test(createMaxNumber.maxNumber(n1, n2, 5),ans11);
  }

  public static void test(int[] x, int[] y) {
    if (x.length != y.length) {
      System.out.println("Not passsed");
    } else {
      for (int i = 0; i < x.length; i++) {
        if (x[i] != y[i]) {
          System.out.println("Not passsed");
          return;
        }
      }
      System.out.println("Passsed");
    }
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] ans = new int[k];
    int ignoredElement = nums1.length + nums2.length - k;
    int i = 0;
    int j = 0;
    int kk = 0;
    while ((i < nums1.length || j < nums2.length) && ignoredElement > 0 && kk < k) {
      int ix = i;
      int index = -1;
      int max = Integer.MIN_VALUE;

      while ((ix - i) <= ignoredElement && ix < nums1.length) {
        if (max < nums1[ix]) {
          max = nums1[ix];
          index = ix;
        }
        ix++;
      }
      int iy = j;
      int indey = -1;
      while ((iy - j) <= ignoredElement && iy < nums2.length) {
        if (max < nums2[iy]) {
          max = nums2[iy];
          indey = iy;
        } else if (max == nums2[iy]) {
          for (int q = index, p = iy; q >= 0 && p >= 0; q--, p--) {
            if (nums1[q] > nums2[p]) {
              max = nums2[iy];
              indey = iy;
              break;
            }
          }
        }
        iy++;
      }
      if (indey != -1) {
        ignoredElement -= (indey - j);
        j = indey + 1;
        ans[kk++] = max;
      } else {
        ignoredElement -= (index - i);
        i = index + 1;
        ans[kk++] = max;
      }
    }
    while (i < nums1.length && j < nums2.length && kk < k) {
      if (nums1[i] > nums2[j]) {
        ans[kk++] = nums1[i];
        i++;
      } else if (nums2[j] > nums1[i]) {
        ans[kk++] = nums2[j];
        j++;
      } else {
        for (int x = i, y = j; x < nums1.length && y < nums2.length; x++, y++) {
          if (nums1[x] > nums2[y]) {
            ans[kk++] = nums1[i];
            i++;
            break;
          } else if (nums1[x] < nums2[y]) {
            ans[kk++] = nums2[j];
            j++;
            break;
          }
        }
      }
    }

    while (i < nums1.length && kk < k) {
      ans[kk++] = nums1[i++];
    }
    while (j < nums2.length && kk < k) {
      ans[kk++] = nums2[j++];
    }
    return ans;
  }
}
