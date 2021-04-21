package EasyProblems.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createWithArray(int[] array) {
        if(array == null && array.length == 0)
            return null;

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean availableLeft = true;
        boolean availableRight = true;

        for(int i = 1; i < array.length; i++){
            TreeNode node = nodes.element();
            if(node.left == null && availableLeft == true){
                if(array[i] != -1) {
                    TreeNode nodeLeft = new TreeNode(array[i]);
                    node.left = nodeLeft;
                    nodes.add(nodeLeft);
                    availableRight = true;
                }else{
                    availableLeft = false;
                    availableRight = true;
                }
            }else {
                if (node.right == null && availableRight == true) {
                    if(array[i] != -1) {
                        TreeNode nodeRight = new TreeNode(array[i]);
                        node.right = nodeRight;
                        nodes.add(nodeRight);
                        availableLeft = true;
                    }else{
                        availableRight = false;
                        availableLeft = true;
                        nodes.remove();
                    }
                }
            }

            if(array[i] != -1 && node.right != null){
                nodes.remove();
            }
        }

        return root;
    }

}
