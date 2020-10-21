package Trees;

import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 */
public class ValidateBST {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(2);

        head.left = node1;
        head.right = node2;

        node1.left = node4;
        node1.right = node6;

        node2.left = node3;
        node2.right = node5;

        boolean result = isValidBST(head);
        System.out.println(result);

    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        ArrayList<TreeNode> myTree = new ArrayList<>();
        myTree = sortTree(myTree, root);


        for(int i = 1; i < myTree.size(); i++){
            if(myTree.get(i - 1).val >= myTree.get(i).val){
                return false;
            }
        }

        return true;

    }

    public static ArrayList<TreeNode> sortTree( ArrayList<TreeNode> myTree, TreeNode node){

        if(node == null)
            return myTree;

        if(node.left == null && node.right == null) {
            myTree.add(node);
            return myTree;
        }

        myTree = sortTree(myTree, node.left);
        myTree.add(node);
        myTree = sortTree(myTree, node.right);

        return myTree;
    }

}
