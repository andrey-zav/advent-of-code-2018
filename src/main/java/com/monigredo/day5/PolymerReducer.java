package com.monigredo.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class PolymerReducer {
  public String reduce(String string) {
    List<Character> oldList = string.chars()
        .mapToObj(value -> (char) value)
        .collect(Collectors.toList());

    ArrayList<Character> newList = new ArrayList<>();

    boolean updated = true;
    while (updated) {
      updated = false;
      for (int i = 0; i < oldList.size(); i++) {
        String value = String.valueOf(oldList.get(i));

        if (i == oldList.size() - 1) {
          newList.add(value.charAt(0));
        } else {
          String nextValue = String.valueOf(oldList.get(i + 1));
          if ((value.equalsIgnoreCase(nextValue) && !value.equals(nextValue))
          ) {
            updated = true;
            i++;
          } else {
            newList.add(value.charAt(0));
          }
        }

      }

      oldList = newList;
      newList = new ArrayList<>();
    }


    StringBuilder stringBuffer = new StringBuilder();
    oldList.forEach(stringBuffer::append);

    System.out.println(stringBuffer);
    System.out.println(stringBuffer.length());
    return stringBuffer.toString();
  }
}
