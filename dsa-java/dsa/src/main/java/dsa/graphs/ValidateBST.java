package dsa.graphs;

/**
 * check if a binary tree is a binary search tree.
 * a binary search tree is a tree where all left nodes must be less than or equal to the current node,
 * which must be less than all the right nodes
 */
public class ValidateBST {

  private int index = 0;
  private Integer last_printed = null;
  
  /**
   * solution #1: in-order traversal, use array
   */
  boolean checkBST_V1(TreeNode root) {
    int[] array = new int[root.size()];

    copyBST(root, array);

    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i-1]) {
        return false;
      }
    }

    return true;
  }

  void copyBST(TreeNode root, int[] array) {
    if (root == null) {
      return;
    }

    copyBST(root.left, array);
    array[index] = root.data;
    index++;
    copyBST(root.right, array);
  }

  /**
   * solution #1: in-order traversal, don't use array, just track the last element we saw and compare it as we go
   */
  boolean checkBST_V2(TreeNode node) {
    if (node == null) {
      return true;
    }

    if (!checkBST_V2(node.left)) {
      return false;
    }

    if (last_printed != null && node.data <= last_printed) {
      return false;
    }

    last_printed = node.data;

    if (!checkBST_V2(node.right)) {
      return false;
    }

    return true;
  }

  /**
   * solution #3: the min / max solution
   * passing downthe min and max values, as we iterate through the tree, we verify against progressively narrower ranges
   */
  boolean checkBST_V3(TreeNode node) {
    return checkBST_V3(node, null, null);
  }

  boolean checkBST_V3(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }

    if ((min != null && node.data <= min) || (max != null && node.data > max)) {
      return false;
    }

    if (!checkBST_V3(node.left, min, node.data) || !checkBST_V3(node.right, node.data, max)) {
      return false;
    }

    return true;
  }
}