package MediumProblems.ArraysAndStrings;

/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 *
 */

public class LongestPalindromicSubString {

    public static void main(String[] args) {

        //String s = "baabaade";
        //String s = "abcdabaade";
        //String s = "vvvvv";
        //String s = "xaabacxcabaaxcabaax";
        //String s = "abcda";
        //String s = "abacab";
        //String s = "esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
        //String s = "aaaabaaa";
        String s = "abcadaabaace";
        //String s = "a";
        //String s = "ac";
        //String s = "";
        //String s = "abb";
        //String s = "bb";
        //String s = "cbbd";
        String result = longestPalindrome4(s);
        System.out.println(result);
    }

    static public String longestPalindrome4(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int startIndex = 0;
        int endIndex = 0;

        for (int index = 0; index < s.length(); index++) {

            int lengthOfOddExpansion = expandAroundCenterUtility(s, index, index);
            int lengthOfEvenExpansion = expandAroundCenterUtility(s, index, index + 1);
            int lengthOfCurrentMaximumPalindrome = Math.max(lengthOfOddExpansion, lengthOfEvenExpansion);

            if (lengthOfCurrentMaximumPalindrome > endIndex - startIndex) {
                startIndex = index - ((lengthOfCurrentMaximumPalindrome - 1) / 2);
                endIndex = index + (lengthOfCurrentMaximumPalindrome / 2);
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    static private int expandAroundCenterUtility(String input, int left, int right) {

        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left -= 1;
            right += 1;
        }

        return right - left - 1;
    }



    static public String longestPalindrome(String s) {

        if(s.length() == 1 || s.length() == 0)
            return s;

        if(s.length() == 2 && s.charAt(0) != s.charAt(1)) {
                return String.valueOf(s.charAt(0));
        }

        String longestPalindrome = "";
        int i = 0;
        int j = s.length() - 1;
        int endPalindrome = 0;
        int startPalindrome = 0;
        int maxLength = 0;

        while(i < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                endPalindrome++;
                startPalindrome++;
                if(i >= j){
                    if(s.substring((i - startPalindrome + 1), (endPalindrome + j)).length() > longestPalindrome.length()) {
                        longestPalindrome = s.substring((i - startPalindrome + 1), (endPalindrome + j));
                        maxLength = longestPalindrome.length();
                        i = i - startPalindrome + 2;
                        startPalindrome = 0;
                        j = s.length() - 1;
                        endPalindrome = 0;
                    }
                }else {
                    i++;
                    j--;
                }
            }else{
                i = i - startPalindrome;
                startPalindrome = 0;
                j = endPalindrome + j;
                endPalindrome = 0;
                j--;
            }

            if(i - startPalindrome >= endPalindrome + j || ((endPalindrome + j) - (i - startPalindrome)) + 1 <= maxLength){
                i++;
                j = s.length() - 1;
                startPalindrome = 0;
                endPalindrome = 0;
                if(i == j){
                    break;
                }
            }


        }

        if(longestPalindrome == "")
            longestPalindrome = String.valueOf(s.charAt(0));

        return longestPalindrome;

    }

    static public String longestPalindrome3(String s) {
        String longestPalindrome = "";
        int i = 0;
        int j = s.length() - 1;
        int endPalindrome = 0;
        int startPalindrome = 0;

        if(s.length() == 1 || s.length() == 0)
            return s;

        if(s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return String.valueOf(s.charAt(0));
        }

        while(i < s.length()){

            if(s.charAt(i) == s.charAt(j)){
                //Start to check if is a palindrome
                endPalindrome++;
                startPalindrome++;
                i++;
                j--;
                if(i >= j && (i < s.length() && j >= 0) && (endPalindrome + j + 1) <= s.length()){
                    if((s.substring((i - startPalindrome), (endPalindrome + j + 1))).length() > longestPalindrome.length()) {
                        longestPalindrome = s.substring((i - startPalindrome), (endPalindrome + j + 1));
                        i = i - startPalindrome;
                        startPalindrome = 0;
                        j = endPalindrome + j;
                        endPalindrome = 0;
                    }else{
                      i--;
                      j--;
                    }
                }
            }else{
                i = i - startPalindrome;
                startPalindrome = 0;
                j = endPalindrome + j;
                endPalindrome = 0;
                j--;
            }

            if(i >= j){
                i++;
                j = s.length() - 1;
                startPalindrome = 0;
                endPalindrome = 0;
            }
        }

        if(longestPalindrome == "")
            longestPalindrome = String.valueOf(s.charAt(0));

        return longestPalindrome;
    }


    //O(N^3)
    static public String longestPalindrome2(String s) {
        String longestPalindrome = "";

        for(int i = 0; i < s.length(); i++){
            for(int j = 1; j < s.length(); j++){
                if(isPalindrome(i, j, s)){
                    if(s.substring(i , j + 1).length() > longestPalindrome.length()){
                        longestPalindrome = s.substring(i , j + 1);
                    }
                }
            }
        }

        return longestPalindrome;
    }

    static public boolean isPalindrome(int start, int end, String s){
        int i = start;
        int j = end;

        if(i > j)
            return false;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }

}
