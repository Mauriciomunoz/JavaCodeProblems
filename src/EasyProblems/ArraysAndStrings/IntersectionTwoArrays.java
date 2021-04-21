package EasyProblems.ArraysAndStrings;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 *
 *
 */

public class IntersectionTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,2,8,4,5};

        int[] result = searchIntersection2(nums1, nums2);
        System.out.println("DONE");
    }

    //TC: O(N^2)
    private static int[] searchIntersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        int k = 0;

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    result.add(nums1[i]);
                    k++;
                    break;
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }


    //TC: O(NLogN)
    private static int[] searchIntersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] aux1;
        int[] aux2;
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else{
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
        }

        int[] res = new int[result.size()];
        for(i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;

    }
}
