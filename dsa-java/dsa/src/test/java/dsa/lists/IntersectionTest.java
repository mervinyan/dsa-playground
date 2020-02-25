package dsa.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntersectionTest {
  @Test
  public void testFindIntersection() {
    LinkedListNode list1 = new LinkedListNode(3);
    LinkedListNode nodeOf1 = new LinkedListNode(1);
    LinkedListNode nodeOf5 = new LinkedListNode(5);
    LinkedListNode nodeOf9 = new LinkedListNode(9);
    LinkedListNode nodeOf7 = new LinkedListNode(7);
    LinkedListNode nodeOf2 = new LinkedListNode(2);
    LinkedListNode nodeOfAnother1 = new LinkedListNode(1);

    list1.setNext(nodeOf1);
    nodeOf1.setNext(nodeOf5);
    nodeOf5.setNext(nodeOf9);
    nodeOf9.setNext(nodeOf7);
    nodeOf7.setNext(nodeOf2);
    nodeOf2.setNext(nodeOfAnother1);

    LinkedListNode list2 = new LinkedListNode(4);
    LinkedListNode nodeOf6 = new LinkedListNode(6);
    list2.setNext(nodeOf6);
    nodeOf6.setNext(nodeOf7);

    assertEquals(nodeOf7, Intersection.findIntersection(list1, list2));
    
  }
}