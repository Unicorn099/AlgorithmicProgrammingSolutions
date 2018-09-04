package codeforces.Round496;

import java.util.Scanner;

public class Polycarpv2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String number = sc.nextLine();

    int count = 0;

    int res[] = new int[number.length() + 1];
    res[0] = 0;
    int index = 0;
    for (int i = 0; i < number.length(); i++) {
      long x =0;
      for (int j = i; j >= index; j--) {
        x+=Long.parseLong(number.charAt(j)+"");
        if(x%3==0){
          count++;
          index=i+1;
          break;
        }
      }
    }

    System.out.println(count);
  }

}
