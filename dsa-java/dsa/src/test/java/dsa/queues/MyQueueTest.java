package dsa.queues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyQueueTest {
  @Test
  public void test() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    assertEquals(3, queue.size());
    assertEquals(new Integer(10), queue.peek());
    assertEquals(new Integer(10), queue.remove());
    assertEquals(new Integer(20), queue.peek());
  }
}