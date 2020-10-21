package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-a-triplet-in-an-array-whose-sum-is-closest-to-a-given-number/
 *
 * Find a triplet in an array whose sum is closest to a given number
 *
 * Given an array arr[] of N integers and an integer X, the task is to find three integers in arr[] such that the sum is closest to X.
 *
 * Examples:
 *
 * Input: arr[] = {-1, 2, 1, -4}, X = 1
 * Output: 2
 * Explanation:
 * Sums of triplets:
 * (-1) + 2 + 1 = 2
 * (-1) + 2 + (-4) = -3
 * 2 + 1 + (-4) = -1
 * 2 is closest to 1.
 *
 * Input: arr[] = {1, 2, 3, 4, -5}, X = 10
 * Output: 9
 * Explanation:
 * Sums of triplets:
 * 1 + 2 + 3 = 6
 * 2 + 3 + 4 = 9
 * 1 + 3 + 4 = 7
 * ...
 * 9 is closest to 10.
 *
 *
 *
 */


public class FindTripletSum {

    public static void main(String[] args) {

        int[] myArray = new int[10];

        myArray[0] = -1;
        myArray[1] = 2;
        myArray[2] = 1;
        myArray[3] = -4;
        myArray[4] = -5;
        myArray[5] = 5;
        myArray[6] = 7;
        myArray[7] = 82;
        myArray[8] = 13;
        myArray[9] = 4;


        int result = findCloseResult(myArray, 97);
        System.out.println(result);

    }

    //TC: O(N^2LogN)
    //SC: O(1)
    public static int findCloseResult(int[] array, int value) {

        //O(LogN)
        Arrays.sort(array);

        int sum = 0;
        int closer = Integer.MAX_VALUE;

        for(int j = 0; j < array.length - 2; j++){

            int aux1 = j + 1;
            int aux2 = array.length - 1;

            while(aux1 < aux2){
                sum = array[aux1] + array[aux2] + array[j];

                if(Math.abs(value - sum) < Math.abs(value - closer)){
                    closer = sum;
                }

                if(sum > value)
                    aux2--;
                else
                    aux1++;
            }

        }

        return closer;
    }
}
