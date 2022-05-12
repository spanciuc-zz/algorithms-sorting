package com.pantifik.algorithms.sorting.heap;

import com.pantifik.algorithms.sorting.base.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * A heapsort implementation.
 */
public class Heap implements Sorting {

  @Override
  public <T extends Comparable<T>> T[] sortAscending(T[] array) {
    return doSort(array, Sorting.comparator());
  }

  @Override
  public <T extends Comparable<T>> T[] sortDescending(T[] array) {
    return doSort(array, Sorting.reverseComparator());
  }

  private <T extends Comparable<T>> T[] doSort(T[] array, Comparator<T> comparator) {
    T[] result = Arrays.copyOf(array, array.length);
    return heapsort(result, comparator);
  }

  private <T extends Comparable<T>> T[] heapsort(T[] result, Comparator<T> comparator) {

    heapify(result, comparator);

    for (int i = result.length - 1; i > 0; i--) {
      swap(result, 0, i);
      moveDown(result, i - 1, 0, comparator);
    }

    return result;
  }

  private <T extends Comparable<T>> void swap(T[] array, int from, int to) {
    T temp = array[to];
    array[to] = array[from];
    array[from] = temp;
  }

  private <T extends Comparable<T>> void heapify(T[] result, Comparator<T> comparator) {
    int midIndex = result.length / 2;
    for (int i = midIndex; i >= 0; i--) {
      moveDown(result, result.length - 1, i, comparator);
    }
  }

  private <T extends Comparable<T>> void moveDown(T[] result, int maxLength, int currentIndex,
      Comparator<T> comparator) {
    int previousChildIndex = 2 * currentIndex;
    if (previousChildIndex == maxLength - 1) {
      moveWhenOneChild(result, currentIndex, comparator, previousChildIndex + 1);
    } else if(previousChildIndex < maxLength - 1) {
      moveWhenTwoChilds(result, maxLength, currentIndex, comparator, previousChildIndex + 1,
          previousChildIndex + 2);
    }
  }

  private <T extends Comparable<T>> void moveWhenTwoChilds(T[] result, int maxLength,
      int currentIndex, Comparator<T> comparator, int leftChildIndex, int rightChildIndex) {
    T currentValue = result[currentIndex];
    var biggestChildIndexValuePair = findBiggestIndexValuePair(result, leftChildIndex,
        rightChildIndex, comparator);
    if (Objects.compare(biggestChildIndexValuePair.value(), currentValue, comparator) > 0) {
      swap(result, currentIndex, biggestChildIndexValuePair.index);
      moveDown(result, maxLength, biggestChildIndexValuePair.index, comparator);
    }
  }

  private <T extends Comparable<T>> void moveWhenOneChild(T[] result, int currentIndex,
      Comparator<T> comparator, int childIndex) {
    if (Objects.compare(result[childIndex], result[currentIndex], comparator) > 0) {
      swap(result, currentIndex, childIndex);
    }
  }

  private <T extends Comparable<T>> IndexValuePair<T> findBiggestIndexValuePair(T[] result,
      int firstIndex, int secondIndex, Comparator<T> comparator) {
    T firstValue = result[firstIndex];
    T secondValue = result[secondIndex];
    return Objects.compare(firstValue, secondValue, comparator) < 0 ?
        new IndexValuePair<>(secondIndex, secondValue) :
        new IndexValuePair<>(firstIndex, firstValue);
  }

  private record IndexValuePair<T>(int index, T value) {}
}
