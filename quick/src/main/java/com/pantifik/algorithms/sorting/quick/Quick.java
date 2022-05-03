package com.pantifik.algorithms.sorting.quick;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Quick implements Sorting {
  @Override
  public <T extends Comparable<T>> T[] sortAscending(T[] array) {
    return doSort(array, Sorting.comparator());
  }

  @Override
  public <T extends Comparable<T>> T[] sortDescending(T[] array) {
    return doSort(array, Sorting.reverseComparator());
  }

  private <T extends Comparable<T>> T[] doSort(T[] array, Comparator<T> comparator) {
    if (array.length == 0) {
      return Arrays.copyOf(array, array.length);
    }
    var result = Arrays.copyOf(array, array.length);
    quickSort(result, 0, result.length - 1, comparator);
    return result;
  }

  private <T extends Comparable<T>> void quickSort(T[] array, int leftIndex, int rightIndex,
      Comparator<T> comparator) {
    int pivotIndex = partition(array, leftIndex, rightIndex, comparator);
    if (leftIndex < pivotIndex - 1) {
      quickSort(array, leftIndex, pivotIndex - 1, comparator);
    }
    if (pivotIndex < rightIndex) {
      quickSort(array, pivotIndex, rightIndex, comparator);
    }
  }

  private <T extends Comparable<T>> int partition(T[] array, int leftIndex, int rightIndex,
      Comparator<T> comparator) {
    T pivot = array[(leftIndex + rightIndex) / 2];
    while (leftIndex <= rightIndex) {
      while (Objects.compare(array[leftIndex], pivot, comparator) < 0) {
        leftIndex++;
      }
      while (Objects.compare(array[rightIndex], pivot, comparator) > 0) {
        rightIndex--;
      }
      if (leftIndex <= rightIndex) {
        swap(array, leftIndex, rightIndex);
        leftIndex++;
        rightIndex--;
      }
    }
    return leftIndex;
  }

  private <T extends Comparable<T>> void swap(T[] array, int from, int to) {
    T temp = array[to];
    array[to] = array[from];
    array[from] = temp;
  }
}
