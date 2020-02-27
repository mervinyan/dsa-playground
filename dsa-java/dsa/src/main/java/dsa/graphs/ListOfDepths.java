package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

  public void createLevelLinkedList_DFS(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
    if (root == null) {
      return;
    }

    LinkedList<TreeNode> list = null;

    if (lists.size() == level) {
      list = new LinkedList<>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }

    list.add(root);

    createLevelLinkedList_DFS(root.left, lists, level + 1);
    createLevelLinkedList_DFS(root.right, lists, level + 1);
  }

  /**
   * depth-first search with pre-order traversal algorithm where we pass in level +1 to the next recursive level
   */
  public List<LinkedList<TreeNode>> createLevelLinkedList_DFS(TreeNode root) {
    List<LinkedList<TreeNode>> lists = new ArrayList<>();
    createLevelLinkedList_DFS(root, lists, 0);
    return lists;
  }

  /**
   * breadth-first search
   * with each level i, we will have already fully visited all nodes on level i - 1. 
   * this means that to get which nodes are on level i, we can simply look at children of the nodes of level i - 1
   */
  public List<LinkedList<TreeNode>> createLevelLinkedList_BFS(TreeNode root) {
    List<LinkedList<TreeNode>> result = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      result.add(current);

      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        if (parent.left != null) {
          current.add(parent.left);
        }
        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }

    return result;
  }
}