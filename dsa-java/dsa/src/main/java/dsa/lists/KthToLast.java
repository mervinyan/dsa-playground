package dsa.lists;

public class KthToLast {

  static int printKthToLast(LinkedListNode head, int k) {
    if (head == null) {
      return 0;
    }
    int index = printKthToLast(head.next, k) + 1;
    if (index == k) {
      System.out.println(k + "th to last node is " + head.data);
    }
    return index;
  }

  static class Index {
    public int value = 0;
  }

  static LinkedListNode kthToLast(LinkedListNode head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  static LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
    if (head == null) {
      return null;
    }
    LinkedListNode node = kthToLast(head.next, k, idx);
    idx.value = idx.value + 1;
    if (idx.value == k) {
      return head;
    }
    return node;
  }

  /**
   * use two pointers p1 and p2. place them k nodes apart in the linked list
   * by putting p2 at the beginning and moving p1 k nodes into the list. then
   * when we move them at the same pace, p1 will hit the end of the linked list 
   * after LENGTH-k steps. at that point p2 will be LENGTH - k nodes into the list,
   * or k nodes from the end
   */
  static LinkedListNode nthToLast(LinkedListNode head, int k) {
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;

    //move p1 k nodes into the list
    for (int i = 0; i < k; i++) {
      if (p1 == null) {
        return null;
      }
      p1 = p1.next;
    }

    //move them at the same pace, when p1 hits the end, p2 will be at the right element
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p2;
  }
}