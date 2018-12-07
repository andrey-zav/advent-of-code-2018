package com.monigredo.day4;

import lombok.SneakyThrows;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrew Z
 */
public class InputParser {
   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

   @SneakyThrows
   public List<Shift> parse(String path){
      URL resource = com.monigredo.day2.Main.class.getClassLoader().getResource(path);
      List<String> entries = Files.readAllLines(Paths.get(resource.toURI()));


      List<ShiftEvent> shiftEvents = entries.stream()
            .map(this::toShiftEvent)
            .collect(Collectors.toList());

      shiftEvents.sort(Comparator.comparing(ShiftEvent::getTime));

      return Collections.emptyList();
   }

   private ShiftEvent toShiftEvent(String entry) {
      EventType type = getType(entry);
      LocalDateTime time = getTime(entry);

      return new ShiftEvent(time, type);
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
