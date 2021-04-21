package MediumProblems.ArraysAndStrings;

import java.util.*;

/**
 *
 * Leetcode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 *
 */


public class ThreeSum {

    public static void main(String[] args) {

        int[] n = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(n);
        System.out.println(result);
    }

    //Input: nums = [-1,0,1,2,-1,-4]
    //nums.sort = [-4,-1,-1,0,1,2]
    static public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3)
            return null;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }


        return result;
    }




}
