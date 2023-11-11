package yym.svydovets.algorithm.task.numbers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;

public class LRUCache {
  private Map<Integer, Node> cache;
  private int capacity;

  private Node left;
  private Node right;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();

    //left = LRU , right = most recent
    left = new Node(0, 0);
    right = new Node(0, 0);
    left.next = right;
    right.prev = left;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
      insert(cache.get(key));
      return cache.get(key).val;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    cache.put(key, new Node(key, value));
    insert(cache.get(key));

    if (cache.size() > capacity) {
      // remove from the list and delete the LRU from the hashmap
      Node lru = left.next;
      remove(lru);
      cache.remove(lru.key);
    }
  }

  // remove node from list
  public void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  // insert node at right
  public void insert(Node node) {
    Node prev = right.prev;
    Node next = right;

    prev.next = node;
    next.prev = node;

    node.next = next;
    node.prev = prev;
  }

  private class Node {

    private int key;
    private int val;

    Node next;
    Node prev;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public static void main(String[] args) {
    LruCacheOptimal lRUCache = new LruCacheOptimal(2);
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

  static class LruCacheOptimal extends LinkedHashMap<Integer,Integer> {
    private int capacity = 0;

    public LruCacheOptimal(int capacity) {
      super(capacity,0.75F,true);
      this.capacity = capacity;

    }

    public int get(int key) {
      return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
      super.put(key,value);
    }

    public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldestChild) {
      return size() > this.capacity;
    }
  }

}
