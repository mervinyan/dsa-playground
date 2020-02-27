package dsa.graphs;

public class TreeNode {
  public int data;
  public TreeNode left, right, parent;
  private int size = 0;

  public TreeNode(int data) {
    this.data = data;
    this.size = 1;
  }

  public void insertInOrder(int data) {
    if (data < this.data) {
      if (left == null) {
        setLeftChild(new TreeNode(data));
      } else {
        left.insertInOrder(data);
      }
    } else {
      if (right == null) {
        setRightChild(new TreeNode(data));
      } else {
        right.insertInOrder(data);
      }
    }
    size++;
  }

  public int size() {
    return size;
  }

  public TreeNode find(int data) {
    if (data == this.data) {
      return this;
    } else if (data < this.data) {
      return left != null ? left.find(data) : null;
    } else if (data> this.data) {
      return right != null ? right.find(data) : null; 
    }
    return null;
  }

  public void setLeftChild(TreeNode left) {
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  public void setRightChild(TreeNode right) {
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  @Override
  public String toString() {
    return String.format("%s%s%s", left != null ? (left.toString()+" ") : "", data, right != null ? (right.toString() + " ") : "");
  }
}