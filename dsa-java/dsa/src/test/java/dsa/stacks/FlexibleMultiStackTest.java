package dsa.stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlexibleMultiStackTest {
  @Test
  public void test() {
    FlexibleMultiStack stack = new FlexibleMultiStack(3, 2);
    stack.push(0, 10);
    stack.push(1, 20);
    stack.push(1, 40);
    stack.push(2, 30);
    stack.push(2, 50);
    stack.push(2, 60);

    assertEquals(10, stack.peek(0));
    assertEquals(40, stack.peek(1));
    assertEquals(60, stack.peek(2));

    stack.pop(1);
    assertEquals(20, stack.peek(1));

    stack.pop(2);
    assertEquals(50, stack.peek(2));
  }
}