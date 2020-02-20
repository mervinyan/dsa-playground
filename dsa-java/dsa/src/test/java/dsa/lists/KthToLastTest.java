package dsa.lists;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KthToLastTest {

  private LinkedListNode head;
  List<LinkedListNode> nodes = new ArrayList<>();

  @Before
  public void setUp() {
    //10, 20, 30, 0, 10, 20, 30, 0, 10 

    for (int i = 1; i < 10; i++) {
      nodes.add(new LinkedListNode((i % 4) * 10));
    }

    // 0 -> 10 -> 30 -> 20 -> 20 -> 10 -> 30 -> 10 -> 0
    head = nodes.get(3);
    head.setNext(nodes.get(0));
    nodes.get(0).setNext(nodes.get(6));
    nodes.get(6).setNext(nodes.get(1));
    nodes.get(1).setNext(nodes.get(5));
    nodes.get(5).setNext(nodes.get(4));
    nodes.get(4).setNext(nodes.get(2));
    nodes.get(2).setNext(nodes.get(8));
    nodes.get(8).setNext(nodes.get(7));
  }

  @Test
  public void testPrintKthToLast() {
    KthToLast.printKthToLast(head, 2);
  }

  @Test
  public void testKthToLast() {
    LinkedListNode expected = nodes.get(8);
    LinkedListNode actual = KthToLast.kthToLast(head, 2);
    assertEquals(expected.data, actual.data);
  }

  @Test
  public void testNthToLast() {
    LinkedListNode expected = nodes.get(8);
    LinkedListNode actual = KthToLast.nthToLast(head, 2);
    assertEquals(expected.data, actual.data);
  }
}