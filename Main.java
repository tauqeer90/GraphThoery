import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    List<List<Character>> adjacencyMatrix = new ArrayList<>();
    List<Character> tempNode = new ArrayList<>(Arrays.asList('.', 
    '.', '.', '#', '.', '.', '.'));
    adjacencyMatrix.add(tempNode);

    tempNode = new ArrayList<>(Arrays.asList('.', 
    '#', '.', '.', '.', '#', '.'));
    adjacencyMatrix.add(tempNode);

    tempNode = new ArrayList<>(Arrays.asList('.', 
    '#', '.', '.', '.', '.', '.'));
    adjacencyMatrix.add(tempNode);

     tempNode = new ArrayList<>(Arrays.asList('.', 
    '.', '#', '#', '.', '.', '.'));
    adjacencyMatrix.add(tempNode);

     tempNode = new ArrayList<>(Arrays.asList('#', 
    '.', '#', 'E', '.', '#', '.'));
    adjacencyMatrix.add(tempNode);

    BfsShortestPath bfs = new BfsShortestPath(adjacencyMatrix);
    System.out.println(bfs.shortestPath(0,0));

  }
}