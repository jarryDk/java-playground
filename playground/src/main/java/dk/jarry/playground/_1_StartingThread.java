package dk.jarry.playground;

public interface _1_StartingThread {

  public void getFoo();

  static void main(String[] args) throws InterruptedException {

    // Platform threads
    var pthread = new Thread(() -> {
      System.out.println("Platform " + Thread.currentThread());
    });
    pthread.start();
    pthread.join();

    // Virtual threads
    var vthread = Thread.startVirtualThread(() -> {
      System.out.println("Virtual " + Thread.currentThread());
    });
    vthread.join();
  }

}
