package MediumProblems.TreeAndGraphs;

import EasyProblems.Trees.TreeNode;

public class ConvertSortArrayToBST {
    /**
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
     *
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        //int[] array = {-10,-3,0,5,9};
        //int[] array = {1,2,3,4,5,6,7};
        int[] array = {-1,0,1,2};

        TreeNode result;

        result = sortedArrayToBST(array);

        System.out.println("DONE");
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        TreeNode result = new TreeNode(nums[nums.length / 2]);

        int[] leftArray = new int[nums.length / 2];
        int[] rightArray;
        if(nums.length % 2 == 0){
            rightArray = new int[(nums.length / 2) - 1];
        }else {
            rightArray = new int[nums.length / 2];
        }
        int j = 0;
        int i = 0;

        for(; i < nums.length - 1; i++){
            if(i < nums.length / 2)            {
                leftArray[i] = nums[i];
            }else{
                rightArray[j] = nums[i + 1];
                j++;
            }
        }

        if(i > 0) {
            result.left = sortedArrayToBST(leftArray);
        }

        if(j > 0) {
            result.right = sortedArrayToBST(rightArray);
        }

        return result;
    }

    //INTERNET SOLUTION
    /*

    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        return helper(l, r, nums);
    }

    public TreeNode helper(int l, int r, int[] nums) {
        if (l > r) return null;

        int mid = l + (r - l)/2;
        int val = nums[mid];
        TreeNode node = new TreeNode(val);
        node.left = helper(l, mid - 1, nums);
        node.right = helper(mid + 1, r, nums);

        return node;
    }

     */

}
