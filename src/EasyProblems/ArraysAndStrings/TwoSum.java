package EasyProblems.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 */

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {3,2,12,7,15};
        int[] result = twoSum3(nums, 9);

    }

    //TC: O(N^2)
    //SC: O(1)
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < target) {
                for (int j = 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    //TC: O(N LogN) + O(N) + O(N) = O(3NLogN) = NlogN
    //SC: O(N)
    public static int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];
        int[] copyNums = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            copyNums[i] = nums[i];
        }

        //O(NLogN))
        Arrays.sort(nums);

        int posLeft = nums.length - 1;
        int posRight = 0;

        //O(N)
        while(posLeft > 0){
            int val = nums[posLeft];
            if(nums[posRight] == (target - val)){
                result[0] = nums[posLeft];
                result[1] = nums[posRight];
                break;
            }else{
                if(nums[posRight] > (target - val)){
                    posLeft--;
                }else{
                    posRight++;
                }
            }
        }
        //O(N)
        for(int i = 0; i < copyNums.length; i++){
            if(copyNums[i] == result[0]){
                result[0] = i;
            }

            if(copyNums[i] == result[1]){
                result[1] = i;
            }
        }

        Arrays.sort(result);

        return result;
    }


    //TC: O(N)
    //SC: O(1)
    public static int[] twoSum3(int[] nums, int target) {
        //{0,4,3,0};

        /*

         int[] nums = {3,2,12,7,15};
         k = 9


         HM = 6, 7, 4,
         7 - 9 = 2



         */
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        int val = 0;

        for(int i = 0; i < nums.length; i++){
            val = target - nums[i];
            if (hm.containsKey(val)) {
                result[0] = hm.get(val);
                result[1] = i;
                return  result;
            } else {
                hm.put(nums[i], i);
            }
        }
        return result;
    }

}
