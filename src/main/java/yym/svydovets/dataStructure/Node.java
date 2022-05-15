package yym.svydovets.dataStructure;

/**
 * A generic class Node that supports two type params: one for the key and one for the value.
 *
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class Node<K, V> {
  K key;
  V value;
  Node<K, V> next;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public boolean hasNext() {
    return next != null;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public void setNext(Node<K, V> next) {
    this.next = next;
  }

  public Node<K, V> getNext() {
    return next;
  }
}