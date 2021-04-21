import EasyProblems.Trees.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MockInterview2 {

    /**
     * Create an algorithm that returns the common parent between 2 nodes.
     *
     *
     * Example:
     *
     *         1
     *       /   \
     *      2     8
     *    /  \   /
     *   3    6 7
     *  / \
     * 4   5
     *
     * input: root, 4, 6
     * The common parent between 4 and 6 is 2
     *
     *
     */

    public static void main(String[] args) {

        int[] array = {1,2,8,3,6,7,-1,4,5};


        TreeNode root = new TreeNode();
        root = TreeNode.createWithArray(array);

        isParent(root, 2, 5);
        TreeNode result = commonParent(root, 4, 6);

        System.out.println("DONE");
    }

    static public TreeNode commonParent(TreeNode root, int node1, int node2){
        TreeNode result = new TreeNode();
        result = root;

        Stack<TreeNode> myStack = new Stack<>();
        myStack.push(root);

        TreeNode iterator = myStack.pop();

        while(!myStack.isEmpty() || iterator != null){



        }






        return result;
    }

    static public boolean isParent(TreeNode root, int parent, int son){
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        TreeNode iterator = myQueue.poll();

        while(!myQueue.isEmpty() || iterator != null){

            if(iterator.val == parent){
                Queue<TreeNode> myQueueAux = new LinkedList<>();
                myQueueAux.add(iterator);
                TreeNode iteratorAux = myQueueAux.poll();
                while(!myQueueAux.isEmpty() || iteratorAux != null){
                    if(iteratorAux.val == son){
                        return true;
                    }

                    if(iteratorAux.left != null){
                        myQueueAux.add(iteratorAux.left);
                    }

                    if(iteratorAux.right != null){
                        myQueueAux.add(iteratorAux.right);
                    }

                    iteratorAux = myQueueAux.poll();

                }

                return false;
            }

            if(iterator.left != null){
                myQueue.add(iterator.left);
            }

            if(iterator.right != null){
                myQueue.add(iterator.right);
            }

            iterator = myQueue.poll();

        }

        return false;
    }

}
