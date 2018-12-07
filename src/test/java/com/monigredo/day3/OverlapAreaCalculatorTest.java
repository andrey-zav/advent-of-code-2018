package com.monigredo.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class OverlapAreaCalculatorTest {

  @Test
  void testCalculate() {
    Rectangle rectangle1 = new Rectangle("#1 @ 1,3: 4x4");
    Rectangle rectangle2 = new Rectangle("#2 @ 3,1: 4x4");
    Rectangle rectangle3 = new Rectangle("#3 @ 5,5: 2x2");
    OverlapAreaCalculator calculator = new OverlapAreaCalculator();

    assertEquals(0, calculator.calculate(rectangle1, rectangle3));
    assertEquals(4, calculator.calculate(rectangle1, rectangle2));
    assertEquals(4, calculator.calculate(rectangle2, rectangle1));
    assertEquals(16, calculator.calculate(rectangle2, rectangle2));
    assertEquals(16, calculator.calculate(rectangle1, rectangle1));
  }
}