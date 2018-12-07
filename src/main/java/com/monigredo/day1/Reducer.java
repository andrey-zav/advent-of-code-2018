package com.monigredo.day1;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Andrew Z
 */
public class Reducer {
  public BigInteger reduce(List<BigInteger> numbers) {
    return numbers.stream()
        .reduce(BigInteger::add)
        .orElseThrow(RuntimeException::new);
  }
}
