package hackerrank.WCS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class B {

  // Complete the membersInTheLargestGroups function below.
  static void membersInTheLargestGroups(int n, int m, int a, int b, int f, int s, int t) {
    // Print the names of the students in all largest groups or determine if there are no valid groups.

    Map<String, Integer> classTheyBelong = new HashMap<>();
    String[] personInAGroup = new String[n];
    for (int i = 0; i < n; i++) {
      String[] nmabfst = scanner.nextLine().split(" ");
      classTheyBelong.put(nmabfst[0], Integer.parseInt(nmabfst[1]));
      personInAGroup[i] = "";
    }

    int[] classRestriction = new int[4];
    classRestriction[1] = f;
    classRestriction[2] = s;
    classRestriction[3] = t;

    int groupId = 0;
    Map<String, Integer> groupTheyBelong = new HashMap<>();
    int[][] graderInAGroup = new int[n][4];

    for (int i = 0; i < m; i++) {
      String[] nmabfst = scanner.nextLine().split(" ");
      int groupOfFirstOne = groupTheyBelong.getOrDefault(nmabfst[0], 0);
      int groupOfSecondOne = groupTheyBelong.getOrDefault(nmabfst[1], 0);
      if (groupOfFirstOne == 0 && groupOfSecondOne == 0) {
        groupTheyBelong.put(nmabfst[0], groupId + 1);
        groupTheyBelong.put(nmabfst[1], groupId + 1);
        personInAGroup[groupId + 1] += nmabfst[0] + "," + nmabfst[1] + ",";
        graderInAGroup[groupId + 1][classTheyBelong.get(nmabfst[0])] += 1;
        graderInAGroup[groupId + 1][classTheyBelong.get(nmabfst[1])] += 1;
      } else if (groupOfFirstOne == groupOfSecondOne) {
        //do Nothing
      } else if (groupOfFirstOne != 0 && groupOfSecondOne != 0 && groupOfFirstOne != groupOfSecondOne) {
        //doNothing
        int numberOfPersonInGroupOfSeconOne = findTheCount(personInAGroup, groupOfSecondOne);
        int numberOfPersonInGroupOfFirstOne = findTheCount(personInAGroup, groupOfFirstOne);
        if (numberOfPersonInGroupOfSeconOne + numberOfPersonInGroupOfFirstOne <= b) {
          //Mistake lies here, not considering all the elements count
          if ((graderInAGroup[groupOfFirstOne][classTheyBelong.get(nmabfst[0])] < classRestriction[classTheyBelong.get(nmabfst[0])])
              && (graderInAGroup[groupOfFirstOne][classTheyBelong.get(nmabfst[1])] < classRestriction[classTheyBelong.get(nmabfst[1])])) {

            if (checkIfItsOkToMerge(graderInAGroup, groupOfFirstOne, classTheyBelong, classRestriction, personInAGroup[groupOfSecondOne])) {
              String sss = personInAGroup[groupOfSecondOne];
              for (int l = 0; l < sss.length(); l++) {
                String res = sss.charAt(l) + "";
                for (int j = l + 1; j < sss.length(); j++) {
                  if ((sss.charAt(j) + "").equals(",")) {
                    groupTheyBelong.put(res, groupOfFirstOne);
                    personInAGroup[groupOfFirstOne] += res + ",";
                    graderInAGroup[groupOfFirstOne][classTheyBelong.get(res)] += 1;
                    l = j;
                    break;
                  } else {
                    res += sss.charAt(j) + "";
                  }
                }
              }
            }

          }
        }
      } else if (groupOfFirstOne == 0 && groupOfSecondOne != 0) {
        int numberOfPersonInGroupOfSeconOne = findTheCount(personInAGroup, groupOfSecondOne);
        if (numberOfPersonInGroupOfSeconOne < b) {
          if (graderInAGroup[groupOfSecondOne][classTheyBelong.get(nmabfst[0])] < classRestriction[classTheyBelong.get(nmabfst[0])]) {
            groupTheyBelong.put(nmabfst[0], groupOfSecondOne);
            personInAGroup[groupOfSecondOne] += nmabfst[0] + ",";
            graderInAGroup[groupOfSecondOne][classTheyBelong.get(nmabfst[0])] += 1;
          }
        }
      } else if (groupOfFirstOne != 0 && groupOfSecondOne == 0) {
        int numberOfPersonInGroupOfFirstOne = findTheCount(personInAGroup, groupOfFirstOne);
        if (numberOfPersonInGroupOfFirstOne < b) {
          if (graderInAGroup[groupOfFirstOne][classTheyBelong.get(nmabfst[1])] < classRestriction[classTheyBelong.get(nmabfst[1])]) {
            groupTheyBelong.put(nmabfst[1], groupOfFirstOne);
            personInAGroup[groupOfFirstOne] += nmabfst[1] + ",";
            graderInAGroup[groupOfFirstOne][classTheyBelong.get(nmabfst[1])] += 1;
          }
        }
      }
      groupId++;
    }

    int maxPeople = 0;
    int index = -1;
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!personInAGroup[i].equals("")) {
        int tempMax = findTheCount(personInAGroup, i);
        if (maxPeople < tempMax) {
          index = i;
        }
      }
    }
    indices.add(index);

    for (int i = 0; i < n; i++) {
      if (!personInAGroup[i].equals("")) {
        int tempMax = findTheCount(personInAGroup, i);
        if (index== tempMax) {
          indices.add(i);
        }
      }
    }

    String ans = personInAGroup[index];
