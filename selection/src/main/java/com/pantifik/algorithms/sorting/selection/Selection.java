package com.pantifik.algorithms.sorting.selection;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Selection implements Sorting {

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
    for (var i = 0; i < sorted.length; i++) {
      T target = sorted[i];
      int targetIndex = i;
      for (var j = i + 1; j < sorted.length; j++) {
        if (Objects.compare(sorted[j], target, comparator) < 0) {
          target = sorted[j];
          targetIndex = j;
        }
      }
      swap(sorted, i, targetIndex);
    }
    return sorted;
  }

  private <T extends Comparable<T>> void swap(T[] array, int from, int to) {
    T temp = array[to];
    array[to] = array[from];
    array[from] = temp;
  }
}
