package StacksAndQueues;

import java.util.Stack;

/**
 *
 * CCI: 3.2
 *
 * How would you design a stack which in addition to push and pop, has a function min which returns
 * the minimum element? Push, Pop and Min should all operate in O(1) time.
 *
 * Hint #27, #59, #78
 *
 *
 *
 */

public class StackMin {

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);

        stack.push(9);
        stack.push(13);
        stack.push(3);
        stack.push(8);
        stack.push(4);
        stack.push(5);
        stack.min();
        stack.push(6);
        stack.push(2);
        stack.push(90);
        stack.push(1);
        stack.push(10);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(8);

        stack.push(5);
        stack.min();

    }

    public static class MyStack{

        private int[] myArrayStack;
        private int free = 0;
        private int min;
        private boolean isEmpty = true;

        public MyStack(int size){
            myArrayStack = new int[size];
        }

        public void push(int n){

            if(isEmpty == true){
                myArrayStack[free] = n ;
                min = n;
                free++;
                isEmpty = false;
                return;
            }

            if(n < min) {
                if (free < myArrayStack.length) {
                    myArrayStack[free] = 2 * n - min;
                    min = n;
                    free++;
                }
            }else{
                if (free < myArrayStack.length) {
                    myArrayStack[free] = n;
                    free++;
                }
            }
        }

        public int pop(){

            int val;

            if(free - 1 > -1) {
                val = myArrayStack[free - 1];
                free--;
            }
            else{
                min = 0;
                isEmpty = true;
                return 0;
            }

            if(val < min){
                int val2 = min;
                min = 2 * min - val;
                return val2;
            }else{
                return val;
            }

        }

        public int min(){
            return min;
        }
    }
}
