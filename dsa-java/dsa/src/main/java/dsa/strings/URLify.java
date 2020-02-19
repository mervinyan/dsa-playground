package dsa.strings;

/**
 * Replace all spaces in a string with '%20'. 
 * Assume that the string has suffient space at the end to hold the addtional characters,
 * and that you are given the "true" length of the string
 */
public class URLify {
  static void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0, index, i = 0;
    for (i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }

    index = trueLength + spaceCount * 2;

    if (trueLength < str.length) {
      str[trueLength] = '\0';
    }

    for (i = trueLength-1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index-1] = '0';
        str[index-2] = '2';
        str[index-3] = '%';
        index -= 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }
}