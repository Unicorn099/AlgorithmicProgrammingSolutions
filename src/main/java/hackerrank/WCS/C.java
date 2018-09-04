package hackerrank.WCS;

public class C {
  public static void main(String[] args) {
    int [] A ={1,10,10};
    int m=11;
    int k=1;
    long ans =howManyGoodSubarrays(A,m,k);
    System.out.println(ans);
  }

  static long howManyGoodSubarrays(int[] A, int m, int k) {
    long ans=0;
    for(int i=0;i<A.length;i++){
      long x=1;
      for(int j=i;j<A.length;j++){
        x*=A[j]%m;
        if(x%m==k){
          ans++;
        }
      }
    }
    return ans;
  }
  // Complete the howManyGoodSubarrays function below.
//  static long howManyGoodSubarrays(int[] A, int m, int k) {
//    // Return the number of good subarrays of A.
//
//    long ans = 0;
//
//    long[][] ansArr = new long[A.length][A.length];
//    for (int i = 0; i < A.length; i++) {
//      if (A[i] % m == k) {
//        ans++;
//      }
//      ansArr[0][i] = A[i] % m;
//    }
//
//    for (int i = 1; i < A.length; i++) {
//      long x = 1;
//      for (int j = i; j < A.length; j++) {
//        x=(ansArr[i-1][j-1]%m)*(ansArr[0][j]%m);
//        ansArr[i][j]=x%m;
//        if(ansArr[i][j]==k){
//          ans++;
//        }
//      }
//    }
//
//    return ans;
//  }
}
