package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 * Note: You may assume the string contains only lowercase English letters.
 */

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {

        String str="bdodba";

        int result = firstUniqChar2(str);
        System.out.println(result);

    }

    //TC: O(N)
    //SC: O(N)
    public static int firstUniqChar(String s) {
        int pos = s.length();
        //char, pos
        HashMap<Character, Integer> hm = new HashMap<>();

        if(s.length() == 0)
            return -1;

        for (int i = 0; i < s.length(); ++i)
        {
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), -1);
            }else{
                hm.put(s.charAt(i), i);
            }
        }

        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            int val = entry.getValue();

            if(val < pos && val != -1){
                pos = val;
            }
        }

        if(pos == s.length())
            return -1;

        return pos;
    }

    //O(N)
    //O(N)
    public static int firstUniqChar2(String s) {
        char[] c = new char[26];
        int val = 0;

        for (int i = 0; i < s.length(); ++i)
        {
            val = (s.charAt(i)-'a');
            c[val]++;
        }

        for(int j = 0; j < s.length(); j++){
            val = (s.charAt(j)-'a');

            if(c[val] == 1){
                return j;
            }
        }

        return -1;
    }
}
