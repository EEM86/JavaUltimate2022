package yym.svydovets.concurrency.task;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

// Implement a deadlock.
// System.out.println("Hello from " + Thread.currentThread().getName()); - create threads with 4+ solutions
public class DeadLockTask {

  private static Object lock1 = new Object();
  private static Object lock2 = new Object();

  @SneakyThrows
  public static void main(String[] args) {
//    createThreads();
    var t1 = new Thread(DeadLockTask::actionFirst, "FirstThread");
    var t2 = new Thread(DeadLockTask::actionSecond, "SecondThread");

    t1.start();
    t2.start();

    new Thread(() -> checkState(t1, t2)).start();
  }

  @SneakyThrows
  private static void actionFirst() {
    var name = Thread.currentThread().getName();
    System.out.println(name);
    //todo implement correct locking
  }

  @SneakyThrows
  private static void actionSecond() {
    var name = Thread.currentThread().getName();
    System.out.println(name);
    //todo implement correct locking
  }

  @SneakyThrows
  private static void checkState(Thread t1, Thread t2) {
    while (true) {
      System.out.println(Thread.currentThread().getName() + " checking other threads:");
      System.out.println(t1.getName() + " with state " + t1.getState());
      System.out.println(t2.getName() + " with state " + t2.getState());
      Thread.sleep(1000);
    }
  }

  @SneakyThrows
  private static void createThreads() {

  }

}
