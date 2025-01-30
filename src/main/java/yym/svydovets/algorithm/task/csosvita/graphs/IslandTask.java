package yym.svydovets.algorithm.task.csosvita.graphs;

public class IslandTask {

    /**
     * {@link yym.svydovets.algorithm.task.matrix.NumsOfIslands}
     */
    public static int findIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islandsTotal = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    dfs(grid, row, col);
                    islandsTotal++;
                }
            }
        }
        return islandsTotal;
    }

    private static void dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

}
