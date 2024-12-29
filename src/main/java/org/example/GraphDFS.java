package org.example;


import java.util.*;

class GraphDFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public GraphDFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    void DFSUtil(int startVertex, boolean[] visited)
    {
        // Mark the current node as visited and print it
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        for (int adjacent : adjacencyList[startVertex]) {
            if (!visited[adjacent])
                DFSUtil(adjacent, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive DFSUtil()
    void DFS(int startVertex)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[vertices];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth-First Traversal starting from vertex 2:");
        graph.DFS(2);
    }
}

