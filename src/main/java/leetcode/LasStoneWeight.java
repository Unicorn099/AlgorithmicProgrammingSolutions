package year2019.practice.leetcode;

import java.util.PriorityQueue;

public class LasStoneWeight {

  public static void main(String[] args) {
    LasStoneWeight l = new LasStoneWeight();
    int[] arr = {2, 7, 4, 1, 8};
    System.out.print(l.lastStoneWeight(arr));
  }

  public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < stones.length; i++) {
      priorityQueue.add(stones[i]);
    }
    while (!priorityQueue.isEmpty()) {

      if (priorityQueue.size() >= 2) {
        int x = priorityQueue.poll();
        int y = priorityQueue.poll();
        int diff = Math.abs(x - y);
        if (diff != 0) {
          priorityQueue.add(diff);
        }
      } else {
        break;
      }
    }
    if (priorityQueue.size() == 0) {
      return 0;
    } else {
      return priorityQueue.peek();
    }
  }
}
