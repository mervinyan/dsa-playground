package dsa.lists;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class LoopDetectionTest {
  @Test
  public void testFindBeginning() {
    LinkedListNode nodeA = new LinkedListNode((int)'A');
    LinkedListNode nodeB = new LinkedListNode((int)'B');
    LinkedListNode nodeC = new LinkedListNode((int)'C');
    LinkedListNode nodeD = new LinkedListNode((int)'D');
    LinkedListNode nodeE = new LinkedListNode((int)'E');
    LinkedListNode nodeF = new LinkedListNode((int)'F');

    LinkedListNode head = nodeA;
    nodeA.setNext(nodeB);
    nodeB.setNext(nodeC);
    nodeC.setNext(nodeD);
    nodeD.setNext(nodeE);
    nodeE.setNext(nodeF);
    nodeF.setNext(nodeC);

    LinkedListNode expected = nodeC;

    LinkedListNode actual = LoopDetection.fiindBeginning(head);

    assertEquals(expected, actual);
  }


}