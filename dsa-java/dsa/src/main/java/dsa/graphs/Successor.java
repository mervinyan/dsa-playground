package dsa.graphs;

/**
 * Algorithm to find the next node (i.e., in-order successor) of a given node in a binary search tree.
 * Each node has a link to its parent.
 */
public class Successor {

  TreeNode inorderSuccessor(TreeNode n) {
    if (n == null) {
      return null;
    }

    if (n.right != null) {
      return leftMostChild(n.right);
    } else {
      TreeNode q = n;
      TreeNode x = q.parent;

      while (x != null && x.left != q) {
        q = x;
        x = x.parent;
      }

      return x;
    }
  }

  TreeNode leftMostChild(TreeNode n) {
    if (n == null) {
      return null;
    }
    while (n.left != null) {
      n = n.left;
    }
    return n;
  }
}