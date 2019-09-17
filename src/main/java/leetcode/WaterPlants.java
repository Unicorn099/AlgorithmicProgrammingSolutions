package year2019.practice.leetcode;

public class WaterPlants {

  public static void main(String[] args) {
    int[] arr = {2, 4, 5, 2, 2};
    int capacity = 6;
    WaterPlants waterPlants = new WaterPlants();
    System.out.println(waterPlants.steps(arr, capacity));
  }

  public int steps(int[] arr, int capacity) {
    int steps = 0;
    int currentCapacity = capacity;
    int currentPosition = 0;
    for (int i = 0; i < arr.length; ) {
      if (arr[i] <= currentCapacity) {
        steps += ((i + 1) - currentPosition);
        currentCapacity -= arr[i];
        currentPosition++;
        i++;
      } else {
        currentCapacity = capacity;
        steps += 2 * i;
      }
    }
    return steps;
  }
}
