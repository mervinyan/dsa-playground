package dsa.lists;

import java.util.HashSet;
import java.util.Set;

/**
 * remove duplicates from an unsorted linked list
 */
public class RemoveDuplicates {

  /**
   * use hashtable to track duplicates
   */
  static void deleteDups_V1(LinkedListNode n) {
    Set<Integer> set = new HashSet<>();
    LinkedListNode previous = null;

    while (n != null) {
      if (set.contains(n.data)) {
        previous.next = n.next;
      } else {
        set.add(n.data);
        previous = n;
      }
      n = n.next;
    }
  }

  /**
   * no buffer allowed
   * iterate with two pointers: current which iterates through the linkedlist, and runner which checks all subsequent nodes for duplicates
   */
  static void deleteDups_V2(LinkedListNode head) {
    LinkedListNode current = head;
    while (current != null) {
      LinkedListNode runner = current;
      while (runner.next != null) {
        if (runner.next.data == current.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }
}