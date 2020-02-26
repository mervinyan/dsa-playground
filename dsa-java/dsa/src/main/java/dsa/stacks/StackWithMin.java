package dsa.stacks;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {

  public void push(int value) {
    int newMin = Math.min(value, min());
    super.push(new NodeWithMin(value, newMin));
  }

  public int min() {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return peek().min;
    }
  }
}

class NodeWithMin {
  int value;
  int min;

  public NodeWithMin(int v, int min) {
    this.value = v;
    this.min = min;
  }
}