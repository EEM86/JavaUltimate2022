package yym.svydovets.algorithm.task.numbers;

import static java.time.LocalDateTime.now;

import org.apache.commons.lang3.NotImplementedException;

public class LRUCache {

  public LRUCache(int capacity) {
  }

  public void put(Object o1, Object o2) {
  }

  public Object get(Object key) {
    throw new NotImplementedException();
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(1));    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2));    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1));    // return -1 (not found)
    System.out.println(lRUCache.get(3));    // return 3
    System.out.println(lRUCache.get(4));    // return 4
  }

}
