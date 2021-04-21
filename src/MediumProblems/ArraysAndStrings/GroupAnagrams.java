package MediumProblems.ArraysAndStrings;

import java.util.*;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 */

public class GroupAnagrams {

    public static void main(String[] args) {

        //String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"a"};
        String[] strs2 = {""};

        List<List<String>> output = groupAnagrams(strs2);
        System.out.println("DONE");
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for(int i = 0; i < strs.length; i ++){
            char[] strAux = strs[i].toCharArray();
            Arrays.sort(strAux);
            if(!hm.containsKey(String.valueOf(strAux))){
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                hm.put(String.valueOf(strAux), strings);
            }else{
                List<String> strings = new ArrayList<>();
                strings = hm.get(String.valueOf(strAux));
                strings.add(strs[i]);
                hm.put(String.valueOf(strAux), strings);
            }

        }

        for(Map.Entry<String, List<String>> entry : hm.entrySet()){
            List<String> wordsValues = entry.getValue();
            result.add(wordsValues);
        }

        return result;
    }

}
