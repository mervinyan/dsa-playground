package dsa.strings;

/**
 * Compresss string by using the counts of repeated characters.
 * For example, the string aabcccccaaa woule become a2b1c5a3.
 * If the compressed string would not bcome smaller than the original one,
 * then return the orginal one
 */
public class Compression {

  static String compress_V1(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }

    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  static String compress_V2(String str) {
    int finalLength = countCompression(str);

    if (finalLength >= str.length()) {
      return str;
    }

    StringBuilder compressed = new StringBuilder(finalLength);
    int countConsecutive = 0;

    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }

    return compressed.toString();
  }

  static int countCompression(String str) {
    int compressedLength = 0; 
    int countConsecutive = 0;

    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressedLength += 1 + String.valueOf(countConsecutive).length();
        countConsecutive = 0;
      }
    }

    return compressedLength;
  }
}