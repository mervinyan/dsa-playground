package dsa.strings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 * 
 * if two strings are permutations then we know they have the same characters but in diffrent orders
 */
public class Permutations {
  /**
   * solution #1: sort the strings
   */
  static boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    return sort(s).equals(sort(t));
  }

  static boolean permutationIgnoreCase(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    return sort(s).equalsIgnoreCase(sort(t));
  }

  static String sort(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  /**
   * solution #2: check if the two strings have identical character counts
   */
  static boolean permutation_V2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] letters = new int[128];

    char[] s_array = s.toCharArray();
    for (char c : s_array) {
      letters[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
      int c= (int)t.charAt(i);
      letters[c]--;
      if (letters[c] < 0) {
        return false;
      }
    }

    return true;
  }
}