package com.pantifik.algorithms.sorting.bubble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingTest {

  protected Bubble sorting;

  @BeforeEach
  void setUp() {
    sorting = new Bubble();
  }

  @Test
  void sort_whenNullParam_shouldThrowException() {
    Assertions.assertThrows(NullPointerException.class, () -> sorting.sort(null));
  }

  @Test
  void sortAscending_whenNullParam_shouldThrowException() {
    Assertions.assertThrows(NullPointerException.class, () -> sorting.sortAscending(null));
  }

  @Test
  void sortDescending_whenNullParam_shouldThrowException() {
    Assertions.assertThrows(NullPointerException.class, () -> sorting.sortDescending(null));
  }

  @Test
  void sort_whenEmpty_shouldReturnEmptyArray() {
    var expected = new Integer[0];
    Assertions.assertArrayEquals(expected, sorting.sort(expected));
  }

  @Test
  void sortAscending_whenEmpty_shouldReturnEmptyArray() {
    var expected = new Integer[0];
    Assertions.assertArrayEquals(expected, sorting.sortAscending(expected));
  }

  @Test
  void sortDescending_whenEmpty_shouldReturnEmptyArray() {
    var expected = new Integer[0];
    Assertions.assertArrayEquals(expected, sorting.sortDescending(expected));
  }

  @Test
  void sort_whenParamNotNullAndNotEmpty_shouldSortAscendingAndReturn() {
    var expected = createExpectedAscending();
    var unordered = createUnordered();
    Assertions.assertArrayEquals(expected, sorting.sort(unordered));
  }

  @Test
  void sortAscending_whenParamNotNullAndNotEmpty_shouldSortAscendingAndReturn() {
    var expected = createExpectedAscending();
    var unordered = createUnordered();
    Assertions.assertArrayEquals(expected, sorting.sortAscending(unordered));
  }

  @Test
  void sortDescending_whenParamNotNullAndNotEmpty_shouldSortDescendingAndReturn() {
    var expected = createExpectedDescending();
    var unordered = createUnordered();
    Assertions.assertArrayEquals(expected, sorting.sortDescending(unordered));
  }

  private Integer[] createUnordered() {
    return new Integer[]{9, 1, 6, -6, -5, 2, 5, -7, -1, 8, -8, -4, 3, 4, -3, -2, 7, -9, 0};
  }

  private Integer[] createExpectedAscending() {
    return new Integer[]{-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  }

  private Integer[] createExpectedDescending() {
    return new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9};
  }
}