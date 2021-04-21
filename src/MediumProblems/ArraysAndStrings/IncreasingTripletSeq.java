package MediumProblems.ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 */

public class IncreasingTripletSeq {

    public static void main(String[] args) {

        //int[] nums = {2, 6, 5, 11, 4, 8, 10};
        int[] nums = {4, 6, 1, 2, 3};

        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }

    static public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }

            if(min < nums[i] ){
                min2 = Math.min(nums[i], min2);
            }

            if(min2 < nums[i]){
                return true;
            }
        }

        return false;
    }

    //TC: O(N*M*O)
    static public boolean increasingTriplet2(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k]){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
