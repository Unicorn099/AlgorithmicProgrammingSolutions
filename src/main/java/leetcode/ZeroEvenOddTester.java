package year2019.practice.leetcode;

import java.util.function.IntConsumer;

public class ZeroEvenOddTester {

  public static void main(String[] args) throws InterruptedException {
    ZeroEvenOdd z = new ZeroEvenOdd(2);
    IntConsumer intConsumer = System.out::print;

    Thread t0 = new Thread(() -> {
      try {
        z.zero(intConsumer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread t1 = new Thread(() -> {
      try {
        z.odd(intConsumer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    Thread t2 = new Thread(() -> {
      try {
        z.even(intConsumer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t0.start();
    t1.start();
    t2.start();

    t0.join();
    t1.join();
    t2.join();
  }
}
