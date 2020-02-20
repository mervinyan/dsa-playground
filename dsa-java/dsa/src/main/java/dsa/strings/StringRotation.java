package dsa.strings;

/**
 * assume you have a method isSubString which checks if one word is a substring of another.
 * given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString
 * e.g. "waterbottle" is a rotation of "erbottlewat"
 */
public class StringRotation {

  static boolean isRotation(String s1, String s2) {
    int len = s1.length();
    if (len == s2.length() && len > 0) {
      String s1s1 = s1 + s1;
      return isSubString(s1s1, s2);
    }
    return false;
  }

  static boolean isSubString(String s1, String s2) {
    return s1.indexOf(s2) >= 0;
  }
}