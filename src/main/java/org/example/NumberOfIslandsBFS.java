package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Function to count the number of islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    // Breadth-First Search to mark the connected land as visited
    private void bfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = '0'; // Mark the cell as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0], currY = current[1];

            for (int[] direction : DIRECTIONS) {
                int newX = currX + direction[0];
                int newY = currY + direction[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = '0'; // Mark the cell as visited
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        NumberOfIslandsBFS solution = new NumberOfIslandsBFS();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid1)); // Output: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid2)); // Output: 3
    }
}