//    List<String> ansList = new ArrayList<>();
    Set<String> ansList = new TreeSet<>();
    if (a > ans.length()) {
      System.out.println("no groups");
      return;
    } else {
      for(int k=0;k<indices.size();k++) {
        ans = personInAGroup[indices.get(k)];
        for (int i = 0; i < ans.length(); i++) {
          String res = ans.charAt(i) + "";
          for (int j = i + 1; j < ans.length(); j++) {
            if ((ans.charAt(j) + "").equals(",")) {
              ansList.add(res);
              i = j;
              break;
            } else {
              res += ans.charAt(j) + "";
            }
          }
        }
      }
    }

//    Collections.sort(ansList);
    ansList.stream().forEach(System.out::println);
  }

  private static boolean checkIfItsOkToMerge(int[][] graderInAGroup, int groupOfFirstOne, Map<String, Integer> classTheyBelong, int[] classRestriction, String s) {
    //Putting peopleof second Group in FirstOne
    boolean canBeMerged = true;

    int[][] localGraderInAGroup = new int[graderInAGroup.length][];
    for (int i = 0; i < graderInAGroup.length; i++) {
      int[] lo = new int[graderInAGroup[i].length];
      for (int j = 0; j < graderInAGroup[i].length; j++) {
        lo[j] = graderInAGroup[i][j];
      }
      localGraderInAGroup[i] = lo;
    }

    String sss = s;
    for (int l = 0; l < sss.length(); l++) {
      String res = sss.charAt(l) + "";
      for (int j = l + 1; j < sss.length(); j++) {
        if ((sss.charAt(j) + "").equals(",")) {
          if (localGraderInAGroup[groupOfFirstOne][classTheyBelong.get(res)] < classRestriction[classTheyBelong.get(res)]) {
            localGraderInAGroup[groupOfFirstOne + 1][classTheyBelong.get(res)] += 1;
            l = j;
          } else {
            l = sss.length() + 1;
            canBeMerged = false;
            break;
          }
          break;
        } else {
          res += sss.charAt(j) + "";
        }
      }
    }
    return canBeMerged;
  }

  private static int findTheCount(String[] personInAGroup, int i) {
    int count = 0;
    String s = personInAGroup[i];
    for (int j = 0; j < s.length(); j++) {
      if ((s.charAt(j) + "").equals(",")) {
        count++;
      }
    }
    return count;
  }

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
}
