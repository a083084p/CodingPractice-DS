package org.example.Tree;

import java.util.ArrayList;
import java.util.List;

// Node class to represent each node in the tree
class TreeNodeDFS {
    int data;
    TreeNodeDFS left;
    TreeNodeDFS right;

    TreeNodeDFS(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeDFS {

    // In-order Traversal: Left, Root, Right
    public static List<Integer> inorderTraversal(TreeNodeDFS root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNodeDFS node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result);
            result.add(node.data);
            inorderHelper(node.right, result);
        }
    }

    // Pre-order Traversal: Root, Left, Right
    public static List<Integer> preorderTraversal(TreeNodeDFS root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNodeDFS node, List<Integer> result) {
        if (node != null) {
            result.add(node.data);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }

    // Post-order Traversal: Left, Right, Root
    public static List<Integer> postorderTraversal(TreeNodeDFS root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(TreeNodeDFS node, List<Integer> result) {
        if (node != null) {
            postorderHelper(node.left, result);
            postorderHelper(node.right, result);
            result.add(node.data);
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a tree
//        TreeNodeDFS root = new TreeNodeDFS(1);
//        root.left = new TreeNodeDFS(2);
//        root.right = new TreeNodeDFS(3);
//        root.left.left = new TreeNodeDFS(4);
//        root.left.right = new TreeNodeDFS(5);
//        root.right.left = new TreeNodeDFS(6);
//        root.right.right = new TreeNodeDFS(7);

        TreeNodeDFS root = new TreeNodeDFS(9);
        root.left = new TreeNodeDFS(4);
        root.right = new TreeNodeDFS(20);
        root.left.left = new TreeNodeDFS(1);
        root.left.right = new TreeNodeDFS(6);
        root.right.left = new TreeNodeDFS(15);
        root.right.right = new TreeNodeDFS(170
        );

        // Perform Traversals
        List<Integer> inorderResult = inorderTraversal(root);
        System.out.println("In-order Traversal: " + inorderResult);

        List<Integer> preorderResult = preorderTraversal(root);
        System.out.println("Pre-order Traversal: " + preorderResult);

        List<Integer> postorderResult = postorderTraversal(root);
        System.out.println("Post-order Traversal: " + postorderResult);
    }
}

