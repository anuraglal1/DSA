package Trees;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(lDiameter, rDiameter), leftHeight + rightHeight);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        return Math.max(left, right);
    }

    static TreeNode insertIntoTree(TreeNode root, int data) {
        // If the tree is empty, assign new node
        // address to root
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        // Else, do level order traversal until we find an empty
        // place, i.e. either left child or right child of some
        // node is pointing to NULL.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // First check left if left is null insert
            // node in left otherwise check for right
            if (curr.left != null)
                q.add(curr.left);
            else {
                curr.left = new TreeNode(data);
                return root;
            }

            if (curr.right != null)
                q.add(curr.right);
            else {
                curr.right = new TreeNode(data);
                return root;
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TreeNode root = null;

        for (int key : nums) {
            root = insertIntoTree(root, key);
        }

        System.out.println("Printing tree: ");

        printTree(root);

        System.out.println();

        int diameter = diameterOfBinaryTree(root);
        System.out.println("The diameter of tree is : " + diameter  + " 😊");

    }
}
