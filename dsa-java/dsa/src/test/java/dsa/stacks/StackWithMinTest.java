package dsa.stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackWithMinTest {
  @Test
  public void test() {
    StackWithMin stack = new StackWithMin();
    stack.push(5);
    assertEquals(5, stack.min());

    stack.push(6);
    assertEquals(5, stack.min());

    stack.push(3);
    assertEquals(3, stack.min());

    stack.push(7);
    assertEquals(3, stack.min());

    stack.pop();
    assertEquals(3, stack.min());

    stack.pop();
    assertEquals(5, stack.min());
  }
}