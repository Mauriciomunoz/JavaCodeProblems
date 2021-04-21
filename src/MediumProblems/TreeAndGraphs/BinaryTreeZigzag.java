package MediumProblems.TreeAndGraphs;

import EasyProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 * Example 1:
 *
 *     3
 *   /   \
 *  9    20
 *     /   \
 *    15    7
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 */

public class BinaryTreeZigzag {
    public static void main(String[] args) {

        //int[] array = {3,9,20,-1,-1,15,7};
        //int[] array = {3,9,20,10,-1,16,7,-1,15,-1,-1,18,19};
        int[] array = {1};

        TreeNode root = new TreeNode();
        root = TreeNode.createWithArray(array);

        List<List<Integer>> result = new ArrayList<>();
        result = zigzagLevelOrder(null);

        System.out.println("DONE");
    }

    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stackLeft = new Stack();
        Stack<TreeNode> stackRight = new Stack();

        stackRight.push(root);

        while(!stackLeft.isEmpty() || !stackRight.isEmpty()){
            List<Integer> myList = new ArrayList<>();
            while(!stackRight.isEmpty()) {
                root = stackRight.pop();
                myList.add(root.val);
                if (root.left != null) {
                    stackLeft.push(root.left);
                }

                if (root.right != null) {
                    stackLeft.push(root.right);
                }
            }
            if(!myList.isEmpty())
                result.add(myList);

            myList = new ArrayList<>();
            while(!stackLeft.isEmpty()){
                root = stackLeft.pop();
                myList.add(root.val);

                if(root.right != null){
                    stackRight.push(root.right);
                }

                if(root.left != null){
                    stackRight.push(root.left);
                }
            }
            if(!myList.isEmpty())
                result.add(myList);

        }


        return result;

    }
}
