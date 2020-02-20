package dsa.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringRotationTest {
  @Test
  public void testIsRotation() {
    String s1 = "waterbootle";
    String s2 = "erbootlewat";

    assertEquals(true, StringRotation.isRotation(s1, s2));
  }

  @Test
  public void testIsRotation_false() {
    String s1 = "waterbootle";
    String s2 = "nrbootlewat";

    assertEquals(false, StringRotation.isRotation(s1, s2));
  }
}