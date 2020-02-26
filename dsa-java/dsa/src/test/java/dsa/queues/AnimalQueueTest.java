package dsa.queues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalQueueTest {
  @Test
  public void test() {
    AnimalQueue queue = new AnimalQueue();
    queue.enqueue(new Dog("Dog1"));
    queue.enqueue(new Dog("Dog2"));
    queue.enqueue(new Cat("Cat1"));
    queue.enqueue(new Cat("Cat2"));
    queue.enqueue(new Cat("Cat3"));
    queue.enqueue(new Dog("Dog3"));

    assertEquals("Dog1", queue.dequeueAny().name);
    assertEquals("Cat1", queue.dequeueCats().name);
    assertEquals("Dog2", queue.dequeueDogs().name);
  }
}