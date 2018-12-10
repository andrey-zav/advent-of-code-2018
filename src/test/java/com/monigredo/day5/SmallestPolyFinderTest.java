package com.monigredo.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class SmallestPolyFinderTest {

  @Test
  void findSmallest() {
    assertEquals("", extract("aA"));
    assertEquals("", extract("aAa"));
    assertEquals("b", extract("aAab"));
    assertEquals("daDA", extract("dabAcCaCBAcCcaDA"));
  }

  private String extract(String string) {
    return new SmallestPolyFinder().findSmallest(string);
  }
}