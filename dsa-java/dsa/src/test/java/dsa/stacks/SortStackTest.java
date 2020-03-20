package dsa.stacks;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class SortStackTest {
  @Test
  public void test() {
    Stack<Integer> s = new Stack<>();

    s.push(7);
    s.push(10);
    s.push(5);

    SortStack.sort(s);

    assertEquals(Integer.valueOf(5), s.pop());
    assertEquals(Integer.valueOf(7), s.pop());
    assertEquals(Integer.valueOf(10), s.pop());
  }
}