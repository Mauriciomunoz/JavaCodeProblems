package ArraysAndStrings;

import java.util.Arrays;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] str = {"abca","aba","saab"};//{"aca","cab"}; //{"flower","flow","flight"}; //{"flow","gloss", "rolo"};{"flower","flow","glowest"}; {"aa","ab"};//

        String result = longestCommonPrefix2(str);
        System.out.println(result);
    }

    //TC: O(N^2)
    //SC: O(1)
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0 || strs == null)
            return "";

        if(strs.length == 1)
            return strs[0];

        StringBuilder result = new StringBuilder();
        int posLessChar = 0;

        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < strs[posLessChar].length()){
                posLessChar = i;
            }
        }

        char[] ctrlWordArray = strs[posLessChar].toCharArray();

        for(int i = 0; i < strs.length; i++){
            if(i != posLessChar) {
                char[] word = strs[i].toCharArray();
                result.setLength(0);
                for (int j = 0; j < ctrlWordArray.length; j++) {
                    if (word[j] == ctrlWordArray[j]) {
                        result.append(ctrlWordArray[j]);
                    }else{
                        break;
                    }
                }
                ctrlWordArray = result.toString().toCharArray();
            }
        }

        return result.toString();
    }

    //TC: O(N LogN)
    //SC: O(1)
    //Internet solution
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        int len = strs.length;
        Arrays.sort(strs);
        int num = Math.min(strs[0].length(),strs[len-1].length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++){
            if(strs[0].charAt(i) == strs[len-1].charAt(i)) sb.append(strs[0].charAt(i));
            else break;
        }
        return sb.toString();
    }
}
