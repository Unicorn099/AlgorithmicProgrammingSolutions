package facebook.QR;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FightingZombie {
  final static String WORK_DIR = "E:\\testingtestingtesting123\\FightingZombie\\";

  class SpellsDesc {
    int noOfTimes;
    int sizeOfDice;
    int z;

    public SpellsDesc(int noOfTimes, int sizeOfDice, int z) {
      this.noOfTimes = noOfTimes;
      this.sizeOfDice = sizeOfDice;
      this.z = z;
    }

    public SpellsDesc(int noOfTimes, int sizeOfDice) {
      this.noOfTimes = noOfTimes;
      this.sizeOfDice = sizeOfDice;
    }

    @Override
    public String toString() {
      return "SpellsDesc{" +
          "noOfTimes=" + noOfTimes +
          ", sizeOfDice=" + sizeOfDice +
          ", z=" + z +
          '}';
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + "A-large-practice.in"));
    PrintWriter pw = new PrintWriter(
        new FileWriter(WORK_DIR + "output.txt"));

    int caseCnt = sc.nextInt();
    sc.nextLine();
    for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
      System.out.println("Processing test case " + (caseNum + 1));
      pw.print("Case #" + (caseNum + 1) + ": ");
      new FightingZombie().solve(sc, pw);
    }
    pw.flush();
    pw.close();
    sc.close();
  }

  private void solve(Scanner sc, PrintWriter pw) {
    String[] str = sc.nextLine().split(" ");
    int minDamageNeeded = Integer.parseInt(str[0]);
    int noOfSpells = Integer.parseInt(str[1]);

    String[] spells = sc.nextLine().split(" ");
    SpellsDesc[] spellsDescArr = new SpellsDesc[spells.length];
    for (int i = 0; i < noOfSpells; i++) {

      int firstIndex = spells[i].indexOf("d");
      int secondIndex = spells[i].indexOf("-");
      int thirdIndex = spells[i].indexOf("+");
      SpellsDesc spellsDesc;
      if (secondIndex != -1) {
        spellsDesc = new SpellsDesc(Integer.parseInt(spells[i].substring(0, firstIndex)), Integer.parseInt(spells[i].substring(firstIndex + 1, secondIndex)),
            -Integer.parseInt(spells[i].substring(secondIndex + 1)));
      } else if (thirdIndex != -1) {
        spellsDesc = new SpellsDesc(Integer.parseInt(spells[i].substring(0, firstIndex)), Integer.parseInt(spells[i].substring(firstIndex + 1, thirdIndex)),
            Integer.parseInt(spells[i].substring(thirdIndex + 1)));
      } else {
        spellsDesc = new SpellsDesc(Integer.parseInt(spells[i].substring(0, firstIndex)), Integer.parseInt(spells[i].substring(firstIndex + 1)));
      }
      System.out.println(spellsDesc);
      spellsDescArr[i] = spellsDesc;

      int totalNumberOfValues=0;
      int numberGreater = 0;

    }


  }
}
