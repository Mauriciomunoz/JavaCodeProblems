package EasyProblems;

/**
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 *
 *
 */

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {


        System.out.println(titleToNumber("FXSHRXW"));
    }

    public static int titleToNumber(String columnTitle) {

        int result = 0;

        for(int i = columnTitle.length() - 1; i >= 0; i--){
            result = result + (int) (Math.pow(26, (columnTitle.length() - 1) - i) * (columnTitle.charAt(i) - 'A' + 1));
        }

        return result;
    }

}
