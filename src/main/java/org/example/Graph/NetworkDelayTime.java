package org.example.Graph;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Min-heap to store the current node and the cost to reach it
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{k, 0});

        // Map to track the minimum time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int time = current[1];

            if (dist.containsKey(node)) continue;  // Skip if already visited

            dist.put(node, time);  // Record the minimum time

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int nextTime = time + neighbor[1];
                    if (!dist.containsKey(nextNode)) {
                        minHeap.add(new int[]{nextNode, nextTime});
                    }
                }
            }
        }

        if (dist.size() != n) return -1;  // If not all nodes are visited, return -1

        int maxTime = Collections.max(dist.values());
        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();

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



//Summary

//Let's break down and explain the function `networkDelayTime` step by step. This function is designed to find the minimum time required for a signal to reach all nodes in a network, starting from a specific node `k`. If it's impossible for the signal to reach all nodes, it returns `-1`.

//        ### Function Overview
//
//        - **Input Parameters:**
//        - `times`: A 2D array where each entry is of the form `[u, v, w]`, representing a directed edge from node `u` to node `v` with a travel time `w`.
//        - `n`: The total number of nodes in the network.
//        - `k`: The starting node from which the signal is sent.
//
//        - **Output:**
//        - The function returns the minimum time required for the signal to reach all nodes. If not all nodes can be reached, it returns `-1`.
//
//        ### Detailed Explanation
//
//        #### 1. Creating the Graph (Adjacency List)
//
//        ```java
//        Map<Integer, List<int[]>> graph = new HashMap<>();
//        for (int[] time : times) {
//        graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
//        }
//        ```
//
//        - **Purpose**:
//        - This part of the code builds an adjacency list representation of the graph using a `Map`. The key is the source node, and the value is a list of arrays. Each array contains a destination node and the travel time to that node.
//
//        - **Explanation**:
//        - `computeIfAbsent(time[0], x -> new ArrayList<>())`: This method checks if the key `time[0]` exists in the map. If not, it creates a new `ArrayList` and associates it with the key.
//        - `.add(new int[]{time[1], time[2]})`: Adds an edge to the list of the source node, with the target node `time[1]` and travel time `time[2]`.
//
//        #### 2. Initializing the Min-Heap (Priority Queue)
//
//        ```java
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        minHeap.add(new int[]{k, 0});
//        ```
//
//        - **Purpose**:
//        - The `PriorityQueue` (min-heap) is used to keep track of the next node to process based on the shortest time to reach it.
//
//        - **Explanation**:
//        - `PriorityQueue<>(Comparator.comparingInt(a -> a[1]))`: The min-heap is initialized to prioritize nodes with the smallest travel time. The comparator ensures that the queue orders its elements based on the second element (`a[1]`) of the arrays.
//        - `minHeap.add(new int[]{k, 0})`: The starting node `k` is added to the queue with a time of `0` (since we start there).
//
//        #### 3. Dijkstra's Algorithm to Find the Shortest Paths
//
//        ```java
//        Map<Integer, Integer> dist = new HashMap<>();
//
//        while (!minHeap.isEmpty()) {
//        int[] current = minHeap.poll();
//        int node = current[0];
//        int time = current[1];
//
//        if (dist.containsKey(node)) continue;  // Skip if already visited
//
//        dist.put(node, time);  // Record the minimum time
//
//        if (graph.containsKey(node)) {
//        for (int[] neighbor : graph.get(node)) {
//        int nextNode = neighbor[0];
//        int nextTime = time + neighbor[1];
//        if (!dist.containsKey(nextNode)) {
//        minHeap.add(new int[]{nextNode, nextTime});
//        }
//        }
//        }
//        }
//        ```
//
//        - **Purpose**:
//        - This part of the code implements Dijkstra's algorithm, which is used to find the shortest path from the starting node `k` to all other nodes.
//
//        - **Explanation**:
//        - `dist`: A map that stores the shortest time to reach each node.
//        - `while (!minHeap.isEmpty())`: This loop continues until all reachable nodes have been processed.
//        - `int[] current = minHeap.poll()`: Retrieves and removes the node with the shortest current known travel time from the priority queue.
//        - `if (dist.containsKey(node)) continue;`: If the node has already been visited (i.e., the shortest path to it is already known), it is skipped.
//        - `dist.put(node, time);`: The shortest time to reach this node is recorded.
//        - `if (graph.containsKey(node))`: If the current node has outgoing edges, the algorithm processes each neighbor.
//        - `int nextTime = time + neighbor[1];`: Calculates the time it would take to reach the neighbor through the current node.
//        - `if (!dist.containsKey(nextNode))`: If the neighbor hasn't been visited yet, it's added to the priority queue with the calculated travel time.
//
//        #### 4. Final Check and Result Calculation
//
//        ```java
//        if (dist.size() != n) return -1;  // If not all nodes are visited, return -1
//
//        int maxTime = Collections.max(dist.values());
//        return maxTime;
//        ```
//
//        - **Purpose**:
//        - To determine whether all nodes were reached and, if so, find the maximum time it took to reach any node (which would be the total time required for the signal to reach all nodes).
//
//        - **Explanation**:
//        - `if (dist.size() != n)`: If the number of nodes for which we have a shortest path (`dist.size()`) is less than `n`, it means some nodes are unreachable, so the function returns `-1`.
//        - `int maxTime = Collections.max(dist.values());`: Finds the maximum value in the `dist` map, which represents the time it took to reach the farthest node.
//        - `return maxTime;`: Returns the maximum time as the result.
//
//        ### Summary
//        The `networkDelayTime` function efficiently calculates the minimum time required for a signal to propagate through a network from a given starting node. It uses Dijkstra's algorithm with a priority queue to explore the shortest paths to all nodes and returns the time it takes for the last node to receive the signal, or `-1` if some nodes cannot be reached.