package EasyProblems;

import java.util.List;

/**
 * CTCI 8.1
 *
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 *
 */


public class TripleStep {
    public static void main(String[] args) {



        int result = runningChild(4);

        System.out.println(result);
    }


    public static int runningChild(int n){
        int[] array = new int[n + 1];

        array[0] = 1;
        array[1] = 1;
        array[2] = 2;


        for(int i = 3; i < array.length; i++){
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];

        }


        return array[n];
    }

}
