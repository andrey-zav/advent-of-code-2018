package com.monigredo.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class RectangleTest {

  @Test
  public void testToString() {
    assertEquals("#1 @ 1,3: 4x4", new Rectangle("#1 @ 1,3: 4x4").toString());
    assertEquals("#2 @ 3,1: 4x4", new Rectangle("#2 @ 3,1: 4x4").toString());
    assertEquals("#3 @ 5,5: 2x2", new Rectangle("#3 @ 5,5: 2x2").toString());
  }


}