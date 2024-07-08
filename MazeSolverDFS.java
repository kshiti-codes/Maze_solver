import java.util.Arrays;

public class MazeSolverDFS {
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

        boolean pathExists = solveMazeDFS(maze, start[0], start[1], end);
        System.out.println("Path exists: " + pathExists);
        printMaze(maze);
    }

    private static boolean solveMazeDFS(int[][] maze, int row, int col, int[] end) {
        if (row == end[0] && col == end[1]) {
            maze[row][col] = 2; // Mark the path
            return true;
        }

        if (isValidMove(maze, row, col)) {
            maze[row][col] = 2; // Mark the current cell as part of the path

            for (int i = 0; i < 4; i++) {
                int nextRow = row + ROW_MOVES[i];
                int nextCol = col + COL_MOVES[i];

                if (solveMazeDFS(maze, nextRow, nextCol, end)) {
                    return true;
                }
            }

            maze[row][col] = 0; // Unmark the current cell (backtrack)
        }

        return false;
    }

    private static boolean isValidMove(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0;
    }

    private static void printMaze(int[][] maze) {
        for (int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
    }
}
