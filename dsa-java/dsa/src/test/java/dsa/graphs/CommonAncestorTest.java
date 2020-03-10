package dsa.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommonAncestorTest {

  private TreeNode nodeOf20;
  private  CommonAncestor sut;
  
  @Before
  public void setUp() {
    nodeOf20 = new TreeNode(20);
    nodeOf20.insertInOrder(10);
    nodeOf20.insertInOrder(30);
    nodeOf20.insertInOrder(5);
    nodeOf20.insertInOrder(15);
    nodeOf20.insertInOrder(3);
    nodeOf20.insertInOrder(7);
    nodeOf20.insertInOrder(17);

    sut = new CommonAncestor();
  }
  @Test
  public void testFindCommonAncestor_V1() {
    TreeNode nodeOf3 = nodeOf20.find(3);
    TreeNode nodeOf17 = nodeOf20.find(17);
    TreeNode nodeOf10 = nodeOf20.find(10);

    TreeNode actual = sut.findCommonAncestor_V1(nodeOf3, nodeOf17);
    TreeNode expected = nodeOf10;

    assertEquals(expected, actual);
  }

  @Test
  public void testFindCommonAncestor_V2() {
    TreeNode nodeOf3 = nodeOf20.find(3);
    TreeNode nodeOf17 = nodeOf20.find(17);
    TreeNode nodeOf10 = nodeOf20.find(10);

    TreeNode actual = sut.findCommonAncestor_V2(nodeOf20, nodeOf3, nodeOf17);
    TreeNode expected = nodeOf10;

    assertEquals(expected, actual);
  }

  @Test
  public void testFindCommonAncestor_V3() {
    TreeNode nodeOf3 = nodeOf20.find(3);
    TreeNode nodeOf17 = nodeOf20.find(17);
    TreeNode nodeOf10 = nodeOf20.find(10);

    TreeNode actual = sut.findCommonAncestor_V3(nodeOf20, nodeOf3, nodeOf17);
    TreeNode expected = nodeOf10;

    assertEquals(expected, actual);
  }

  @Test
  public void testFindCommonAncestor_V4() {
    TreeNode nodeOf3 = nodeOf20.find(3);
    TreeNode nodeOf17 = nodeOf20.find(17);
    TreeNode nodeOf10 = nodeOf20.find(10);

    TreeNode actual = sut.findCommonAncestor_V4(nodeOf20, nodeOf3, nodeOf17);
    TreeNode expected = nodeOf10;

    assertEquals(expected, actual);
  }
}