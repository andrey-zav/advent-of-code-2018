package com.monigredo.day4;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   public long getTotalSleepMinutes() {
      int i = 0;
      long totalSleepMillis = 0;
      while (i + 1 < sleepEvents.size()) {
         ShiftEvent sleepEvent = sleepEvents.get(0);
         ShiftEvent wakeEvent = sleepEvents.get(i + 1);

         long sleepMillis = wakeEvent.getTime().toEpochSecond(ZoneOffset.UTC) - sleepEvent.getTime().toEpochSecond(ZoneOffset.UTC);
         totalSleepMillis += sleepMillis;

         i += 2;
      }

      return totalSleepMillis / (1000 * 60);
   }

   public void getTopSleepMinute() {
      Map<LocalDateTime, Integer> fq = new HashMap<>();
      int i = 0;
      while (i + 1 < sleepEvents.size()) {
         ShiftEvent sleepEvent = sleepEvents.get(0);
         ShiftEvent wakeEvent = sleepEvents.get(i + 1);


      }
   }
}
