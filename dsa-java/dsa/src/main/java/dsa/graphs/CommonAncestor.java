package dsa.graphs;

/**
 * Algorithm to find the common ancestor of two nodes in a binary tree
 */
public class CommonAncestor {
 
  // solution #1: with link to parents
  TreeNode findCommonAncestor_V1(TreeNode p, TreeNode q) {
    int delta = depth(p) -depth(q);
    TreeNode first = delta > 0 ? q : p;
    TreeNode second = delta > 0 ? p : q;
    second = goUpBy(second, Math.abs(delta));

    while (first != second && first != null && second != null) {
      first = first.parent;
      second = second.parent;
    }

    return first == null || second == null ? null : first;
  }

  //solution #2: with link to parents (better worst-case runtime)
  TreeNode findCommonAncestor_V2(TreeNode root, TreeNode p, TreeNode q) {
    if (!covers(root, p) || !covers(root, q)) {
      return null;
    } else if (covers(p, q)) {
      return p;
    } else if (covers(q, p)) {
      return q;
    }

    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    while (!covers(sibling, q)) {
      sibling = getSibling(parent);
      parent = parent.parent;
    }

    return parent;
  }

  // solution #3: without links to parents
  TreeNode findCommonAncestor_V3(TreeNode root, TreeNode p, TreeNode q) {
    if (!covers(root, p) || !covers(root, q)) {
      return null;
    }

    return ancestorHelper(root, p, q);
  }

  TreeNode goUpBy(TreeNode node, int delta) {
    while (delta > 0 && node != null) {
      node = node.parent;
      delta--;
    }
    return node;
  }

  int depth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }

  boolean covers(TreeNode root, TreeNode p) {
    if (root == null) {
      return false;
    }
    if (root == p) {
      return true;
    }
    return covers(root.left, p) || covers(root.right, p);
  }

  TreeNode getSibling(TreeNode node) {
    if (node == null || node.parent == null) {
      return null;
    }

    TreeNode parent = node.parent;
    return parent.left == node ? parent.right : parent.left;
  }

  TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);
    if (pIsOnLeft != qIsOnLeft) {
      return root;
    }
    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
  }

  TreeNode findCommonAncestor_V4(TreeNode root, TreeNode p, TreeNode q) {
    Result r = commonAncestorHelper_V4(root, p, q);
    if (r.isAncestor) {
      return r.node;
    }
    return null;
  }

  Result commonAncestorHelper_V4(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return new Result(null, false);
    }

    if (root == p && root == q) {
      return new Result(root, true);
    }

    Result rx = commonAncestorHelper_V4(root.left, p, q);
    if (rx.isAncestor) {
      return rx;
    }

    Result ry = commonAncestorHelper_V4(root.right, p, q);
    if (ry.isAncestor) {
      return ry;
    }

    if (rx.node != null && ry.node != null) {
      return new Result(root, true);
    } else if (root == p || root == q) {
      boolean isAncestor = rx.node != null || ry.node != null;
      return new Result(root, isAncestor);
    } else {
      return new Result(rx.node != null ? rx.node : ry.node, false);
    }
  }

  class Result {
    public TreeNode node;
    public boolean isAncestor;
    public Result(TreeNode n, boolean isAnc) {
      this.node = n;
      this.isAncestor = isAnc;
    }
  }
}