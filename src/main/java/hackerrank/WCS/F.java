package hackerrank.WCS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class F {

  public static void main(String[] args) {
    String[] nq = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nq[0]);

    int q = Integer.parseInt(nq[1]);

    competitiveTeams(n, q);

    scanner.close();
  }

  // Complete the competitiveTeams function below.

  private static final Scanner scanner = new Scanner(System.in);

  static Map<Integer, Node> mapReference = new HashMap<>();
  static Map<Integer, Integer> countInAGroup = new HashMap<>();

  static class Node {
    Node parent;
    int size;
    int value;
  }

  static void competitiveTeams(int n, int q) {
    // Print the answer for each query of type 2. Take the query data from the standard input.
    int maxGroupId = n;
    for (int i = 1; i <= n; i++) {
      Node node = new Node();
      node.parent = null;
      node.value = i;//id
      node.size = 1;
      mapReference.put(i, node);
      int x = countInAGroup.getOrDefault(1, 0);
      countInAGroup.put(1, x + 1);
    }

    for (int kk = 0; kk < q; kk++) {//10^5
      String[] nq = scanner.nextLine().split(" ");
      if (Integer.parseInt(nq[0]) == 1) {
        int i = Integer.parseInt(nq[1]);
        int j = Integer.parseInt(nq[2]);
        findTheNodeAndJoinThen(i, j, maxGroupId);
        maxGroupId++;
      } else {
        findTheCount(Integer.parseInt(nq[1]));
      }
    }
  }


  private static void findTheCount(int qi) {

    countInAGroup.entrySet().removeIf(
        matches -> matches.getValue().compareTo(Integer.valueOf(0)) == 0);

    long ans = 0;
    if (qi == 0) {
      int numberOfGroups = 0;
      for (Map.Entry<Integer, Integer> xx : countInAGroup.entrySet()) {
        numberOfGroups += xx.getValue();
      }
      System.out.println((numberOfGroups * (numberOfGroups - 1) / 2));
    } else {

      for (Map.Entry<Integer, Integer> xx : countInAGroup.entrySet()) {
        for (Map.Entry<Integer, Integer> yy : countInAGroup.entrySet()) {
          if (Math.abs(xx.getKey() - yy.getKey()) >= qi) {
            ans += xx.getValue() * yy.getValue();
          }
        }
      }
      System.out.println(ans / 2);
    }
  }

//  private static void findTheCount(int qi, Map<Integer, Integer>  countInAGroup) {
//    long mul;
//    long ans = 0;
////    boolean ifThereWasATeam=false;
//    for (int i = 1; i < countInAGroup.length; i++) {
////      if (i + qi < countInAGroup.length) {
//        mul = 1;
//        for (int j = i + qi; j < countInAGroup.length; j++) {
////          if(countInAGroup[j]!=0) {
////            ifThereWasATeam=true;
//            mul = countInAGroup[i] * countInAGroup[j];
//            ans+=mul;
////          }
//        }
////      }
//    }
//    System.out.println(ans);
//  }

//  private static void findTheNodeAndJoinThen(int i, int j, int maxGroupId) {
//    Node node1 = mapReference.get(i);
//    Node node2 = mapReference.get(j);
//    if (node1.parent == null && node2.parent == null) {
//      Node node = new Node();
//      node.value = maxGroupId + 1;
//      node1.parent = node;
//      node2.parent = node;
//      node.size = node1.size + node2.size;
//      int x = countInAGroup.getOrDefault(node.size, 0);
//      countInAGroup.put(node.size, x + 1);
//      x = countInAGroup.getOrDefault(node1.size, 0);
//      countInAGroup.put(node1.size, x - 1);
//      x = countInAGroup.getOrDefault(node2.size, 0);
//      countInAGroup.put(node2.size, x - 1);
//    } else if (node1.parent != null && node2.parent != null) {
//      if (node1.parent.value != node2.parent.value) {
//        node1.parent.value = maxGroupId + 1;
//        node2.parent.value = maxGroupId + 1;//reference didnt change so they are having same value but pointing to different parent
//        int tempSize = node1.parent.size + node2.parent.size;
//        int x = countInAGroup.getOrDefault(node1.parent.size, 0);
//        countInAGroup.put(node1.parent.size, x - 1);
//        x = countInAGroup.getOrDefault(node2.parent.size, 0);
//        countInAGroup.put(node2.parent.size, x - 1);
//        x = countInAGroup.getOrDefault(tempSize, 0);
//        countInAGroup.put(tempSize, x + 1);
//        node1.parent.size = tempSize;
//        node2.parent.size = tempSize;
//      }
//    } else if (node1.parent != null && node2.parent == null) {
//      node1.parent.value = maxGroupId + 1;
//      node2.parent = node1.parent;
//
//      int x = countInAGroup.getOrDefault(node1.parent.size, 0);
//      countInAGroup.put(node1.parent.size, x - 1);
//      x = countInAGroup.getOrDefault(node2.size, 0);
//      countInAGroup.put(node2.size, x - 1);
//      node1.parent.size += node2.size;
//      x = countInAGroup.getOrDefault(node1.parent.size, 0);
//      countInAGroup.put(node1.parent.size, x + 1);
//
//    } else if (node1.parent == null && node2.parent != null) {
//      node2.parent.value = maxGroupId + 1;
//      node1.parent = node2.parent;
//
//      int x = countInAGroup.getOrDefault(node2.parent.size, 0);
//      countInAGroup.put(node2.parent.size, x - 1);
//      x = countInAGroup.getOrDefault(node1.size, 0);
//      countInAGroup.put(node1.size, x - 1);
//      node2.parent.size += node1.size;
//      x = countInAGroup.getOrDefault(node2.parent.size, 0);
//      countInAGroup.put(node2.parent.size, x + 1);
//    }
//
//  }
  private static void findTheNodeAndJoinThen(int i, int j, int maxGroupId) {
    Node node1 = mapReference.get(i);
    Node node2 = mapReference.get(j);
    while (node1.parent != null) {
      node1 = node1.parent;
    }
    while (node2.parent != null) {
      node2 = node2.parent;
    }
    if (node2.value != node1.value) {
      Node node = new Node();
      node.value = maxGroupId + 1;
      node.size = node1.size + node2.size;
      node.parent = null;
      node1.parent = node;
      node2.parent = node;
      int x = countInAGroup.getOrDefault(node.size, 0);
      countInAGroup.put(node.size, x + 1);
      x = countInAGroup.getOrDefault(node1.size, 0);
      countInAGroup.put(node1.size, x - 1);
      x = countInAGroup.getOrDefault(node2.size, 0);
      countInAGroup.put(node2.size, x - 1);
    }
  }
}
