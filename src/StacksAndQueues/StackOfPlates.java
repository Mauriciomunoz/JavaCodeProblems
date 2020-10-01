package StacksAndQueues;

import java.util.*;

/**
 *
 * CCI: 3.3
 *
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold.
 *
 * Implement a Data Structure SetOfStacks that mimics this. SetOfStacks should be composed by several stacks and should
 * create a new stack once the previous one exceeds capacity.
 *
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack, that is pop() should return
 * the same values as it would if there were just a single stack.
 *
 * FOLLOW UP:
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *
 * Hint #64, #81
 *
 *
 *
 */

public class StackOfPlates {
    public static void main(String[] args) {
        SetOfStacks sStacks = new SetOfStacks(5);

        sStacks.push(1);
        sStacks.push(2);
        sStacks.push(3);
        sStacks.push(4);
        sStacks.push(5);

        sStacks.push(6);
        sStacks.push(7);
        sStacks.push(8);

        sStacks.pop();
        sStacks.pop();
        sStacks.push(9);
        sStacks.push(10);

        sStacks.pop();
        sStacks.pop();
        sStacks.pop();
        sStacks.pop();

        sStacks.push(11);

        sStacks.push(12);
        sStacks.push(13);
        sStacks.push(14);
        sStacks.push(15);
        sStacks.push(16);

        sStacks.push(17);
        sStacks.push(18);

        sStacks.popAt(1);
        sStacks.popAt(1);
        sStacks.popAt(1);
        sStacks.popAt(1);
        sStacks.popAt(1);
        sStacks.pop();
        sStacks.pop();
        sStacks.pop();
        sStacks.push(19);


        System.out.println("DONE");

    }

    public static class SetOfStacks{

        int threshold = 0;
        int cont = 0;
        int contStacks = 0;
        ArrayList<int[]> myStacks = new ArrayList<>();
        Map<Integer, Integer> validSpace= new HashMap<>();

        public SetOfStacks(int sizeStacks){
            threshold = sizeStacks;
        }

        public void push(int value){
            int[] stack;
            if(contStacks == 0 || validSpace.get(contStacks - 1) == 5) {
                stack = new int[threshold];
                validSpace.put(contStacks, 0);
                contStacks++;
                myStacks.add(stack);
            } else {
                stack = myStacks.get(contStacks - 1);
            }

            cont = validSpace.get(contStacks - 1);
            stack[cont] = value;
            cont++;
            validSpace.put(contStacks - 1, cont);

        }

        public int pop(){
            int value = 0;
            int[] stack = myStacks.get(contStacks - 1);
            cont = validSpace.get(contStacks - 1);
            value = stack[cont - 1];
            stack[cont - 1] = -1;
            cont--;
            validSpace.put(contStacks - 1, cont);
            if(cont == 0){
                validSpace.remove(contStacks - 1);
                myStacks.remove(contStacks - 1);
                contStacks--;
            }
            return value;

        }

        //This works, but some blank spaces will be remaining.
        //Will be necessary to rebalance all the stacks to avoid this issue
        //This issue could happen with a value max of N - 1 where N = size of stack
        public int popAt(int subStack){
            int value = 0;
            if(subStack < contStacks){
                int[] stack = myStacks.get(subStack);
                cont = validSpace.get(subStack);
                value = stack[cont - 1];
                stack[cont - 1] = -1;
                cont--;
                validSpace.put(subStack, cont);
                if(cont == 0){
                    validSpace.remove(subStack);
                    rebalanceValidSpace(subStack);
                    myStacks.remove(subStack);
                    contStacks--;
                }
            }
            return value;
        }

        //If a stack was removed, the validSpace Map must be updated.
        private void rebalanceValidSpace(int substack){
            for(Map.Entry<Integer, Integer> entry : validSpace.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue();
                if(key >= substack){
                    key--;
                    validSpace.put(key, value);
                    validSpace.remove(key + 1);
                }
            }
        }

    }

}
