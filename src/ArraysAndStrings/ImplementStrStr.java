package ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Constraints:
 * haystack and needle consist only of lowercase English characters.
 */

public class ImplementStrStr {

    public static void main(String[] args) {

        String haystack = "abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba";//"missisaipissipi";
        String needle = "bbbbbbaa";

        int result = strStr(haystack, needle);
        System.out.println(result);
    }


    //TC: O(N)
    //SC: O(1)
    public static  int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;

        if(needle.length() > haystack.length())
            return -1;

        int pos = -1;
        int posLastChar = needle.length() - 1;
        char firstChar = needle.charAt(0);
        char lastChar = needle.charAt(posLastChar);
        int j = 0;
        int cont = 0;

        for(int i = 0; i < haystack.length(); i++) {
            if(posLastChar >= haystack.length())
                break;

            if (haystack.charAt(i) == firstChar && haystack.charAt(posLastChar) == lastChar) {
                if(cont == 0)
                    pos = i;

                cont++;
                j++;

                if(j < needle.length())
                    firstChar = needle.charAt(j);
                else
                    break;

            }else{
                if(cont > 0){
                    i = pos;
                    posLastChar = i + needle.length();
                    firstChar = needle.charAt(0);
                    j = 0;
                    cont = 0;
                }else {
                    posLastChar += 1;

                }
            }
        }

        if(cont == needle.length())
            return pos;

        return -1;
    }
}
