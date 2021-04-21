package EasyProblems.ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 *
 */

public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1534236469;

        reverse2(x);
    }

    //TC: O(N)
    //SC: O(N)
    public static int reverse(int x) {

        int result = 0;
        boolean negative = false;

        if(x < 0){
            x*=-1;
            negative = true;
        }

        String xStr = String.valueOf(x);
        char[] c = xStr.toCharArray();

        int i = 0;
        int j = c.length - 1;
        char temp;

        while(i < j){
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;

            i++;
            j--;
        }

        xStr = "";

        for(int k = 0; k < c.length; k++){
            xStr += c[k];
        }

        result = Integer.valueOf(xStr);

        if(negative == true){
            result*=-1;
        }

        return result;
    }

    //TC: O(N)
    //SC: O(1)
    static int reverse2(int x)
    {

        boolean negative = false;
        int oldRev = 0;

        if(x < 0){
            x*=-1;
            negative = true;
        }

        int rev_num = 0;
        while(x > 0)
        {
            rev_num = rev_num * 10 + x % 10;

            if((rev_num - (x % 10))/10 != oldRev){
                return 0;
            }

            x = x / 10;
            oldRev = rev_num;
        }

        if(negative == true)
            rev_num *= -1;

        return rev_num;
    }
}
