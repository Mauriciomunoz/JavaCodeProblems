package EasyProblems.ArraysAndStrings;


/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {
    public static void main(String[] args) {

        String str = "anagram";
        String str2 = "nagaram";

        boolean result = isAnagram(str, str2);
        System.out.println(result);

    }

    //TC: O(N)
    //SC: O(N)
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] c = new char[26];
        int val = 0;

        for(int i = 0; i < s.length(); i++){
            val = s.charAt(i) - 'a';
            c[val]++;
        }

        for(int j = 0; j < t.length(); j++){
            val = t.charAt(j) - 'a';
            if(c[val] > 0){
                c[val]--;
            }else{
                return false;
            }
        }

        for(int k = 0; k < c.length; k++){
            if(c[k] != 0){
                return false;
            }
        }

        return true;
    }

}
