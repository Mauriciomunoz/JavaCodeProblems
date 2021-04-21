package CCI_Problems;

import java.util.Stack;

/**
 * CCI: 3.5 SortStack
 *
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek and isEmpty.
 *
 * Hints: #15, #32, #43
 *
 */
public class SortStack_3_5 {

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();
        myStack.push(9);
        myStack.push(1);
        myStack.push(5);
        myStack.push(3);
        myStack.push(2);
        myStack.push(4);
        myStack.push(8);

        sortStack(myStack);

        System.out.println("DONE");

    }

    //TC: O(N^2)
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> auxStack = new Stack<>();

        while(!stack.isEmpty()) {
            int aux = bigger(stack);
            stack = removeBigger(stack, aux);
            auxStack.push(aux);
        }

        return auxStack;

    }

    public static int bigger(Stack<Integer> stack){
        Stack<Integer> stackAux = new Stack<>();
        stackAux.addAll(stack);

        Stack<Integer> stackAux2 = new Stack<>();

        int big = stackAux.pop();

        while(!stackAux.isEmpty()){
            int val = stackAux.pop();
            if(val > big){
                big = val;
            }
        }

        return big;
    }

    public static Stack<Integer> removeBigger(Stack<Integer> stack, int bigger){
        Stack<Integer> stackAux = stack;
        Stack<Integer> stackShort = new Stack<>();

        while(!stackAux.isEmpty()){
            int val = stackAux.pop();
            if(bigger != val){
                stackShort.push(val);
            }
        }

        return stackShort;
    }
}
