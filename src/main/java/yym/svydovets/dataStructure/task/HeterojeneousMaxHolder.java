package yym.svydovets.dataStructure.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeterojeneousMaxHolder {

  List<Container<?>> items;

  public HeterojeneousMaxHolder() {
    items = new ArrayList<>();
  }

  public HeterojeneousMaxHolder(List<Container<?>> items) {
    this.items = items;
  }

  public <T extends Comparable<? super T>> void put(Class<T> clazz, T element) {
    var c = new Container<T>(clazz, element);
    System.out.println("Items before add: " + items.size());

    if (isContain(clazz)) {
      System.out.println("Items: " + items.size());
      items.stream()
          .filter(e -> e.getClazz().isAssignableFrom(c.getClazz()))
          .filter(e -> isChangesNeeded(clazz, element, e))
          .map(result -> getChangedElement(result, clazz.cast(c.getElement())))
          .findAny()
          .orElse(null);
          return;
    }
    items.add(c);
  }

  private <T> boolean isContain(Class<T> clazz) {
    return items.stream()
        .anyMatch(i -> i.getClazz().isAssignableFrom(clazz));
  }

  private <T extends Comparable<? super T>> boolean isChangesNeeded(Class<T> clazz, T element, Container<?> e) {
    System.out.println(element.compareTo(clazz.cast(e.getElement())) > 0);
    return element.compareTo(clazz.cast(e.getElement())) > 0;
  }

  public <T> T getMax(Class<T> clazz) {
    return items.stream()
        .filter(i -> i.getClazz().isAssignableFrom(clazz))
//        .peek(e -> System.out.println("second: " + e.getClazz() + " : " + e.getElement()))
        .map(e -> clazz.cast(e.getElement()))
        .findAny()
        .orElse(null);
  }

  private <T extends Comparable<? super T>> Object getChangedElement(Container<?> container, T element) {
    System.out.println("Element:" + element);
    var castedContainer = (Container<T>) container;
    castedContainer.setElement(element);
    return castedContainer;
  }


  public static void main(String[] args) {
    final HeterojeneousMaxHolder map = new HeterojeneousMaxHolder();
    map.put(Integer.class, 3);
    map.put(Integer.class, 7);
    map.put(Integer.class, 6);
    map.put(String.class, "3");
    map.put(String.class, "4");
    map.put(String.class, "1");
    System.out.println("Size:" + map.items.size());
    System.out.println(map.getMax(Integer.class));
    System.out.print(map.getMax(String.class));
  }

  @Data
  @AllArgsConstructor
  @EqualsAndHashCode
  private class Container<T> {
    Class<T> clazz;
    T element;

  }
}
