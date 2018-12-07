package com.monigredo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class Utils {
  public static List<BigInteger> asIntList(long... numbers) {

    return Arrays.stream(numbers)
        .mapToObj(BigInteger::valueOf)
        .collect(Collectors.toList());
  }
}
