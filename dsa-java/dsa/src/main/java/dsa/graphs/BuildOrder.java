package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BuildOrder {

  // Fina a correct build order
  Project[] findBuildOrder_V1(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects_V1(graph.getNodes());
  }

  Stack<Project> findBuildOrder_V2(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects_V2(graph.getNodes());
  }

  // Build the graph, adding the edge (a, b) if b is dependent on a. Asume a pair is list in the build order.
  // The pair (a, b) in dependencies indicates that b depends on a and a must be built before b.
  Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();

    for (String project : projects) {
      graph.getOrCreateNode(project);
    }

    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }

    return graph;
  }

  // Return a list of the projects a correct build order
  Project[] orderProjects_V1(List<Project> projects) {
    Project[] order = new Project[projects.size()];

    // Add roots to the build order first
    int endOfList = addNonDependent(order, projects, 0);

    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Project current = order[toBeProcessed];

      // We have a circular dependency since there are no remaining projects with zero dependencies.
      if (current == null) {
        return null;
      }

      // Remove itslef as a dependency
      List<Project> children = current.getChildren();
      for (Project child : children) {
        child.decrementDependencies();
      }

      // Add children that have no one depending on them
      endOfList = addNonDependent(order, children, endOfList);
      toBeProcessed++;
    }

    return order;
  }

  Stack<Project> orderProjects_V2(List<Project> projects) {
    Stack<Project> stack = new Stack<Project>();
    for (Project project : projects) {
      if (project.getState() == Project.State.BLANK) {
        if (!doDFS(project, stack)) {
          return null;
        }
      }
    }
    return stack;
  }

  boolean doDFS(Project project, Stack<Project> stack) {
    if (project.getState() == Project.State.PARTIAL) {
      return false;
    }

    if (project.getState() == Project.State.BLANK) {
      project.setState(Project.State.PARTIAL);
      List<Project> children = project.getChildren();
      for (Project child : children) {
        if (!doDFS(child, stack)) {
          return false;
        }
      }
      project.setState(Project.State.COMPLETE);
      stack.push(project);
    }

    return true;
  }

  // A helpe function ot insert projects with zero dependencies into the order array, starting at index offset
  int addNonDependent(Project[] order, List<Project> projects, int offset) {
    for (Project project : projects) {
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        offset++;
      }
    }
    return offset;
  }

  class Graph {
    private List<Project> nodes = new ArrayList<>();
    private Map<String, Project> map = new HashMap<String, Project>();
  
    public Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        nodes.add(node);
        map.put(name, node);
      }
  
      return map.get(name);
    }
  
    public void addEdge(String startName, String endName) {
      Project start = getOrCreateNode(startName);
      Project end = getOrCreateNode(endName);
      start.addNeigbor(end);
    }
  
    public List<Project> getNodes() {
      return nodes;
    }
  }
  
  static class Project {
    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;

    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;

    public State getState() {
      return state;
    }

    public void setState(State state) {
      this.state = state;
    }
  
    public Project(String n) {
      this.name = n;
    }
  
    public void addNeigbor(Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
        node.incrementDependencies();
      }
    }
  
    public void incrementDependencies() {
      dependencies++;
    }
  
    public void decrementDependencies() {
      dependencies--;
    }
  
    public String getName() {
      return name;
    }
  
    public List<Project> getChildren() {
      return children;
    }
  
    public int getNumberDependencies() {
      return dependencies;
    }
  }
}

