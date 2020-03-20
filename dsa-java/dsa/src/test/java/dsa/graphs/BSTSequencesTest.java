package dsa.graphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTSequencesTest {
  private  BSTSequences sut;
  
  @Before
  public void setUp() {
    
    sut = new BSTSequences();
  }
  @Test
  public void testAllSequences_3Nodes() {
    TreeNode nodeOf2 = new TreeNode(2);
    nodeOf2.insertInOrder(1);
    nodeOf2.insertInOrder(3);
    List<LinkedList<Integer>> actual = sut.allSequences(nodeOf2);
    List<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.add(2);
    list1.add(1);
    list1.add(3);

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(2);
    list2.add(3);
    list2.add(1);

    expected.add(list1);
    expected.add(list2);

    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(toString(expected.get(i)), toString(actual.get(i)));
    }

  }

  @Test
  public void testAllSequences_10Nodes() {
    TreeNode nodeOf50 = new TreeNode(50);
    nodeOf50.insertInOrder(20);
    nodeOf50.insertInOrder(10);
    nodeOf50.insertInOrder(25);
    nodeOf50.insertInOrder(5);
    nodeOf50.insertInOrder(15);
    nodeOf50.insertInOrder(60);
    nodeOf50.insertInOrder(70);
    nodeOf50.insertInOrder(65);
    nodeOf50.insertInOrder(80);
    
    List<LinkedList<Integer>> actual = sut.allSequences(nodeOf50);
    System.out.println("number of possible arrays: " + actual.size());
    for (int i = 0; i < actual.size(); i++) {
      System.out.println(toString(actual.get(i)));
    }
    // List<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
    // LinkedList<Integer> list1 = new LinkedList<>();
    // list1.add(2);
    // list1.add(1);
    // list1.add(3);

    // LinkedList<Integer> list2 = new LinkedList<>();
    // list2.add(2);
    // list2.add(3);
    // list2.add(1);

    // expected.add(list1);
    // expected.add(list2);

    // assertEquals(expected.size(), actual.size());
    // for (int i = 0; i < expected.size(); i++) {
    //   assertEquals(toString(expected.get(i)), toString(actual.get(i)));
    // }

  }

  String toString(LinkedList<Integer> list) {
    StringBuilder sb = new StringBuilder(list.size());
    sb.append("{");
    sb.append(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      sb.append(", ");
      sb.append(list.get(i));
    }
    sb.append("}");
    return sb.toString();
  }

}