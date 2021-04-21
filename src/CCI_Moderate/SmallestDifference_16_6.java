package CCI_Moderate;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * CCI: 16.6
 *
 * Given two arrays of integers, compute the pair of values (one value in each array) with the
 * smallest (non-negative) difference. Return the difference
 *
 * Example:
 *
 * Input
 *  {1,3,15,11,2}
 *  {23,127,235,19,8}
 *
 * Output
 *  3. The pair is (11, 8)
 *
 *
 * Hints: #632 670 679
 */

public class SmallestDifference_16_6 {

    public static void main(String[] args) {

        int[] array1 = {1, 3, 15, 11, 2 , 2};
        int[] array2 = {23, 127, 235, 19, 8};

        int result = minimalDifference3(array1, array2);
        System.out.println(result);

    }

    //TC: O(N^2)
    static int minimalDifference(int[] array1, int[] array2){
        int result = 0;
        int diff = 0;
        int[] values = new int[2];

        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if( array2[j] <  array1[i])
                    diff = array1[i] - array2[j];
                else
                    diff = array2[j] - array1[i];

                if(diff < result || result == 0) {
                    result = diff;
                    values[0] = array1[i];
                    values[1] = array2[j];
                }
            }
        }
        return result;
    }

    //TC: O(NLogN)
    //SC Bigger
    static int minimalDifference2(int[] array1, int[] array2){
        int result = 0;
        int diff = 0;
        int[] aux = new int[array1.length + array2.length];
        HashSet<Integer> hsArray1 = new HashSet<>();
        HashSet<Integer> hsArray2 = new HashSet<>();

        for(int i = 0; i < aux.length; i++){
            if(i < array1.length ){
                aux[i] = array1[i];
                hsArray1.add(array1[i]);
            }else{
                aux[i] = array2[i - array1.length];
                hsArray2.add(array2[i - array1.length]);
            }
        }

        Arrays.sort(aux);

        for(int j = 1; j < aux.length; j ++){
            if((hsArray1.contains(aux[j]) && hsArray2.contains(aux[j - 1]))
                    || (hsArray1.contains(aux[j - 1]) && hsArray2.contains(aux[j]))
            ) {
                diff = aux[j] - aux[j - 1];
                if (diff < result || result == 0) {
                    result = diff;
                }
            }
        }

        return result;
    }


    static int minimalDifference3(int[] array1, int[] array2){
        int result = 0;
        int diff = 0;

        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0;
        int j = 0;
        while(i < array1.length && j < array2.length){

            diff = Math.abs(array1[i] - array2[j]);

            if( diff < result || result == 0){
                result = diff;
            }

            if(array1[i] < array2[j]){
                i++;
            }
            else{
                j++;
            }

        }

        return result;
    }


}