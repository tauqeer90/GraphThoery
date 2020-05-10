import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Node node0 = new Node(0, 50);
    Node node1 = new Node(1, 100);
    Node node2 = new Node(2, 300);
    Node node3 = new Node(3, 500);

    List<List<Node>> adjMatrix = new ArrayList<>();
    adjMatrix.add(new ArrayList<Node>(Arrays.asList(node1, node3)));
    adjMatrix.add(new ArrayList<Node>(Arrays.asList(node0, node2)));
    adjMatrix.add(new ArrayList<Node>(Arrays.asList(node1, node3)));
    adjMatrix.add(new ArrayList<Node>(Arrays.asList(node0, node2)));
    DFS dfs = new DFS(adjMatrix);

    System.out.println("Result: " + dfs.findNodeUsingDfs(node0, 100));
  }
}