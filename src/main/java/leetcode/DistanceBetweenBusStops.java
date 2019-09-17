package year2019.practice.leetcode;

public class DistanceBetweenBusStops {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
    System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(arr, 0, 2));
  }

  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int ans1 = 0;
    for (int i = start; i != destination; i = (i + 1) % distance.length) {
      ans1 += distance[i];
    }
    int ans2 = 0;
    for (int i = destination; i != start; i = (i + 1) % distance.length) {
      ans2 += distance[i];
    }
    return Math.min(ans1, ans2);
  }
}
