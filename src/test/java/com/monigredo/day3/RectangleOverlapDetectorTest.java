package com.monigredo.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Andrew Z
 */
class RectangleOverlapDetectorTest {

  @Test
  void doesOverlap() {
    RectangleOverlapDetector detector = new RectangleOverlapDetector();
    Rectangle rectangle1 = new Rectangle("#1 @ 1,3: 4x4");
    Rectangle rectangle2 = new Rectangle("#2 @ 3,1: 4x4");
    Rectangle rectangle3 = new Rectangle("#3 @ 5,5: 2x2");

    assertTrue(detector.doOverlap(rectangle1, rectangle2));
    assertTrue(detector.doOverlap(rectangle2, rectangle1));

    assertFalse(detector.doOverlap(rectangle3, rectangle1));
    assertFalse(detector.doOverlap(rectangle3, rectangle2));
    assertFalse(detector.doOverlap(rectangle1, rectangle3));
    assertFalse(detector.doOverlap(rectangle2, rectangle3));
  }
}