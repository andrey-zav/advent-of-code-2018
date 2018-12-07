package com.monigredo.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class Main {
  public static void main(String[] args) throws URISyntaxException, IOException {
    URL resource = com.monigredo.day2.Main.class.getClassLoader().getResource("day3/input.txt");
    List<String> ids = Files.readAllLines(Paths.get(resource.toURI()));

    List<Rectangle> rectangles = ids.stream()
        .map(Rectangle::new)
        .collect(Collectors.toList());

//    findOverlapArea(rectangles);

    RectangleOverlapDetector detector = new RectangleOverlapDetector();

    for (int i = 0; i < rectangles.size(); i++) {
      Rectangle rectangle = rectangles.get(i);

      boolean overlap = false;
      for (int j = 0; j < rectangles.size(); j++) {
        if (j == i){
          continue;
        }

        if (detector.doOverlap(rectangle, rectangles.get(j))){
          overlap = true;
          break;
        }
      }

      if (!overlap){
        System.out.println(rectangle);
        break;
      }
    }
  }

  private static void findOverlapArea(List<Rectangle> rectangles) {
    long maxX = 1000;
    long maxY = 1000;

    long area = 0;
    RectangleOverlapDetector detector = new RectangleOverlapDetector();
    for (int i = 0; i < maxX - 1; i++) {
      for (int j = 0; j < maxY - 1; j++) {
        System.out.println("Analyzing " + i + "," + j);
        Rectangle oneSqr = new Rectangle(String.format("#0 @ %s,%s: 1x1", i, j));
        int overlaps = 0;

        for (Rectangle rectangle : rectangles) {
          if (detector.doOverlap(oneSqr, rectangle)) {
            overlaps++;

            if (overlaps > 1) {
              System.out.println("Found second overlap, adding square");
              area++;
              break;
            }
          }
        }
      }
    }

    System.out.println(area);
  }
}
