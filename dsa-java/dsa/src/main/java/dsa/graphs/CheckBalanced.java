package dsa.graphs;

/**
 * check if a binary tree is balanced. 
 * a balanced tree is defined to be a tree such that the heights of the two substrees of any node never differ by more than one.
 */
public class CheckBalanced {

  int getHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }

    return Math.max(getHeight(root.left), getHeight(root.right)) +1;
  }

  boolean isBalanced_V1(TreeNode root) {
    if (root == null) {
      return true;
    }

    int heightDiff = getHeight(root.left) - getHeight(root.right);
    if (Math.abs(heightDiff) > 1) {
      return false;
    } else {
      return isBalanced_V1(root.left) && isBalanced_V1(root.right);
    }
  }

  int checkHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int leftHeight = checkHeight(root.left);
    if (leftHeight == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    int rightHeight = checkHeight(root.right);
    if (rightHeight == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    int heightDiff = leftHeight - rightHeight;
    if (Math.abs(heightDiff) > 1) {
      return Integer.MIN_VALUE;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  boolean isBalanced_V2(TreeNode root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }
}