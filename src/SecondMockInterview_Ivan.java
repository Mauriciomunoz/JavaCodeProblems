import EasyProblems.Trees.TreeNode;

import java.util.*;

public class SecondMockInterview_Ivan {

    /***
     *
     * This problem was asked by Yelp.
     * The horizontal distance of a binary tree node describes how far left or right the node will be when the tree is printed out.
     *
     * More rigorously, we can define it as follows:
     * The horizontal distance of the root is 0.
     * The horizontal distance of a left child is hd(parent) - 1.
     * The horizontal distance of a right child is hd(parent) + 1.
     *
     * For example, for the following tree, hd(1) = -2, and hd(6) = 0.
     *
     *              5
     *           /     \
     *         3         7
     *       /  \      /   \
     *     1     4    6     9
     *    /                /
     *   0                8
     *
     * The bottom view of a tree, then, consists of the lowest node at each horizontal distance. If there are two nodes at the same depth and horizontal distance, either is acceptable.
     * For this tree, for example, the bottom view could be [0, 1, 3, 6, 8, 9].
     * Given the root to a binary tree, return its bottom view.
     *
     *
     */

    public static void main(String[] args) {

        //int[] n = {5,3,6,2,4,-1,-1,1};
        //int[] n = {6,3,7,2,4};
        /*
        [3,1,4,null,2]
        3
         */
        int[] n = {5,3,7,1,4,6,9,0,-1,-1,-1,-1,-1,8,-1};

        int k = 3;

        TreeNodeMod tree = TreeNodeMod.createWithArray(n);
        int[] result = getBottomView(tree);

        System.out.println("DONE");
    }

    public static int[] getBottomView(TreeNodeMod root){
        //N is depth of tree, 2N

        ArrayList<Integer> myList = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int indexHelper = Math.abs(searchLeft(root));

        helper(root, 0, hm);

        int[] arr = new int[hm.size()];

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            arr[indexHelper + key] = val;

        }

        return arr;

    }

    public static void helper(TreeNodeMod node, int hd, HashMap<Integer, Integer> hm){
        if(node == null)
            return;

        helper(node.left, hd - 1, hm);
        node.hd = hd;
        hm.put(hd, node.val);

        //replace(node, myList); //Will replace the node in the list with the same hd and same level as the node sent

        //myList.add(node);
        helper(node.right, hd + 1, hm);

    }


    public static int searchLeft(TreeNodeMod root){
        int i = -1;
        while(root != null){
            i++;
            root = root.left;
        }

        return i;
    }


    static class TreeNodeMod{
        int val;
        int hd;
        int level;
        TreeNodeMod left;
        TreeNodeMod right;
        TreeNodeMod() {}
        TreeNodeMod(int val) { this.val = val; }
        TreeNodeMod(int val, TreeNodeMod left, TreeNodeMod right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNodeMod createWithArray(int[] array) {
            if(array == null && array.length == 0)
                return null;

            TreeNodeMod root = new TreeNodeMod(array[0]);
            Queue<TreeNodeMod> nodes = new LinkedList<>();
            nodes.add(root);
            boolean availableLeft = true;
            boolean availableRight = true;

            for(int i = 1; i < array.length; i++){
                TreeNodeMod node = nodes.element();
                if(node.left == null && availableLeft == true){
                    if(array[i] != -1) {
                        TreeNodeMod nodeLeft = new TreeNodeMod(array[i]);
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
                            TreeNodeMod nodeRight = new TreeNodeMod(array[i]);
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
}
