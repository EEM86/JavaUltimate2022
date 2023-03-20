package yym.svydovets.concurrency.task;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
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
    synchronized (lock1) {
      System.out.println(name + " locks lock1");
      Thread.sleep(1000);
      synchronized (lock2) {
        System.out.println(name + " locks lock2");
      }
    }
  }

  @SneakyThrows
  private static void actionSecond() {
    var name = Thread.currentThread().getName();
    System.out.println(name);
    synchronized (lock2) {
      System.out.println(name + " locks lock2");
      Thread.sleep(1000);
      synchronized (lock1) {
        System.out.println(name + " locks lock1");
      }
    }
  }

  @SneakyThrows
  private static void checkState(Thread t1, Thread t2) {
    System.out.println(Thread.currentThread().getName() + " checking other threads:");
    while (true) {
      System.out.println(t1.getName() + " with state " + t1.getState());
      System.out.println(t2.getName() + " with state " + t2.getState());
      Thread.sleep(1000);
    }
  }

  @SneakyThrows
  private static void createThreads() {
    var t1 = new Thread();
    t1.start();
    System.out.println("t1: " + t1.getName() + " in state " + t1.getState());

    var t2 = new Thread(() -> {
      System.out.println("Thread " + Thread.currentThread().getName() + " in state " + Thread.currentThread().getState());
    });
    t2.start();

   Executors.newFixedThreadPool(1).execute(() -> System.out.println(
       "Thread " + Thread.currentThread().getName() + " in state " + Thread.currentThread().getState()));

    var t4 = new CompletableFuture<String>();
    t4.completeAsync(() -> {
      return "Thread " + Thread.currentThread().getName() + " in state " + Thread.currentThread().getState();
    });
    System.out.println(t4.get());

  }

}
