package codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MysteriousPresent {

  static class Cards implements Comparable<Cards> {
    int h;
    int w;
    int index;

    @Override
    public int compareTo(Cards o) {
      if (this.h - o.h != 0) {
        return this.h - o.h;
      } else {
        return this.w - o.w;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int nE = Integer.parseInt(str[0]);
    int cH = Integer.parseInt(str[1]);
    int cW = Integer.parseInt(str[2]);

    List<Cards> cardsList = new ArrayList<>();
    for (int i = 0; i < nE; i++) {
      Cards cards = new Cards();
      String[] s = sc.nextLine().split(" ");
      cards.h = Integer.parseInt(s[0]);
      cards.w = Integer.parseInt(s[1]);
      cards.index = i + 1;
      cardsList.add(cards);
    }
    Collections.sort(cardsList);

    int count = 0;
    String s = "";
    int i = 0;
    while (i < nE) {
      if (cardsList.get(i).w > cW && cardsList.get(i).h > cH) {
        count++;
        s += String.valueOf(cardsList.get(i).index) + " ";
        break;
      }
      i++;
    }
    for (int j = i + 1; j < nE; j++) {
      if (cardsList.get(j).w > cardsList.get(i).w && cardsList.get(j).h > cardsList.get(i).h) {
        count++;
        s += String.valueOf(cardsList.get(j).index) + " ";
        i = j;
      }
    }

    //
    Collections.sort(cardsList, new Comparator<Cards>() {
      @Override
      public int compare(Cards o1, Cards o2) {
        if (o1.w - o2.w != 0) {
          return o1.w - o2.w;
        } else {
          return o1.h - o2.h;
        }
      }
    });

    int count1 = 0;
    String s1 = "";
    int ii = 0;
    while (ii < nE) {
      if (cardsList.get(ii).w > cW && cardsList.get(ii).h > cH) {
        count1++;
        s1 += String.valueOf(cardsList.get(ii).index) + " ";
        break;
      }
      ii++;
    }
    for (int j = ii + 1; j < nE; j++) {
      if (cardsList.get(j).w > cardsList.get(ii).w && cardsList.get(j).h > cardsList.get(ii).h) {
        count1++;
        s1 += String.valueOf(cardsList.get(j).index) + " ";
        ii = j;
      }
    }

    if (count > count1) {
      System.out.println(count);
      if (count != 0) {
        System.out.println(s);
      }
    } else {
      System.out.println(count1);
      if (count1 != 0) {
        System.out.println(s1);
      }
    }
  }
}
