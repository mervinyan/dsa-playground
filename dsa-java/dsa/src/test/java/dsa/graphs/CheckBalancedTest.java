package dsa.graphs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class CheckBalancedTest {
  private TreeNode balancedTree;
  private TreeNode unbalancedTree;

  private CheckBalanced  sut;

  @Before
  public void setUp() {
    List<TreeNode> nodes = IntStream.of(1, 2, 3, 4, 5, 6, 7).mapToObj(i -> new TreeNode(i)).collect(Collectors.toList());

    nodes.get(3).left = nodes.get(1);
    nodes.get(1).left = nodes.get(0);
    nodes.get(1).right = nodes.get(2);
    nodes.get(3).right = nodes.get(5);
    nodes.get(5).left = nodes.get(4);
    nodes.get(5).right = nodes.get(6);
    
    balancedTree = nodes.get(3);

    unbalancedTree = new TreeNode(20);
    unbalancedTree.left = nodes.get(3);
    unbalancedTree.right = new TreeNode(10);
  }

  @Test
  public void testIsBalanced_V1_Balanced() {
    sut = new CheckBalanced();
    assertEquals(true, sut.isBalanced_V1(balancedTree));
  }

  @Test
  public void testIsBalanced_V2_Balanced() {
    sut = new CheckBalanced();
    assertEquals(true, sut.isBalanced_V2(balancedTree));
  }

  @Test
  public void testIsBalanced_V1_Unbalanced() {
    sut = new CheckBalanced();
    assertEquals(false, sut.isBalanced_V1(unbalancedTree));
  }

  @Test
  public void testIsBalanced_V2_Unbalanced() {
    sut = new CheckBalanced();
    assertEquals(false, sut.isBalanced_V2(unbalancedTree));
  }
}