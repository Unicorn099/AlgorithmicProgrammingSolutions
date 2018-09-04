package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationSystem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String [] ans = new String[n];

    Map<String,Integer> str = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String s = sc.nextLine();
      int x = str.getOrDefault(s,0);
      if(x==0){
        ans[i]="OK";
      }else{
        ans[i]=s+String.valueOf(x);
      }
      str.put(s,x+1);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(ans[i]);
    }
  }
}
