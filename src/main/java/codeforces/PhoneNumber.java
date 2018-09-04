package codeforces;

import java.util.Scanner;

public class PhoneNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());
    System.out.println(findThePerm(n));
  }

  private static String findThePerm(int n) {
    String str = "";

    int max=n+1;
    int tempMax=0;
    int index=1;
    for(int i=1;i<=Math.sqrt(n);i++){
      tempMax = i+ (int)Math.ceil(n/(double)i);
      if(max>tempMax){
        max=tempMax;
        index=i;
      }
    }

    for(int i=n;i>=1;){
      String tempStr="";
      for(int j=0;(i-j)>0 && j<index;j++){
        tempStr=(i-j)+" "+tempStr;
      }
      str+=tempStr;
      i=i-index;
    }

    return str;
  }

}
