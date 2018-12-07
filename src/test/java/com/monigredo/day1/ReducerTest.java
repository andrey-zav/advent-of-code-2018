package com.monigredo.day1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.monigredo.Utils.asIntList;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Andrew Z
 */
public class ReducerTest {

  @Test
  void testReduce() {
    BigInteger result = new Reducer().reduce(asIntList(5, -1, 2));

    assertEquals(BigInteger.valueOf(6), result);
  }

}