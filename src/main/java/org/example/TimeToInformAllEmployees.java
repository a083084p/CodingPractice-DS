package org.example;

import java.util.ArrayList;
import java.util.List;

public class TimeToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create an adjacency list to represent the hierarchy
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }

        // Perform DFS to find the total time to inform all employees
        return dfs(headID, subordinates, informTime);
    }

    private int dfs(int current, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        for (int subordinate : subordinates.get(current)) {
            maxTime = Math.max(maxTime, dfs(subordinate, subordinates, informTime));
        }
        return maxTime + informTime[current];
    }

    // Main method for testing
    public static void main(String[] args) {
        TimeToInformAllEmployees solution = new TimeToInformAllEmployees();
        int n1 = 1;
        int headID1 = 0;
        int[] manager1 = {-1};
        int[] informTime1 = {0};
        System.out.println(solution.numOfMinutes(n1, headID1, manager1, informTime1)); // Output: 0

        int n2 = 6;
        int headID2 = 2;
        int[] manager2 = {2, 2, -1, 2, 2, 2};
        int[] informTime2 = {0, 0, 1, 0, 0, 0};
        System.out.println(solution.numOfMinutes(n2, headID2, manager2, informTime2)); // Output: 1
    }
}

