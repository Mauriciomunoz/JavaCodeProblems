import EasyProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {

        //int[] n = {5,3,6,2,4,-1,-1,1};
        //int[] n = {6,3,7,2,4};
        /*
        [3,1,4,null,2]
        3
         */
        int[] n = {6,2,7,1,4,-1,-1,-1,-1,3,-1};
        //int[] n = {3,1,4,-1,2};
        int k = 3;

        TreeNode tree = TreeNode.createWithArray(n);


        int result = kthSmallest(tree, k);

        System.out.println("DONE");
    }

    public static int kthSmallest(TreeNode root, int k) {
        int result = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        /*helperCounter(root, k, 0, myList);
        for(int i = 0; i < myList.size(); i++){
            if(k - 1 == i)
                return myList.get(i);
        }*/
        helperSearch(root, k, 0, myList);

        return myList.get(0);
    }

    public static int helperSearch(TreeNode node, int k, int level, ArrayList<Integer> result){

        if(result.isEmpty()) {
            if (node == null) {
                return 0;
            }

            level += helperSearch(node.left, k, level, result);
            level += 1;
            if (level == k)
                result.add(node.val);
            //I am returning value instead a level. This cause conflict
            //return node.val;

            level += helperSearch(node.right, k, level - 1, result);
        }
        return level;

    }

    public static void helperCounter(TreeNode node, int k, int level, ArrayList<Integer> myList){

        if(node == null){
            return;
        }

        helperCounter(node.left, k, level, myList);
        myList.add(node.val);
        helperCounter(node.right, k, level, myList);

    }



    public static int kthSmallest2(TreeNode root, int k) {
        int count = 0;
       Stack<TreeNode> myStack = new Stack<>();
       pushLeft(myStack, root);

       while(!myStack.isEmpty()){
           TreeNode aux = myStack.pop();
           count++;
           if(count == k){
               return aux.val;
           }
           pushLeft(myStack, aux.right);
       }

       return 0;
    }

    public static void pushLeft(Stack stack, TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

}
