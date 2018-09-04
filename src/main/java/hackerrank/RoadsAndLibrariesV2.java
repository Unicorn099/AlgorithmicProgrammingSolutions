package hackerrank;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class RoadsAndLibrariesV2 {

  // Complete the roadsAndLibraries function below.
  static Map<Integer, TreeSet<Integer>> adj;
  static boolean[] marked;

  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

    adj = new LinkedHashMap<Integer, TreeSet<Integer>>();
    long ans = 0;

    for (int i = 0; i < cities.length; i++) {
      TreeSet<Integer> xx = adj.getOrDefault(cities[i][0], new TreeSet<>());
      xx.add(cities[i][1]);
      adj.put(cities[i][0], xx);

      xx = adj.getOrDefault(cities[i][1], new TreeSet<>());
      xx.add(cities[i][0]);
      adj.put(cities[i][1], xx);

    }

    marked = new boolean[n + 1];
    ans = findTheConnectedComponents(c_lib, c_road);

    for(int i=adj.size();i<n;i++){
      ans+=c_lib;
    }

    return ans;
  }

  private static long findTheConnectedComponents(int c_lib, int c_road) {
    long charges = 0;
    for (Map.Entry<Integer, TreeSet<Integer>> a : adj.entrySet()) {
      if (!marked[a.getKey()]) {
        marked[a.getKey()] = true;

        charges += c_lib;
//        List<Integer> vertex = new ArrayList<>();
//        vertex.add(a.getKey());
        charges += dfs(a.getKey(),  c_lib, c_road);
      }

    }
    return charges;
  }

  private static int dfs(int key,  int c_lib, int c_road) {
    int charges = 0;
    TreeSet<Integer> integers = adj.get(key);
    for (Integer kk : integers) {
      if (!marked[kk]) {
        if (c_lib < c_road) {
          charges += c_lib;
        } else {
          charges += c_road;
        }
//        vertex.add(kk);
        marked[kk] = true;
        charges += dfs(kk, c_lib, c_road);
      }
    }
    return charges;
  }

//  private static int dfs(TreeSet<Integer> key, List<Integer> vertex, int c_lib, int c_road) {
//    int charges = 0;
//    for (Integer kk : key) {
//      if (!marked[kk]) {
//        if (c_lib < c_road) {
//          charges += c_lib;
//        } else {
//          charges += c_road;
//        }
//        vertex.add(kk);
//        marked[kk] = true;
//        charges += dfs(adj.get(kk), vertex, c_lib, c_road);
//      }
//    }
//    return charges;
//  }

  final static String WORK_DIR = "E:\\testingtestingtesting123\\Rank\\";

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(new FileReader(WORK_DIR
        + "RoadsAndLibraries.txt"));

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
      System.out.println(result);

    }

    scanner.close();
  }
}

