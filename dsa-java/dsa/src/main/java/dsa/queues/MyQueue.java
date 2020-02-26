package dsa.queues;

import java.util.Stack;

public class MyQueue<T> {
  private Stack<T> stackOldest, stackNewest;

  public MyQueue() {
    stackNewest = new Stack<T>();
    stackOldest = new Stack<T>();
  }

  public int size() {
    return stackNewest.size() + stackOldest.size();
  }

  public void add(T value) {
    stackNewest.push(value);
  }

  /**
   * Move elements from stackNewest into stackOldest. 
   * This is usually done so that we can do operations on stackOldest.
   */
  private void shiftStacks() {
    if (stackOldest.isEmpty()) {
      while (!stackNewest.isEmpty()) {
        stackOldest.push(stackNewest.pop());
      }
    }
  }

  public T peek() {
    shiftStacks();;
    return stackOldest.peek();
  }

  public T remove() {
    shiftStacks();
    return stackOldest.pop();
  }
}