package com.monigredo.day1;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class Main {
  public static void main(String[] args) throws IOException, URISyntaxException {
    URL resource = Main.class.getClassLoader().getResource("day1/input.txt");
    List<BigInteger> numbers = Files.readAllLines(Paths.get(resource.toURI()))
        .stream()
        .map(BigInteger::new)
        .collect(Collectors.toList());

    printTotal(numbers);
    printFirstRepeatedFrequency(numbers);
  }

  private static void printFirstRepeatedFrequency(List<BigInteger> numbers) {
    BigInteger result = new FrequencyFinder().find(numbers);

    System.out.println(result);
  }

  private static void printTotal(List<BigInteger> numbers) {
    BigInteger result = new Reducer().reduce(numbers);

    System.out.println(result);
  }
}
