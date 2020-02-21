package dsa.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PartitionTest {

  private LinkedListNode head;


  @Before
  public void setUp() {
    LinkedListNode nodeOf3 = new LinkedListNode(3);
    LinkedListNode nodeOf5 = new LinkedListNode(5);
    LinkedListNode nodeOf8 = new LinkedListNode(8);
    LinkedListNode anotherNodeOf5 = new LinkedListNode(5);
    LinkedListNode nodeOf10 = new LinkedListNode(10);
    LinkedListNode nodeOf2 = new LinkedListNode(2);
    LinkedListNode nodeOf1 = new LinkedListNode(1);

    // 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    nodeOf3.setNext(nodeOf5);
    nodeOf5.setNext(nodeOf8);
    nodeOf8.setNext(anotherNodeOf5);
    anotherNodeOf5.setNext(nodeOf10);
    nodeOf10.setNext(nodeOf2);
    nodeOf2.setNext(nodeOf1);

    head = nodeOf3;
  }
  
  @Test
  public void testPartition_v1() {
    String expected = "3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10";
    Partition.partition_V1(head, 5);
    String actual = head.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void testPartition_v2() {
    String expected = "1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10";
    LinkedListNode node = Partition.partition_V2(head, 5);
    String actual = node.toString();
    assertEquals(expected, actual);
  }
}