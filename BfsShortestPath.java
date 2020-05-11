import java.util.*;

public class BfsShortestPath
{
  private List<List<Character>> adjacencyMatrix;
  private List<List<Boolean>> visited = new ArrayList<>();
  private int rows;
  private int cols;
  private Queue<Integer> rowQueue;
  private Queue<Integer> colQueue;
  private int[] directionRow = {0, 0, 1, -1};
  private int[] directionCol = {-1, 1, 0, 0};
  private int nodesInCurrentLayer = 1;
  private int nodesInNextLayer = 0;
  private int moveCount = 0;


  public BfsShortestPath(List<List<Character>> adjacenyMatrix)
  {
    this.adjacencyMatrix = adjacenyMatrix;
    this.cols = adjacenyMatrix.get(0).size();
    this.rows = adjacenyMatrix.size();
    Boolean[] tempVisited = new Boolean[cols];
    Arrays.fill(tempVisited, false);
    for(int i = 0; i < rows; i++)
    {
      visited.add(new ArrayList<>(Arrays.asList(tempVisited)));
    }
    rowQueue = new LinkedList<>();
    colQueue = new LinkedList<>();
  }

  public int shortestPath(int startRow, int startCol)
  {
    rowQueue.add(startRow);
    colQueue.add(startCol);
    visited.get(startRow).set(startCol, true);
    while(!rowQueue.isEmpty())
    {
      int row = rowQueue.remove();
      int col = colQueue.remove();
      Character currentNode = adjacencyMatrix.get(row).get(col);
      if(currentNode == 'E')
      {
        return moveCount;
      }
      enqueValidNeighbours(row, col);
      nodesInCurrentLayer--;
      if(nodesInCurrentLayer == 0)
      {
        nodesInCurrentLayer = nodesInNextLayer;
        nodesInNextLayer = 0;
        moveCount++;
      }
    }
    return -1;
  }

  public void enqueValidNeighbours(int currentRow, int currentCol)
  {
    for(int i = 0; i < 4; i++)
    {
      int neighbourRow = currentRow + directionRow[i];
      int neighbourCol = currentCol + directionCol[i];

      if(neighbourRow >= rows || neighbourCol >= cols || neighbourRow < 0 || neighbourCol < 0)
        continue;

      if(visited.get(neighbourRow).get(neighbourCol) == true)
        continue;

      visited.get(neighbourRow).set(neighbourCol, true);
      Character neighbourNode = adjacencyMatrix.get(neighbourRow).get(neighbourCol);
      
      if(neighbourNode == '#')
        continue;

      rowQueue.add(neighbourRow);
      colQueue.add(neighbourCol);
      nodesInNextLayer++;
    }
  }


}