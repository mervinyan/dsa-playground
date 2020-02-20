package dsa.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesTest {
  private LinkedListNode head;
  private LinkedListNode expected;

  @Before
  public void setUp() {
    List<LinkedListNode> nodes = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      nodes.add(new LinkedListNode((i % 4) * 10));
    }
    //10, 20, 30, 0, 10, 20, 30, 0, 10 

    head = nodes.get(3);
    head.setNext(nodes.get(0));
    nodes.get(0).setNext(nodes.get(6));
    nodes.get(6).setNext(nodes.get(1));
    nodes.get(1).setNext(nodes.get(5));
    nodes.get(5).setNext(nodes.get(4));
    nodes.get(4).setNext(nodes.get(2));
    nodes.get(2).setNext(nodes.get(8));
    nodes.get(8).setNext(nodes.get(7));

    // 0 -> 10 -> 30 -> 20 -> 20 -> 10 -> 20 -> 10 -> 0

    //expected 0 -> 10 -> 30 -> 20
    expected = new LinkedListNode(0);
    expected.setNext(new LinkedListNode(10));
    expected.next.setNext(new LinkedListNode(30));
    expected.next.next.setNext(new LinkedListNode(20));

  }

  @Test
  public void testRemoveDups_V1() {
    RemoveDuplicates.deleteDups_V1(head);

    LinkedListNode actual = head;
    while (actual != null && expected != null) {
      assertEquals(expected.data, actual.data);
      expected = expected.next;
      actual = actual.next;
    }

    if (actual != null || expected != null) {
      fail();
    }
  }

  @Test
  public void testRemoveDups_V2() {
    RemoveDuplicates.deleteDups_V2(head);

    LinkedListNode actual = head;
    while (actual != null && expected != null) {
      assertEquals(expected.data, actual.data);
      expected = expected.next;
      actual = actual.next;
    }

    if (actual != null || expected != null) {
      fail();
    }
  }
}