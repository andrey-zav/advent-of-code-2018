package com.monigredo.day5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SmallestPolyFinder {
  public String findSmallest(String string) {
    Set<Character> allLetters = string.chars().mapToObj(value -> (char) value).collect(Collectors.toSet());

    PolymerReducer polymerReducer = new PolymerReducer();

    String min = allLetters.stream()
        .map(removeLetter(string))
        .map(polymerReducer::reduce)
        .min((Comparator.comparing(String::length)))
        .orElseThrow();

    System.out.println(min);
    System.out.println(min.length());
    return min;
  }

  private Function<Character, String> removeLetter(String string) {
    return l -> {
      String result = string.replaceAll(l.toString().toLowerCase(), "");
      result = result.replaceAll(l.toString().toUpperCase(), "");
      return result;
    };
  }
}