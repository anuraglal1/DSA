package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean ltr = true;  // Left to right on first level
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (ltr) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(level);
            ltr = !ltr;
        }

        return res;
    }

    static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null)
            return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < nums.length) {
            TreeNode current = queue.poll();

            // left child
            if (nums[i] != null) {
                current.left = new TreeNode(nums[i]);
                queue.add(current.left);
            }
            i++;

            // right child
            if (i < nums.length && nums[i] != null) {
                current.right = new TreeNode(nums[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }

        result = result.subList(0, i + 1);

        System.out.println(result);
    }


    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(nums);

        System.out.println("Printing tree: ");

        printTree(root);

        System.out.println();

        List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(root);
        System.out.println("The zigZag level order traversal of tree is : " + zigzagLevelOrder  + " 😊");

    }
}
