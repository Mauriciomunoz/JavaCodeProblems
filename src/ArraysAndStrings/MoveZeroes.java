package ArraysAndStrings;

/**
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */

public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {1,0,3,0,12,0};
        moveZeroes2(nums);

    }


    //TC: O(N^2)
    //SC: O(1)
    public static void moveZeroes(int[] nums) {

        int pos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                pos = i;
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] == 0){
                        nums[j] = nums[pos];
                        nums[pos] = 0;
                    }
                }
            }
        }

        int val = 0;
    }

    //TC: O(N)
    //SC: O(1)
    public static void moveZeroes2(int[] nums) {
        int pos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos++;
            }
        }

        for(int j = pos; j < nums.length; j++){
            nums[j] = 0;
        }
    }

}
