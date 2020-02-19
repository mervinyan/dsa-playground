package dsa.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationsTest {
  @Test
  public void testPermutations() {
    String s = "Dog";
    String t = "dog";

    assertEquals(false, Permutations.permutation(s, t));
  }

  @Test
  public void testPermutationsIgnoreCase() {
    String s = "Dog";
    String t = "dog";

    assertEquals(true, Permutations.permutationIgnoreCase(s, t));
  }

  @Test
  public void testPermutations_V2() {
    String s = "Dog";
    String t = "dog";

    assertEquals(false, Permutations.permutation_V2(s, t));
  }
}