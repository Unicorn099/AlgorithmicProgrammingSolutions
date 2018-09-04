package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String a = sc.nextLine();
    String b = sc.nextLine();

    int count0 = 0;
    int count1 = 0;
    int count1b = 0;
    List<Integer>indexList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if(b.charAt(i)=='1'){
        count1b++;
        indexList.add(i);
      }
      if (a.charAt(i) == '0') {
        count0++;
      } else {
        count1++;
      }
    }

    int mulCount=0;
    for(int i=0;i<indexList.size();i++){
      int tempCount=0;
      for(int j=i+1;j<indexList.size();j++){
        if(a.charAt(indexList.get(i))!=a.charAt(indexList.get(j))){
          tempCount++;
        }
      }
      mulCount+=tempCount;
      if(mulCount>(count0*count1)){
        break;
      }
    }

//    int mul=count1b>1?1:0;
//    for(int i=1;i<count1b;i++){
//      mul*=i;
//    }
    int ans=count0==0||count1==0?0:(count0*count1)-mulCount>0?(count0*count1)-mulCount:0;
    System.out.println(ans);
  }
}
