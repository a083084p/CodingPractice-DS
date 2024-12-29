package org.example.Graph;

import java.util.Arrays;

public class NetworkDelayTimeBellmanFord {

    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize distances array with "infinity" values.
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // The distance to the start node is 0.

        // Relax edges up to n-1 times
        for (int i = 1; i <= n - 1; i++) {
            // Iterate through each edge
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];
                // Relax the edge if a shorter path to v is found via u
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Find the maximum distance from the start node to any other node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If there's a node that can't be reached, return -1
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTimeBellmanFord ndt = new NetworkDelayTimeBellmanFord();

        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4;
        int k1 = 2;
        System.out.println(ndt.networkDelayTime(times1, n1, k1));  // Output: 2

        int[][] times2 = {{1, 2, 1}};
        int n2 = 2;
        int k2 = 1;
        System.out.println(ndt.networkDelayTime(times2, n2, k2));  // Output: 1

        int[][] times3 = {{1, 2, 1}};
        int n3 = 2;
        int k3 = 2;
        System.out.println(ndt.networkDelayTime(times3, n3, k3));  // Output: -1
    }
}

