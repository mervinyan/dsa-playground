package dsa.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {
  private LinkedListNode head;
  @Before
  public void setUp() {
    head = new LinkedListNode(0);
    head.setNext(new LinkedListNode(1));
    head.next.setNext(new LinkedListNode(2));
    head.next.next.setNext(new LinkedListNode(1));
    head.next.next.next.setNext(new LinkedListNode(0));
  }

  @Test
  public void testIsPalindrome_V1() {
    boolean expected = true;
    boolean actual = Palindrome.isPalindrome_V1(head);
    assertEquals(expected, actual);
  }

  @Test
  public void testIsPalindrome_V2() {
    boolean expected = true;
    boolean actual = Palindrome.isPalindrome_V2(head);
    assertEquals(expected, actual);
  }

  @Test
  public void testIsPalindrome_V3() {
    boolean expected = true;
    boolean actual = Palindrome.isPalindrome_V3(head);
    assertEquals(expected, actual);
  }
}