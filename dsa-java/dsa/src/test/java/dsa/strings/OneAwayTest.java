package dsa.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OneAwayTest {
  @Test
  public void testOneEditAway_V1() {
    String first = "pale";
    String second = "ale";

    assertEquals(true, OneAway.oneEditAway_V1(first, second));
  }

  @Test
  public void testOneEditAway_V2() {
    String first = "pale";
    String second = "bale";

    assertEquals(true, OneAway.oneEditAway_V2(first, second));
  }

  @Test
  public void testMoreOneEditAway_V1() {
    String first = "pale";
    String second = "bae";

    assertEquals(false, OneAway.oneEditAway_V1(first, second));
  }
}