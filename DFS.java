import java.util.*;

public class DFS
{
  List<List<Node>> adjMatrix;
  List<Boolean> visited;

  public DFS(List<List<Node>> adjMatrix)
  {
    this.adjMatrix = adjMatrix;
    Boolean[] tempVisited = new Boolean[adjMatrix.size()];
    Arrays.fill(tempVisited, new Boolean(false));
    visited = Arrays.asList(tempVisited);
  }

  public boolean findNodeUsingDfs(Node startNode, int searchValue)
  {
    if(visited.get(startNode.index) == true)
      return false;

    visited.set(startNode.index, true);

    if(startNode.value == searchValue)
    {
      return true;
    }

    List<Node> neighbours = adjMatrix.get(startNode.index);
    Iterator<Node> iter = neighbours.iterator();
    while(iter.hasNext())
    {
       boolean result = findNodeUsingDfs(iter.next(), searchValue);
       if(result == true)
        return result;
    }

    return false;
  }

}