package ArraysAndStrings;

/**
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 *
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 *
 * Input: [9,9,9]
 * Output: [1,0,0,0]
 * Explanation: The array represents the integer 4321.
 *
 */

public class PlusOne {

    public static void main(String[] args) {

        int[] nums = {9,8,9,9,9};


        int[] result = plusOne(nums);
        System.out.println(result);

    }

    //TC: O(N)
    //SC: O(N)
    public static int[] plusOne(int[] digits){
        int val = 0;

        if(digits.length == 0 || digits == null) {
            int[] output = {1};
            return output;
        }

        if(digits[digits.length-1] != 9){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }else{

            for(int i = digits.length - 1; i >= 0; i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                    val = 1;
                }
                else{
                    digits[i] += val;
                    break;
                }
            }

            if(digits[0] != 0)
                return digits;
            else{
                int[] output = new int[digits.length + 1];
                output[0] = 1;
                return output;
            }
        }
    }

}
