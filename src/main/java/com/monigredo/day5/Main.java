package com.monigredo.day5;

import lombok.SneakyThrows;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Andrew Z
 */
public class Main {
  @SneakyThrows
  public static void main(String[] args) {
    URL resource = com.monigredo.day2.Main.class.getClassLoader().getResource("day5/input.txt");
    List<String> ids = Files.readAllLines(Paths.get(resource.toURI()));

    String string = ids.get(0);

    reducePolymer(string);
    new SmallestPolyFinder().findSmallest(string);
  }

  private static void reducePolymer(String string) {
    String reduce = new PolymerReducer().reduce(string);
    System.out.println(reduce.length());
  }


}
