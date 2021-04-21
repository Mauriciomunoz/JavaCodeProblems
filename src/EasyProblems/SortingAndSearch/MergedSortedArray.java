package EasyProblems.SortingAndSearch;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 * Constraints:
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 *
 */

public class MergedSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge2(nums1, 3, nums2, 3);
        System.out.println("DONE");

    }

    //TC: O(N LogN)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int lenght1 = nums1.length - nums2.length;
        int j = 0;

        for(int i = lenght1; i < nums1.length; i++){
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);

        System.out.println("Sorted");

    }

    //TC: O(N)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;

        for(; i >= 0 && j >= 0; k--){
            if(nums2[j] > nums1[i]){
                nums1[k] = nums2[j];
                j--;
            }else{
                nums1[k] = nums1[i];
                i--;
            }
        }

        while (k >= 0) {
            if( i < 0 ){
                nums1[k] = nums2[j];
                j--;
                k--;
            }else{
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }


        System.out.println("Sorted");

    }

}
