package year2019.practice.leetcode;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

  private boolean oddPrinted = false;
  private int toggle = 0;

  private int n;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (toggle != 0) {
          try {
//            System.out.println(toggle+"********"+Thread.currentThread());
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        printNumber.accept(0);
        toggle = oddPrinted ? 2 : 1;
        notifyAll();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      synchronized (this) {
        while (toggle != 2) {
          try {
//            System.out.println(toggle+"********"+Thread.currentThread());
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        printNumber.accept(i);
        toggle = 0;
        oddPrinted = false;
        notifyAll();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {

    for (int i = 1; i <= n; i += 2) {
      synchronized (this) {
        while (toggle != 1) {
          try {
//            System.out.println(toggle+"********"+Thread.currentThread());
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        printNumber.accept(i);
        toggle = 0;
        oddPrinted = true;
        notifyAll();
      }
    }
  }
}
