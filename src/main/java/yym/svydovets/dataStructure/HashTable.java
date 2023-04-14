package yym.svydovets.dataStructure;

/**
 * A simple implementation of the Hash Table that allows storing a generic key-value pair. The table itself is based
 * on the array of {@link Node} objects.
 * <p>
 * An initial array capacity is 16.
 * <p>
 * Every time a number of elements is equal to the array size that tables gets resized
 * (it gets replaced with a new array that it twice bigger than before). KEY.g. resize operation will replace array
 * of size 16 with a new array of size 32. PLEASE NOTE that all elements should be reinserted to the new table to make
 * sure that they are still accessible  from the outside by the same key.
 *
 * @param <KEY> key type parameter
 * @param <VALUE> value type parameter
 */
public class HashTable<KEY, VALUE> {

  int capacity = 16;
  int size = 0;
  Node<KEY, VALUE>[] arr = null;

  @SuppressWarnings({"unchecked", "rawtype"})
  public HashTable() {
    arr = new Node[capacity];
  }

  /**
   * Puts a new element to the table by its key. If there is an existing element by such key then it gets replaced
   * with a new one, and the old value is returned from the method. If there is no such key then it gets added and
   * null value is returned.
   *
   * @param key   element key
   * @param value element value
   * @return old value or null
   */
  public VALUE put(KEY key, VALUE value) {

    if (size >= arr.length) {
      resize(arr);
    }

    return insertOrReplaceValue(key, value);
  }



  private VALUE insertOrReplaceValue(KEY key, VALUE value) {
    int idx = 0;

    if (key != null) {
      idx = Math.abs(key.hashCode() * key.toString().length() % arr.length);
    }

    Node<KEY, VALUE> newNode = new Node<>(key, value);
    Node<KEY, VALUE> existedNode = arr[idx];

    if (existedNode == null) {
      arr[idx] = newNode;
      size++;
      return null;
    }

    final VALUE valueFromDuplicatedKey = findValueFromDuplicatedKey(key, value, existedNode);
    if (valueFromDuplicatedKey != null) {
      return valueFromDuplicatedKey;
    }

    while (existedNode.hasNext()) {
      existedNode = existedNode.getNext();
      final VALUE valueToReturn = findValueFromDuplicatedKey(key, value, existedNode);
      if (valueToReturn != null) {
        return valueToReturn;
      }
    }

    existedNode.setNext(newNode);
    size++;
    return null;
  }

  @SuppressWarnings("unchecked")
  private void resize(Node<KEY, VALUE>[] entries) {
    capacity *= 2;
    arr = new Node[capacity];
    for (Node<KEY, VALUE> entry : entries) {
      if (entry != null) {
        insertOrReplaceValue(entry.getKey(), entry.getValue());
      }
    }
  }

  private VALUE findValueFromDuplicatedKey(KEY key, VALUE value, Node<KEY, VALUE> node) {
    if (node.getKey().equals(key)) {
      final VALUE oldValue = node.getValue();
      node.setValue(value);
      return oldValue;
    }
    return null;
  }

  /**
   * Prints a content of the underlying table (array) according to the following format:
   * 0: key1:value1 -> key2:value2
   * 1:
   * 2: key3:value3
   * ...
   */
  public void printTable() {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i + ": " + printNodesInArray(arr[i]));
    }
  }

  private String printNodesInArray(Node<KEY, VALUE> node) {
    if (node == null) return "";
    String next = " -> ", delimiter = ":";
    StringBuilder sb = new StringBuilder();
    if (node.hasNext()) {
      while (node.hasNext()) {
        appendLine(sb, node, delimiter).append(next);
        node = node.getNext();
      }
      appendLine(sb, node, delimiter);
    } else {
      appendLine(sb, node, delimiter);
    }
    return sb.toString();
  }

  private StringBuilder appendLine(StringBuilder sb, Node<KEY, VALUE> node, String delimiter) {
    return sb.append(node.getKey()).append(delimiter).append(node.getValue());
  }

  private static class Node<K, V> {
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

}