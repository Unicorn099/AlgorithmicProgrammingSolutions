package codeforces.Round495;

import java.util.Scanner;

public class SonyaExhibition {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str  = sc.nextLine().split(" ");
    int n=Integer.parseInt(str[0]);
    int m=Integer.parseInt(str[1]);

    int [][] data = new int[m][2];
    for(int i=0;i<m;i++){
      str  = sc.nextLine().split(" ");
      data[i][0]=Integer.parseInt(str[0]);
      data[i][1]=Integer.parseInt(str[1]);
    }

    //
    int []ans = new int [n];
    for(int i=0;i<m;i++){
      if((data[i][1]-data[i][0])%2==0){//Odd Category

      }else{//EvenCategory
        for(int j=data[i][0]-1;j<data[i][1];j++){
//          if(j<)
        }
      }
    }
  }
}
