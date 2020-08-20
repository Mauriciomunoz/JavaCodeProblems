package ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 * Constraints:
 * s consists only of printable ASCII characters.
 */

public class IsPalindrome {

    public static void main(String[] args) {

        String str1 = "0k.;r0.k;";//"8V8K;G;K;V;";//"Marge, let's \"[went].\" I await {news} telegram.";

        boolean result = isPalindrome(str1);
        System.out.println(result);

    }

    //TC: O(N)
    //SC: O(1)
    public static boolean isPalindrome(String s) {

        s=s.toLowerCase();

        int val = 0;
        int val2 = 0;
        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            val = s.charAt(i) - 'a';
            val2 = s.charAt(j) - 'a';

            if(((val >= 0 && val <= 25) || (val >= -49 && val <= -40)) && ((val2 >= 0 && val2 <= 25) || (val2 >= -49 && val2 <= -40))){
                if(val != val2) {
                    return false;
                }
                i++;
                j--;
            }else{
                if((val < 0 || val > 25) && (val < -49 || val > -40)){
                    i++;
                }
                if((val2 < 0 || val2 > 25) && (val2 < -49 || val2 > -40)){
                    j--;
                }
            }
        }
        return true;
    }

    //TC:O(N)
    //SC: O(1)
    //replaceAll could slow the algorithm
    public static boolean isPalindrome2(String s) {

        s=s.toLowerCase();
        s=s.replaceAll("[^a-zA-Z0-9]", "");

        int val = 0;
        int val2 = 0;
        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            val = s.charAt(i) - 'a';
            val2 = s.charAt(j) - 'a';

            if(val != val2) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
