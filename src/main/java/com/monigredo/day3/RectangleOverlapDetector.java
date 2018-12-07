package com.monigredo.day3;

/**
 * @author Andrew Z
 */
public class RectangleOverlapDetector {
  public boolean doOverlap(Rectangle a, Rectangle b){
    if (a.bottomX <= b.topX || b.bottomX <= a.topX){
      return false;
    }

    if (a.bottomY <= b.topY || b.bottomY <= a.topY){
      return false;
    }

    return true;
  }



  private double distance(Rectangle a, Rectangle b) {
    return Math.sqrt((a.topX - b.topX)^2 + (a.topX - b.topX)^2);
  }
}
