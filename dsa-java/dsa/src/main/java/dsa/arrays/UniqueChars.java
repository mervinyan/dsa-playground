package dsa.arrays;

/**
 * Implement an algorithm to determine if a string has all unqiue characters.
 * What if you cannot use additonal data structures?
 */
public class UniqueChars {

  /**
   * Assume the string is an ASCII string. There are 128 unique ASCII characters.
   */
  static boolean isUniquechars(String str) {
    if (str.length() > 128) {
      return false;
    }

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) {
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }
}