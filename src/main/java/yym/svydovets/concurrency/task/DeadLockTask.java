package yym.svydovets.concurrency.task;

import lombok.SneakyThrows;

public class DeadLockTask {

  @SneakyThrows
  public static void main(String[] args) {
    var first = new DeadLock("first");
    var second = new DeadLock("second");

    var firstThread = new Thread(() -> first.checkOtherThread(second));
    firstThread.start();

    Thread.sleep(200);

    var secondThread = new Thread(() -> second.checkOtherThread(first));
    secondThread.start();

    System.out.println("First thread state" + firstThread.getState());
    System.out.println("Second thread state" + secondThread.getState());

    System.out.println("Main thread is finished: " + Thread.currentThread().getName());
  }

  public static class DeadLock {
    private String name;

    public DeadLock(String name) {
      this.name = name;
    }

    @SneakyThrows
    public synchronized void checkOtherThread(DeadLock other) {
      final Thread current = Thread.currentThread();
      System.out.println("Current state " + this.name + ": " + current.getState());
      System.out.println("Checking other thread in a thread: " + current.getName() + ", name: " + name);
      Thread.sleep(1000);
      other.action();
      System.out.println("Current state " + this.name + ": " + current.getState());
      System.out.println("Leaving checkOtherThread: " + current.getName() + ", name: " + name);
    }

    public synchronized void action() {
      System.out.println("Action inside thread: " + Thread.currentThread().getName() + ", name: " + name);
      System.out.println("Leaving action in the thread: " + Thread.currentThread().getName() + ", name: " + name);
    }
  }

}
