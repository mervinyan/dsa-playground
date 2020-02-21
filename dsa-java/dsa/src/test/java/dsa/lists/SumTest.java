package dsa.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SumTest {

  @Before 
  public void setUp() {

  }

  @Test
  public void testAddLists_V1() {
    //digits are stored in reverse order

    //617
    LinkedListNode l1 = new LinkedListNode(7);
    l1.setNext(new LinkedListNode(1));
    l1.next.setNext(new LinkedListNode(6));

    //295
    LinkedListNode l2 = new LinkedListNode(5);
    l2.setNext(new LinkedListNode(9));
    l2.next.setNext(new LinkedListNode(2));
    String expected = "2 -> 1 -> 9";

    LinkedListNode result = Sum.addLists_V1(l1, l2, 0);

    assertEquals(expected, result.toString());
  }

  @Test
  public void testAddLists_V2() {
    //digits are stored in forward order

    //1234
    LinkedListNode l1 = new LinkedListNode(1);
    l1.setNext(new LinkedListNode(2));
    l1.next.setNext(new LinkedListNode(3));
    l1.next.next.setNext(new LinkedListNode(4));

    //567
    LinkedListNode l2 = new LinkedListNode(5);
    l2.setNext(new LinkedListNode(6));
    l2.next.setNext(new LinkedListNode(7));

    String expected = "1 -> 8 -> 0 -> 1";

    LinkedListNode result = Sum.addLists_V2(l1, l2);

    assertEquals(expected, result.toString());
  }
}