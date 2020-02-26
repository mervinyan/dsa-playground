package dsa.graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RouteBetweenNodesTest {

  private Graph g;

  @Before
  public void setUp() {
    g = new Graph();
    Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		
  }
  @Test
  public void testSearch_ThereIsRouteBetweenNodes() {
    Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		assertEquals(true, RouteBetweenNodes.search(g, start, end));
  }

  @Test
  public void testSearch_ThereIsNoRouteBetweenNodes() {
    Node[] n = g.getNodes();
		Node start = n[2];
		Node end = n[5];
		assertEquals(false, RouteBetweenNodes.search(g, start, end));
  }
}