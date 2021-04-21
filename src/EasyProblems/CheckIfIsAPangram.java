package EasyProblems;

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 *
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 * Example 2:
 * Input: sentence = "leetcode"
 * Output: false
 *
 */

public class CheckIfIsAPangram {

    public static void main(String[] args) {

        String str = "thequickbrownfoxjumpsoverthelazydog";

        System.out.println("Result is " + checkIfPangram(str));
    }

    public static boolean checkIfPangram(String sentence) {
        int[] aux = new int[26];

        for(int i = 0; i < sentence.length(); i++){
            aux[sentence.charAt(i) - 'a'] += 1;
        }

        for(int j = 0; j < aux.length; j++){
            if(aux[j] == 0)
                return false;
        }

        return true;
    }
}
