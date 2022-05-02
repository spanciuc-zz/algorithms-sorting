package com.pantifik.algorithms.sorting.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SortingTest {

  @Test
  void comparator_whenBothNull_shouldReturn0() {
    assertEquals(0, Sorting.comparator()
        .compare(null, null));
  }

  @Test
  void comparator_whenFirstNotNullAndSecondNull_shouldReturn1() {
    assertEquals(1, Sorting.<Integer>comparator()
        .compare(1, null));
  }

  @Test
  void comparator_whenFirstNullAndSecondNotNull_shouldReturnNegative1() {
    assertEquals(-1, Sorting.<Integer>comparator()
        .compare(null, 1));
  }

  @Test
  void comparator_whenBothNotNull_shouldReturnCompareToResult() {
    int expected = Integer.valueOf(3)
        .compareTo(4);
    assertEquals(expected, Sorting.<Integer>comparator()
        .compare(3, 4));
  }

  @Test
  void reverseComparator_whenBothNull_shouldReturn0() {
    assertEquals(0, Sorting.reverseComparator()
        .compare(null, null));
  }

  @Test
  void reverseComparator_whenFirstNullAndSecondNotNull_shouldReturn1() {
    assertEquals(1, Sorting.<Integer>reverseComparator()
        .compare(null, 1));
  }

  @Test
  void reverseComparator_whenFirstNotNullAndSecondNull_shouldReturnNegative1() {
    assertEquals(-1, Sorting.<Integer>reverseComparator()
        .compare(1, null));
  }

  @Test
  void reverseComparator_whenBothNotNull_shouldReturnCompareToResult() {
    int expected = -1 * Integer.valueOf(3)
        .compareTo(4);
    assertEquals(expected, Sorting.<Integer>reverseComparator()
        .compare(3, 4));
  }

}