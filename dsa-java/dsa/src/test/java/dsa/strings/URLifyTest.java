package dsa.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class URLifyTest {
  @Test
  public void testReplaceSpaces() {
    String original = "Mr John Smith    ";
    String expected = "Mr%20John%20Smith";

    char[] content = original.toCharArray();
    int trueLength = 13;

    URLify.replaceSpaces(content, trueLength);

    String actual = new String(content);

    assertEquals(expected, actual);
  }
}