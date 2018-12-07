package com.monigredo.day3;

/**
 * @author Andrew Z
 */
public class OverlapAreaCalculator {
  public long calculate(Rectangle rectangle1, Rectangle rectangle2) {
    long xOverlap = Math.min(rectangle1.bottomX - rectangle2.topX, rectangle2.bottomX - rectangle1.topX);
    long yOverlap = Math.min(rectangle1.bottomY - rectangle2.topY, rectangle2.bottomY - rectangle1.topY);

    return xOverlap * yOverlap;
  }
}
