package dsa.arrays;

/**
 * Implement an algorithm to determine if a string has all unqiue characters.
 * What if you cannot use additonal data structures?
 */
public class UniqueChars {

  /**
   * Assume the string is an ASCII string. There are 128 unique ASCII characters.
   * Use array of boolean values where the flag at index i indicates whether 
   * character i in the alphabet is contained in the string. The second time you see 
   * this character you can immediately return false
   */
  static boolean isUniqueChars_V1(String str) {
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

  /**
   * Use bit vector to reduce the space usage.
   * int: 4 bytes, 32 bits. good for testing 32 unique characters
   * long: 8 bytes, 64 bits. good for testing 64 unique characters (alphabet and numeric values)
   * the checker has at least 128 bits if testing ascii characters
   */
  static boolean isUniqueChars_V2_LowerCase_Alphabet(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i)-'a'; 
      if ((checker & ( 1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }

  static boolean isUniqueChars_V2_UpperCase_Alphabet(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i)-'A'; 
      if ((checker & ( 1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }

  static boolean isUniqueChars_V2_UpperCase_Numeric(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i)-48; //the ascii code for 0 is 48
      if ((checker & ( 1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
}