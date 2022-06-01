package com.pantifik.algorithms.sorting.binary_insertion;

import static java.util.Arrays.binarySearch;
import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;

public class BinaryInsertion implements Sorting {

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
      int j = Math.abs(binarySearch(result, 0, i, current, comparator) + 1);
      System.arraycopy(result, j, result, j + 1, i - j);
      result[j] = current;
    }
    return result;
  }
}
