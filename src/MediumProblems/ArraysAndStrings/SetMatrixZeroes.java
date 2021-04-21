package MediumProblems.ArraysAndStrings;

/**
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * [1 1 1 ]
 * [1 0 1 ]
 * [1 1 1 ]
 *
 * [1 0 1 ]
 * [0 0 0 ]
 * [1 0 1 ]
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 *
 * [0 1 2 0]
 * [3 4 5 2]
 * [1 3 1 5]
 *
 * [0 0 0 0]
 * [0 4 5 0]
 * [0 3 1 0]
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 *
 */



public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 0;

        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 2;

        matrix[2][0] = 1;
        matrix[2][1] = 3;
        matrix[2][2] = 1;
        matrix[2][3] = 5;

        int[][] matrix2 = new int[3][3];
        matrix2[0][0] = 1;
        matrix2[0][1] = 1;
        matrix2[0][2] = 1;

        matrix2[1][0] = 1;
        matrix2[1][1] = 0;
        matrix2[1][2] = 1;

        matrix2[2][0] = 1;
        matrix2[2][1] = 1;
        matrix2[2][2] = 1;

        int[][] matrix3 = new int[3][4];
        matrix3[0][0] = 3;
        matrix3[0][1] = 1;
        matrix3[0][2] = 2;
        matrix3[0][3] = 4;

        matrix3[1][0] = 0;
        matrix3[1][1] = 4;
        matrix3[1][2] = 5;
        matrix3[1][3] = 6;

        matrix3[2][0] = 1;
        matrix3[2][1] = 8;
        matrix3[2][2] = 9;
        matrix3[2][3] = 2;

        int[][] matrix4 = new int[1][2];
        matrix4[0][0] = 1;
        matrix4[0][1] = 0;

        int[][] matrix5 = new int[2][1];
        matrix5[0][0] = 1;
        matrix5[1][0] = 0;

        setZeroes(matrix5);


    }


    //TC: O(N*M)
    //SC: O(1)
    static public void setZeroes(int[][] matrix) {

        boolean column = false;
        boolean row = false;


        for(int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                column = true;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    //matrix[i][j] = flag;
                }
            }
        }

        //Column
        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //Rows
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }


        if(column == true){
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(row == true){
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        System.out.println("DONE");

    }


}
