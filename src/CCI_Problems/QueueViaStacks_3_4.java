package CCI_Problems;

import java.util.Stack;

/**
 *
 * CCI: 3.4
 *
 * Imagine a MyQueue class which implements a queue using two stacks.
 *
 * Hint #98, #114
 *
 */

public class QueueViaStacks_3_4 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);

        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());

        myQueue.push(7);

        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());

        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(10);

        System.out.println("DONE: "+myQueue.pop());
        System.out.println("DONE: "+myQueue.pop());


        System.out.println("DONE");

    }

    public static class MyQueue{

        private int sizeQueue;
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public MyQueue(int size){
            sizeQueue = size;
        }

        public void push(int value){
            pushStack.push(value);
        }

        public int pop(){
            int value = -1;

            if(popStack.size() == 0 && pushStack.size() > 0){
                int sizeQ = pushStack.size();
                if(popStack.isEmpty()) {
                    for(int i = 0; i < sizeQ; i++) {
                        popStack.push(pushStack.pop());
                    }
                    value = popStack.pop();
                    return value;
                }
            }else{
                if(popStack.size() != 0)
                    value = popStack.pop();
            }

            return value;
        }

    }
}
