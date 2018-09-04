package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class RoadsAndLibraries {

  // Complete the roadsAndLibraries function below.
  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

    Map<Integer, TreeSet<Integer>> adj = new LinkedHashMap<Integer, TreeSet<Integer>>();
    long ans = 0;

    int maxDegree = -1;
    int maxDegreeIndex = -1;
    for (int i = 0; i < n; i++) {
      TreeSet<Integer> xx = adj.getOrDefault(cities[i][0], new TreeSet<>());
      xx.add(cities[i][1]);
      adj.put(cities[i][0], xx);

      if (xx.size() > maxDegree) {
        maxDegree = xx.size();
        maxDegreeIndex = cities[i][0];
      }
      xx = adj.getOrDefault(cities[i][1], new TreeSet<>());
      xx.add(cities[i][0]);
      adj.put(cities[i][1], xx);

      if (xx.size() > maxDegree) {
        maxDegree = xx.size();
        maxDegreeIndex = cities[i][1];
      }

    }

    boolean[] marked = new boolean[n + 1];
    List<List<Integer>> res = findTheConnectedComponents(adj, marked, c_lib, c_road);

    return ans;
  }

  private static List<List<Integer>> findTheConnectedComponents(Map<Integer, TreeSet<Integer>> adj, boolean[] marked, int c_lib, int c_road) {
    List<List<Integer>> verticesInConnectedComponent = new ArrayList<>();
    long charges = 0;
    for (Map.Entry<Integer, TreeSet<Integer>> a : adj.entrySet()) {
      if (!marked[a.getKey()]) {
        marked[a.getKey()] = true;

        charges += c_lib;
        List<Integer> vertex = new ArrayList<>();
        vertex.add(a.getKey());
        charges += dfs(a.getValue(), adj, marked, vertex, c_lib, c_road);
        verticesInConnectedComponent.add(vertex);
      }

    }
    return verticesInConnectedComponent;
  }

  private static int dfs(TreeSet<Integer> key, Map<Integer, TreeSet<Integer>> adj, boolean[] marked, List<Integer> vertex, int c_lib, int c_road) {
    int charges = 0;
    for (Integer kk : key) {
      if (!marked[kk]) {
        if (c_lib < c_road) {
          charges += c_lib;
        }
        vertex.add(kk);
        marked[kk] = true;
        charges += dfs(adj.get(kk), adj, marked, vertex, c_lib, c_road);
      }
    }
    return charges;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {


    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] nmC_libC_road = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nmC_libC_road[0]);

      int m = Integer.parseInt(nmC_libC_road[1]);

      int c_lib = Integer.parseInt(nmC_libC_road[2]);

      int c_road = Integer.parseInt(nmC_libC_road[3]);

      int[][] cities = new int[m][2];

      for (int i = 0; i < m; i++) {
        String[] citiesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int citiesItem = Integer.parseInt(citiesRowItems[j]);
          cities[i][j] = citiesItem;
        }
      }

      long result = roadsAndLibraries(n, c_lib, c_road, cities);

    }

    scanner.close();
  }
}

