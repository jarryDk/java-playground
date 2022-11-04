package dk.jarry.playground;


public interface _2_StartingThreadWithBuilder {
  static void main(String[] args) throws InterruptedException {

    // Platform thread
    var pthread = Thread.ofPlatform()
        .name("platform-", 0)
        .start(() -> {
          System.out.println("Platform " + Thread.currentThread());
        });
    pthread.join();

    // Virtual thread
    var vthread = Thread.ofVirtual()
        .name("virtual-", 0)
        .start(() -> {
          System.out.println("Virtual " + Thread.currentThread());
        });
    vthread.join();
  }
}
