package com.pantifik.algorithms.sorting.bubble;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * The bubble sort implementation.
 * <p>
 * The complexity is O(n*n) average and worst case.
 */
public class Bubble implements Sorting {

  @Override
  public <T extends Comparable<T>> T[] sort(T[] array) {
    return sortAscending(array);
  }

  @Override
  public <T extends Comparable<T>> T[] sortAscending(T[] array) {
    return doSort(array, Sorting.comparator());
  }

  @Override
  public <T extends Comparable<T>> T[] sortDescending(T[] array) {
    return doSort(array, Sorting.reverseComparator());
  }

  private <T extends Comparable<T>> T[] doSort(T[] array, Comparator<T> comparator) {
    var sorted = Arrays.copyOf(array, array.length);
    var isSorted = true;
    do {
      isSorted = true;
      for (var i = 0; i < sorted.length - 1; i++) {
        if (Objects.compare(sorted[i], sorted[i + 1], comparator) > 0) {
          isSorted = false;
          swap(sorted, i, i + 1);
        }
      }
    } while (!isSorted);
    return sorted;
  }

  private <T extends Comparable<T>> void swap(T[] array, int from, int to) {
    T temp = array[to];
    array[to] = array[from];
    array[from] = temp;
  }
}
