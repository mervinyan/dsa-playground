package dsa.stacks;

import java.util.EmptyStackException;

public class FlexibleMultiStack {

  /**
   * StackInfo is a simple class that holds a set of data about each stack.
   * It does no thold the actual items in the stack. We could have done this with just a bunch of individual variables,
   * but that's messy and doesn't gain us much.
   */
  private class StackInfo {
    public int start, size, capacity;
    
    public StackInfo(int start, int capacity) {
      this.start = start;
      this.capacity = capacity;
    }

   /**
    * Check if an index on the full array is within the stack boundaries.
    * The stack can wrap around to the start of the array.
    */
    public boolean isWithinStackCapacity(int index) {
      // if outside of bounds of array, return false
      if (index < 0 || index >= values.length) {
        return false;
      }

      // if index wraps around, ajust it
      int contiguousIndex = index < start ? index + values.length : index;
      int end = start + capacity;

      return start <= contiguousIndex && contiguousIndex < end;
    }

    public int lastCapacityIndex() {
      return adjustIndex(start + capacity - 1);
    }

    public int lastElementIndex() {
      return adjustIndex(start + size - 1);
    }

    public boolean isFull() {
      return size == capacity;
    }

    public boolean isEmpty() {
      return size == 0;
    }
  }

  private StackInfo[] info;
  private int[] values;

  public FlexibleMultiStack(int numberOfStacks, int defaultSize) {
    info = new StackInfo[numberOfStacks];
    for (int i = 0; i < numberOfStacks; i++) {
      info[i] = new StackInfo(defaultSize * i, defaultSize);
    }
    values = new int[numberOfStacks * defaultSize];
  }

  /**
   * Push value onto stack num, shifting/expanding stacks as necessary.
   * Throws exception if all stackss are full
   */
  public void push(int stackNum, int value) {
    if (allStacksAreFull()) {
      throw new FullStackException();
    }

    StackInfo stack = info[stackNum];
    if (stack.isFull()) {
      expand(stackNum);
    }

    // find the index of the top element in the array + 1, and increment the stack pointer
    stack.size++;
    values[stack.lastElementIndex()] = value;
  }

  /**
   * Remove value from stack
   */
  public int pop(int stackNum) {
    StackInfo stack = info[stackNum];
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }

    int value = values[stack.lastElementIndex()];
    values[stack.lastElementIndex()] = 0;
    stack.size--;
    return value;
  }

  /**
   * Get top element of stack
   */
  public int peek(int stackNum) {
    StackInfo stack = info[stackNum];
    return values[stack.lastElementIndex()];
  }

  private void shift(int stackNum) {
    System.out.println("/// Shifting " + stackNum);
    StackInfo stack = info[stackNum];

    // if this stack is at its full capacity, then you need to move the next stack over by one element. 
    // This stack can now claim the freed index
    if (stack.size >= stack.capacity) {
      int nextStack = (stackNum + 1) % info.length;
      shift(nextStack);
      stack.capacity++;
    }

    // Shift all elements in stack over by one
    int index = stack.lastCapacityIndex();
    while (stack.isWithinStackCapacity(index)) {
      values[index] = values[previousIndex(index)];
      index = previousIndex(index);
    }

    //Adjust stack data
    values[stack.start] = 0;
    stack.start = nextIndex(stack.start);
    stack.capacity--;
  }

  // expand stack by shifting over other stacks
  private void expand(int stackNum) {
    shift((stackNum+1) % info.length);
    info[stackNum].capacity++;
  }

  // returns the number of items actually present in stack
  public int numberOfElements() {
    int size = 0;
    for (StackInfo sd : info) {
      size += sd.size;
    }
    return size;
  }

  /**
   * returns true if all the stacks are full
   */
  public boolean allStacksAreFull() {
    return numberOfElements() == values.length;
  }

  // adjust index to be within the range of 0 -> length - 1
  private int adjustIndex(int index) {
    //Java's mod operator can return neg values. For example, (-11 %  5) will return -1, not 4.
    //We actually want the value to be 4 (since we are wrapping around the index)
    int max = values.length;
    return ((index % max) + max) % max;
  }

  // get index after this index, adjusted for wrap around
  private int nextIndex(int index) {
    return adjustIndex(index + 1);
  }

  // get index before this index, adjusted for wrap around
  private int previousIndex(int index) {
    return adjustIndex(index - 1);
  }


}