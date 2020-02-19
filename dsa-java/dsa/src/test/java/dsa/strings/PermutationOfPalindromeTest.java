package dsa.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermutationOfPalindromeTest {
  @Test
  public void testIsPermutationOfPalindrome_V1() {
    String phrase = "Tact Coa";
    boolean expected = true;
    boolean actual = PermutationOfPalindrome.isPermutationOfPalindrome_V1(phrase);
    assertEquals(expected, actual);
  }

  @Test
  public void testIsPermutationOfPalindrome_V2() {
    String phrase = "Tact Coa";
    boolean expected = true;
    boolean actual = PermutationOfPalindrome.isPermutationOfPalindrome_V2(phrase);
    assertEquals(expected, actual);
  }

  @Test
  public void testIsPermutationOfPalindrome_V3() {
    String phrase = "Tact Coa";
    boolean expected = true;
    boolean actual = PermutationOfPalindrome.isPermutationOfPalindrome_V3(phrase);
    assertEquals(expected, actual);
  }
}