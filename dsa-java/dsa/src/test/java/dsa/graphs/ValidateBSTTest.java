package dsa.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ValidateBSTTest {
  private TreeNode binarySearchTree;
  private ValidateBST sut;

  @Before
  public void setUp() {
    TreeNode nodeOf20 = new TreeNode(20);
    nodeOf20.insertInOrder(10);
    nodeOf20.insertInOrder(30);
    nodeOf20.insertInOrder(5);
    nodeOf20.insertInOrder(15);
    nodeOf20.insertInOrder(3);
    nodeOf20.insertInOrder(7);
    nodeOf20.insertInOrder(17);

    binarySearchTree = nodeOf20;

    sut = new ValidateBST();
  }

  @Test
  public void testCheckBST_V1() {  
    assertEquals(true, sut.checkBST_V1(binarySearchTree));
  }

  @Test
  public void testCheckBST_V2() {
    assertEquals(true, sut.checkBST_V2(binarySearchTree));
  }

  @Test
  public void testCheckBST_V3() {
    assertEquals(true, sut.checkBST_V3(binarySearchTree));
  }

}