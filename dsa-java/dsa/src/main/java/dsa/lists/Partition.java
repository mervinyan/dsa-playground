package dsa.lists;

public class Partition {

  /**
   * pass in the head of the linked list and the value to partition around
   */
  static LinkedListNode partition_V1(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;

    while (node != null) {
      LinkedListNode next = node.next;
      node.next = null;
      if (node.data < x) {
        if (beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    if (beforeStart == null) {
      return afterStart;
    }

    beforeEnd.next = afterStart;
    return beforeStart;
  }

  /**
   * Elements bigger than the pivot element are put at the tail and elements smaller are put at the head.
   * Each time we insert an element, we update either the head or tail
   */
  static LinkedListNode partition_V2(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    return head;
  }
}