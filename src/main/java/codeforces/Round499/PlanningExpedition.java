package codeforces.Round499;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PlanningExpedition {

  static class Package implements Comparable<Package> {
    int type;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Package aPackage = (Package) o;
      return type == aPackage.type;
    }

    @Override
    public int hashCode() {

      return Objects.hash(type);
    }

    int quanitity;

    public Package(int type, int quanitity) {
      this.type = type;
      this.quanitity = quanitity;
    }

    @Override
    public int compareTo(Package o) {
      return this.quanitity - o.quanitity;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    int ep = Integer.parseInt(str[0]);
    int p = Integer.parseInt(str[1]);

    str = sc.nextLine().split(" ");
    if (p < ep) {
      System.out.println(0);
    } else {
      Set<Package> packages = new TreeSet<>();
      Map<Integer, Integer> packageTypeCount = new HashMap<>();
      for (int i = 0; i < p; i++) {
        int y = Integer.parseInt(str[i]);
        int x = packageTypeCount.getOrDefault(y, 0);
        x++;
        packageTypeCount.put(y, x);
      }

      for (Map.Entry<Integer, Integer> xxx : packageTypeCount.entrySet()) {
        Package pp = new Package(xxx.getKey(), xxx.getValue());
        packages.add(pp);
      }

      Iterator<Package> it = packages.iterator() ;int k=0;
      while(it.hasNext() && k<ep){
        Package ip =it.next();
        it.remove();
        ip.quanitity --;
        packages.add(ip);
      }


    }
  }
}
