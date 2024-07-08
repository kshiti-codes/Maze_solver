import java.util.LinkedList;
import java.util.Queue;

public class MazeSolverBFS {
    private static final int[] ROW_MOVES = {-1, 1, 0, 0};
    private static final int[] COL_MOVES = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };
        int[] start = {0, 0};
        int[] end = {4, 4};

        boolean pathExists = solveMazeBFS(maze, start, end);
        System.out.println("Path exists: " + pathExists);
        printMaze(maze);
    }

    private static boolean solveMazeBFS(int[][] maze, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2; // Mark the start cell as part of the path

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == end[0] && col == end[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = row + ROW_MOVES[i];
                int nextCol = col + COL_MOVES[i];

                if (isValidMove(maze, nextRow, nextCol)) {
                    queue.add(new int[]{nextRow, nextCol});
                    maze[nextRow][nextCol] = 2; // Mark the cell as part of the path
                }
            }
        }

        return false;
    }

    private static boolean isValidMove(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0;
    }

    private static void printMaze(int[][] maze) {
        for (int[] row : maze) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
