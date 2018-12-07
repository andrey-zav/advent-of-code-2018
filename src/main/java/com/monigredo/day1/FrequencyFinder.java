package com.monigredo.day1;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Andrew Z
 */
public class FrequencyFinder {
  public BigInteger find(List<BigInteger> numbers) {
    BigInteger currentFrequency = BigInteger.ZERO;
    Set<BigInteger> occurred = new HashSet<>();

    int i = 0;
    while (occurred.add(currentFrequency)){

      BigInteger number = numbers.get(i);
      currentFrequency = currentFrequency.add(number);

      if (++i == numbers.size()) i = 0;
    }

    return currentFrequency;
  }
}
