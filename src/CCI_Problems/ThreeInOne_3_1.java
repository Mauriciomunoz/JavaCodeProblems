package CCI_Problems;


/**
 *
 * CCI: 3.1
 *
 * Describe how you could use a single array to implement three stacks.
 *
 * With the given size of the stacks I can create an array of size of the three stacks.
 *
 *
 *
 */
public class ThreeInOne_3_1 {

    public static void main(String[] args) {
        MyStack stack = new MyStack(3, 10);
        stack.push(0, 0);
        stack.push(1, 0);
        stack.push(2, 0);
        stack.push(3, 0);
        stack.push(4, 0);
        stack.push(5, 0);
        stack.push(6, 0);
        stack.push(7, 0);
        stack.push(8, 0);
        stack.push(9, 0);

        stack.pop(0);
        stack.pop(0);
        stack.pop(0);

        stack.push(10, 0);
        stack.push(0, 0);
        stack.push(100, 1);
        stack.push(100, 2);

    }

    //THis could be improved using two extra arrays to save the positions of the first and last element on each stack
    public static class MyStack{

        int[] myArrayStack;
        int sizeStack;

        public MyStack(int k, int size){
            sizeStack = size;
            myArrayStack = new int[size * k];
            for(int i = 0; i < myArrayStack.length; i++){
                myArrayStack[i] = -1;
            }
        }

        public void push(int n, int k){
            for(int i = k * sizeStack; i < (k * sizeStack) + sizeStack; i++){
                if(myArrayStack[i] == -1){
                    myArrayStack[i] = n;
                    return;
                }else{
                    //No space on stack
                }
            }
        }

        public int pop(int k){
            for(int i = (k * sizeStack) - 1 + sizeStack; i > k * sizeStack; i--){
                if(myArrayStack[i] != -1) {
                    int val = myArrayStack[i];
                    myArrayStack[i] = -1;
                    return val;
                }

            }
            return -1;
        }
    }
}
