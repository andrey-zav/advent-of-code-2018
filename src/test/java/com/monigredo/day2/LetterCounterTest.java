package com.monigredo.day2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class LetterCounterTest {
  @Test
  void testCountLetterFrequencies() {
    LetterCounter counter = new LetterCounter();

    assertEquals(expected(t('a', 2), t('b', 2), t('c', 2), t('d', 2), t('e', 2), t('f', 2)),
        counter.countFrequencies("abcdefabcdef"));

    assertEquals(expected(t('a', 1), t('b', 3)),
        counter.countFrequencies("abbb"));

    assertEquals(expected(t('a', 2), t('b', 3), t('c', 1)),
        counter.countFrequencies("cababb"));
  }

  private Map<Character, Long> expected(Map.Entry<Character, Integer>... entries) {
    Map<Character, Long> map = new HashMap<>();

    Arrays.stream(entries).forEach(e -> map.put(e.getKey(), Long.valueOf(e.getValue())));

    return map;
  }

  private Map.Entry t(Character key, int value) {
    return new Entry(key, value);
  }
}