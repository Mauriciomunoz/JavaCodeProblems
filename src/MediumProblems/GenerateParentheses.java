package MediumProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 */
public class GenerateParentheses {

    static List<String> result2 = new ArrayList<>();

    public static void main(String[] args) {

        int n = 3;

        List<String> result = generateParenthesis(n);

        System.out.println("DONE");
    }

    public static List<String> generateParenthesis(int n) {

        int open = n;
        List<String> result = new ArrayList<>();

      // calculatingValues(open, 0, "", result);
        permute("", n, 0);

        return result;

    }


    public static void calculatingValues(int open, int close, String value, List<String> result){

        if(open == 0 && close == 0) {
            result.add(value);
            return;
        }
        else{
            if(close == 0) {
                calculatingValues(open - 1, close + 1, value + "(", result);
            }else {

                if(open == 0) {
                    calculatingValues(open, close - 1, value + ")", result);
                }else{
                    calculatingValues(open - 1, close + 1, value + "(", result);
                    calculatingValues(open, close - 1, value + ")", result);
                }
            }

        }


    }

    public static void permute(String str, int leftToOpen, int leftToClose) {
        if(leftToOpen == 0 && leftToClose == 0) {
            result2.add(str);
            return;
        }

        if(leftToClose == 0)
            permute(str + "(", leftToOpen-1, leftToClose+1);
        else
            if(leftToOpen == 0)
                permute(str + ")", leftToOpen, leftToClose-1);
        else {
            permute(str + "(", leftToOpen-1, leftToClose+1);
            permute(str + ")", leftToOpen, leftToClose-1);
        }
    }
}
