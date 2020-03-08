package dsa.graphs;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

import dsa.graphs.BuildOrder.Project;

public class BuildOrderTest {
  
  @Test
  public void testFindBuildOrder_V1() {
    String[] projects = { "a", "b", "c", "d", "e", "f", "g" };
    String[][] dependencies = { { "f", "c" }, { "f", "b" }, { "c", "a" }, { "b", "a" }, { "f", "a" }, { "a", "e" },
        { "b", "e" }, { "d", "g" } };

    String[] expecteds = { "d", "f", "g", "c", "b", "a", "e" };

    BuildOrder sut = new BuildOrder();
    Project[] orderedProjects = sut.findBuildOrder_V1(projects, dependencies);

    String[] actuals = Arrays.stream(orderedProjects).map(p -> p.getName()).toArray(String[]::new);

    assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void testFindBuildOrder_V2() {
    String[] projects = { "a", "b", "c", "d", "e", "f", "g" };
    String[][] dependencies = { { "f", "c" }, { "f", "b" }, { "c", "a" }, { "b", "a" }, { "f", "a" }, { "a", "e" },
        { "b", "e" }, { "d", "g" } };

    String[] expecteds = { "f", "d", "g", "c", "b", "a", "e" };

    BuildOrder sut = new BuildOrder();
    Stack<Project> orderedProjects = sut.findBuildOrder_V2(projects, dependencies);

    Stack<Project> reversedOrderedProjects = new Stack<>();
    while (!orderedProjects.isEmpty()) {
      reversedOrderedProjects.push(orderedProjects.pop());
    }
    String[] actuals = reversedOrderedProjects.stream().map(p -> p.getName()).toArray(String[]::new);

    assertArrayEquals(expecteds, actuals);
  }
}