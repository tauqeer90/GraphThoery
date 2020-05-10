import java.util.*;

public class DFS
{
  private List<List<Node>> adjMatrix;
  private List<Boolean> visited;

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

  public int[] findConnectedComponents()
  {
    int count = -1;
    int[] connectedComponents = new int[adjMatrix.size()];
    for(int i = 0; i < adjMatrix.size(); i++)
    {
      if(visited.get(i) == false)
      {
        count++;
        connectedComponentsDfs(connectedComponents, i, count);
      }
    }
    return connectedComponents;
  }

  private void connectedComponentsDfs(int[] connectedComponents, int startNodeIndex, int count)
  {
    visited.set(startNodeIndex, true);

    connectedComponents[startNodeIndex] = count;
    List<Node> neighbours = adjMatrix.get(startNodeIndex);
    Iterator<Node> iter = neighbours.iterator();
    
    while(iter.hasNext())
    {
      Node nextNeighbour = iter.next();
      if(visited.get(nextNeighbour.index) == false)
      {
        connectedComponentsDfs(connectedComponents, nextNeighbour.index, count);
      }
    }
  }



}