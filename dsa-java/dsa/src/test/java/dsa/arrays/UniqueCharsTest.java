package dsa.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueCharsTest {
  
  @Test
  public void testUniqueASCIIChars_V1_LessThan128Chars_Unique() {
    String str = "abcBCD12345";
    assertEquals(true, UniqueChars.isUniqueChars_V1(str));
  }

  @Test
  public void testUniqueASCIIChars_V1_LessThan128Chars_NotUnique() {
    String str = "abcBCD12343";
    assertEquals(false, UniqueChars.isUniqueChars_V1(str));
  }

  @Test
  public void testUniqueASCIIChars_V1_128Chars() {
    String str = "";
    for (int i = 0; i < 128; i++) {
      str = str + (char)i;
    }
    assertEquals(true, UniqueChars.isUniqueChars_V1(str));
  }

  @Test
  public void testUniqueASCIIChars_V1_GreaterThan128Chars() {
    String str = "";
    for (int i = 0; i < 128; i++) {
      str = str + (char)i;
    }
    str = str + (char)10;
    assertEquals(false, UniqueChars.isUniqueChars_V1(str));
  }

  @Test
  public void testUniqueASCIIChars_V2_LowerCase_Alphabet_LessThan26Chars_Unique() {
    String str = "abc12345";
    assertEquals(true, UniqueChars.isUniqueChars_V2_LowerCase_Alphabet(str));
  }

  @Test
  public void testUniqueASCIIChars_V2_LowerCase_Alphabet_26Chars() {
    String str = "";
    for (int i = 0; i < 26; i++) {
      str = str + (char)(i + (int)'a');
    }
    assertEquals(true, UniqueChars.isUniqueChars_V2_LowerCase_Alphabet(str));
  }

  @Test
  public void testUniqueASCIIChars_V2_LowerCase_Alphabet_GreaterThan26Chars() {
    String str = "";
    for (int i = 0; i < 26; i++) {
      str = str + (char)(i + (int)'a');
    }
    str = str + 'a';
    assertEquals(false, UniqueChars.isUniqueChars_V2_LowerCase_Alphabet(str));
  }

}