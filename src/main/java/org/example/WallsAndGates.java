package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int INF = 2147483647;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all gates' positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Perform BFS from each gate
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Check if the new position is within bounds and is an empty room
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && rooms[newX][newY] == INF) {
                    rooms[newX][newY] = rooms[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] rooms1 = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        solution.wallsAndGates(rooms1);
        for (int[] row : rooms1) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Output: [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]

        int[][] rooms2 = {{-1}};
        solution.wallsAndGates(rooms2);
        for (int[] row : rooms2) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Output: [[-1]]
    }
}
