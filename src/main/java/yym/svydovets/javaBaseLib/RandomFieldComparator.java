package yym.svydovets.javaBaseLib;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * By default it compares only accessible fields, but this can be configured via a constructor property. If no field is
 * available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 */
public class RandomFieldComparator<T> implements Comparator<T> {

  private Class<T> clazz;
  private Field field;

  public RandomFieldComparator(Class<T> targetType) {
    this(targetType, true);
  }

  /**
   * A constructor that accepts a class and a property indicating which fields can be used for comparison. If property
   * value is true, then only public fields or fields with public getters can be used.
   *
   * @param targetType                  a type of objects that may be compared
   * @param compareOnlyAccessibleFields config property indicating if only publicly accessible fields can be used
   */
  public RandomFieldComparator(Class<T> targetType, boolean compareOnlyAccessibleFields) {
    clazz = targetType;

    var fields =  compareOnlyAccessibleFields ? targetType.getFields() : targetType.getDeclaredFields();

    if (fields.length > 0) {
      field = Arrays.stream(fields)
          .filter(f -> !f.getType().isPrimitive() || !Comparable.class.isAssignableFrom(clazz))
          .skip(ThreadLocalRandom.current().nextInt(fields.length))
          .findFirst()
          .orElse(fields[0]);
    }
  }

  /**
   * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
   * for the fields, and it treats null value grater than a non-null value (nulls last).
   */
  @SneakyThrows
  @Override
  public int compare(T o1, T o2) {
    Objects.requireNonNull(field);
    field.setAccessible(true);
    var field1 = (Comparable) field.get(o1);
    var field2 = (Comparable) field.get(o2);
    field.setAccessible(false);

    if (field1 == null) return 1;
    if (field2 == null) return -1;

    return field1.compareTo(field2);
  }

  /**
   * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
   * of the type T, and the second parameter is the comparing field name.
   *
   * @return a predefined statement
   */
  @Override
  public String toString() {
    if (field == null) {
      return String.format("Compared class %s has no acceptable fields to compare.", clazz.getSimpleName());
    }
    return String.format("Compared class %s field=%s", clazz.getSimpleName(), field.getName());
  }
}