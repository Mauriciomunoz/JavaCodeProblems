package ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 *
 */


public class ReverseString {
    public static void main(String[] args) {

        char[] myStr = {'h','e','l','o'};

        reverseString(myStr);
    }

    //TC: O(N)
    //SC: O(1)
    public static void reverseString(char[] s) {

        int i =0;
        int lastPos = s.length - 1;
        char aux;

        while(i < lastPos){
            aux = s[i];
            s[i] = s[lastPos];
            s[lastPos] = aux;
            lastPos--;
            i++;
        }

    }

}
