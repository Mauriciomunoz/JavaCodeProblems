package EasyProblems;

import java.util.List;

/**
 * https://leetcode.com/problems/missing-number/.
 *
 *Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {9,1,4,3,6,5,2,7,8};
        //int[] nums = {2,0};

        int result = missingNumber2(nums);

        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums.length){
                nums[Math.abs(nums[i])] *= -1;
                if(nums[Math.abs(nums[i])] == 0)
                    nums[Math.abs(nums[i])] = -1;
            }
        }

        boolean zero = false;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] > 0 && nums[j] != 0){
                return j;
            }
        }
        return 0;
    }


    public static int missingNumber2(int[] nums) {
        int sum=0;
        int n = nums.length;
        int sumIndex = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sumIndex += i;
            sum += nums[i];
        }
        //return ((n * (n + 1)) / 2) - sum;
        return (sumIndex + n) - sum;
    }
}
