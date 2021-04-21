package MediumProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *
 *
 */

public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        List<List<Integer>> result = permute(nums);

        System.out.println("DONE");
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        getAllPermutation(-1, nums, new ArrayList<>(), result);

        return result;
    }


    public static List<List<Integer>> calculatePermutation(int[] nums, int pos){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();


        if(nums.length - 1 == pos){
            aux.add(nums[0]);
            result.add(aux);
            return result;
        }


        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> permutations = new ArrayList<>();
            permutations = calculatePermutation(nums, pos + 1);

            for (List<Integer> perm : permutations
                 ) {
                perm.add(nums[pos]);
            }

            result.addAll(permutations);

        }

        return result;

    }
      /*  List<Integer> permutation = new ArrayList<>();

        if(nums.length - 1 == pos) {
            permutation.add(nums[pos]);
            return permutation;
        }

        permutation.addAll(calculatePermutation(nums, pos+1));
        permutation.add(nums[pos]);

        return permutation;

       */
    //}

    public static void getAllPermutation(int idx, int[]nums, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i != idx && !curr.contains(nums[i])){
                curr.add(nums[i]);
                getAllPermutation(i, nums, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }

}
