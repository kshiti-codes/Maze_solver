# Maze_solver

## Explanation
### DFS Implementation
1. Main Method:

Defines the maze, the starting point, and the ending point.
Calls the solveMazeDFS method to solve the maze.
Prints if a path exists and the resulting maze.

2. solveMazeDFS Method:

Recursive method to solve the maze using DFS.
Base case: If the current cell is the end cell, mark it and return true.
Recursive case: If the current move is valid, mark the cell and explore all possible moves (up, down, left, right).
If a move leads to the end, return true; otherwise, backtrack by unmarking the cell.

3. isValidMove Method:

Checks if the current cell is within bounds and not a wall.

4. printMaze Method:

Prints the maze with the path marked.

### BFS Implementation
1. Main Method:

Defines the maze, the starting point, and the ending point.
Calls the solveMazeBFS method to solve the maze.
Prints if a path exists and the resulting maze.

2. solveMazeBFS Method:

Uses a queue to implement BFS.
Marks the start cell and adds it to the queue.
While the queue is not empty, dequeues the current cell and checks if it's the end cell.
For each valid move, marks the cell and enqueues it.
Returns true if the end cell is reached.

3. isValidMove Method:

Checks if the current cell is within bounds and not a wall.

4. printMaze Method:

Prints the maze with the path marked.

## Complexity Analysis
### Time Complexity
1. DFS Time Complexity:

In the worst case, DFS explores all cells of the maze once.
Time complexity is O(N * M), where N is the number of rows and M is the number of columns.

2. BFS Time Complexity:

BFS also explores all cells of the maze once in the worst case.
Time complexity is O(N * M).

### Space Complexity
1. DFS Space Complexity:

The space complexity is O(N * M) due to the recursion stack in the worst case where the path is very convoluted.

2. BFS Space Complexity:

The space complexity is O(N * M) due to the queue storing all cells of the maze in the worst case.

## Conclusion
Both DFS and BFS can be used to solve the maze problem effectively. BFS is usually preferred for shortest path problems as it explores all nodes level by level. DFS can be more memory efficient for large but shallow mazes.
