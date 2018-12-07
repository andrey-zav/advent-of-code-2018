package com.monigredo.day3;

import lombok.Data;
import lombok.Value;

/**
 * @author Andrew Z
 */
@Data
public class Rectangle {
  public long id;
  public long topX;
  public long topY;
  public long bottomX;
  public long bottomY;

  public Rectangle(String string) {
    parseRectangle(string);
  }

  private void parseRectangle(String string) {
    String[] split1 = string.split("@");

    id = Long.parseLong(split1[0].substring(1).trim());

    String[] split2 = split1[1].trim().split(",");

    topX = Long.parseLong(split2[0].trim());

    String[] split3 = split2[1].split(":");

    topY = Long.parseLong(split3[0].trim());

    String[] split4 = split3[1].split("x");


    bottomX = topX + Long.parseLong(split4[0].trim());
    bottomY = topY + Long.parseLong(split4[1].trim());
  }


  @Override
  public String toString() {
    return String.format("#%s @ %s,%s: %sx%s", id, topX, topY, bottomX - topX, bottomY - topY);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Rectangle rectangle = (Rectangle) o;

    return id == rectangle.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }


}
