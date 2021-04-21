package MediumProblems;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subsets/
 *
 *Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 */
public class Subsets {

    public static void main(String[] args) {

        int[] n = {1,2,3};

        List<List<Integer>> result = subsets(n);

        System.out.println("DONE");
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        helper(nums, 0, list, result);

        /*
        for(int i = 0; i< nums.length; i++){
            List<Integer> aux = new ArrayList<>();
            aux.add(nums[i]);
            q.add(aux);
        }*/



        return result;
    }

    private static void helper(int arr[], int sI, List<Integer> list, List<List<Integer>> output){
        if(arr.length == sI ){
            output.add(new ArrayList<Integer>(list));
            return;
        }

        // leave first element;
        helper(arr, sI+1, list, output);
        // add first element
        list.add(arr[sI]);
        helper(arr, sI+1, list, output);
        // remove last element in list in order to backtrack
        list.remove(list.size()-1);

        return;
    }

}
