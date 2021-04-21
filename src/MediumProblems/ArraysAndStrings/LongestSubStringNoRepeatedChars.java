package MediumProblems.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 *
 */

public class LongestSubStringNoRepeatedChars {

    public static void main(String[] args) {

        //String s = "pwwkew";
        String s = "dvdf";
        int result = lengthOfLongestSubstring2(s);
        System.out.println("DONE");
    }

    static public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] c = s.toCharArray();
        int i = 0;
        int counter = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        while(i < c.length){
            if(!hm.containsKey(c[i])){
                hm.put(c[i], i);
                i++;
                counter++;
                if(counter > max)
                    max = counter;
            }else{
                i  = hm.get(c[i]) + 1;
                hm = new HashMap<>();
                hm.put(c[i], i);
                i++;
                counter = 1;

            }
        }

        return max;
    }

    static public int lengthOfLongestSubstring2(String s) {

        if(s.length() == 0 || s == null)
            return 0;

        int max = 0;
        int counter = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, i);
                counter++;
                max = Math.max(counter, max);
            }else{
                i = hm.get(c) + 1;
                hm.clear();
                hm.put(s.charAt(i), i);
                counter = 1;
            }
        }

        return max;
    }

}
