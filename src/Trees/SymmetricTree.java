package Trees;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/627/
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 *
 *
 *
 */

public class SymmetricTree {

    public static void main(String[] args) {
        //{1,2,2,3,4,4,3};
        //int[] array = {1,2,2,3,4,4,3};
        int[] array = {1,2,2,-1,3,-1,3};

        TreeNode root = new TreeNode();
        root = TreeNode.createWithArray(array);

        boolean result = isSymmetric(null);
        System.out.println("DONE");
    }

    public static boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        boolean result = helper(leftNode, rightNode);

        return result;
    }

    public static boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left == null && right != null)
            return false;

        if(left != null && right == null)
            return false;

        if(left.val != right.val)
            return false;

        if(helper(left.left, right.right))
        {
            if(helper(left.right,right.left)) {
                return true;
            }
        }

        return false;

    }

}
