package ArraysAndStrings;

import java.util.HashMap;

public class ValidSudoku {

    /**
     * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
     *
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     *
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character '.'.
     * The given board size is always 9x9.
     *
     * Example:
     * Input:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: true
     *
     *
     */

    public static void main(String[] args) {

        char[][] sudoku = new char[9][9];
        sudoku[0][0] = '5';
        sudoku[0][1] = '3';
        sudoku[0][2] = '.';
        sudoku[0][3] = '.';
        sudoku[0][4] = '7';
        sudoku[0][5] = '.';
        sudoku[0][6] = '.';
        sudoku[0][7] = '.';
        sudoku[0][8] = '.';

        sudoku[1][0] = '6';
        sudoku[1][1] = '.';
        sudoku[1][2] = '.';
        sudoku[1][3] = '1';
        sudoku[1][4] = '9';
        sudoku[1][5] = '5';
        sudoku[1][6] = '.';
        sudoku[1][7] = '.';
        sudoku[1][8] = '.';

        sudoku[2][0] = '.';
        sudoku[2][1] = '9';
        sudoku[2][2] = '8';
        sudoku[2][3] = '.';
        sudoku[2][4] = '.';
        sudoku[2][5] = '.';
        sudoku[2][6] = '.';
        sudoku[2][7] = '6';
        sudoku[2][8] = '.';

        sudoku[3][0] = '8';
        sudoku[3][1] = '.';
        sudoku[3][2] = '.';
        sudoku[3][3] = '.';
        sudoku[3][4] = '6';
        sudoku[3][5] = '.';
        sudoku[3][6] = '.';
        sudoku[3][7] = '.';
        sudoku[3][8] = '3';

        sudoku[4][0] = '4';
        sudoku[4][1] = '.';
        sudoku[4][2] = '.';
        sudoku[4][3] = '8';
        sudoku[4][4] = '.';
        sudoku[4][5] = '3';
        sudoku[4][6] = '.';
        sudoku[4][7] = '.';
        sudoku[4][8] = '1';

        sudoku[5][0] = '7';
        sudoku[5][1] = '.';
        sudoku[5][2] = '.';
        sudoku[5][3] = '.';
        sudoku[5][4] = '2';
        sudoku[5][5] = '.';
        sudoku[5][6] = '.';
        sudoku[5][7] = '.';
        sudoku[5][8] = '6';

        sudoku[6][0] = '.';
        sudoku[6][1] = '6';
        sudoku[6][2] = '.';
        sudoku[6][3] = '.';
        sudoku[6][4] = '.';
        sudoku[6][5] = '.';
        sudoku[6][6] = '2';
        sudoku[6][7] = '8';
        sudoku[6][8] = '.';

        sudoku[7][0] = '.';
        sudoku[7][1] = '.';
        sudoku[7][2] = '.';
        sudoku[7][3] = '4';
        sudoku[7][4] = '1';
        sudoku[7][5] = '9';
        sudoku[7][6] = '.';
        sudoku[7][7] = '.';
        sudoku[7][8] = '5';

        sudoku[8][0] = '.';
        sudoku[8][1] = '.';
        sudoku[8][2] = '.';
        sudoku[8][3] = '.';
        sudoku[8][4] = '8';
        sudoku[8][5] = '.';
        sudoku[8][6] = '.';
        sudoku[8][7] = '7';
        sudoku[8][8] = '9';

        boolean result = isValidSudoku(sudoku);
        System.out.println(result);
    }

    //TC: O(N^4)
    //SC: O(N)
    public static boolean isValidSudoku(char[][] board) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            hm.clear();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.') {
                    if (hm.containsKey(board[i][j])) {
                        return false;
                    } else {
                        hm.put(board[i][j], 1);
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            hm.clear();
            for(int j = 0; j < board[0].length; j++){
                if(board[j][i] != '.') {
                    if (hm.containsKey(board[j][i])) {
                        return false;
                    } else {
                        hm.put(board[j][i], 1);
                    }
                }
            }
        }

        int stopBox = board.length;
        for(int boxCol = 0; boxCol < stopBox; boxCol += 3) {
            for (int boxRow = 0; boxRow < stopBox; boxRow += 3) {
                hm.clear();
                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        if (board[i][j] != '.') {
                            if (hm.containsKey(board[i][j])) {
                                return false;
                            } else {
                                hm.put(board[i][j], 1);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
