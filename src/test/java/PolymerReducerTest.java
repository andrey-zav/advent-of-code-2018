import com.monigredo.day5.PolymerReducer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew Z
 */
class PolymerReducerTest {

  @Test
  void reduce() {
    assertEquals("", reduce("aA"));
    assertEquals("b", reduce("aAb"));
    assertEquals("abAb", reduce("abAb"));
    assertEquals("ABAB", reduce("ABAB"));
    assertEquals("abAB", reduce("abAB"));
    assertEquals("AABBB", reduce("AABBB"));
    assertEquals("AAB", reduce("AABBb"));
    assertEquals("dabCBAcaDA", reduce("dabAcCaCBAcCcaDA"));
  }

  private String reduce(String string) {
    PolymerReducer polymerReducer = new PolymerReducer();

    return polymerReducer.reduce(string);
  }
}
