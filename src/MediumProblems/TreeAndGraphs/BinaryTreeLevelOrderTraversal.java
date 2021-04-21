package MediumProblems.TreeAndGraphs;

import EasyProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    /**
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/628/
     *
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        //{1,2,2,3,4,4,3};
        //int[] array = {1,2,2,3,4,4,3};
        int[] array = {3,9,20,-1,-1,15,7};

        TreeNode root = new TreeNode();
        root = TreeNode.createWithArray(array);

        List<List<Integer>> result = new ArrayList<>();
        result = levelOrder2(root);

        System.out.println("DONE");
    }

    //TC: O(N^2)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<>();
        List<Integer> listRow = new ArrayList<>();
        List<TreeNode> aux = new ArrayList<>();
        List<List<TreeNode>> myListNodes = new ArrayList<>();

        listRow.add(root.val);
        aux.add(root);
        myList.add(listRow);

        while(aux.size() > 0){
            listRow = new ArrayList<>();
            aux = helpOrder(aux, listRow);
            myList.add(listRow);
        }

        return myList;
    }

    public static List<TreeNode> helpOrder(List<TreeNode> array, List<Integer> myValues){

        List<TreeNode> aux = new ArrayList<>();

        for (TreeNode node : array
             ) {
            if(node.left != null) {
                aux.add(node.left);
                myValues.add(node.left.val);
            }
            if(node.right != null) {
                aux.add(node.right);
                myValues.add(node.right.val);
            }
        }

        return aux;
    }

    //TC: O(N)
    public static List<List<Integer>> levelOrder2(TreeNode root) {

        if(root == null)
            return null;

        List<List<Integer>> myList = new ArrayList<>();
        HashMap<Integer, List<Integer>> treeMap = new HashMap<>();

        helpOrder2(root, treeMap, 1);

        for (HashMap.Entry<Integer, List<Integer>> entry : treeMap.entrySet()
             ) {
            int key = entry.getKey();
            List<Integer> arrayNodes = entry.getValue();
            myList.add(arrayNodes);

        }

        return myList;
    }

    public static void helpOrder2(TreeNode node, HashMap<Integer, List<Integer>> treeMap, int deep){
        if(node == null)
            return;

        if(treeMap.containsKey(deep)) {
            List<Integer> aux = treeMap.get(deep);
            aux.add(node.val);
            treeMap.put(deep, aux);
        }else{
            List<Integer> aux = new ArrayList<Integer>();
            aux.add(node.val);
            treeMap.put(deep, aux);
        }

        if(node.left != null) {
            helpOrder2(node.left, treeMap, deep+1);
        }

        if(node.right != null) {
            helpOrder2(node.right, treeMap, deep+1);
        }

    }


}
