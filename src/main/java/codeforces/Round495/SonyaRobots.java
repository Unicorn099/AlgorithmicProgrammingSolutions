package codeforces.Round495;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SonyaRobots {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= Integer.parseInt(sc.nextLine());
    String [] str = sc.nextLine().split(" ");

    int []x = new int[n];
    for(int i=0;i<n;i++){
      x[i]=Integer.parseInt(str[i]);
    }
    //

    int count=0;
    Set<Integer> leftRead = new HashSet<>();
    Set<Integer> rightReadd = new HashSet<>();
    int []xx = new int[n];
    int c=0;
    for(int i=n-1;i>=1;i--){
      if(!rightReadd.contains(x[i])){
        c++;
        xx[i]=c;
        rightReadd.add(x[i]);
      }else{
        xx[i]=c;
      }
    }

    for(int i=0;i<n-1;i++){
      if(!leftRead.contains(x[i])) {
        leftRead.add(x[i]);
        count+=xx[i+1];
      }
    }

    System.out.println(count);
  }
}
