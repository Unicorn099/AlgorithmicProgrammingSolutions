package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

  private Map<Integer, List<Integer>> adjList;
  private int visited[];

  public static void main(String[] args) {
    CourseSchedule courseSchedule = new CourseSchedule();
    int[][] arr1 = {{1, 0}};
    int[][] arr2 = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
    int[][] arr3 = {{1, 2}, {2, 3}, {3, 4}, {0, 1}};
    System.out.println(courseSchedule.canFinish(2, arr1));
    System.out.println(courseSchedule.canFinish(4, arr2));
    System.out.println(courseSchedule.canFinish(5, arr3));
  }


  public boolean canFinish(int numCourses, int[][] prerequisites) {
    adjList = new HashMap<>();
    int len = prerequisites.length;
    for (int i = 0; i < len; i++) {
      List<Integer> orDefault = adjList.getOrDefault(prerequisites[i][0], new ArrayList<>());
      orDefault.add(prerequisites[i][1]);
      adjList.put(prerequisites[i][0], orDefault);
    }

    for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
      int x = entry.getKey();
      for (Integer ii : entry.getValue()) {
        visited = new int[numCourses];
        visited[ii]=1;
        boolean res = checkIfCycleExists(ii, x);
        if (res) {
          return false;
        }
      }
    }

    return true;

  }

  public boolean checkIfCycleExists(int x, int currentNode) {
    if (adjList.containsKey(x)) {
      for (Integer ii : adjList.get(x)) {
        if (visited[ii]!=1) {
          if (ii == currentNode) {
            return true;
          } else {
            visited[ii]=1;
            return checkIfCycleExists(ii, currentNode);
          }
        }
      }
      return false;
    } else {
      return false;
    }
  }
}
