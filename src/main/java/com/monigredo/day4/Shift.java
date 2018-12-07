package com.monigredo.day4;

import lombok.Data;

import java.util.List;

/**
 * @author Andrew Z
 */
@Data
public class Shift {
   public ShiftEvent startEvent;
   public List<ShiftEvent> events;
}
