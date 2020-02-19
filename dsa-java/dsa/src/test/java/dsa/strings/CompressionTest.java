package dsa.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompressionTest {
  @Test
  public void testCompress_V1() {
    String str = "aabcccccbb";
    String expected = "a2b1c5b2";

    String actual = Compression.compress_V1(str);
    assertEquals(expected, actual);
  }

  @Test
  public void testCompress_V2() {
    String str = "aabcccccbb";
    String expected = "a2b1c5b2";

    String actual = Compression.compress_V2(str);
    assertEquals(expected, actual);
  }
}