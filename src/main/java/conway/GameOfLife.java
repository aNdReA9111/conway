package conway;

public class GameOfLife {
    private int[][] grid;

    public GameOfLife(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setCell(int row, int col, int state) {
        grid[row][col] = state;
    }

    public void nextGeneration() {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];

        updateGridRecursively(newGrid, 0, 0);
        grid = newGrid;
    }

    private void updateGridRecursively(int[][] newGrid, int row, int col) {
        if (row >= grid.length) return;
        if (col >= grid[0].length) {
            updateGridRecursively(newGrid, row + 1, 0);
            return;
        }

        int neighbors = countLiveNeighbors(row, col);
        CellState state = CellStateFactory.getState(grid[row][col]);
        newGrid[row][col] = state.nextState(neighbors);

        updateGridRecursively(newGrid, row, col + 1);
    }

    private int countLiveNeighbors(int row, int col) {
        return countLiveNeighborsRecursively(row, col, row - 1, col - 1);
    }

    private int countLiveNeighborsRecursively(int row, int col, int r, int c) {
        if (r > row + 1) return 0;
        if (c > col + 1) return countLiveNeighborsRecursively(row, col, r + 1, col - 1);

        int count = (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && (r != row || c != col)) ? grid[r][c] : 0;
        return count + countLiveNeighborsRecursively(row, col, r, c + 1);
    }
}
