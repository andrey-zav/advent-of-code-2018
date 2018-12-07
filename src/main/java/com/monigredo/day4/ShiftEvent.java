package com.monigredo.day4;

import lombok.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

/**
 * @author Andrew Z
 */
@Value
public class ShiftEvent {
   public LocalDateTime time;
   public EventType type;
   public String rawData;
}
