package codeforces.Round499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stages {
  static int N;
  static int K;

  static Map<Character, Integer> charVal = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    N = Integer.parseInt(str[0]);
    K = Integer.parseInt(str[1]);
    String s = sc.nextLine();

    charVal.put('a', 1);
    charVal.put('b', 2);
    charVal.put('c', 3);
    charVal.put('d', 4);
    charVal.put('e', 5);
    charVal.put('f', 6);
    charVal.put('g', 7);
    charVal.put('h', 8);
    charVal.put('i', 9);
    charVal.put('j', 10);
    charVal.put('k', 11);
    charVal.put('l', 12);
    charVal.put('m', 13);
    charVal.put('n', 14);
    charVal.put('o', 15);
    charVal.put('p', 16);
    charVal.put('q', 17);
    charVal.put('r', 18);
    charVal.put('s', 19);
    charVal.put('t', 20);
    charVal.put('u', 21);
    charVal.put('v', 22);
    charVal.put('w', 23);
    charVal.put('x', 24);
    charVal.put('y', 25);
    charVal.put('z', 26);
    int x = solve(s);
    System.out.println(x);
  }

  private static int solve(String s) {

    char[] xx = s.toCharArray();
    Arrays.sort(xx);

    int k = 13*27;
    int count=0;

    for (int i = 0; i < xx.length; i++) {
      int tempK = 0;
      int tempCount=0;
      tempK += charVal.get(xx[i]);
      count++;
      tempCount++;
      char c = xx[i];
      for (int j = i+1; j < xx.length; j++) {
        if (tempCount < K) {
          if (xx[j] - c >= 2) {
            tempK += charVal.get(xx[j]);
            count++;
            tempCount++;
            c = xx[j];
          }
        }else{
          break;
        }
      }
      if(tempK<k && tempCount==K){
        k=tempK;
      }
    }
    if(k!=13*27){
      return k;
    }else{
      return -1;
    }

  }
}
