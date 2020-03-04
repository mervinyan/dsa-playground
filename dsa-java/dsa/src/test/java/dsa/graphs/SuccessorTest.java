package dsa.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuccessorTest {
 
  @Test
  public void testInorderSuccessor() {
    TreeNode nodeOf20 = new TreeNode(20);
    nodeOf20.insertInOrder(10);
    nodeOf20.insertInOrder(30);
    nodeOf20.insertInOrder(5);
    nodeOf20.insertInOrder(15);
    nodeOf20.insertInOrder(3);
    nodeOf20.insertInOrder(7);
    nodeOf20.insertInOrder(17);

    Successor successor = new Successor();
    assertEquals(30, successor.inorderSuccessor(nodeOf20).data);
  }
}