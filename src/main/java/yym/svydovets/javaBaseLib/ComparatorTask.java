package yym.svydovets.javaBaseLib;

import java.util.Comparator;
import java.util.function.Function;

/*
Implement  a custom method createComparatorComparing [10 min]
Declare a generic method createComparatorComparing that accepts an extraction function and returns a comparator
Specify method type parameters to make sure that extraction function accepts a target type as input param and returns a comparable type
Implement a comparing logic based on values that were computed using the extraction function
Return comparator instance
 */
public class ComparatorTask {

  public <T, R extends Comparable<? super R>> Comparator<T> createComparatorComparing(Function<? super T, ? extends R> func) {
    return (o1, o2) -> (func.apply(o1).compareTo(func.apply(o2)));
  }

  /*
  * Declare another composeComparatorThenComparing that accepts a comparator and an extraction function
  * Specify method type parameters to make sure that extraction function accepts a target type as input param and returns a comparable type
  * Implement a comparing logic using the given comparator, and in case comparing values are equals, compare values that are computed based on the extraction function
  * Return a new comparator instance
  *
   */
  public <T, R extends Comparable<R>> Comparator<T> composeComparatorThenComparing(
      Comparator<T> comparator, Function<T, R> func) {
    return (o1, o2) -> {
      if (comparator.compare(o1, o2) == 0) {
        return createComparatorComparing(func).compare(o1, o2);
      }
      return comparator.compare(o1, o2);
    };
  }

}
