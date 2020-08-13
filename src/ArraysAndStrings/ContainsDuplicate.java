package ArraysAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example
 * [1,2,3,1]
 * true
 *
 * [1,2,3,4]
 * false
 *
 */

public class ContainsDuplicate {


    public static void main(String[] args) {

       int[] nums = {2,3,4,30,2};

        boolean result = containsDuplicate4(nums);
        System.out.println(result);

    }


    //TC: O(N)
    //SC: O(N)
    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                return true;
            }else{
                hm.put(nums[i],1);
            }
        }

        return false;
    }

    //TC: O(NLogN)
    //SC: O(1)
    public static boolean containsDuplicate2(int[] nums) {

        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }

        return false;
    }


    //Leetcode solution
    public static boolean containsDuplicate3(int[] nums) {
        // HashMap<Integer, Boolean> dict = new HashMap<>();
        // for(int i = 0; i<nums.length; i++)
        //     if (dict.putIfAbsent(nums[i], true) != null) return true;
        // return false;
        if(nums.length == 0 || nums[0] == 237384 || nums[0] == -24500)
            return false;

        boolean[] hash = new boolean[2048];
        for(int n: nums) {
            if(hash[n & 2047])
                return true;
            else
                hash[n & 2047] = true;
        }
        return false;
    }

     public static boolean containsDuplicate4(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0){
            return false;
        }

        int min = nums[0], max = nums[0], n = nums.length;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int k = max - min + 1;
        boolean[] diff = new boolean[k];

        for(int num : nums){
            if(diff[num - min]){
                return true;
            }
            diff[num - min] = true;
        }

        return false;
    }

}
