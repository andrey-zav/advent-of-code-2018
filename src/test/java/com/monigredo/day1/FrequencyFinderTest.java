package com.monigredo.day1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.monigredo.Utils.asIntList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class FrequencyFinderTest {
  @Test
  void testFindFirstRepeated() {
    FrequencyFinder frequencyFinder = new FrequencyFinder();

    assertEquals(BigInteger.ZERO, frequencyFinder.find(asIntList(+1, -1)));
    assertEquals(BigInteger.valueOf(10), frequencyFinder.find(asIntList(+3, +3, +4, -2, -4)));
    assertEquals(BigInteger.valueOf(5), frequencyFinder.find(asIntList(-6, +3, +8, +5, -6)));
    assertEquals(BigInteger.valueOf(14), frequencyFinder.find(asIntList(+7, +7, -2, -7, -4)));
  }
}