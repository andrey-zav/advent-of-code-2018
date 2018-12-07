package com.monigredo.day2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Andrew Z
 */
public class LetterCounter {

  public Map<Character, Long> countFrequencies(String id) {
//    Map<Character, Long> fq = new HashMap<>();
//    for (Character c : id.toCharArray()) {
//      fq.compute(c, (k, v) -> v == null ? 1L : v + 1);
//    }
//
//    return fq;

    return id.chars()
        .mapToObj(n -> (char) n)
        .collect(groupingBy(Function.identity(), counting()));
  }
}
