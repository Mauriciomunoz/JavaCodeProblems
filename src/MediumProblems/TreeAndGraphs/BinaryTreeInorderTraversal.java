package MediumProblems.TreeAndGraphs;

import EasyProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/786/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *     1
 *      \
 *       2
 *     /
 *    3
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 */


public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        //int[] array = {1,5,2,-1,-1,3,4,-1,7,8,9};
        int[] array = {3,-1,20,15,7,2,8};

        //int[] array = {2,3,-1,1};

        TreeNode root = new TreeNode();
        root = TreeNode.createWithArray(array);

        List<Integer> result = new ArrayList<>();
        result = inorderTraversal(root);

        System.out.println("DONE");
    }

    //Recursive Solution
    static public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root.left == null && root.right == null){
            result.add(root.val);
            return result;
        }

        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }

        result.add(root.val);

        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> myStack = new Stack();

        while(root != null || !myStack.isEmpty()){

            while(root != null){
                myStack.push(root);
                root = root.left;
            }

            root = myStack.pop();

            result.add(root.val);

            root = root.right;

        }

        return result;

    }

    static public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> myStack = new Stack();

        while(root != null){

            if(root.left != null){
                myStack.add(root);
                root = root.left;
            }else {

                if (root.right != null) {
                    result.add(root.val);
                    root = root.right;
                }else{
                    result.add(root.val);
                    if(myStack.isEmpty())
                        break;
                    root = myStack.pop();
                    result.add(root.val);
                }
            }

        }

        return  result;
    }


    static public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode iterator = root;
        Stack<TreeNode> myStack = new Stack();
        HashSet<TreeNode> aux = new HashSet<>();
        boolean leftSide = true;

        while(iterator != null){
            if(iterator.left != null && iterator.right != null){
                if(!aux.contains(iterator.left)) {
                    myStack.push(iterator);
                    iterator = iterator.left;
                }else{
                    result.add(iterator.val);
                    aux.add(iterator);
                    iterator = iterator.right;
                }
            }else{
                if(iterator.left == null && iterator.right == null){
                    result.add(iterator.val);
                    aux.add(iterator);
                    
                    if(!myStack.isEmpty()) {
                        iterator = myStack.pop();
                    }else{
                        iterator = null;
                    }
                }
            }

        }

        return  result;

    }
}
