package year2019.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {

  private Map<Integer, Integer>[] arr;
  private int snap_id;

  public SnapshotArray(int length) {
    this.arr = new HashMap[length];
    this.snap_id = 0;
  }

  public void set(int index, int val) {
    Map<Integer, Integer> integerIntegerMap = this.arr[index];
    if (integerIntegerMap == null) {
      integerIntegerMap = new HashMap<>();
    }
    integerIntegerMap.put(this.snap_id, val);
    this.arr[index] = integerIntegerMap;
  }

  public int snap() {
    return this.snap_id++;
  }

  public int get(int index, int snap_id) {
    Map<Integer, Integer> integerIntegerMap = this.arr[index];
    if (integerIntegerMap == null) {
      return 0;
    }
    while (!integerIntegerMap.containsKey(snap_id) && snap_id >= 0) {
      snap_id--;
    }
    if (snap_id < 0) {
      return 0;
    } else {
      return integerIntegerMap.get(snap_id);
    }
  }

  public static void main(String[] args) {
    SnapshotArray obj = new SnapshotArray(4);
    obj.snap();
    obj.snap();
    obj.snap();
    int i = obj.get(3, 1);
    System.out.println(i);
    obj.set(2, 4);
    obj.snap();
    obj.set(1, 4);
  }
}