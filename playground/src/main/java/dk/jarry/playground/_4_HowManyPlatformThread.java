package dk.jarry.playground;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public interface _4_HowManyPlatformThread {
  static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    var barrier = new CyclicBarrier(100_000);
    var threads = IntStream.range(0, 100_000)
        .mapToObj(i -> new Thread(() -> {
          try {
            //Thread.sleep(5_000);
            barrier.await();
          } catch (InterruptedException | BrokenBarrierException e) {
            throw new AssertionError(e);
          }
        }))
        .toList();
    var i = 0;
    for (var thread: threads) {
      System.out.println(i++);
      thread.start();
    }
    for (var thread : threads) {
      thread.join();
    }
  }
}
