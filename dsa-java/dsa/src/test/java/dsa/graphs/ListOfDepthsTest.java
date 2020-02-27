package dsa.graphs;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class ListOfDepthsTest {

  private TreeNode root;
  private ListOfDepths  sut;

  @Before
  public void setUp() {
    List<TreeNode> nodes = IntStream.of(1, 2, 3, 4, 5, 6, 7).mapToObj(i -> new TreeNode(i)).collect(Collectors.toList());

    nodes.get(3).left = nodes.get(1);
    nodes.get(1).left = nodes.get(0);
    nodes.get(1).right = nodes.get(2);
    nodes.get(3).right = nodes.get(5);
    nodes.get(5).left = nodes.get(4);
    nodes.get(5).right = nodes.get(6);
    
    root = nodes.get(3);
  }

  @Test
  public void testCreateLevelLinkedList_DFS() {
    sut = new ListOfDepths();
    List<LinkedList<TreeNode>> lists = sut.createLevelLinkedList_DFS(root);
    
    assertEquals(3, lists.size());
    
    assertEquals(1, lists.get(0).size());
    assertEquals(4, lists.get(0).getFirst().data);

    assertEquals(2, lists.get(1).size());
    assertEquals(2, lists.get(1).getFirst().data);
    assertEquals(6, lists.get(1).getLast().data);

    assertEquals(4, lists.get(2).size());
    assertEquals(1, lists.get(2).getFirst().data);
    assertEquals(3, lists.get(2).get(1).data);
    assertEquals(5, lists.get(2).get(2).data);
    assertEquals(7, lists.get(2).get(3).data);
  }

  @Test
  public void testCreateLevelLinkedList_BFS() {
    sut = new ListOfDepths();
    List<LinkedList<TreeNode>> lists = sut.createLevelLinkedList_BFS(root);
    
    assertEquals(3, lists.size());
    
    assertEquals(1, lists.get(0).size());
    assertEquals(4, lists.get(0).getFirst().data);

    assertEquals(2, lists.get(1).size());
    assertEquals(2, lists.get(1).getFirst().data);
    assertEquals(6, lists.get(1).getLast().data);

    assertEquals(4, lists.get(2).size());
    assertEquals(1, lists.get(2).getFirst().data);
    assertEquals(3, lists.get(2).get(1).data);
    assertEquals(5, lists.get(2).get(2).data);
    assertEquals(7, lists.get(2).get(3).data);
  }
}