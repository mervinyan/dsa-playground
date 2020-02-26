package dsa.stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetOfStacksTest {
  @Test
  public void test() {
    SetOfStacks stacks = new SetOfStacks(3);
    for (int i = 0; i < 10; i++) {
      stacks.push(i);
    }
    assertEquals(9, stacks.pop());
    assertEquals(8, stacks.popAt(2));
    assertEquals(5, stacks.popAt(1));
    assertEquals(6, stacks.popAt(1));
  }
}