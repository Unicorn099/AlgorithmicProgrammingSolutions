package codeforces;

import java.util.Scanner;

public class MysteriousPresentV2 {

  static class Cards {
    int w;
    int h;
    int index;

    @Override
    public String toString() {
      return "Cards{" +
          "w=" + w +
          ", h=" + h +
          ", index=" + index +
          '}';
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int nE = Integer.parseInt(str[0]);
    int cW = Integer.parseInt(str[1]);
    int cH = Integer.parseInt(str[2]);

    Cards[] cardsList = new Cards[nE];
    for (int i = 0; i < nE; i++) {
      Cards cards = new Cards();
      String[] s = sc.nextLine().split(" ");
      cards.w = Integer.parseInt(s[0]);
      cards.h = Integer.parseInt(s[1]);
      cards.index = i + 1;
      cardsList[i] = cards;
    }

    //Solving here

    Cards[][] ansList = new Cards[nE][nE];

    for (int i = 0; i < nE; i++) {
      if (cardsList[i].w > cW && cardsList[i].h > cH) {
        ansList[0][i] = (cardsList[i]);
      }
    }

    for (int i = 1; i < nE; i++) {
      for (int k = 0; k < nE; k++) {
        if (ansList[i - 1][k] != null)
          for (int j = 0; j < nE; j++) {
            if (cardsList[j].w > ansList[i - 1][k].w && cardsList[j].h > ansList[i - 1][k].h) {
              ansList[i][k] = (cardsList[j]);
            }
          }
      }
    }

    for (int i = 0; i < nE; i++) {
      for (int j = 0; j < nE; j++) {
        if (ansList[i][j] != null) {
          System.out.print(ansList[i][j] + " ");
        }else{
          System.out.print("--");
        }
      }
      System.out.println();
    }
  }
}
