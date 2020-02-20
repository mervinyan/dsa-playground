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
}