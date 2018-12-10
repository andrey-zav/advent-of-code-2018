package com.monigredo.day4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew Z
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardShifts {
  public Long guardId;
  public List<Shift> shifts;

  public Long getTotalSleepDurationInMinutes() {
    Long totalSleepDuration = shifts.stream()
        .map(Shift::getTotalSleepMinutes)
        .reduce(Long::sum)
        .orElseThrow(IllegalArgumentException::new);
    return totalSleepDuration;
  }

  public Long getTopSleepMinute() {
    Map<Integer, Long> minutes = shifts.stream()
        .map(Shift::toSleepMap)
        .reduce(GuardShifts::mergeMinutes)
        .orElseThrow(RuntimeException::new);
    return minutes.entrySet().stream()
        .max(Comparator.comparing(Map.Entry::getValue))
        .orElseThrow(RuntimeException::new).getValue();
  }

  private static Map<Integer, Long> mergeMinutes(Map<Integer, Long> map1, Map<Integer, Long> map2) {
    HashMap<Integer, Long> merged = new HashMap<>(map1);

    for (Map.Entry<Integer, Long> entry : map2.entrySet()) {
      merged.compute(entry.getKey(), (k, v) -> v == null ? entry.getValue() : entry.getValue() + v);
    }


    return merged;
  }
}
