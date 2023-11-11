package yym.svydovets.algorithm.task;


import java.util.HashMap;
import java.util.Map;

public class HeterojeneousMaxHolder {
  // ToDo Implement a multi-type container that holds maximum values.
  //  It should store up to one value per type, should be type-safe
  Map<Class<?>, Object> holder;

  public HeterojeneousMaxHolder() {
    holder = new HashMap<>();
  }

  public HeterojeneousMaxHolder(Map<Class<?>, Object> holder) {
    this.holder = holder;
  }

  public <T extends Comparable<? super T>> void put(Class<T> clazz, T value) {
    final T currentValue = (T) holder.get(clazz);
    if (currentValue == null || currentValue.compareTo(value) < 1) {
      holder.put(clazz, value);
    }

  }

  public <T extends Comparable<? super T>> T getMax(Class<T> clazz) {
    return (T) holder.get(clazz);
  }

  public static void main(String[] args) {
    final HeterojeneousMaxHolder map = new HeterojeneousMaxHolder();
    map.put(Integer.class, 3);
    map.put(Integer.class, 9);
    map.put(Integer.class, 6);
    map.put(String.class, "6");
    map.put(String.class, "8");
    map.put(String.class, "2");
    System.out.println(map.getMax(Integer.class));
    System.out.print(map.getMax(String.class));
  }
}
