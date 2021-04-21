package EasyProblems.SortingAndSearch;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/
 *
 * First Bad Version
 *
 * Solution
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the
 * first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 *
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 * 1 <= bad <= n <= 231 - 1
 *
 *
 */
public class FirstBadVersion {
    public static void main(String[] args) {

        int result = 0;

        result = firstBadVersion(1);
        System.out.println("DONE");

    }

    public static int firstBadVersion(int n) {

        int result = n;
        int trueValue = 0;
        int falseValue = 0;

        while(trueValue - falseValue != 1){
            if(isBadVersion(result)){
                trueValue = result;
                if(falseValue == 0){
                    result = result / 2;
                }else{
                    result = ((trueValue - falseValue) / 2) + falseValue;
                }
            }else{
                falseValue = result;
                if(trueValue == 0){
                    result = result / 2;
                }else{
                    result = ((trueValue - falseValue) / 2) + falseValue;
                }
            }
        }

        return trueValue;

    }

    public static boolean isBadVersion(int n) {

        if( n >= 1 )
            return true;

        return false;

    }
}
