package com.pantifik.algorithms.sorting.base;

import java.util.Comparator;

/**
 * Provides methods for sorting.
 */
public interface Sorting {

  /**
   * A null safe comparator.
   * <p>
   * Nulls are considered equal, and lowest object.
   *
   * @param <T>
   *     the type of the objects.
   * @return a null safe comparator.
   */
  static <T extends Comparable<T>> Comparator<T> comparator() {
    return (o1, o2) -> {
      if (o1 == null) {
        if (o2 == null) {
          return 0;
        } else {
          return -1;
        }
      }
      if (o2 == null) {
        return 1;
      }
      return o1.compareTo(o2);
    };
  }

  /**
   * A null safe reverse comparator.
   * <p>
   * Nulls are considered equal, and higher object.
   *
   * @param <T>
   *     the type of the objects.
   * @return a null safe comparator.
   */
  static <T extends Comparable<T>> Comparator<T> reverseComparator() {
    return (o1, o2) -> {
      if (o1 == null) {
        if (o2 == null) {
          return 0;
        } else {
          return 1;
        }
      }
      if (o2 == null) {
        return -1;
      }
      return -1 * o1.compareTo(o2);
    };
  }

  /**
   * Sorts the given array in ascending order, see {@link #sortAscending(T[])}.
   *
   * @param array
   *     - the array to be sorted.
   * @param <T>
   *     type of the elements in the array.
   * @return new array instance with sorted elements.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  default <T extends Comparable<T>> T[] sort(T[] array) {
    return this.sortAscending(array);
  }

  /**
   * Sorts the given array in ascending order.
   *
   * @param array
   *     - the array to be sorted.
   * @param <T>
   *     type of the elements in the array.
   * @return @return new array instance with sorted elements.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  <T extends Comparable<T>> T[] sortAscending(T[] array);

  /**
   * Sorts the given array in descending order.
   *
   * @param array
   *     - the array to be sorted.
   * @param <T>
   *     type of the elements in the array.
   * @return @return new array instance with sorted elements.
   *
   * @throws NullPointerException
   *     if the given array is null.
   */
  <T extends Comparable<T>> T[] sortDescending(T[] array);

}
