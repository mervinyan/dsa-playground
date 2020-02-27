package dsa.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimalTreeTest {
  @Test
  public void test() {
    int[] array = new int[10];
    for (int i = 0; i < 10; i++) {
      array[i] = i;
    }

    MinimalTree tree = new MinimalTree();
    TreeNode root = tree.createMinimalBST(array);

    assertEquals(4, root.data);
    assertEquals(1, root.left.data);
    assertEquals(2, root.left.right.data);

    // String expected = "0 1 2 3 4 5 6 7 8 9";
    // assertEquals(expected, root.toString());
  }
}