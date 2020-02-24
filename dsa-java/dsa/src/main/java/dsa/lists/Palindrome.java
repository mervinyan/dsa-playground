package dsa.lists;

import java.util.Stack;

public class Palindrome {
  // Solution #1: Reverse and Compare
  static boolean isPalindrome_V1(LinkedListNode head) {
    LinkedListNode reversed = reverseAndClone(head);
    return isEqual(head, reversed);
  }

  static LinkedListNode reverseAndClone(LinkedListNode node) {
    LinkedListNode head = null;
    while (node != null) {
      LinkedListNode n = new LinkedListNode(node.data);
      n.next = head;
      head = n;
      node = node.next;
    }
    return head;
  }

  static boolean isEqual(LinkedListNode one, LinkedListNode two) {
    while (one != null && two != null) {
      if (one.data != two.data) {
        return false;
      }
      one = one.next;
      two = two.next;
    }
    return one == null && two == null;
  }

  // Solution #2: Iterative approach
  // Using the fast runner / slow runner technique to determine the middle of the
  // linked list

  static boolean isPalindrome_V2(LinkedListNode head) {
    LinkedListNode fast = head;
    LinkedListNode slow = head;

    Stack<Integer> stack = new Stack<>();

    while (fast != null && fast.next != null) {
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      int top = stack.pop().intValue();

      if (top != slow.data) {
        return false;
      }

      slow = slow.next;
    }

    return true;
  }

  static class Result {
    LinkedListNode node;
    boolean result;

    public Result(LinkedListNode node, boolean result) {
      this.node = node;
      this.result = result;
    }
  }

  static boolean isPalindrome_V3(LinkedListNode head) {
    int length = lengthOfList(head);
    Result p = isPalindromeRecurse(head, length);
    return p.result;
  }

  static Result isPalindromeRecurse(LinkedListNode head, int length) {
    if (head == null || length < 0) {
      return new Result(head, true);
    } else if (length == 1) {
      return new Result(head.next, true);
    }

    Result res = isPalindromeRecurse(head.next, length - 2);

    if (!res.result || res.node == null) {
      return res;
    }

    res.result = (head.data == res.node.data);

    res.node = res.node.next;

    return res;

  }

  static int lengthOfList(LinkedListNode n) {
    int size = 0;
    while (n != null) {
      size++;
      n = n.next;
    }
    return size;
  }
}