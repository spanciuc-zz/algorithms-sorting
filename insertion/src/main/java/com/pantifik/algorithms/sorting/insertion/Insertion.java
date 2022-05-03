package com.pantifik.algorithms.sorting.insertion;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Insertion implements Sorting {

  @Override
  public <T extends Comparable<T>> T[] sortAscending(T[] array) {
    return doSort(array, Sorting.comparator());
  }

  @Override
  public <T extends Comparable<T>> T[] sortDescending(T[] array) {
    return doSort(array, Sorting.reverseComparator());
  }

  private <T extends Comparable<T>> T[] doSort(T[] array, Comparator<T> comparator) {
    if (array.length == 0 || array.length == 1) {
      return Arrays.copyOf(array, array.length);
    }
    var result = Arrays.copyOf(array, array.length);
    for (var i = 1; i < result.length; i++) {
      T current = result[i];
      int j = i;
      while (j > 0 && Objects.compare(current, result[j - 1], comparator) < 0) {
        result[j] = result[j - 1];
        j--;
      }
      result[j] = current;
    }
    return result;
  }
}
