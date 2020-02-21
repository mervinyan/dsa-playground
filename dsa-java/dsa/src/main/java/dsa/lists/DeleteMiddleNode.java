package dsa.lists;

/**
 * Implement an algorithm to delete the middle (any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node
 */
public class DeleteMiddleNode {

  /**
   * Copy the data from the next node over to the current node, 
   * and then delete the next node
   */
  static boolean deleteNode(LinkedListNode n) {
    if (n == null || n.next == null) {
      return false;
    }

    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;

    return true;
  }
}