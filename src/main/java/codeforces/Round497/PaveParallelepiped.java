package codeforces.Round497;

public class PaveParallelepiped {
  public static void main(String[] args) {
    int numberOfFactors = findFactors(100);
    System.out.println(numberOfFactors);
  }

  private static int findFactors(int i) {
    int count=0;
    for(int j=1;j<i;j++){
      if(i%j==0){
        count++;
        if(i/j!=i){
          count++;
        }
      }
    }
    return 0;
  }
}
