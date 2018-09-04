package hackerrank;

/**
 * Created by Peeyush on 6/15/2017.
 */
public class ArrayFormatter {
  public static void main(String[] args) {
    int[] x = {10, 25, 13, -10, 25, -12, -14, 58, 96, 2};
    for (int i = 0; i < x.length; i++)
      System.out.print(x[i] + " ");

    System.out.println();
    x = formatArray(x);
    for (int i = 0; i < x.length; i++)
      System.out.print(x[i] + " ");
  }

  private static int[] formatArray(int[] x) {

    int tempIndex = -1;
    int tempNumber;
    for (int i = 0; i < x.length; i++) {
      if (x[i] >= 0) {
//                int k = i;
//                while (tempIndex != -1 && x[tempIndex] < 0) {
//                    tempNumber = x[tempIndex];
//                    x[tempIndex] = x[k];
//                    x[k] = tempNumber;
//                    tempIndex--;
//                    k--;
//                }
//                tempIndex = i;
        while (tempIndex != -1 && x[tempIndex] < 0) {
          tempNumber = x[tempIndex + 1];
          x[tempIndex + 1] = x[tempIndex];
          x[tempIndex] = tempNumber;
          tempIndex--;
        }
        tempIndex = i;
      } else {
        tempIndex = i;
      }
    }
    return x;
  }
}
