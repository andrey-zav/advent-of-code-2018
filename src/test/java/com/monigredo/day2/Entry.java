package com.monigredo.day2;

import java.util.Map;

/**
 * @author Andrew Z
 */
public class Entry implements Map.Entry<Character, Integer> {
  private Character key;
  private Integer value;

  public Entry(Character key, Integer value) {
    this.key = key;
    this.value = value;
  }


  @Override
  public Character getKey() {
    return key;
  }

  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public Integer setValue(Integer integer) {
    this.value = integer;
    return value;
  }

}
