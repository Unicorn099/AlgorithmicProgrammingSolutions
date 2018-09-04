package hackerrank.WCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bv2 {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] nmabfst = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nmabfst[0]);

    int m = Integer.parseInt(nmabfst[1]);

    int a = Integer.parseInt(nmabfst[2]);

    int b = Integer.parseInt(nmabfst[3]);

    int f = Integer.parseInt(nmabfst[4]);

    int s = Integer.parseInt(nmabfst[5]);

    int t = Integer.parseInt(nmabfst[6]);

    membersInTheLargestGroups(n, m, a, b, f, s, t);

    scanner.close();
  }

  static Map<String, Integer> classTheyBelong = new HashMap<>();
  static Map<String, Integer> groupTheyBelong = new HashMap<>();

//  static Map<Integer, List<String>> peopleInAGroup = new HashMap<>();
  static List<List<String>> peopleOfAGroup = new ArrayList<>();
  static Map<Integer, Map<Integer,Integer>> graderInAGroup = new HashMap<>();

  // Complete the membersInTheLargestGroups function below.
  static void membersInTheLargestGroups(int n, int m, int a, int b, int f, int s, int t) {
    // Print the names of the students in all largest groups or determine if there are no valid groups.

    for (int i = 0; i < n; i++) {
      String[] nmabfst = scanner.nextLine().split(" ");
      classTheyBelong.put(nmabfst[0], Integer.parseInt(nmabfst[1]));
      groupTheyBelong.put(nmabfst[0],i+1);
      peopleOfAGroup.add(i+1, Arrays.asList(nmabfst[0]));
//      graderInAGroup.put(Integer.parseInt(nmabfst[1]))
    }

    for (int i = 0; i < m; i++) {
      String[] nmabfst = scanner.nextLine().split(" ");
      checkIfCanBeAddedThenAdd(nmabfst,n, b, f, s, t);
    }

//    Map<Integer, List<String>> sorted = peopleInAGroup.entrySet().parallelStream()
//        .sorted(comparingInt(e -> e.getValue().size()))
//        .collect(toMap(
//            Map.Entry::getKey,
//            Map.Entry::getValue,
//            (x, y) -> {
//              throw new AssertionError();
//            },
//            LinkedHashMap::new
//        ));
//
//    sorted.entrySet().removeIf(
//        matches -> matches.getValue().size() == 0);
//
//    for (Map.Entry xx : sorted.entrySet()) {
//
//    }
  }

  private static void checkIfCanBeAddedThenAdd(String[] nmabfst, int n, int b, int f, int s, int t) {

    int g1 = groupTheyBelong.get(nmabfst[0]);
    int g2 = groupTheyBelong.get(nmabfst[1]);
    int newGroupId=n+1;
    if(peopleOfAGroup.get(g1).size()+peopleOfAGroup.get(g2).size()<=b){

    }

  }
}
