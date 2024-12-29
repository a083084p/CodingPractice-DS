package org.example.Tree;

// Define the path for the script
//package com.example.treebfs;

//This is from Chat GPT. Test and Practice.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Node class to represent each node in the tree
class TreeNode {
    int data;
    List<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class TreeBFS {

    // BFS method to traverse the tree
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.data);

            for (TreeNode child : current.children) {
                queue.add(child);
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a tree
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode child4 = new TreeNode(5);
        TreeNode child5 = new TreeNode(6);

        root.children.add(child1);
        root.children.add(child2);
        child1.children.add(child3);
        child1.children.add(child4);
        child2.children.add(child5);

        // Perform BFS
        List<Integer> bfsResult = bfs(root);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}

