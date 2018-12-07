package com.monigredo.day4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew Z
 */
@Data
public class Shift {
   public Long guardId;
   public ShiftEvent startEvent;
   public List<ShiftEvent> sleepEvents;

   public Shift(ShiftEvent startEvent) {
      guardId = extractGuardId(startEvent);
      this.startEvent = startEvent;
      sleepEvents = new ArrayList<>();
   }

   private Long extractGuardId(ShiftEvent startEvent) {
      String[] split = startEvent.getRawData().split("#");

      String[] split2 = split[1].split(" ");

      return Long.valueOf(split2[0]);
   }

   public void addSleepEvent(ShiftEvent event) {
      sleepEvents.add(event);
   }

   public void getTotalSleepTime(){
      throw new UnsupportedOperationException();
   }

   public void getTopSleepHour(){
      throw new UnsupportedOperationException();
   }
}
