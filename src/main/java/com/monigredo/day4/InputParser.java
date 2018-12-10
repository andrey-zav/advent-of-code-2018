package com.monigredo.day4;

import lombok.SneakyThrows;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class InputParser {
   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

   @SneakyThrows
   public List<Shift> parse(String path) {
      URL resource = com.monigredo.day2.Main.class.getClassLoader().getResource(path);
      List<String> entries = Files.readAllLines(Paths.get(resource.toURI()));


      List<ShiftEvent> shiftEvents = entries.stream()
            .map(this::toShiftEvent)
            .collect(Collectors.toList());

      shiftEvents.sort(Comparator.comparing(ShiftEvent::getTime));

      List<Shift> shifts = extractShifts(shiftEvents);

      List<GuardShifts> guardShifts = toGuardShifts(shifts);

      GuardShifts topSleepingGuard = guardShifts.stream()
          .max(Comparator.comparing(GuardShifts::getTotalSleepDurationInMinutes)).orElseThrow(
          RuntimeException::new);

      Long guardId = topSleepingGuard.getGuardId();
      Long topSleepMinute = topSleepingGuard.getTopSleepMinute();
      System.out.println(guardId);
      System.out.println(topSleepMinute);
      System.out.println(guardId * topSleepMinute);

      return shifts;
   }

   private List<GuardShifts> toGuardShifts(List<Shift> shifts) {
      Map<Long, List<Shift>> guardShiftsMap = shifts
          .stream()
          .collect(Collectors.groupingBy(Shift::getGuardId));

      List<GuardShifts> guardShifts = new ArrayList<>();
      guardShiftsMap.forEach((k,v) -> guardShifts.add(new GuardShifts(k, v)));

      return guardShifts;
   }

   private List<Shift> extractShifts(List<ShiftEvent> shiftEvents) {
      List<Shift> shifts = new ArrayList<>();
      Shift currentShift = new Shift(shiftEvents.get(0));
      shiftEvents.remove(0);
      for (ShiftEvent shiftEvent : shiftEvents) {
         EventType type = shiftEvent.getType();

         if (type == EventType.START) {
            shifts.add(currentShift);
            currentShift = new Shift(shiftEvent);
         } else {
            currentShift.addSleepEvent(shiftEvent);
         }
      }

      return shifts;
   }

   private ShiftEvent toShiftEvent(String entry) {
      EventType type = getType(entry);
      LocalDateTime time = getTime(entry);

      return new ShiftEvent(time, type, entry);
   }

   private LocalDateTime getTime(String entry) {
      String[] split = entry.split("]");

      String timeString = split[0].substring(1);

      return LocalDateTime.from(formatter.parse(timeString));
   }

   private EventType getType(String entry) {
      if (entry.contains("shift")) return EventType.START;
      if (entry.contains("asleep")) return EventType.SLEEP;
      if (entry.contains("wakes")) return EventType.WAKE;

      throw new IllegalArgumentException();
   }

   public static void main(String[] args) {
      new InputParser().parse("day4/input.txt");
   }
}
