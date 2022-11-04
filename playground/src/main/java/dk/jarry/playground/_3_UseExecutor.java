package dk.jarry.playground;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;


public interface _3_UseExecutor {

  static void main(String[] args) throws ExecutionException, InterruptedException {

    var executor = Executors.newFixedThreadPool(4);
    // var executor = Executors.newVirtualThreadPerTaskExecutor();

    var future1 = executor.submit(() -> {
      Thread.sleep(10);
      return 1;
    });
    var future2 = executor.submit(() -> {
      Thread.sleep(1_000);
      return 2;
    });
    executor.execute(new Foo(42));
    executor.shutdown();
    var result = future1.get() + future2.get();
    System.out.println(result);

  }

  class Foo implements Runnable {
    Integer number = 0;
    public Foo(Integer number) {
      this.number = number;
    }
    @Override
    public void run() {
      System.out.println(Foo.class.getName() + " : " + number);
    }
  }

}
