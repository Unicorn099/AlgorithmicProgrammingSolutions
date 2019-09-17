package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

  public static void main(String[] args) {
    CourseScheduleII courseScheduleII = new CourseScheduleII();
//    int[][] prerequisites1 = {{0, 1}, {1, 2}, {2, 5}, {3, 0}, {3, 4}, {4, 1}, {4, 2}};
//    int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    int[][] prerequisites3 = {{0,1},{1, 0}};
//    int[] order1 = courseScheduleII.findOrder(6, prerequisites1);
//    Arrays.stream(order1).forEach(System.out::println);
//    int[] order2 = courseScheduleII.findOrder(4, prerequisites2);
//    Arrays.stream(order2).forEach(System.out::println);
    int[] order3 = courseScheduleII.findOrder(2, prerequisites3);
    Arrays.stream(order3).forEach(System.out::println);
  }

  Map<Integer, List<Integer>> adjList;
  int[] visited;


  public int[] findOrder(int numCourses, int[][] prerequisites) {
    adjList = new HashMap<>();
    visited = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> orDefault = adjList.getOrDefault(prerequisites[i][0], new ArrayList<>());
      orDefault.add(prerequisites[i][1]);
      adjList.put(prerequisites[i][0], orDefault);
    }

    int[] ans = new int[numCourses];
    List<Integer> mainArray = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
      if (visited[entry.getKey()] != 2) {
        List<Integer> order = new ArrayList<>();
        List<Integer> preRequiredCourse = entry.getValue();
        visited[entry.getKey()] = 1;
        for (Integer i : preRequiredCourse) {
          if (visited[i] == 0) {
            visited[i] = 1;
            List<Integer> ord = callRec(i);
            if (ord == null) {
              return new int[]{};
            } else {
              order.addAll(ord);
              order.add(i);
            }
            visited[i] = 2;
          } else if (visited[i] == 1) {
            return new int[numCourses];
          }
        }
        visited[entry.getKey()] = 2;
        order.add(entry.getKey());
        mainArray.addAll(order);
      }
    }
    int k = 0;
    for (Integer ii : mainArray) {
      ans[k++] = ii;
    }
    for(int i=0;i<numCourses;i++){
      if(visited[i]==0){
        ans[k++]=i;
      }
    }
    return ans;
  }

  private List<Integer> callRec(int preRequiredCourse) {

    List<Integer> ans = new ArrayList<>();
    if (adjList.containsKey(preRequiredCourse)) {
      for (Integer integer : adjList.get(preRequiredCourse)) {
        if (visited[integer] == 0) {
          visited[integer] = 1;
          List<Integer> ord = callRec(integer);
          if (ord == null) {
            return null;
          } else {
            ans.addAll(ord);
            ans.add(integer);
            visited[integer] = 2;
          }
        } else if (visited[integer] == 1) {
          return null;
        }
      }
      return ans;
    } else {
      return ans;
    }
  }
}
