package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree was created by traversing thorugh an array from left to
 * right and inserting each element. Given a binary search tree with distinct
 * elements, print all possible arrays that could have led to this tree.
 */
public class BSTSequences {
  public List<LinkedList<Integer>> allSequences(TreeNode node) {
    List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

    if (node == null) {
      result.add(new LinkedList<Integer>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(node.data);

    /* Recurse on left and right subtrees. */
    List<LinkedList<Integer>> leftSeq = allSequences(node.left);
    List<LinkedList<Integer>> rightSeq = allSequences(node.right);

    /* Weave together each list form the left and right sides. */
    for (LinkedList<Integer> left : leftSeq) {
      for (LinkedList<Integer> right : rightSeq) {
        List<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
        weaveList(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }
    return result;
  }

  /** 
   * Weave lists together in all possible ways.
   * This algorithm works by removing the head from one list, recursing, and then doding the same thing with the other list.
   */   
  void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    /* one list is empty. Add remainder to [a cloned] prefix and store result. */
    if (first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }

    //Recurse with head of first added to the prefix. 
    //Removing the head will damage first, so we'll need to put it back where we found it afterwards.
    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveList(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);

    //Do the same thing with second, damaging and then restroing the list.
    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveList(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
  }
}