package EasyProblems.Trees;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
 *
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 *
 */

public class MaxDepthBinaryTree {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        head.left = node1;
        head.right = node2;
        node2.left = node3;
        node2.right = node4;

        int result = maxDepth(head);
        System.out.println(result);

    }

    //TC: O(N)
    //SC: O(1)
    public static int maxDepth(TreeNode root) {

        int result = 0;
        int result2 = 0;

        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        result = maxDepth(root.left);
        result2 = maxDepth(root.right);

        if(result < result2){
            return result2 + 1;
        }else{
            return result + 1;
        }

    }
}
