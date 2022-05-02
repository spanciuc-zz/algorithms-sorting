package com.pantifik.algorithms.sorting.merge;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * The merge sort implementation.
 * <p>
 * The complexity is O(n*log(n)) average and worst case.
 */
public class Merge implements Sorting {
  @Override
  public <T extends Comparable<T>> T[] sortAscending(T[] array) {
    return doSort(array, Sorting.comparator());
  }

  @Override
  public <T extends Comparable<T>> T[] sortDescending(T[] array) {
    return doSort(array, Sorting.reverseComparator());
  }

  private <T extends Comparable<T>> T[] doSort(T[] array, Comparator<T> comparator) {
    var result = Arrays.copyOf(array, array.length);
    var helper = (T[]) Array.newInstance(array.getClass()
        .getComponentType(), array.length);
    mergesort(result, helper, 0, array.length - 1, comparator);
    return result;
  }

  private <T extends Comparable<T>> void mergesort(T[] result, T[] helper, int lowIndex,
      int highIndex, Comparator<T> comparator) {
    if (lowIndex < highIndex) {
      int midIndex = (lowIndex + highIndex) / 2;
      mergesort(result, helper, 0, midIndex, comparator);
      mergesort(result, helper, midIndex + 1, highIndex, comparator);
      merge(result, helper, lowIndex, midIndex, highIndex, comparator);
    }
  }

  private <T extends Comparable<T>> void merge(T[] result, T[] helper, int lowIndex, int midIndex,
      int highIndex, Comparator<T> comparator) {
    System.arraycopy(result, lowIndex, helper, lowIndex, highIndex - lowIndex + 1);
    int currentLeft = lowIndex;
    int currentRight = midIndex + 1;
    int current = lowIndex;
    while (currentLeft <= midIndex && currentRight <= highIndex) {
      if (Objects.compare(helper[currentLeft], helper[currentRight], comparator) <= 0) {
        result[current++] = helper[currentLeft++];
      } else {
        result[current++] = helper[currentRight++];
      }
    }
    System.arraycopy(helper, currentLeft, result, current, midIndex - currentLeft + 1);
  }
}
