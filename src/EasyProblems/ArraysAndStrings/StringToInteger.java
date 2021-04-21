package EasyProblems.ArraysAndStrings;


/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
 *
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */

public class StringToInteger {
    public static void main(String[] args) {

        String str = "4193 with words";
        //+ 2 3
        // 2 + 3
        //
        int result = myAtoi(str);
        System.out.println(result);
    }

    //TC: O(N)
    //SC: O(1)
    public static int myAtoi(String str) {
        if (str.length() == 0)
            return 0;

        int result = 0;
        char c;
        int sign = 0;
        int val = 0;
        int oldValue = 0;
        int i = 0;

        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                break;
            }

            if (c == '-' && sign == 0) {
                sign = -1;
                i++;
                break;
            }

            if (c == '+' && sign == 0) {
                sign = 1;
                i++;
                break;
            }

            if( c != ' ')
                return 0;
        }

        if(sign == 0)
            sign = 1;

        for (int j = i; j < str.length(); j++) {
            c = str.charAt(j);
            if (c >= '0' && c <= '9'){
                val = Character.getNumericValue(c);
                result = (result * 10) + val;
                if ((result / 10) != oldValue) {
                    if (sign == -1)
                        return -2147483648;
                    return 2147483647;
                }
                oldValue = result;
            }else{
                break;
            }

        }

        result *= sign;

        return result;
    }


    public static int myAtoi5(String str) {
        if(str.length() == 0)
            return 0;

        int result = 0;
        char c;
        int sign = 0;
        int val = 0;
        int oldValue = 0;

        for(int i = 0; i < str.length(); i ++){
            c = str.charAt(i);

            if(c == '-' && sign == 0) {
                sign = -1;
            }
            else {
                if (c == '+' && sign == 0) {
                    sign = 1;
                } else {
                    if(c == '+' || c == '-' && sign != 0)
                        return 0;

                    if (c >= '0' && c <= '9') {
                        if(sign == 0)
                            sign = 1;

                        val = Character.getNumericValue(c);
                        result = (result * 10) + val;
                        if ((result / 10) != oldValue) {
                            if (sign == -1)
                                return -2147483648;
                            return 2147483647;
                        }
                        oldValue = result;
                    } else {
                        if(sign != 0)
                            break;

                        if(c != ' ' && sign == 0)
                            return 0;
                    }
                }
            }

        }

        result *= sign;

        return result;
    }

    public static int myAtoi4(String str) {

        if(str.length() == 0)
            return 0;

        int result = 0;
        char c;
        int sign = 0;
        int i = 0;
        int val = 0;
        int oldValue = 0;

        c = str.charAt(i);
        while(i < str.length() && ((c >='0' && c <='9') || c =='-' || c == '+' || c == ' ')){
            c = str.charAt(i);
            if(c == '-' && sign == 0) {
                sign = -1;
            }
            else {
                if (c == '+' && sign == 0) {
                    sign = 1;
                } else {
                    if(c == '+' || c == '-' && sign != 0)
                        return 0;

                    if (c >= '0' && c <= '9') {
                        if(sign == 0)
                            sign = 1;

                        val = Character.getNumericValue(c);
                        result = (result * 10) + val;
                        if ((result / 10) != oldValue) {
                            if (sign == -1)
                                return -2147483648;
                            return 2147483647;
                        }
                        oldValue = result;
                    } else {
                        if(c != ' ' && sign == 0)
                            return 0;
                    }
                }
            }
            i++;
        }

        result *= sign;

        return result;
        /*
        for(int i = 0; i < str.length(); i++) {
            c = str.charAt(i);


            if(c == '-' || c == '+' || c <=' '){
                if(str.charAt(i + 1) != '+' || str.charAt(i + 1) != '-'){

                }
            }else{
                return 0;
            }


        }*/


    }

    public static int myAtoi3(String str) {
        int result = 0;
        char c;
        int val = 0;
        boolean negative = false;
        int oldValue = 0;

        for(int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if(c >='0' && c <='9'){
                if(i - 1 >= 0){
                    if(str.charAt(i - 1) == '-')
                        negative = true;
                }

                val = Character.getNumericValue(c);
               result = (result * 10) + val;
               if((result / 10) != oldValue) {
                   if(negative)
                       return -2147483648;
                   return 2147483647;
               }
               oldValue = result;
            }else{
                if (c != ' ' && c != '-' && c != '+')
                    break;
            }
        }

        if(negative)
            result*=-1;

        return  result;
    }

    public static int myAtoi2(String str) {
        int result = 0;
        char c;
        int val = 0;
        boolean negative = false;
        int oldValue = 0;
        int cont = 0;

        for(int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if(c >='0' && c <='9'){
                if(cont > 1)
                    return 0;

                if(i - 1 >= 0){
                    if(str.charAt(i - 1) == '-')
                        negative = true;
                }

                val = Character.getNumericValue(c);
                result = (result * 10) + val;
                if((result / 10) != oldValue) {
                    if(negative)
                        return -2147483648;
                    return 2147483647;
                }
                oldValue = result;
            }else{
                if(c == '-' || c == '+')
                    cont++;
                else
                    if (c != ' ' )
                        break;
            }
        }

        if(negative)
            result*=-1;

        return  result;
    }
}
