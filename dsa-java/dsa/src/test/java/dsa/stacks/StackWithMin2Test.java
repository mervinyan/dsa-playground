package dsa.stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackWithMin2Test {
  @Test
  public void test() {
    StackWithMin2 stack = new StackWithMin2();
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